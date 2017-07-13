package restList;

import java.io.Serializable;

public class RestList implements Serializable{
	private Integer restListNo;
	private String restListName;
	private String restListAdd;
	private String restListPhone;
	private String restListIntro;
	private Integer restListKind;
	private byte[] restListImg;
	
	public RestList() {
		super();
	}
	public Integer getRestListNo() {
		return restListNo;
	}
	public void setRestListNo(Integer restListNo) {
		this.restListNo = restListNo;
	}
	public String getRestListName() {
		return restListName;
	}
	public void setRestListName(String restListName) {
		this.restListName = restListName;
	}
	public String getRestListAdd() {
		return restListAdd;
	}
	public void setRestListAdd(String restListAdd) {
		this.restListAdd = restListAdd;
	}
	public String getRestListPhone() {
		return restListPhone;
	}
	public void setRestListPhone(String restListPhone) {
		this.restListPhone = restListPhone;
	}
	public String getRestListIntro() {
		return restListIntro;
	}
	public void setRestListIntro(String restListIntro) {
		this.restListIntro = restListIntro;
	}
	public Integer getRestListKind() {
		return restListKind;
	}
	public void setRestListKind(Integer restListKind) {
		this.restListKind = restListKind;
	}
	public byte[] getRestListImg() {
		return restListImg;
	}
	public void setRestListImg(byte[] restListImg) {
		this.restListImg = restListImg;
	}
	public RestList(Integer restListNo, String restListName, String restListAdd, String restListPhone,
			String restListIntro, Integer restListKind, byte[] restListImg) {
		super();
		this.restListNo = restListNo;
		this.restListName = restListName;
		this.restListAdd = restListAdd;
		this.restListPhone = restListPhone;
		this.restListIntro = restListIntro;
		this.restListKind = restListKind;
		this.restListImg = restListImg;
	}
}
