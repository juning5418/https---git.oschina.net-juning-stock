/* 
 * stockCompany
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
public class StockCompanyVO extends BaseVO {
	
	public static final String TABLE_ALIAS = "stockCompany";

	//columns START
	/**
	 * 股票公司信息
	 */
	private Long id;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 股票代码
	 */
	private String code;
	//columns END
	public StockCompanyVO(){
	
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("company", getCompany())
			.append("code", getCode())
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
			.append(getCompany())
			.append(getCode())
			.append(getDataStatus())
			.append(getCreatedDate())
			.append(getModifiedDate())
			.append(getCreatedBy())
			.append(getModifiedBy())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockCompanyVO == false) return false;
		if(this == obj) return true;
		StockCompanyVO other = (StockCompanyVO)obj;
		return new EqualsBuilder()
			.append(getId(), other.getId())
			.append(getCompany(), other.getCompany())
			.append(getCode(), other.getCode())
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
    public void setCompany(String value) {
        this.company = value;
    }
    public String getCompany() {
        return this.company;
    }
    public void setCode(String value) {
        this.code = value;
    }
    public String getCode() {
        return this.code;
    }
}


