package com.sunjoy.trm.web.master.vo;

import java.io.Serializable;

public class CourseVo implements Serializable{
	/**
	 * @serialField  serialVersionUID
	 */
	private static final long serialVersionUID = -2697315752667117417L;
	
	private String id;
	private String name;//课程名
	private Integer level;//级别
	private Integer phase;//阶段
	private Integer ageGradeStart;//年龄阶段开始
	private Integer ageGradeEnd;//年龄阶段结束
	private Integer numberPerTerm;//每期节数
	private Integer pricePerTerm;//每期学费
	private String status;//状态
	private String memo;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getPhase() {
		return phase;
	}
	public void setPhase(Integer phase) {
		this.phase = phase;
	}
	public Integer getAgeGradeStart() {
		return ageGradeStart;
	}
	public void setAgeGradeStart(Integer ageGradeStart) {
		this.ageGradeStart = ageGradeStart;
	}
	public Integer getAgeGradeEnd() {
		return ageGradeEnd;
	}
	public void setAgeGradeEnd(Integer ageGradeEnd) {
		this.ageGradeEnd = ageGradeEnd;
	}
	public Integer getNumberPerTerm() {
		return numberPerTerm;
	}
	public void setNumberPerTerm(Integer numberPerTerm) {
		this.numberPerTerm = numberPerTerm;
	}
	public Integer getPricePerTerm() {
		return pricePerTerm;
	}
	public void setPricePerTerm(Integer pricePerTerm) {
		this.pricePerTerm = pricePerTerm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
