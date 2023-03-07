package com.forexchange.currencyconverter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ExchangeRate")
public class CurrencyRates {
    
	@Id
	@Column(name="Id")
	int id;
	@Column(name=" fromcurrency")
	String fromcurrency;
	@Column(name="tocurrency")
	String tocurrency;
	@Column(name="exchangeRate")
	BigDecimal exchangeRate;
	@Column(name="TotalValue")
	BigDecimal totalCalculatedAmount;
	@Column(name="Amount")
	BigDecimal conversionMultiple;
	@Column(name="source")
	 String source;
	int port;
	
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "cid")
	transient Rates rates;	
	
	public CurrencyRates() {
		super();
	}

	public CurrencyRates(String fromcurrency, String tocurrency) {
		super();
		this.fromcurrency = fromcurrency;
		this.tocurrency = tocurrency;
	}
	
	

	public CurrencyRates(int id, String fromcurrency, String tocurrency, BigDecimal exchangeRate,
			BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, int port) {
		
		this.id=id;
		this.fromcurrency=fromcurrency;
				this.tocurrency=tocurrency;
		this.exchangeRate=exchangeRate;
				this.conversionMultiple=conversionMultiple;
					this.totalCalculatedAmount=totalCalculatedAmount;
				this.port=port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getFromcurrency() {
		return fromcurrency;
	}

	public void setFromcurrency(String fromcurrency) {
		this.fromcurrency = fromcurrency;
	}

	public String getTocurrency() {
		return tocurrency;
	}

	public void setTocurrency(String tocurrency) {
		this.tocurrency = tocurrency;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "CurrencyRates [fromcurrency=" + fromcurrency + ", tocurrency=" + tocurrency + ", exchangeRate="
				+ exchangeRate + ", source=" + source + "]";
	}

	
	
	
	
	
	
}
