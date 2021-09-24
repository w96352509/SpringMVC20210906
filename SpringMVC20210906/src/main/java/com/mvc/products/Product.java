package com.mvc.products;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {
   
   @NotNull(message = "�п�ܰӫ~����")
   @NotBlank(message = "�п�ܰӫ~����")
   private Group group; //�ӫ~����
   
   @NotBlank(message = "�ӫ~�W�٤��i�O�ŭ�")
   @Size(min = 3 , max = 50 , message = "�ӫ~�W�٤���3~50�r����")
   private String name; //�ӫ~�W��
   
   @NotBlank(message = "�ӫ~���椣�i�O�ŭ�")
   @Range(min = 1 , max = 10000  , message = "�ӫ~���椶��1~1W����")
   private Double price ; //�ӫ~����
   
   @NotBlank(message = "�ӫ~�ƶq���i�O�ŭ�")
   @Min(value = 1 , message = "�ӫ~�ƶq�����j�󵥩�1")
   private Integer amount ; //�ӫ~�ƶq
   
   @PastOrPresent(message = "�W��������i�j�󤵤�")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date date ; //�W�����

public Group getGroup() {
	return group;
}

public void setGroup(Group group) {
	this.group = group;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Integer getAmount() {
	return amount;
}

public void setAmount(Integer amount) {
	this.amount = amount;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

@Override
public String toString() {
	return "Product [group=" + group + ", name=" + name + ", price=" + price + ", amount=" + amount + ", date=" + date
			+ "]";
}
   
   
}
