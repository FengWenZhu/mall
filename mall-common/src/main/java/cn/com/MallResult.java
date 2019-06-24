package cn.com;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MallResult
 * Description: 用于分页查询，渲染EasyUIDataGrid数据
 * Company: Future Tech
 * @author fwz
 * @version v1.0.0 2019/6/25 0:26 fwz 文件初始创建
 */
public class MallResult implements Serializable {
    /** 总记录数 */
    private Long total;
    /** 渲染数据 */
    private List data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
