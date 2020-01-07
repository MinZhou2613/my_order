package com.my.order.utils;

public class SearchInfo {
	
int pageno=1;//默认在第一页


public int getPrevno() {
	return pageno>1?pageno-1:1;
}
public int getNextno() {
	return pageno+1;
}
public static int maxrow=6;//每页6行
	
public int getPageno() {
	return pageno;
}
public void setPageno(int pageno) {
	if(pageno<1)pageno=1;
	this.pageno = pageno;
	int pos=(pageno-1)*maxrow;
	limit=" limit "+pos+","+maxrow;
}
public void setPagable(boolean pagable) {
	int pos=(pageno-1)*maxrow;
	if(pagable)limit =" limit "+pos+","+maxrow;
	else limit="";
}
String where;
String limit =" limit 0,"+maxrow;
String sort;
public String getWhere() {
	return where;
}
public void setWhere(String where) {
	this.where = where;
}
public String getLimit() {
	return limit;
}
public void setLimit(String limit) {
	this.limit = limit;
}
public String getSort() {
	return sort;
}
public void setSort(String sort) {
	this.sort = sort;
}


}
