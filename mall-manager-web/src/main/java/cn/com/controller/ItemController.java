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

    @Reference(version = "1.0.0")
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
     * @param ids :  商品主键集合
     * @return int : 受影响行数
     * @throws
     * @Date 2019/6/25 22:15
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
}
