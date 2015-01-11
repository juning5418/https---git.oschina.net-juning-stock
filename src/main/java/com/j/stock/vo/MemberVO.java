/* 
 * Member
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
 * 2013-06-03   	    chh		     Initial
 **********************************************************************
*/
package com.j.stock.vo;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MemberVO extends BaseVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4547727653453636795L;

	public static final String TABLE_ALIAS = "Member";

	//columns START
	/**
	 * 会员
	 */
	private Long id;
	/**
	 * 积分
	 */
	private Long integral;
	/**
	 * 用户名，用于登入
	 */
	private String username;
	/**
	 * 手机，用于登录
	 */
	private String mobile;
	/**
	 * email，用于登录
	 */
	private String email;
	/**
	 * 会员号码，用于会员卡
	 */
	private String barCode;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 推荐人Id
	 */
	private Long memberId;
	/**
	 * 昵称
	 */
	private String nick;
	/**
	 * 自定义属性
	 */
	private String defProps;
	/**
	 * 身份证
	 */
	private String idCard;
	/**
	 * 中文名
	 */
	private String chName;
	/**
	 * 英文名
	 */
	private String engName;
	/**
	 * 性别,1:男，2：女
	 */
	private Integer gender = 1;
	/**
	 * 生日
	 */
	private java.util.Date birthday;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 婚姻状态，1：已婚，0：未婚
	 */
	private Integer marriageStatus;
	/**
	 * 正职面貌，1：群众，2：共青团员，3党员
	 */
	private Integer politicsStatus;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 短号
	 */
	private String cornet;
	/**
	 * msn
	 */
	private String msn;
	/**
	 * qq
	 */
	private String qq;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 专业
	 */
	private String professional;
	/**
	 * 毕业学校
	 */
	private String graduationSchool;
	/**
	 * 送货地址1
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zipcode;
	/**
	 * 用户状态，1可用，0停用
	 */
	private Integer userStatus;
	/**
	 * 排序，越大越靠前
	 */
	private Long sortOrder;
	/**
	 * 头像
	 */
	private byte[] headPortrait;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * vip等级
	 */
	private Long level;
	/**
	 * 地址2
	 */
	private String address2;
	/**
	 * 充值开始时间
	 */
	private java.util.Date startDate;
	/**
	 * 有效时间
	 */
	private java.util.Date validDate;
	/**
	 * 会员费用,余额
	 */
	private java.math.BigDecimal memberFee;
	/**
	 * 押金费用
	 */
	private java.math.BigDecimal securityFee;
	
	/**
	 * 会员级别名称，从data
	 */
	private String levelName;
	
	/**
	 * 
	 */
	private String hobbies;

	
	private String devicetoken;
	
	//columns END
	public MemberVO(){
	
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("integral", getIntegral())
			.append("mobile", getMobile())
			.append("email", getEmail())
			.append("barCode", getBarCode())
			.append("password", getPassword())
			.append("memberId", getMemberId())
			.append("nick", getNick())
			.append("defProps", getDefProps())
			.append("idCard", getIdCard())
			.append("chName", getChName())
			.append("engName", getEngName())
			.append("gender", getGender())
			.append("birthday", getBirthday())
			.append("nation", getNation())
			.append("nativePlace", getNativePlace())
			.append("marriageStatus", getMarriageStatus())
			.append("politicsStatus", getPoliticsStatus())
			.append("phone", getPhone())
			.append("cornet", getCornet())
			.append("msn", getMsn())
			.append("qq", getQq())
			.append("education", getEducation())
			.append("professional", getProfessional())
			.append("graduationSchool", getGraduationSchool())
			.append("address", getAddress())
			.append("zipcode", getZipcode())
			.append("userStatus", getUserStatus())
			.append("sortOrder", getSortOrder())
			.append("headPortrait", getHeadPortrait())
			.append("remark", getRemark())
			.append("dataStatus", getDataStatus())
			.append("createdDate", getCreatedDate())
			.append("modifiedDate", getModifiedDate())
			.append("createdBy", getCreatedBy())
			.append("modifiedBy", getModifiedBy())
			.append("companyId", getCompanyId())
			.append("level", getLevel())
			.append("address2", getAddress2())
			.append("startDate", getStartDate())
			.append("validDate", getValidDate())
			.append("memberFee", getMemberFee())
			.append("securityFee", getSecurityFee())
			.toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getIntegral())
			.append(getMobile())
			.append(getEmail())
			.append(getBarCode())
			.append(getPassword())
			.append(getMemberId())
			.append(getNick())
			.append(getDefProps())
			.append(getIdCard())
			.append(getChName())
			.append(getEngName())
			.append(getGender())
			.append(getBirthday())
			.append(getNation())
			.append(getNativePlace())
			.append(getMarriageStatus())
			.append(getPoliticsStatus())
			.append(getPhone())
			.append(getCornet())
			.append(getMsn())
			.append(getQq())
			.append(getEducation())
			.append(getProfessional())
			.append(getGraduationSchool())
			.append(getAddress())
			.append(getZipcode())
			.append(getUserStatus())
			.append(getSortOrder())
			.append(getHeadPortrait())
			.append(getRemark())
			.append(getDataStatus())
			.append(getCreatedDate())
			.append(getModifiedDate())
			.append(getCreatedBy())
			.append(getModifiedBy())
			.append(getCompanyId())
			.append(getLevel())
			.append(getAddress2())
			.append(getStartDate())
			.append(getValidDate())
			.append(getMemberFee())
			.append(getSecurityFee())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MemberVO == false) return false;
		if(this == obj) return true;
		MemberVO other = (MemberVO)obj;
		return new EqualsBuilder()
			.append(getId(), other.getId())
			.append(getIntegral(), other.getIntegral())
			.append(getMobile(), other.getMobile())
			.append(getEmail(), other.getEmail())
			.append(getBarCode(), other.getBarCode())
			.append(getPassword(), other.getPassword())
			.append(getMemberId(), other.getMemberId())
			.append(getNick(), other.getNick())
			.append(getDefProps(), other.getDefProps())
			.append(getIdCard(), other.getIdCard())
			.append(getChName(), other.getChName())
			.append(getEngName(), other.getEngName())
			.append(getGender(), other.getGender())
			.append(getBirthday(), other.getBirthday())
			.append(getNation(), other.getNation())
			.append(getNativePlace(), other.getNativePlace())
			.append(getMarriageStatus(), other.getMarriageStatus())
			.append(getPoliticsStatus(), other.getPoliticsStatus())
			.append(getPhone(), other.getPhone())
			.append(getCornet(), other.getCornet())
			.append(getMsn(), other.getMsn())
			.append(getQq(), other.getQq())
			.append(getEducation(), other.getEducation())
			.append(getProfessional(), other.getProfessional())
			.append(getGraduationSchool(), other.getGraduationSchool())
			.append(getAddress(), other.getAddress())
			.append(getZipcode(), other.getZipcode())
			.append(getUserStatus(), other.getUserStatus())
			.append(getSortOrder(), other.getSortOrder())
			.append(getHeadPortrait(), other.getHeadPortrait())
			.append(getRemark(), other.getRemark())
			.append(getDataStatus(), other.getDataStatus())
			.append(getCreatedDate(), other.getCreatedDate())
			.append(getModifiedDate(), other.getModifiedDate())
			.append(getCreatedBy(), other.getCreatedBy())
			.append(getModifiedBy(), other.getModifiedBy())
			.append(getCompanyId(), other.getCompanyId())
			.append(getLevel(), other.getLevel())
			.append(getAddress2(), other.getAddress2())
			.append(getStartDate(), other.getStartDate())
			.append(getValidDate(), other.getValidDate())
			.append(getMemberFee(), other.getMemberFee())
			.append(getSecurityFee(), other.getSecurityFee())
			.isEquals();
	}
	
    public void setId(Long value) {
        this.id = value;
    }
    public Long getId() {
        return this.id;
    }
    public void setIntegral(Long value) {
        this.integral = value;
    }
    public Long getIntegral() {
        return this.integral;
    }
    public void setMobile(String value) {
        this.mobile = value;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setEmail(String value) {
        this.email = value;
    }
    public String getEmail() {
        return this.email;
    }
    public void setBarCode(String value) {
        this.barCode = value;
    }
    public String getBarCode() {
        return this.barCode;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public String getPassword() {
        return this.password;
    }
    public void setMemberId(Long value) {
        this.memberId = value;
    }
    public Long getMemberId() {
        return this.memberId;
    }
    public void setNick(String value) {
        this.nick = value;
    }
    public String getNick() {
        return this.nick;
    }
    public void setDefProps(String value) {
        this.defProps = value;
    }
    public String getDefProps() {
        return this.defProps;
    }
    public void setIdCard(String value) {
        this.idCard = value;
    }
    public String getIdCard() {
        return this.idCard;
    }
    public void setChName(String value) {
        this.chName = value;
    }
    public String getChName() {
        return this.chName;
    }
    public void setEngName(String value) {
        this.engName = value;
    }
    public String getEngName() {
        return this.engName;
    }
    public void setGender(Integer value) {
        this.gender = value;
    }
    public Integer getGender() {
        return this.gender;
    }
    public void setBirthday(java.util.Date value) {
        this.birthday = value;
    }
    public java.util.Date getBirthday() {
        return this.birthday;
    }
    public void setNation(String value) {
        this.nation = value;
    }
    public String getNation() {
        return this.nation;
    }
    public void setNativePlace(String value) {
        this.nativePlace = value;
    }
    public String getNativePlace() {
        return this.nativePlace;
    }
    public void setMarriageStatus(Integer value) {
        this.marriageStatus = value;
    }
    public Integer getMarriageStatus() {
        return this.marriageStatus;
    }
    public void setPoliticsStatus(Integer value) {
        this.politicsStatus = value;
    }
    public Integer getPoliticsStatus() {
        return this.politicsStatus;
    }
    public void setPhone(String value) {
        this.phone = value;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setCornet(String value) {
        this.cornet = value;
    }
    public String getCornet() {
        return this.cornet;
    }
    public void setMsn(String value) {
        this.msn = value;
    }
    public String getMsn() {
        return this.msn;
    }
    public void setQq(String value) {
        this.qq = value;
    }
    public String getQq() {
        return this.qq;
    }
    public void setEducation(String value) {
        this.education = value;
    }
    public String getEducation() {
        return this.education;
    }
    public void setProfessional(String value) {
        this.professional = value;
    }
    public String getProfessional() {
        return this.professional;
    }
    public void setGraduationSchool(String value) {
        this.graduationSchool = value;
    }
    public String getGraduationSchool() {
        return this.graduationSchool;
    }
    public void setAddress(String value) {
        this.address = value;
    }
    public String getAddress() {
        return this.address;
    }
    public void setZipcode(String value) {
        this.zipcode = value;
    }
    public String getZipcode() {
        return this.zipcode;
    }
    public void setUserStatus(Integer value) {
        this.userStatus = value;
    }
    public Integer getUserStatus() {
        return this.userStatus;
    }
    public void setSortOrder(Long value) {
        this.sortOrder = value;
    }
    public Long getSortOrder() {
        return this.sortOrder;
    }
    public void setHeadPortrait(byte[] value) {
        this.headPortrait = value;
    }
    public byte[] getHeadPortrait() {
        return this.headPortrait;
    }
    public void setRemark(String value) {
        this.remark = value;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setLevel(Long value) {
        this.level = value;
    }
    public Long getLevel() {
        return this.level;
    }
    public void setAddress2(String value) {
        this.address2 = value;
    }
    public String getAddress2() {
        return this.address2;
    }
    public void setStartDate(java.util.Date value) {
        this.startDate = value;
    }
    public java.util.Date getStartDate() {
        return this.startDate;
    }
    public void setValidDate(java.util.Date value) {
        this.validDate = value;
    }
    public java.util.Date getValidDate() {
        return this.validDate;
    }
    public void setMemberFee(java.math.BigDecimal value) {
        this.memberFee = value;
    }
    public java.math.BigDecimal getMemberFee() {
        return this.memberFee;
    }
    public void setSecurityFee(java.math.BigDecimal value) {
        this.securityFee = value;
    }
    public java.math.BigDecimal getSecurityFee() {
        return this.securityFee;
    }


	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}


	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}


