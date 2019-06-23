package cn.com.service.impl;

import cn.com.mapper.ItemMapper;
import cn.com.pojo.Item;
import cn.com.service.ItemService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: ItemServiceImpl
 * Description: 商品信息实现类
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/20 0:14 fwz 文件初始创建
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    /**
     * Description：根据主键查询商品信息
     * @Author fwz
     * @param itemId : 商品Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/20 0:11
     */
    @Override
    public Item getItemById(long itemId) {
        //根据主键查询商品信息
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
