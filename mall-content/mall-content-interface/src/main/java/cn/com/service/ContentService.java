package cn.com.service;

import cn.com.pojo.MallDataGridResult;

/**
 * @ClassName: ContentService
 * @Description: 商品内容接口
 * @company: Future Tech
 * @author fwz
 * @date 2019/7/15 21:35
 * @version 1.0
 */
public interface ContentService {

    /**
     * @Description: 根据categoryId分页查询内容管理新消息
     * @param categoryId: 商品内容分类id
     * @author fwz
     * @date 2019/7/14 20:36
     * @return cn.com.pojo.MallDataGridResult
     */
    MallDataGridResult getContentCategoryList(Long categoryId, Integer pageCurrnet, Integer rows);
}
