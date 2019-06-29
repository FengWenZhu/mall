package cn.com.service;

import cn.com.EasyUiTreeNode;

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
}
