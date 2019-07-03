package cn.com.service.impl;

import cn.com.mapper.ContentCategoryMapper;
import cn.com.pojo.ContentCategory;
import cn.com.pojo.ContentCategoryExample;
import cn.com.pojo.EasyUiTreeNode;
import cn.com.service.ContentCategoryService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
    public List<EasyUiTreeNode> getTree(Long parentId) {
        //创建返回对象list，封装返回数据
        List<EasyUiTreeNode> result = new ArrayList<>();
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
        for (ContentCategory contentCategory : list){
            EasyUiTreeNode node = new EasyUiTreeNode();
            node.setId(contentCategory.getId());
            node.setText(contentCategory.getName());
            node.setState(contentCategory.getIsParent() ? "closed" : "open");
            result.add(node);
        }
        return result;
    }
}
