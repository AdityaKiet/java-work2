package com.aditya;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class ProductList {
	public List<String> productCategories() {
		List<String> list = new ArrayList<>();
		list.add("Cricket");
		list.add("Football");
		return list;
	}
}
