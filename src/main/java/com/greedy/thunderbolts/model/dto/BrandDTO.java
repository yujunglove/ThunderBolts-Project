package com.greedy.thunderbolts.model.dto;

import lombok.Data;

@Data
public class BrandDTO {	
	
	private int brandNo;
	private String brandName;
	private AdminProductDTO product;
}
