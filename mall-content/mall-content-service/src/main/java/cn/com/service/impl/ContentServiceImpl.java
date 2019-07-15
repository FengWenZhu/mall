package cn.com.service.impl;

import cn.com.mapper.ContentMapper;
import cn.com.pojo.Content;
import cn.com.pojo.ContentExample;
import cn.com.pojo.MallDataGridResult;
import cn.com.service.ContentService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: ContentServiceImpl
 * @Description: 商品内容接口实现
 * @company: Future Tech
 * @author fwz
 * @date 2019/7/15 21:36
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    /**
     * @Description: 根据categoryId分页查询内容管理新消息
     * @param categoryId: 商品内容分类id
     * @param pageCurrnet: 当前页数
     * @param rows: 每页条数
     * @author fwz
     * @date 2019/7/15 22:17
     * @return cn.com.pojo.MallDataGridResult
     */
    @Override
    public MallDataGridResult getContentCategoryList(Long categoryId, Integer pageCurrnet, Integer rows) {
        MallDataGridResult result = new MallDataGridResult();
        //设置分页信息
        PageHelper.startPage(pageCurrnet,rows);
        //设置查询条件
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //执行查询
        List<Content> list = contentMapper.selectByExample(example);
        //获取分页信息
        PageInfo<Content> pageInfo = new PageInfo<>(list);
        //获取总记录数
        Long total = pageInfo.getTotal();
        //返回数据
        result.setTotal(total);
        result.setRows(list);
        return result;
    }
}
