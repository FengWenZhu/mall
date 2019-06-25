package cn.com.service.impl;

import cn.com.MallResult;
import cn.com.mapper.ItemMapper;
import cn.com.pojo.Item;
import cn.com.pojo.ItemExample;
import cn.com.service.ItemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    /**
     * Description：分页查询商品信息
     * @Author fwz
     * @param pageCurrnet : 当前页数
     * @param rows :  每页显示记录数
     * @return cn.com.MallResult
     * @throws
     * @Date 2019/6/24 23:34
     */
    @Override
    public MallResult getItemList(int pageCurrnet, int rows) {
        MallResult result = new MallResult();
        //设置分页信息
        PageHelper.startPage(pageCurrnet,rows);
        //执行查询
        ItemExample example = new ItemExample();
        List<Item> list = itemMapper.selectByExample(example);
        //取分页结果
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        //取总记录数
        Long total = pageInfo.getTotal();
        //设置返回信息
        result.setRows(list);
        result.setTotal(total);
        return result;
    }
}
