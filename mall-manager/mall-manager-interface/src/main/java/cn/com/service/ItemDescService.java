package cn.com.service;

import cn.com.pojo.ItemDesc;

/**
 * ClassName: ItemDescService
 * Description: 商品信息描述接口
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/30 14:36 fwz 文件初始创建
 */
public interface ItemDescService {

    /**
     * Description：根据商品信息Id查询商品描述信息
     * @Author fwz
     * @param itemId : 商品信息Id
     * @return cn.com.pojo.ItemDesc
     * @throws
     * @Date 2019/6/30 14:40
     */
    ItemDesc getItemDescByItemId(Long itemId);
}
