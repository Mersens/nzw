package com.nongzi.user.iservice;

import java.io.IOException;

import com.nongzi.vo.Gongsi;

public interface IGongsiService {
	
	public String getGongsiDongtaiData(String userid, String page,String keywords)throws IOException;
	
	public Gongsi addGongsiXinxi(Gongsi gongsi);
	
	public Gongsi updateGongsiXinxi(Gongsi gongsi);
	
}
