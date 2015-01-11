/* 
 * Stock
 *
 * Copyright (c) 2009 Hangzhou ValueSoft Inc., All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ValueSoft Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with ValueSoft.com.
 * 
 * Revision History
 * Date      		Programmer       Notes
 * 2013-12-29   	    juning		     Initial
 **********************************************************************
*/
package com.j.stock.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.List;
import java.util.Map;
public class StockVO extends BaseVO {
	
	public static final String TABLE_ALIAS = "Stock";

	//columns START
	/**
	 * 股票信息
	 */
	private Long id;
	/**
	 * 股票代码
	 */
	private String code;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 当前价
	 */
	private String currentPrice;
	/**
	 * 当日涨跌幅
	 */
	private String quoteChangeTd;
	/**
	 * 当日涨跌额
	 */
	private String amountChangeTd;
	/**
	 * 昨日盘后涨跌幅
	 */
	private String quoteChangeYa;
	/**
	 * 昨日盘后涨跌额
	 */
	private String amountChangeYa;
	/**
	 * 今日盘前涨跌幅
	 */
	private String quoteChangeTb;
	/**
	 * 今日盘前涨跌额
	 */
	private String amountChangeTb;
	/**
	 * 52周股价幅度
	 */
	private String amplitude;
	/**
	 * 成交量
	 */
	private String tradingVolume;
	/**
	 * 总股本
	 */
	private String capitalization;
	/**
	 * 市值
	 */
	private String marketCap;
	/**
	 * 市盈率
	 */
	private String pe;
	
	/**
	 * 新闻信息标题
	 */
	private String stockTitle;
	/**
	 * 新闻信息链接
	 */
	private String stockInfoUrl;
	/**
	 * 新闻信息发布时间
	 */
	private String stockInfoTime;
	
	//columns END
	public StockVO(){
	
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("companyId", getCompanyId())
			.append("code", getCode())
			.append("company", getCompany())
			.append("currentPrice", getCurrentPrice())
			.append("quoteChangeTd", getQuoteChangeTd())
			.append("amountChangeTd", getAmountChangeTd())
			.append("quoteChangeYa", getQuoteChangeYa())
			.append("amountChangeYa", getAmountChangeYa())
			.append("quoteChangeTb", getQuoteChangeTb())
			.append("amountChangeTb", getAmountChangeTb())
			.append("amplitude", getAmplitude())
			.append("tradingVolume", getTradingVolume())
			.append("capitalization", getCapitalization())
			.append("marketCap", getMarketCap())
			.append("pe", getPe())
			.append("dataStatus", getDataStatus())
			.append("createdDate", getCreatedDate())
			.append("modifiedDate", getModifiedDate())
			.append("createdBy", getCreatedBy())
			.append("modifiedBy", getModifiedBy())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCompanyId())
			.append(getCode())
			.append(getCompany())
			.append(getCurrentPrice())
			.append(getQuoteChangeTd())
			.append(getAmountChangeTd())
			.append(getQuoteChangeYa())
			.append(getAmountChangeYa())
			.append(getQuoteChangeTb())
			.append(getAmountChangeTb())
			.append(getAmplitude())
			.append(getTradingVolume())
			.append(getCapitalization())
			.append(getMarketCap())
			.append(getPe())
			.append(getDataStatus())
			.append(getCreatedDate())
			.append(getModifiedDate())
			.append(getCreatedBy())
			.append(getModifiedBy())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockVO == false) return false;
		if(this == obj) return true;
		StockVO other = (StockVO)obj;
		return new EqualsBuilder()
			.append(getId(), other.getId())
			.append(getCompanyId(), other.getCompanyId())
			.append(getCode(), other.getCode())
			.append(getCompany(), other.getCompany())
			.append(getCurrentPrice(), other.getCurrentPrice())
			.append(getQuoteChangeTd(), other.getQuoteChangeTd())
			.append(getAmountChangeTd(), other.getAmountChangeTd())
			.append(getQuoteChangeYa(), other.getQuoteChangeYa())
			.append(getAmountChangeYa(), other.getAmountChangeYa())
			.append(getQuoteChangeTb(), other.getQuoteChangeTb())
			.append(getAmountChangeTb(), other.getAmountChangeTb())
			.append(getAmplitude(), other.getAmplitude())
			.append(getTradingVolume(), other.getTradingVolume())
			.append(getCapitalization(), other.getCapitalization())
			.append(getMarketCap(), other.getMarketCap())
			.append(getPe(), other.getPe())
			.append(getDataStatus(), other.getDataStatus())
			.append(getCreatedDate(), other.getCreatedDate())
			.append(getModifiedDate(), other.getModifiedDate())
			.append(getCreatedBy(), other.getCreatedBy())
			.append(getModifiedBy(), other.getModifiedBy())
			.isEquals();
	}
	
    public void setId(Long value) {
        this.id = value;
    }
    public Long getId() {
        return this.id;
    }
    public void setCode(String value) {
        this.code = value;
    }
    public String getCode() {
        return this.code;
    }
    public void setCompany(String value) {
        this.company = value;
    }
    public String getCompany() {
        return this.company;
    }
    public void setCurrentPrice(String value) {
        this.currentPrice = value;
    }
    public String getCurrentPrice() {
        return this.currentPrice;
    }
    public void setQuoteChangeTd(String value) {
        this.quoteChangeTd = value;
    }
    public String getQuoteChangeTd() {
        return this.quoteChangeTd;
    }
    public void setAmountChangeTd(String value) {
        this.amountChangeTd = value;
    }
    public String getAmountChangeTd() {
        return this.amountChangeTd;
    }
    public void setQuoteChangeYa(String value) {
        this.quoteChangeYa = value;
    }
    public String getQuoteChangeYa() {
        return this.quoteChangeYa;
    }
    public void setAmountChangeYa(String value) {
        this.amountChangeYa = value;
    }
    public String getAmountChangeYa() {
        return this.amountChangeYa;
    }
    public void setQuoteChangeTb(String value) {
        this.quoteChangeTb = value;
    }
    public String getQuoteChangeTb() {
        return this.quoteChangeTb;
    }
    public void setAmountChangeTb(String value) {
        this.amountChangeTb = value;
    }
    public String getAmountChangeTb() {
        return this.amountChangeTb;
    }
    public void setAmplitude(String value) {
        this.amplitude = value;
    }
    public String getAmplitude() {
        return this.amplitude;
    }
    public void setTradingVolume(String value) {
        this.tradingVolume = value;
    }
    public String getTradingVolume() {
        return this.tradingVolume;
    }
    public void setCapitalization(String value) {
        this.capitalization = value;
    }
    public String getCapitalization() {
        return this.capitalization;
    }
    public void setMarketCap(String value) {
        this.marketCap = value;
    }
    public String getMarketCap() {
        return this.marketCap;
    }
    public void setPe(String value) {
        this.pe = value;
    }
    public String getPe() {
        return this.pe;
    }

	public String getStockTitle() {
		return stockTitle;
	}

	public void setStockTitle(String stockTitle) {
		this.stockTitle = stockTitle;
	}

	public String getStockInfoUrl() {
		return stockInfoUrl;
	}

	public void setStockInfoUrl(String stockInfoUrl) {
		this.stockInfoUrl = stockInfoUrl;
	}

	public String getStockInfoTime() {
		return stockInfoTime;
	}

	public void setStockInfoTime(String stockInfoTime) {
		this.stockInfoTime = stockInfoTime;
	}
    
}


