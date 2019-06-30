package cn.com.service;

import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.ItemCat;

import java.util.List;

/**
 * ClassName: ItemCatService
 * Description: 商品类目信息解扣子
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/29 18:41 fwz 文件初始创建
 */
public interface ItemCatService {
    /** 
     * Description：根据parentId查询节点列表，得到商品类目Tree结构
     * @Author fwz
     * @param parentId : 父节点id
     * @return java.util.List<cn.com.EasyUiTreeNode>
     * @throws 
     * @Date 2019/6/29 18:47
     */
    List<EasyUiTreeNode> getItemCatTree(Long parentId);

    /**
     * Description：根据商品类目id查询商品类目信息
     * @Author fwz
     * @param id : 商品类目id
     * @return cn.com.pojo.ItemCat
     * @throws
     * @Date 2019/6/30 15:34
     */
    ItemCat getItemCatById(Long id);
}
