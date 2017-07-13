package restImg;

import java.io.Serializable;

public class RestImg implements Serializable{

	private Integer restImgNo;
	private String restId;
	private String restImgName;
	private String restImgIntro;
	
	
	
	public RestImg() {
		
		
	}

	public RestImg(Integer restImgNo, String restId, String restImgName, String restImgIntro) {
		super();
		this.restImgNo = restImgNo;
		this.restId = restId;
		this.restImgName = restImgName;
		this.restImgIntro = restImgIntro;
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
