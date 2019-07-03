package cn.com.controller;

import cn.com.pojo.EasyUiTreeNode;
import cn.com.service.ContentCategoryService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ContentCategoryController
 * @Description: 商品内容分类管理Controller
 * @Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/7/2 22:09 fwz 文件初始创建
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

    @Reference
    private ContentCategoryService contentCategoryService;

    /**
     * @Description：据父节点id得到内容分类的tree结构
     * @Author fwz
     * @param parentId : 父节点id
     * @return java.util.List<cn.com.pojo.EasyUiTreeNode>
     * @throws
     * @Date 2019/7/2 22:17
     */
    @ApiOperation(value = "据父节点id得到内容分类的tree结构")
    @RequestMapping(value = "/getTree" , method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUiTreeNode> getTree(@RequestParam(value = "id" , defaultValue = "0") Long parentId){
        List<EasyUiTreeNode> result = contentCategoryService.getTree(parentId);
        return result;
    }
}
