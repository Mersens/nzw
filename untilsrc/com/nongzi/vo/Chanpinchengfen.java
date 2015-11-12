package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;


/**
 * Chanpinchengfen entity. @author MyEclipse Persistence Tools
 */

public class Chanpinchengfen  extends  BaseVo  implements java.io.Serializable {


    // Fields    

     private String chengfenid;
     private String chengfenname;
     private Timestamp addtime;
     private Set leimuorchengfens = new HashSet(0);
     private Set chanpinorchengfens = new HashSet(0);


    // Constructors

    /** default constructor */
    public Chanpinchengfen() {
    }

	/** minimal constructor */
    public Chanpinchengfen(String chengfenname, Timestamp addtime) {
        this.chengfenname = chengfenname;
        this.addtime = addtime;
    }
    
    /** full constructor */
    public Chanpinchengfen(String chengfenname, Timestamp addtime, Set leimuorchengfens, Set chanpinorchengfens) {
        this.chengfenname = chengfenname;
        this.addtime = addtime;
        this.leimuorchengfens = leimuorchengfens;
        this.chanpinorchengfens = chanpinorchengfens;
    }

   
    // Property accessors

    public String getChengfenid() {
        return this.chengfenid;
    }
    
    public void setChengfenid(String chengfenid) {
        this.chengfenid = chengfenid;
    }

    public String getChengfenname() {
        return this.chengfenname;
    }
    
    public void setChengfenname(String chengfenname) {
        this.chengfenname = chengfenname;
    }

    public Timestamp getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Set getLeimuorchengfens() {
        return this.leimuorchengfens;
    }
    
    public void setLeimuorchengfens(Set leimuorchengfens) {
        this.leimuorchengfens = leimuorchengfens;
    }

    public Set getChanpinorchengfens() {
        return this.chanpinorchengfens;
    }
    
    public void setChanpinorchengfens(Set chanpinorchengfens) {
        this.chanpinorchengfens = chanpinorchengfens;
    }
   








}