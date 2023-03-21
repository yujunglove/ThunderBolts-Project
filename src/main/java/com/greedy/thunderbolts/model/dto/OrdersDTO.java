package com.greedy.thunderbolts.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrdersDTO {
	private int orderNo;
	private int memberBuyer;
	private int ordersPrice;
	private Date ordersDate;
	private String ordersDiv;
	private int membersSeller;
	private String ordersStatus;
	private int buyingOrderCode;

}