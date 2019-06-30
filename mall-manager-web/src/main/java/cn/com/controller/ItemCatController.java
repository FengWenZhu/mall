package cn.com.controller;

import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.ItemCat;
import cn.com.pojo.MallResult;
import cn.com.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品类目信息Controller")
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * Description：根据parentId查询节点列表，得到商品类目Tree结构
     * @Author fwz
     * @param id : 父节点id
     * @return java.util.List<cn.com.EasyUiTreeNode>
     * @throws
     * @Date 2019/6/29 18:47
     */
    @ApiOperation(value = "根据parentId查询节点列表，得到商品类目Tree结构")
    @RequestMapping(value = "/getItemCatTree" , method = RequestMethod.POST)
    @ResponseBody
    public List<EasyUiTreeNode> getItemCatTree(@RequestParam(value = "id" , defaultValue = "0") Long id){
        List<EasyUiTreeNode> result = itemCatService.getItemCatTree(id);
        return result;
    }

    /**
     * Description：根据主键查询商品类目信息
     * @Author fwz
     * @param id : 商品类目主键
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 15:40
     */
    @ApiOperation(value = "根据主键查询商品类目信息")
    @RequestMapping(value = "/getItemCatById/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public MallResult getItemCatById(@PathVariable("id") Long id){
        ItemCat itemCat = itemCatService.getItemCatById(id);
        MallResult result = new MallResult();
        if(itemCat != null){
            result.setStatus(200);
            result.setData(itemCat);
        }
        return result;
    }

}
