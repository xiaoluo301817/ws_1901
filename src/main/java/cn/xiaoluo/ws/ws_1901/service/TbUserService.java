package cn.xiaoluo.ws.ws_1901.service;

import cn.xiaoluo.ws.ws_1901.entity.TbUser;
import cn.xiaoluo.ws.ws_1901.vo.PageParam;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TbUserService {


	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：addTbUser
	 * 创建人:XiaoLuo 
	 * 时间：2018年10月25日-上午11:39:33 
	 * 
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean addTbUser(TbUser TbUser);

	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：deleteTbUser
	 * 创建人:XiaoLuo 
	 * @param ids
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean deleteTbUser(Integer[] ids);


	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：updateTbUser
	 * 创建人:XiaoLuo
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean updateTbUser(TbUser TbUser);



	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：findAll
	 * 创建人:XiaoLuo 
	 * 时间：2018年10月25日-上午11:41:33 
	 * @return List<TbUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<TbUser> findAll();
	

	
	

	


	/**
	 * 
	 * 根据ID查询实体
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：findOne
	 * 创建人:XiaoLuo 
	 * @param id
	 * @return TbUser
	 * @exception 
	 * @since  1.0.0
	 */
	public TbUser findOne(Integer id);
	
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * cn.xiaoluo.ws.ws_1901.service
	 * 方法名：findByName
	 * 创建人:XiaoLuo 
	 * @param name
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean findByName(String name);


	/**
	 * 用户登录方法
	 * @param username
	 * @param password
	 * @return
	 */
	public  TbUser queryLogin(String username,String password);


	/**
	 *
	 *
	 * @param pageParam		分页条
	 * @return
	 */
	public PageInfo<TbUser> findPage(PageParam pageParam);




}
