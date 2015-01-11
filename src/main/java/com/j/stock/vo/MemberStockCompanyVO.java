/* 
 * MemberStockCompany
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
public class MemberStockCompanyVO extends BaseVO {
	
	public static final String TABLE_ALIAS = "MemberStockCompany";

	//columns START
	/**
	 * 股票公司用户关联信息
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long memberId;
	/**
	 * 股票代码
	 */
	private String code;
	//columns END
	public MemberStockCompanyVO(){
	
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("companyId", getCompanyId())
			.append("memberId", getMemberId())
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
			.append(getCompanyId())
			.append(getMemberId())
			.append(getCode())
			.append(getDataStatus())
			.append(getCreatedDate())
			.append(getModifiedDate())
			.append(getCreatedBy())
			.append(getModifiedBy())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MemberStockCompanyVO == false) return false;
		if(this == obj) return true;
		MemberStockCompanyVO other = (MemberStockCompanyVO)obj;
		return new EqualsBuilder()
			.append(getId(), other.getId())
			.append(getCompanyId(), other.getCompanyId())
			.append(getMemberId(), other.getMemberId())
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
    public void setMemberId(Long value) {
        this.memberId = value;
    }
    public Long getMemberId() {
        return this.memberId;
    }
    public void setCode(String value) {
        this.code = value;
    }
    public String getCode() {
        return this.code;
    }
}


