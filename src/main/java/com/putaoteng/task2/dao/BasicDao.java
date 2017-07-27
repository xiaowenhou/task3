package com.putaoteng.task2.dao;

import java.util.List;
import com.putaoteng.task2.model.BasicVo;

public interface BasicDao {
	/**
	 * 增加数据
	 * @param	user	要增加的User类对象
	 * @return	成功返回true,失败返回false
	 */
	public void addData(BasicVo basicVo);
	
	/**
	 * 删除数据
	 * @param	id	要删除的数据的ID
	 * @return	成功返回true, 失败返回false
	 */
	public void deleteData(long id);
	
	/**
	 * 更新数据
	 * @param	user	更新后的User对象
	 * @return	成功返回true, 失败返回false
	 */
	public void updateData(BasicVo basicVo);
	
	/**
	 * 计算表中的数据总数
	 * @param	field	表中的字段名
	 * @return	返回该表的长度
	 */
	public int countTableLength(String field);
	
	/**
	 *	根据用户id查询单个用户的数据
	 *	@param	id	要查询的用户的ID
	 *	@return	返回查询到的用户对象,没有查询到返回一个空对象 
	 */
	public BasicVo queryOneById(long id);
	
	/**
	 * 查询表中的所有数据 
	 * @param	无参数
	 * @return	返回一个User类型的列表,该列表中存储所有表中数据,空表则返回空list
	 */
	public List<BasicVo> queryAll();
	
	/**
	 * 根据姓名查询数据
	 * @param	要查询的用户的姓名
	 * @return	返回一个User类型的列表,该列表中存储所有符合查询条件的数据 ,没有则返回空
	 */
	public List<BasicVo> queryListByName(String name);
	
	/**
	 * 清空整个表
	 * @param	无参数
	 * @return	成功返回true,失败返回false
	 */
	public void clearTable();
}
