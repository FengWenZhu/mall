package cn.com.service.impl;

import cn.com.mapper.ItemDescMapper;
import cn.com.pojo.ItemDesc;
import cn.com.service.ItemDescService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: ItemDescServiceImpl
 * Description: 商品信息描述接口实现
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/30 14:37 fwz 文件初始创建
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {

    @Autowired
    private ItemDescMapper itemDescMapper;

    /**
     * Description：根据商品信息Id查询商品描述信息
     * @Author fwz
     * @param itemId : 商品信息Id
     * @return cn.com.pojo.ItemDesc
     * @throws
     * @Date 2019/6/30 14:40
     */
    @Override
    public ItemDesc getItemDescByItemId(Long itemId) {
        ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        return itemDesc;
    }
}
