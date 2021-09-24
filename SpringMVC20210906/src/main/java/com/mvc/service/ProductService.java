package com.mvc.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mvc.products.Group;
import com.mvc.products.Product;

public interface ProductService {
    //�ӫ~����
    Map<Integer, Group> groups = new LinkedHashMap<>(); 
	//�d�ߩҦ��ӫ~���
	List<Product> query ();
	//�d�߳浧�ӫ~���
	Product get(String name);
	//�s�W�ӫ~
	boolean save(Product product);
	//�ק�ӫ~
	boolean updatr(Product product);
	//�R���ӫ~
	boolean delete(String name);
	
}
