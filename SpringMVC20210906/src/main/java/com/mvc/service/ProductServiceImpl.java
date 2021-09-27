package com.mvc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.mvc.entity.products.Group;
import com.mvc.entity.products.Product;

@Service
public class ProductServiceImpl implements ProductService {
    //{}�غc�l�@�ι�@
	{
		if (groups.size()==0) {
			//��l�ưӫ~�������
			groups.put(1, new Group(1,"A"));
			groups.put(2, new Group(2,"B"));
			groups.put(3, new Group(3,"C"));
		}
	}
	
	@Override
	public List<Product> query() {
		
		return products;
	}

	@Override
	public Product get(String name) {
	Optional<Product> opt=products.stream()
			                      .filter(p -> p.getName().equals(name))
			                      .findAny();
		
	return opt.isPresent()?opt.get():null;
	}

	@Override
	public boolean save(Product product) {
	    //1.�ھ�group.gid���group����
		//2.�Ngroup����s���product��
		Group group= groups.get(product.getGroup().getGid());
				
		product.setGroup(group);
		products.add(product);
		return true;
	}

	@Override
	public boolean update(Product product) {
		//�O�_����즹����� ����(oProduct)
		Product oProduct = get(product.getName()); 
		Group group= groups.get(product.getGroup().getGid());
		
		product.setGroup(group);
		if (oProduct==null) {  //�L���ӵ����
			
			return false;
		}
		//�i��update
		oProduct.setGroup(product.getGroup());
		oProduct.setName(product.getName());
		oProduct.setPrice(product.getPrice());
		oProduct.setAmount(product.getAmount());
		oProduct.setDate(product.getDate());
		return true;
	}

	@Override
	public boolean delete(String name) {
		
		return products.removeIf(p -> p.getName().equals(name));
	}

}
