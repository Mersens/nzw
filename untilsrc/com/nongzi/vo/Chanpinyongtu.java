package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;


/**
 * Chanpinyongtu entity. @author MyEclipse Persistence Tools
 */

public class Chanpinyongtu extends  BaseVo implements java.io.Serializable {


    // Fields    

     private String yongtuid;
     private String yongtuname;
     private Timestamp addtime;
     private Set leimuoryongtus = new HashSet(0);
     private Set chanpinoryongtus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Chanpinyongtu() {
    }

	/** minimal constructor */
    public Chanpinyongtu(String yongtuname, Timestamp addtime) {
        this.yongtuname = yongtuname;
        this.addtime = addtime;
    }
    
    /** full constructor */
    public Chanpinyongtu(String yongtuname, Timestamp addtime, Set leimuoryongtus, Set chanpinoryongtus) {
        this.yongtuname = yongtuname;
        this.addtime = addtime;
        this.leimuoryongtus = leimuoryongtus;
        this.chanpinoryongtus = chanpinoryongtus;
    }

   
    // Property accessors

    public String getYongtuid() {
        return this.yongtuid;
    }
    
    public void setYongtuid(String yongtuid) {
        this.yongtuid = yongtuid;
    }

    public String getYongtuname() {
        return this.yongtuname;
    }
    
    public void setYongtuname(String yongtuname) {
        this.yongtuname = yongtuname;
    }

    public Timestamp getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Set getLeimuoryongtus() {
        return this.leimuoryongtus;
    }
    
    public void setLeimuoryongtus(Set leimuoryongtus) {
        this.leimuoryongtus = leimuoryongtus;
    }

    public Set getChanpinoryongtus() {
        return this.chanpinoryongtus;
    }
    
    public void setChanpinoryongtus(Set chanpinoryongtus) {
        this.chanpinoryongtus = chanpinoryongtus;
    }
   








}