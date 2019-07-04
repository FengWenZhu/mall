package cn.com.controller;

import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.MallResult;
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
    @RequestMapping(value = "/getContentCategoryTree" , method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUiTreeNode> getContentCategoryTree(@RequestParam(value = "id" , defaultValue = "0") Long parentId){
        List<EasyUiTreeNode> result = contentCategoryService.getContentCategoryTree(parentId);
        return result;
    }

    /**
     * @Description: 内容分类管理新增节点
     * @param parentId: 父节点id
     * @param name: 节点名称
     * @author fwz
     * @date 2019/7/4 23:10
     * @return cn.com.pojo.MallResult
     */
    @ApiOperation(value = "内容分类管理新增节点")
    @RequestMapping(value = "/createContentCategory" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult createContentCategory(Long parentId , String name){
        MallResult result = contentCategoryService.createContentCategory(parentId, name);
        return result;
    }

    /**
     * @Description: 内容分类管理重命名节点
     * @param id: 内容分类主键
     * @param name: 当前节点名称
     * @author fwz
     * @date 2019/7/5 0:35
     * @return cn.com.pojo.MallResult
     */
    @ApiOperation(value = "内容分类管理重命名节点")
    @RequestMapping(value = "/updateContentCategory" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult updateContentCategory(Long id , String name){
        MallResult result = contentCategoryService.updateContentCategory(id, name);
        return result;
    }
}
