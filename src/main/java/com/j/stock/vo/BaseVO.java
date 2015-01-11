package com.j.stock.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BaseVO implements Serializable{
	/**
	 * 公司id
	 */
    protected Long companyId;
	/**
	 * 公司编号
	 */
    protected String companyCode;
	/**
	 * 组织id
	 */
    protected Long orgId;
    /**
     * 数据是否可用，0不可用，1可用，2停用
     */
    protected Integer dataStatus = 1;
    /**
     * 创建时间
     */
    protected Date createdDate = new Date();
    /**
     * 修改时间
     */
    protected Date modifiedDate;
    /**
     * 创建者
     */
    protected Long createdBy;
    protected String createdName;
    /**
     * 修改者
     */
    protected Long modifiedBy;
    /**
     * 是否已经改变
     */
    protected Boolean dataChange;
    protected Map<String,Object> map = new HashMap<String, Object>();
	public Integer getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Boolean getDataChange() {
		return dataChange;
	}
	public void setDataChange(Boolean dataChange) {
		this.dataChange = dataChange;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getCreatedName() {
        return createdName;
    }
    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }
   
}
