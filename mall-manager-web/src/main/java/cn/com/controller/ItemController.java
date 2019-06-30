package cn.com.controller;

import cn.com.pojo.Item;
import cn.com.pojo.MallDataGridResult;
import cn.com.pojo.MallResult;
import cn.com.service.ItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ItemController
 * Description: 商品信息Controller
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/21 22:00 fwz 文件初始创建
 */
@Api(tags = "商品信息Controller")
@Controller
@RequestMapping("/item")
public class ItemController {

    @Reference
    private ItemService itemService;

    /**
     * Description：根据主键查询商品信息
     * @Author fwz
     * @param itemId : 商品Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/20 0:11
     */
    @ApiOperation(value = "根据主键查询商品信息")
    @GetMapping("/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId){
        return itemService.getItemById(itemId);
    }

    /**
     * Description：分页查询商品信息
     * @Author fwz
     * @param page : 当前页数
     * @param rows :  每页显示记录数
     * @return cn.com.MallResult
     * @throws
     * @Date 2019/6/24 23:34
     */
    @ApiOperation(value = "分页查询商品信息")
    @GetMapping("/getItemList")
    @ResponseBody
    public MallDataGridResult getItemList(Integer page, Integer rows){
        MallDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    /**
     * Description：根据id删除商品信息
     * @Author fwz
     * @param ids : 商品主键集合
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 14:03
     */
    @ApiOperation(value = "批量删除商品信息")
    @RequestMapping(value = "/deleteByBatch" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult deleteByBatch(@RequestParam String ids){
        MallResult result = new MallResult();
        int row = itemService.deleteByBatch(ids);
        if(row >= 1){
            result.setStatus(200);
            result.setMsg("删除成功");
        }
        return result;
    }

    /**
     * Description：新增商品信息
     * @Author fwz
     * @param item : 商品信息数据
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 14:04
     */
    @ApiOperation(value = "新增商品信息")
    @RequestMapping(value = "/saveItem" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult saveItem(Item item, String desc){
        MallResult result = itemService.addItem(item, desc);
        return result;
    }
    /**
     * Description：根据商品信息Id查询商品信息
     * @Author fwz
     * @param id : 商品信息Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/30 14:52
     */
    @ApiOperation(value = "根据商品信息Id查询商品信息")
    @RequestMapping(value = "/getItemByItemId/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public MallResult getItemByItemId(@PathVariable Long id){
        Item item = itemService.getItemById(id);
        MallResult result = new MallResult();
        if(item != null){
            result.setStatus(200);
            result.setData(item);
        }
        return result;
    }

    /**
     * Description：更新商品信息
     * @Author fwz
     * @param item : 商品信息
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 19:22
     */
    @ApiOperation(value = "更新商品信息")
    @RequestMapping(value = "/editItem" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult editItem(Item item , String desc){
        MallResult result = itemService.updateItem(item, desc);
        return result;
    }

    /**
     * Description：批量下架商品
     * @Author fwz
     * @param ids : 商品id集合
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 19:25
     */
    @ApiOperation(value = "批量下架商品")
    @RequestMapping(value = "/instockByBatch" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult instockByBatch(String ids){
        MallResult result = new MallResult();
        //返回受影响的行数
        int row = itemService.instockByBatch(ids);
        if(row >= 1){
            result.setStatus(200);
            result.setMsg("商品下架成功");
        }
        return result;
    }

    /**
     * Description：批量上架商品
     * @Author fwz
     * @param ids : 商品id集合
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 19:29
     */
    @ApiOperation("批量上架商品")
    @RequestMapping(value = "/reshelfByBatch" , method = RequestMethod.POST)
    @ResponseBody
    public MallResult reshelfByBatch(String ids){
        MallResult result = new MallResult();
        int row = itemService.reshelfByBatch(ids);
        if(row >= 1){
            result.setStatus(200);
            result.setMsg("商品下架成功");
        }
        return result;
    }
}
