package com.nongzi.user.iservice;

import java.io.IOException;

public interface IXunjiaService {
	

	String getXunjiaData(String dianpuid, String page, String status,String title,String startDate, String endDate) throws IOException;
	
}
