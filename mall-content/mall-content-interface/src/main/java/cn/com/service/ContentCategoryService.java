package cn.com.service;

import cn.com.pojo.EasyUiTreeNode;

import java.util.List;

/**
 * ClassName: ContentCategoryService
 * Description: 商品内容分类接口
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/7/2 22:07 fwz 文件初始创建
 */
public interface ContentCategoryService {

    /**
     * Description：根据父节点id得到内容分类的tree结构
     * @Author fwz
     * @param parentId : 内容分类父节点id
     * @return java.util.List<cn.com.pojo.EasyUiTreeNode>
     * @throws
     * @Date 2019/7/2 21:52
     */
    List<EasyUiTreeNode> getContentCategoryTree(Long parentId);
}
