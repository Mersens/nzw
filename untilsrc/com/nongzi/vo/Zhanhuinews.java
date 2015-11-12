package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Zhanhuinews entity. @author MyEclipse Persistence Tools
 */

public class Zhanhuinews implements java.io.Serializable {

	// Fields

	private String newsid;
	private Zhanhuitype zhanhuitype;
	private Zhanhui zhanhui;
	private String title;
	private String newsimg;
	private String newssrc;
	private String description;
	private String center;
	private String chengcheluxian;
	private Integer status;
	private Integer ishot;
	private Timestamp addtime;
	private String zhubandanwei;
	private String chengbandanwei;
	private String xiebandanwei;
	private String meitizhichi;
	private String zhanhuianpai;
	private String canzhanfanwei;
	private String zhutihuodong;
	private String canzhanxize;
	private String chengyaoxiebandanwei;
	private String dianhua;
	private String chuanzhen;
	private String lianxiren;
	private String shouji;
	private String youxiang;
	private String qq;
	private Integer htmlid;

	// Constructors

	/** default constructor */
	public Zhanhuinews() {
	}

	/** minimal constructor */
	public Zhanhuinews(String title, String newsimg, String newssrc,
			String description, String center, Integer htmlid) {
		this.title = title;
		this.newsimg = newsimg;
		this.newssrc = newssrc;
		this.description = description;
		this.center = center;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Zhanhuinews(Zhanhuitype zhanhuitype, Zhanhui zhanhui, String title,
			String newsimg, String newssrc, String description, String center,
			String chengcheluxian, Integer status, Integer ishot,
			Timestamp addtime, String zhubandanwei, String chengbandanwei,
			String xiebandanwei, String meitizhichi, String zhanhuianpai,
			String canzhanfanwei, String zhutihuodong, String canzhanxize,
			String chengyaoxiebandanwei, String dianhua, String chuanzhen,
			String lianxiren, String shouji, String youxiang, String qq,
			Integer htmlid) {
		this.zhanhuitype = zhanhuitype;
		this.zhanhui = zhanhui;
		this.title = title;
		this.newsimg = newsimg;
		this.newssrc = newssrc;
		this.description = description;
		this.center = center;
		this.chengcheluxian = chengcheluxian;
		this.status = status;
		this.ishot = ishot;
		this.addtime = addtime;
		this.zhubandanwei = zhubandanwei;
		this.chengbandanwei = chengbandanwei;
		this.xiebandanwei = xiebandanwei;
		this.meitizhichi = meitizhichi;
		this.zhanhuianpai = zhanhuianpai;
		this.canzhanfanwei = canzhanfanwei;
		this.zhutihuodong = zhutihuodong;
		this.canzhanxize = canzhanxize;
		this.chengyaoxiebandanwei = chengyaoxiebandanwei;
		this.dianhua = dianhua;
		this.chuanzhen = chuanzhen;
		this.lianxiren = lianxiren;
		this.shouji = shouji;
		this.youxiang = youxiang;
		this.qq = qq;
		this.htmlid = htmlid;
	}

	// Property accessors

	public String getNewsid() {
		return this.newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public Zhanhuitype getZhanhuitype() {
		return this.zhanhuitype;
	}

	public void setZhanhuitype(Zhanhuitype zhanhuitype) {
		this.zhanhuitype = zhanhuitype;
	}

	public Zhanhui getZhanhui() {
		return this.zhanhui;
	}

	public void setZhanhui(Zhanhui zhanhui) {
		this.zhanhui = zhanhui;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsimg() {
		return this.newsimg;
	}

	public void setNewsimg(String newsimg) {
		this.newsimg = newsimg;
	}

	public String getNewssrc() {
		return this.newssrc;
	}

	public void setNewssrc(String newssrc) {
		this.newssrc = newssrc;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getChengcheluxian() {
		return this.chengcheluxian;
	}

	public void setChengcheluxian(String chengcheluxian) {
		this.chengcheluxian = chengcheluxian;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIshot() {
		return this.ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getZhubandanwei() {
		return this.zhubandanwei;
	}

	public void setZhubandanwei(String zhubandanwei) {
		this.zhubandanwei = zhubandanwei;
	}

	public String getChengbandanwei() {
		return this.chengbandanwei;
	}

	public void setChengbandanwei(String chengbandanwei) {
		this.chengbandanwei = chengbandanwei;
	}

	public String getXiebandanwei() {
		return this.xiebandanwei;
	}

	public void setXiebandanwei(String xiebandanwei) {
		this.xiebandanwei = xiebandanwei;
	}

	public String getMeitizhichi() {
		return this.meitizhichi;
	}

	public void setMeitizhichi(String meitizhichi) {
		this.meitizhichi = meitizhichi;
	}

	public String getZhanhuianpai() {
		return this.zhanhuianpai;
	}

	public void setZhanhuianpai(String zhanhuianpai) {
		this.zhanhuianpai = zhanhuianpai;
	}

	public String getCanzhanfanwei() {
		return this.canzhanfanwei;
	}

	public void setCanzhanfanwei(String canzhanfanwei) {
		this.canzhanfanwei = canzhanfanwei;
	}

	public String getZhutihuodong() {
		return this.zhutihuodong;
	}

	public void setZhutihuodong(String zhutihuodong) {
		this.zhutihuodong = zhutihuodong;
	}

	public String getCanzhanxize() {
		return this.canzhanxize;
	}

	public void setCanzhanxize(String canzhanxize) {
		this.canzhanxize = canzhanxize;
	}

	public String getChengyaoxiebandanwei() {
		return this.chengyaoxiebandanwei;
	}

	public void setChengyaoxiebandanwei(String chengyaoxiebandanwei) {
		this.chengyaoxiebandanwei = chengyaoxiebandanwei;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getChuanzhen() {
		return this.chuanzhen;
	}

	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}

	public String getLianxiren() {
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getShouji() {
		return this.shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getYouxiang() {
		return this.youxiang;
	}

	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getHtmlid() {
		return this.htmlid;
	}

	public void setHtmlid(Integer htmlid) {
		this.htmlid = htmlid;
	}

}