package cn.com.service.impl;

import cn.com.mapper.ItemCatMapper;
import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.ItemCat;
import cn.com.pojo.ItemCatExample;
import cn.com.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ItemCatServiceImpl
 * Description: 商品类目信息接口实现
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/29 18:42 fwz 文件初始创建
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * Description：根据parentId查询子节点列表，得到商品类目Tree结构
     * @Author fwz
     * @param parentId : 父节点id
     * @return java.util.List<cn.com.EasyUiTreeNode>
     * @throws
     * @Date 2019/6/29 18:47
     */
    @Override
    public List<EasyUiTreeNode> getItemCatTree(Long parentId) {
        List<EasyUiTreeNode> result = new ArrayList<>();
        ItemCatExample example = new ItemCatExample();
        ItemCatExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<ItemCat> list = itemCatMapper.selectByExample(example);
        //将List<ItemCat>转换为返回结果List<EasyUiTreeNode>
        for (ItemCat itemCat : list){
            EasyUiTreeNode node = new EasyUiTreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent() ? "closed" : "open");
            result.add(node);
        }
        return result;
    }

    /**
     * Description：根据商品类目id查询商品类目信息
     * @Author fwz
     * @param id : 商品类目id
     * @return cn.com.pojo.ItemCat
     * @throws
     * @Date 2019/6/30 15:34
     */
    @Override
    public ItemCat getItemCatById(Long id) {
        ItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
        return itemCat;
    }
}
