package cn.com.controller;

import cn.com.pojo.Item;
import cn.com.service.IItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(tags = "商品信息Controller")
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

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
}
