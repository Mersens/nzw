package com.nongzi.user.iservice;



import org.springframework.web.multipart.MultipartFile;


public interface IImgService{
	/**
	 * 
	 * @param file  上传的文件对象
	 * @return  String 原来的文件名_现在的文件名_现在的文件路径 <br/>
	 * String  fileismax：文件过大 <br/>
	 * String fileisnull：文件为空 <br/>
	 * String fileisException：文件异常 <br/>
	 * @throws RemoteException
	 */
	public String upload(MultipartFile file) ;
	/**
	 * 切割保存用户上传的头像
	 * @param width  切割图片的宽度
	 * @param height 切割图片的高度
	 * @param x  X坐标
	 * @param y Y坐标
	 * @param imagesrc 图片路径
	 * @return  String 1 图片操作成功<br/>
	 */
	public String cutimage(String width, String height, String x, String y,String imagesrc);
	/**
	 * 根据设置的大小设置一个图片并上传
	 * @param file  上传的文件对象
	 * @param x 生成图像的大小
	 * @param request 请求的request对象
	 * @return  String 原来的文件名_现在的文件名_现在的文件路径 <br/>
	 * String  fileismax：文件过大 <br/>
	 * String fileisnull：文件为空 <br/>
	 * String fileisException：文件异常 <br/>
	 * @throws RemoteException
	 */
	public String upload(MultipartFile file, int x) ;
    }