package com.nongzi.user.serviceImpl;


import java.io.File;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.UUID;

import net.maxt.image.ImageUtil;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.nongzi.user.iservice.IImgService;



public class ImgServiceImpl implements IImgService {
	//设置图片上传的根目录
	public String path = "D:/tomcat/tomcatTest/webapps/ROOT/resources";
	//设置用户上传图片的目录
	public String path_xiangmu = "D:/tomcat/tomcatTest/webapps/ROOT/resources/userfile/";
	//定义log4j对象
	private Logger log = Logger.getLogger(this.getClass());

	
	
	/**
	 * 根据设置的大小设置一个图片并上传,返回压缩过的图片
	 * @param file  上传的文件对象
	 * @param x 生成图像的大小
	 * @param request 请求的request对象
	 * @return  String 原来的文件名_现在的文件名_现在的文件路径 <br/>
	 * String  fileismax：文件过大 <br/>
	 * String fileisnull：文件为空 <br/>
	 * String fileisException：文件异常 <br/>
	 * @throws RemoteException
	 */
	@Override
	public String upload(MultipartFile file,int x){
		//当文件大于10兆是返回max表示文件过大
		if (file.getSize() > 1024*1024*10) {
			return "fileismax";
		}
		//当文件为空时返回fileisnull
		if (file.getOriginalFilename().equals("")) {
			return "fileisnull";
		} 
			// 获取文件名
			String fileName = file.getOriginalFilename();
			// 获取一个新的文件名
			String newName = fileName(fileName);
			
			// 新建储存,生成文件名  1a14effa3600489ab28da99e8236d320.png
			String newfilepath = path_xiangmu+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" + newName;
			File targetFile = new File(folder(path_xiangmu+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)), newName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
				folder(newfilepath);
				//返回 原来的文件名_现在的文件名_现在的文件路径
				log.info("保存图片-----"+fileName+"_"+newName+"_"+newfilepath);
				
				
				
				String filetype = newName.substring(newName.lastIndexOf("."), newName.length());
				String filename = newName.substring(0, newName.lastIndexOf("."));
				ImageUtil.scale2(newfilepath, path+"/userfile/"+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" +filename+"-"+x+filetype, x, x, (new Integer(x)) <= 300);
			System.out.println("/userfile/"+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" + filename+"-"+x+filetype);
				return fileName+"_"+newName+"_"+"/userfile/"+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" + filename+"-"+x+filetype;
			} catch (Exception e) {
				e.printStackTrace();
				//当文件发生异常时
				return "fileisException";
			}
	}
	
	
	/**
	 * 
	 * @param file  上传的文件对象
	 * @param request 请求的request对象
	 * @return  String 原来的文件名_现在的文件名_现在的文件路径 <br/>
	 * String  fileismax：文件过大 <br/>
	 * String fileisnull：文件为空 <br/>
	 * String fileisException：文件异常 <br/>
	 * @throws RemoteException
	 */
	@Override
	public String upload(MultipartFile file) {
		System.out.println("-------------------");
		//当文件大于10兆是返回max表示文件过大
		if (file.getSize() > 1024*1024*10) {
			return "fileismax";
		}
		//当文件为空时返回fileisnull
		if (file.getOriginalFilename().equals("")) {
			return "fileisnull";
		} 
			// 获取文件名
			String fileName = file.getOriginalFilename();
			// 获取一个新的文件名
			String newName = fileName(fileName);
			
			// 新建储存,生成文件名  1a14effa3600489ab28da99e8236d320.png
			String newfilepath = path_xiangmu+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" + newName;
			File targetFile = new File(folder(path_xiangmu+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)), newName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
				folder(newfilepath);
				//返回 原来的文件名_现在的文件名_现在的文件路径
				return fileName+"_"+newName+"_"+"/userfile/"+String.valueOf(new Date().getYear() + 1900)+ String.valueOf(new Date().getMonth() + 1)+ "/" + newName;
				
			} catch (Exception e) {
				e.printStackTrace();
				//当文件发生异常时
				return "fileisException";
			}
	}
	
	/**
	 * 上传附件时重新获得附件名称
	 */ 
	public String fileName(String fileName) {
		String[] name = fileName.split("\\.");
		return UUID.randomUUID().toString().replace("-", "") + "."+ name[name.length - 1];
	}
	
	/**
	 * 获得上传文件的数据库数据
	 */  
	public String folder(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			file = new File(path);
			file.mkdir();
		}
		File timefile = new File(path);
		if (!timefile.isDirectory()) {
			timefile = new File(path);
			timefile.mkdir();
		}
		return timefile.getPath();
	}
	
	/**
	 * 切割保存用户上传的头像
	 * @param width  切割图片的宽度
	 * @param height 切割图片的高度
	 * @param x  X坐标
	 * @param y Y坐标
	 * @param imagesrc 图片路径
	 * @return  String 1 图片操作成功<br/>
	 */
	@Override
	public String cutimage(String width, String height, String x, String y, String imagesrc){
		
		//文件的路径不带后缀名
		String filename = imagesrc.substring(0, imagesrc.lastIndexOf("."));
		//文件的后缀名
		String filetype = imagesrc.substring(imagesrc.lastIndexOf("."), imagesrc.length());
		
		//截取图片并替换原来的图片
		ImageUtil.cut(path+imagesrc, path+imagesrc, new Integer(x), new Integer(y), new Integer(width), new Integer(height));
		//保存50、100、150、300尺寸的头像
		ImageUtil.scale2(path+imagesrc, path+filename+"-50"+filetype, 50, 50, (new Integer(width)) <= 50);
		ImageUtil.scale2(path+imagesrc, path+filename+"-100"+filetype, 100, 100, (new Integer(width)) <= 100);
		ImageUtil.scale2(path+imagesrc, path+filename+"-150"+filetype, 150, 150, (new Integer(width)) <= 150);
		ImageUtil.scale2(path+imagesrc, path+filename+"-300"+filetype, 300, 300, (new Integer(width)) <= 300);
		return "1";
	}
	
	
}