package com.example.spring.checksplit.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="checks")
public class Check {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String restaurant;
	private Double subtotal;
	private Double taxAmount;
	private Integer partySize;
	private Integer itemsOrdered;
	private Date date;
	private String city;
	
	@OneToMany(mappedBy="check", fetch=FetchType.LAZY)
	private List<Order> orders;
	
	public Check() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Integer getPartySize() {
		return partySize;
	}
	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}
	public Integer getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(Integer itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


}
