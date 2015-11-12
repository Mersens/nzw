package com.nongzi.web.serviceImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nongzi.util.BaseUtil;
import com.nongzi.web.iservice.IWebsiteService;
/**
 * 实现接口
 * @author 朱庆杰
 *
 */
public class WebsiteServiceImpl implements IWebsiteService {
	@Autowired
	private BaseUtil bu;
	private Logger log = Logger.getLogger(this.getClass());

}
