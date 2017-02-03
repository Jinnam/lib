package com.blog.beast4307.service;

public class Cost {
	private int memberRentalCost;
	private int nonMemberRentalCost;
	
	public int getMemberRentalCost() {
		return memberRentalCost;
	}
	public void setMemberRentalCost(int memberRentalCost) {
		this.memberRentalCost = memberRentalCost;
	}
	public int getNonMemberRentalCost() {
		return nonMemberRentalCost;
	}
	public void setNonMemberRentalCost(int nonMemberRentalCost) {
		this.nonMemberRentalCost = nonMemberRentalCost;
	}
	@Override
	public String toString() {
		return "Cost [memberRentalCost=" + memberRentalCost + ", nonMemberRentalCost=" + nonMemberRentalCost + "]";
	}
	
	
}