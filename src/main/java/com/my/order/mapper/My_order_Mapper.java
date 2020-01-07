package com.my.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.my.order.entity.My_order;
import com.my.order.utils.SearchInfo;

@Repository
public interface My_order_Mapper {
	@Select("select * from My_order ${where} ${sort} ${limit}")
	public List<My_order> select(SearchInfo s);  //${where} ${sort} ${limit} 三个值将由SearchInfo提供
	
	@Select("select * from My_order")
	public List<My_order> selectALL();
	
	@Select("select * from My_order where id=#{id}")
	public My_order getByid(int id);
	
	@Insert("insert into My_order(id,goods,price,create_time,customer) values(#{id},#{goods},#{price},#{create_time},#{customer})")
	public int insert(My_order my_order);
	
	@Insert("update My_order set goods=#{goods},price=#{price},customer=#{customer} where id=#{id}")
	public int update(My_order my_order);
	
	@Delete("delete from My_order where id=#{id}")
	public int delete(int id);

	@Select("select * from My_order")
	public List<My_order> findAllByGoodsLike(String key);
	



}
