package cn.com.controller;

import cn.com.pojo.ItemDesc;
import cn.com.pojo.MallResult;
import cn.com.service.ItemDescService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ItemDescController
 * Description: 商品信息描述Controller
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/30 14:44 fwz 文件初始创建
 */
@Api(tags = "商品信息描述")
@RestController
@RequestMapping("/itemDesc")
public class ItemDescController {

    @Reference
    private ItemDescService itemDescService;

    /**
     * Description：根据商品信息Id查询商品描述信息
     * @Author fwz
     * @param itemId : 商品信息Id
     * @return cn.com.pojo.ItemDesc
     * @throws
     * @Date 2019/6/30 14:48
     */
    @ApiOperation(value = "根据商品信息Id查询商品描述信息")
    @RequestMapping(value = "/getItemDescByItemId/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public MallResult getItemDescByItemId(@PathVariable(value = "id") Long itemId){
        ItemDesc itemDesc = itemDescService.getItemDescByItemId(itemId);
        MallResult result = new MallResult();
        if(itemDesc != null){
            result.setStatus(200);
            result.setData(itemDesc);
        }
        return result;
    }
}
