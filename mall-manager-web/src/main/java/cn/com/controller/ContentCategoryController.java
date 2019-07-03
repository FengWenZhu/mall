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
 * @company: Future Tech
 * @author fwz
 * @date 2019/7/3 23:06
 * @version 1.0
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

    @Reference
    private ContentCategoryService contentCategoryService;

   /**
    * @Description: 根据父节点id得到内容分类的tree结构
    * @param parentId: 父节点id
    * @author fwz
    * @date 2019/7/3 23:10
    * @return java.util.List<cn.com.pojo.EasyUiTreeNode>
    */
    @ApiOperation(value = "据父节点id得到内容分类的tree结构")
    @RequestMapping(value = "/getTree" , method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUiTreeNode> getTree(@RequestParam(value = "id" , defaultValue = "0") Long parentId){
        List<EasyUiTreeNode> result = contentCategoryService.getTree(parentId);
        return result;
    }
}
