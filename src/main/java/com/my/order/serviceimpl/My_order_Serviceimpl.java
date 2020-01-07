package com.my.order.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.order.entity.My_order;
import com.my.order.mapper.My_order_Mapper;
import com.my.order.service.My_order_Service;
import com.my.order.utils.SearchInfo;

@Service
public class My_order_Serviceimpl implements My_order_Service{
@Autowired
My_order_Mapper mapper;


public List<My_order> select(SearchInfo s){
	return mapper.select(s);
}
public List<My_order> selectALL(){
	return mapper.selectALL();
}
public My_order getByid(int id){
	return mapper.getByid(id);
}
public int insert(My_order my_order) {
	return mapper.insert(my_order);
}
public int update(My_order my_order) {
	return mapper.update(my_order);
}
public int delete(int id)
{
	return mapper.delete(id);
}

public List<My_order> searchMy_order(String key) {
	    return mapper.findAllByGoodsLike("%" + key + "%");
	}

}

