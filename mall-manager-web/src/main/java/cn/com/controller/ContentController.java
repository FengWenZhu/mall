package cn.com.controller;

import cn.com.pojo.MallDataGridResult;
import cn.com.service.ContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ContentController
 * @Description: 商品内容管理Controller
 * @company: Future Tech
 * @author fwz
 * @date 2019/7/15 22:15
 * @version 1.0
 */
@Api(tags = "商品内容管理Controller")
@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    /**
     * @Description: 根据categoryId分页查询内容管理新消息
     * @param categoryId: 商品内容分类id
     * @param page: 当前页数
     * @param rows: 每页记录数
     * @author fwz
     * @date 2019/7/15 22:20
     * @return cn.com.pojo.MallDataGridResult
     */
    @ApiOperation(value = "商品内容管理分页查询")
    @RequestMapping(value = "/getContentCategoryList" , method = RequestMethod.GET)
    @ResponseBody
    public MallDataGridResult getContentCategoryList(Long categoryId, Integer page, Integer rows) {
        MallDataGridResult result = contentService.getContentCategoryList(categoryId, page, rows);
        return result;
    }
}
