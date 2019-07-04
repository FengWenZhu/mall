package cn.com.service.impl;

import cn.com.mapper.ContentCategoryMapper;
import cn.com.pojo.ContentCategory;
import cn.com.pojo.ContentCategoryExample;
import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.MallResult;
import cn.com.service.ContentCategoryService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: ContentCategoryImpl
 * Description: 商品内容分类接口实现
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/7/2 22:08 fwz 文件初始创建
 */
@Service
public class ContentCategoryImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    /**
     * Description：根据父节点id得到内容分类的tree结构
     * @Author fwz
     * @param parentId : 内容分类父节点id
     * @return java.util.List<cn.com.pojo.EasyUiTreeNode>
     * @throws
     * @Date 2019/7/2 21:52
     */
    @Override
    public List<EasyUiTreeNode> getContentCategoryTree(Long parentId) {
        //创建返回对象list，存放返回数据
        List<EasyUiTreeNode> result = new ArrayList<>();
        //根据parentId查询子节点列表
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
        //封装返回的数据
        for (ContentCategory contentCategory : list){
            EasyUiTreeNode node = new EasyUiTreeNode();
            node.setId(contentCategory.getId());
            node.setText(contentCategory.getName());
            node.setState(contentCategory.getIsParent() ? "closed" : "open");
            result.add(node);
        }
        return result;
    }

    /**
     * @Description: 内容分类管理新增节点
     * @param parentId: 父节点id
     * @param name: 节点名称
     * @author fwz
     * @date 2019/7/4 22:00
     * @return int
     */
    @Override
    @Transactional
    public MallResult createContentCategory(Long parentId, String name) {
        //新增内容分类信息对象
        ContentCategory contentCategory = new ContentCategory();
        //父节点id
        contentCategory.setParentId(parentId);
        //新增节点名称
        contentCategory.setName(name);
        //1-正常，2-删除
        contentCategory.setStatus(1);
        //新增一定为叶子节点
        contentCategory.setIsParent(Boolean.FALSE);
        //排序方式，默认值为1
        contentCategory.setSortOrder(1);
        //获取系统时间
        Date date = new Date();
        //创建时间
        contentCategory.setCreated(date);
        //更新时间
        contentCategory.setUpdated(date);
        int row = contentCategoryMapper.insert(contentCategory);
        //新增时需判断父节点的isParent属性，如果为false，则更改为true
        ContentCategory category = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(category.getIsParent() == Boolean.FALSE){
            category.setIsParent(Boolean.TRUE);
            category.setUpdated(date);
            //更新父节点数据的isParent字段以及更新时间
            contentCategoryMapper.updateByPrimaryKey(category);
        }
        //返回结果
        MallResult result = new MallResult();
        if(row >=1){
            result.setStatus(200);
            result.setData(contentCategory);
            result.setMsg("内容分类管理新增节点成功");
        }
        return result;
    }

    /**
     * @Description: 修改当前节点名称
     * @param id: 内容分类主键
     * @param name: 当前节点名称
     * @author fwz
     * @date 2019/7/5 0:12
     * @return cn.com.pojo.MallResult
     */
    @Override
    @Transactional
    public MallResult updateContentCategory(Long id, String name) {
        //修改内容分类信息对象
        ContentCategory contentCategory = new ContentCategory();
        //主键
        contentCategory.setId(id);
        //节点名称
        contentCategory.setName(name);
        //获取系统当前时间
        Date date = new Date();
        //更新时间
        contentCategory.setUpdated(date);
        //执行更新操作,返回受影响的行
        int row = contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
        //返回对象
        MallResult result = new MallResult();
        if(row >= 1){
            result.setStatus(200);
            result.setMsg("内容分类管理节点重命名成功");
        }
        return result;
    }
}
