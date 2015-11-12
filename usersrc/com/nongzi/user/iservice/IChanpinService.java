package com.nongzi.user.iservice;

import java.io.IOException;

import com.nongzi.vo.Gongsi;

public interface IChanpinService {
	public String getChanpinData(String userid, String page, String status)throws IOException;
}
