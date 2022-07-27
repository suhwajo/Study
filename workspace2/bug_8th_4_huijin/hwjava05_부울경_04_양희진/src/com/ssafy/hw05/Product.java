package com.ssafy.hw05;

public class Product {
	private long product_num;
	private String product_name;
	private int price;
	private int count;
	private String info;
	
	Product(){
		
	}
	
	Product(long product_num, String product_name, int price, int count, String info){
		this.product_num = product_num;
		this.product_name = product_name;
		this.price = price;
		this.count = count;
		this.info = info;
	}
	
	public long getProduct_num() {
		return product_num;
	}
	public void setProduct_num(long product_num) {
		this.product_num = product_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품 번호: "+this.product_num+"\t|\t"+;
	}
	
}
