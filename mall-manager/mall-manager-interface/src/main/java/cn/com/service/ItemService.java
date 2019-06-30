package cn.com.service;

import cn.com.pojo.Item;
import cn.com.pojo.MallDataGridResult;
import cn.com.pojo.MallResult;

/**
 * ClassName: ItemService
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
    Item getItemById(Long itemId);
    /**
     * Description：分页查询商品信息
     * @Author fwz
     * @param pageCurrnet : 当前页数
     * @param rows :  每页显示记录数
     * @return cn.com.MallResult
     * @throws
     * @Date 2019/6/24 23:34
     */
    MallDataGridResult getItemList(int pageCurrnet, int rows);

    /**
     * Description：根据id删除商品信息
     * @Author fwz
     * @param ids :  商品主键集合
     * @return int : 受影响行数
     * @throws
     * @Date 2019/6/25 22:15
     */
    int deleteByBatch(String ids);

    /**
     * Description：新增商品信息
     * @Author fwz
     * @param item : 商品信息
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 13:34
     */
    MallResult addItem(Item item , String desc);

    /**
     * Description：更新商品信息
     * @Author fwz
     * @param item : 商品信息
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 18:41
     */
    MallResult updateItem(Item item , String desc);

    /**
     * Description：根据id下架商品
     * @Author fwz
     * @param ids : 商品主键集合
     * @return int
     * @throws
     * @Date 2019/6/30 19:07
     */
    int instockByBatch(String ids);

    /**
     * Description：根据id上架商品
     * @Author fwz
     * @param ids : 商品主键集合
     * @return int
     * @throws
     * @Date 2019/6/30 19:36
     */
    int reshelfByBatch(String ids);
}
