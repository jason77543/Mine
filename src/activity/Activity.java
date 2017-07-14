package activity;

import java.io.Serializable;
import java.sql.Date;

import sun.awt.image.BytePackedRaster;


public class Activity implements Serializable{
	private Integer actNo;
	private String restId;
	private String actName;
	private String actContent;
	private Date actDate;
	private Date actFDate;
	private Integer actStatus;
	private Integer actULimit;
	private Integer actLLimit;
	private Integer actKind;
	private String actAnotherKind;
	private byte[] actInitImg;
	
	
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Activity(Integer actNo, String restId, String actName, String actContent, Date actDate, Date actFDate,
			Integer actStatus, Integer actULimit, Integer actLLimit, Integer actKind, String actAnotherKind,
			byte[] actInitImg) {
		super();
		this.actNo = actNo;
		this.restId = restId;
		this.actName = actName;
		this.actContent = actContent;
		this.actDate = actDate;
		this.actFDate = actFDate;
		this.actStatus = actStatus;
		this.actULimit = actULimit;
		this.actLLimit = actLLimit;
		this.actKind = actKind;
		this.actAnotherKind = actAnotherKind;
		this.actInitImg = actInitImg;
	}
	public Integer getActNo() {
		return actNo;
	}
	public void setActNo(Integer actNo) {
		this.actNo = actNo;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
		this.restId = restId;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getActContent() {
		return actContent;
	}
	public void setActContent(String actContent) {
		this.actContent = actContent;
	}
	public Date getActDate() {
		return actDate;
	}
	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}
	public Date getActFDate() {
		return actFDate;
	}
	public void setActFDate(Date actFDate) {
		this.actFDate = actFDate;
	}
	public Integer getActStatus() {
		return actStatus;
	}
	public void setActStatus(Integer actStatus) {
		this.actStatus = actStatus;
	}
	public Integer getActULimit() {
		return actULimit;
	}
	public void setActULimit(Integer actULimit) {
		this.actULimit = actULimit;
	}
	public Integer getActLLimit() {
		return actLLimit;
	}
	public void setActLLimit(Integer actLLimit) {
		this.actLLimit = actLLimit;
	}
	public Integer getActKind() {
		return actKind;
	}
	public void setActKind(Integer actKind) {
		this.actKind = actKind;
	}
	public String getActAnotherKind() {
		return actAnotherKind;
	}
	public void setActAnotherKind(String actAnotherKind) {
		this.actAnotherKind = actAnotherKind;
	}
	public byte[] getActInitImg() {
		return actInitImg;
	}
	public void setActInitImg(byte[] actInitImg) {
		this.actInitImg = actInitImg;
	}
}
