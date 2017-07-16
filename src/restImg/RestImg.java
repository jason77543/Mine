package restImg;

import java.io.Serializable;

public class RestImg implements Serializable{

	private Integer restImgNo;
	private String restId;
	private String restImgName;
	private String restImgIntro;
	private byte[] restImg;
	
	
	public RestImg() {
		
		
	}

	
	
	public RestImg(Integer restImgNo, String restId, String restImgName, String restImgIntro, byte[] restImg) {
		super();
		this.restImgNo = restImgNo;
		this.restId = restId;
		this.restImgName = restImgName;
		this.restImgIntro = restImgIntro;
		this.restImg = restImg;
	}



	public byte[] getRestImg() {
		return restImg;
	}



	public void setRestImg(byte[] restImg) {
		this.restImg = restImg;
	}



	public Integer getRestImgNo() {
		return restImgNo;
	}
	public void setRestImgNo(Integer restImgNo) {
		this.restImgNo = restImgNo;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
		this.restId = restId;
	}
	public String getRestImgName() {
		return restImgName;
	}
	public void setRestImgName(String restImgName) {
		this.restImgName = restImgName;
	}
	public String getRestImgIntro() {
		return restImgIntro;
	}
	public void setRestImgIntro(String restImgIntro) {
		this.restImgIntro = restImgIntro;
	}
	
	
	

}
