package com.umar.expensetracker.domain;

public class Transaction {
	private Integer transactionId;
	private Integer userId;
	private Double amount;
	private String note;
	private Long transactionDate;

	public Transaction(int transaction_id, Integer transactionId, Integer userId, Double amount, String note, Long transactionDate) {
		this.transactionId = transactionId;
		this.userId = userId;
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}
}
