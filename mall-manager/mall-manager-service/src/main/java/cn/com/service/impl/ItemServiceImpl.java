package cn.com.service.impl;

import cn.com.mapper.ItemDescMapper;
import cn.com.mapper.ItemMapper;
import cn.com.pojo.*;
import cn.com.service.ItemService;
import cn.com.utils.IDUtils;
import cn.com.utils.SnowflakeIdWorker;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private ItemDescMapper itemDescMapper;

    /**
     * Description：根据主键查询商品信息
     * @Author fwz
     * @param itemId : 商品Id
     * @return cn.com.pojo.Item
     * @throws
     * @Date 2019/6/20 0:11
     */
    @Override
    public Item getItemById(Long itemId) {
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
    public MallDataGridResult getItemList(int pageCurrnet, int rows) {
        MallDataGridResult result = new MallDataGridResult();
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

    /**
     * Description：根据id删除商品信息
     * @Author fwz
     * @param ids :  商品主键集合
     * @return int : 受影响行数
     * @throws
     * @Date 2019/6/25 22:15
     */
    @Override
    @Transactional
    public int deleteByBatch(String ids) {
        //得到id的数据集
        String[] id = ids.split(",");
        //返回受影响行数
        int row = itemMapper.deleteByBatch(id);
        return row;
    }

    /**
     * Description：新增商品信息
     * @Author fwz
     * @param item : 商品信息
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 13:34
     */
    @Override
    @Transactional
    public MallResult addItem(Item item, String desc) {
        //生成商品ID
        Long itemId = Long.valueOf(SnowflakeIdWorker.getId());
        //补全item属性
        item.setId(itemId);
        //1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        //获取系统当前时间
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        //向商品表插入数据
        int itemResult = itemMapper.insert(item);
        //创建商品描述表对象
        ItemDesc itemDesc = new ItemDesc();
        //补全商品描述表属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        //向商品描述表插入数据
        int itemDescResult = itemDescMapper.insert(itemDesc);
        //封装返回结果
        MallResult result = new MallResult();
        if(itemResult >= 1 && itemDescResult >= 1){
            result.setStatus(200);
            result.setMsg("新增商品信息成功");
        }
        return result;
    }

    /**
     * Description：更新商品信息
     * @Author fwz
     * @param item : 商品信息
     * @param desc : 商品描述
     * @return cn.com.pojo.MallResult
     * @throws
     * @Date 2019/6/30 18:41
     */
    @Override
    @Transactional
    public MallResult updateItem(Item item, String desc) {
        //获取系统时间
        Date date = new Date();
        item.setUpdated(date);
        //更新商品信息
        int itemResult = itemMapper.updateByPrimaryKeySelective(item);
        //创建商品描述对象
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(date);
        //更新商品描述信息
        int itemDescResult = itemDescMapper.updateByPrimaryKeySelective(itemDesc);
        //封装返回结果
        MallResult result = new MallResult();
        if(itemResult >= 1 && itemDescResult >= 1){
            result.setStatus(200);
            result.setMsg("新增商品信息成功");
        }
        return result;
    }

    /**
     * Description：根据id下架商品
     * @Author fwz
     * @param ids : 商品主键集合
     * @return int
     * @throws
     * @Date 2019/6/30 19:07
     */
    @Override
    public int instockByBatch(String ids) {
        //得到主键数组
        String[] id = ids.split(",");
        //返回受影响的行数
        int row = itemMapper.instockByBatch(id);
        return row;
    }

    /**
     * Description：根据id上架商品
     * @Author fwz
     * @param ids : 商品主键集合
     * @return int
     * @throws
     * @Date 2019/6/30 19:36
     */
    @Override
    public int reshelfByBatch(String ids) {
        //得到主键数组
        String[] id = ids.split(",");
        //返回受影响的行数
        int row = itemMapper.reshelfByBatch(id);
        return row;
    }
}
