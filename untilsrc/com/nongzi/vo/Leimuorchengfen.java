package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;


/**
 * Leimuorchengfen entity. @author MyEclipse Persistence Tools
 */

public class Leimuorchengfen  extends BaseVo implements java.io.Serializable {


    // Fields    

     private String lcid;
     private Leimu leimu;
     private Chanpinchengfen chanpinchengfen;
     private Integer orderval;
     private Timestamp addtime;


    // Constructors

    /** default constructor */
    public Leimuorchengfen() {
    }

    
    /** full constructor */
    public Leimuorchengfen(Leimu leimu, Chanpinchengfen chanpinchengfen, Integer orderval, Timestamp addtime) {
        this.leimu = leimu;
        this.chanpinchengfen = chanpinchengfen;
        this.orderval = orderval;
        this.addtime = addtime;
    }

   
    // Property accessors

    public String getLcid() {
        return this.lcid;
    }
    
    public void setLcid(String lcid) {
        this.lcid = lcid;
    }

    public Leimu getLeimu() {
        return this.leimu;
    }
    
    public void setLeimu(Leimu leimu) {
        this.leimu = leimu;
    }

    public Chanpinchengfen getChanpinchengfen() {
        return this.chanpinchengfen;
    }
    
    public void setChanpinchengfen(Chanpinchengfen chanpinchengfen) {
        this.chanpinchengfen = chanpinchengfen;
    }

    public Integer getOrderval() {
        return this.orderval;
    }
    
    public void setOrderval(Integer orderval) {
        this.orderval = orderval;
    }

    public Timestamp getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }
   








}