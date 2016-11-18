package com.mangocity.spring.domain;

import java.io.Serializable;

/**
 * 用户信息
 * 
 * @author Jerrik
 */
public class UserVO implements Serializable {
	private static final long serialVersionUID = -5351093608962731039L;

	private String userName;
	
	private String mobileNo;
	
	private String birthday;
	
	private String email;
	
	private String sex;
	
	private String trueName;
	
	private String profession;
	
	private String crops;
	
	private String acreage;
	
	private String photoUrl;
	
	private AddressInfo addressInfo;

	public static class AddressInfo implements Serializable{
		private String provinceName;
		
		private String cityName;
		
		private String districtName;
		
		private String detailAddress;

		public String getProvinceName() {
			return provinceName;
		}

		public void setProvinceName(String provinceName) {
			this.provinceName = provinceName;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getDistrictName() {
			return districtName;
		}

		public void setDistrictName(String districtName) {
			this.districtName = districtName;
		}

		public String getDetailAddress() {
			return detailAddress;
		}

		public void setDetailAddress(String detailAddress) {
			this.detailAddress = detailAddress;
		}

		@Override
		public String toString() {
			return "AddressInfo [provinceName=" + provinceName + ", cityName=" + cityName + ", districtName="
					+ districtName + ", detailAddress=" + detailAddress + "]";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCrops() {
		return crops;
	}

	public void setCrops(String crops) {
		this.crops = crops;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", mobileNo=" + mobileNo
				+ ", birthday=" + birthday + ", email=" + email + ", sex="
				+ sex + ", trueName=" + trueName + ", profession=" + profession
				+ ", crops=" + crops + ", acreage=" + acreage + ", photoUrl="
				+ photoUrl + ", addressInfo=" + addressInfo + "]";
	}
}
