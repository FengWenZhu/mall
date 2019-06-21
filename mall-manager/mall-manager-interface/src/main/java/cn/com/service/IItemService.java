package cn.com.service;

import cn.com.pojo.Item;
/**
 * ClassName: IItemService
 * Description: 商品信息接口
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/20 0:13 fwz 文件初始创建
 */
public interface IItemService {
    /**
     * Description：根据主键查询商品信息
     * @Author fwz
     * @param itemId : 商品Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/20 0:11
     */
    Item getItemById(long itemId);
}
