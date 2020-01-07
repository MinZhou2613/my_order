package com.my.order.service;

import java.util.List;

import com.my.order.entity.My_order;
import com.my.order.utils.SearchInfo;

public interface My_order_Service {

	public List<My_order> selectALL();
	public My_order getByid(int id);
	public int insert(My_order my_order);
	public int update(My_order my_order);
	public int delete(int id);
	public List<My_order> select(SearchInfo s);
	public List<My_order> searchMy_order(String key);
	

}
