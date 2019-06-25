package cn.com.service;

import cn.com.MallResult;
import cn.com.pojo.Item;
/**
 * ClassName: IItemService
 * Description: 商品信息接口
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/20 0:13 fwz 文件初始创建
 */
public interface ItemService {
    /**
     * Description：根据主键查询商品信息
     * @Author fwz
     * @param itemId : 商品Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/20 0:11
     */
    Item getItemById(long itemId);
    /**
     * Description：分页查询商品信息
     * @Author fwz
     * @param pageCurrnet : 当前页数
     * @param rows :  每页显示记录数
     * @return cn.com.MallResult
     * @throws
     * @Date 2019/6/24 23:34
     */
    MallResult getItemList(int pageCurrnet, int rows);
}
