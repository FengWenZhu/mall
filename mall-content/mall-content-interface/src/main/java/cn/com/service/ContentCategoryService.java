package cn.com.service;

import cn.com.pojo.EasyUiTreeNode;
import cn.com.pojo.MallResult;

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

    /**
     * @Description: 内容分类管理新增节点
     * @param parentId: 父节点id
     * @param name: 节点名称
     * @author fwz
     * @date 2019/7/4 22:00
     * @return int
     */
    MallResult createContentCategory(Long parentId, String name);

    /**
     * @Description: 修改当前节点名称
     * @param id: 内容分类主键
     * @param name: 当前节点名称
     * @author fwz
     * @date 2019/7/5 0:12
     * @return cn.com.pojo.MallResult
     */
    MallResult updateContentCategory(Long id , String name);
}
