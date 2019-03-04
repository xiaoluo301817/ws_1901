package cn.xiaoluo.ws.ws_1901.vo;


/**
 * 
 * 
 * PageParam
 * 创建人:XiaoLuo
 * 时间：2018年2月27日-下午9:04:30 
 * @version 1.0.0
 *
 */
public class PageParam implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//第几页
	private Integer pageNo=1;
	//每页多少条
	private Integer pageSize=5;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageParam [pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}
}
