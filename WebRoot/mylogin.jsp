<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
</head>
<body>
	<h2>获取用户信息测试</h2>
	<form action="/myInfo/getUserInfo" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>登陆测试</h2>
	<form action="/login/userLogin" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测用户名是否存在</h2>
	<form action="/register/existUsername" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测手机号是否存在</h2>
	<form action="/register/existUserphone" method="post">
		<table>
			<tr>
				<td>手机号：</td>
				<td><input type="text" name="userphone"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>


	<h2>检测用户注册</h2>
	<form action="/register/userRegister" method="post">
		<table>
			<tr>
				<td>手机号：</td>
				<td><input type="text" name="userphone"></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="userpwd"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测查询区域</h2>
	<form action="area/getProvince" method="post">
		<table>


			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测查询城市</h2>
	<form action="area/getCityByProvinceId" method="post">
		<table>
			<tr>
				<td>省份id：</td>
				<td><input type="text" name="provinceid"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测查询县区</h2>
	<form action="area/getAreaByCityId" method="post">
		<table>
			<tr>
				<td>省份id：</td>
				<td><input type="text" name="cityid"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测个人信息修改</h2>
	<form action="userAccount/updateGerenXinxi" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="xingming"></td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><input type="text" name="qq"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测修改密码</h2>
	<form action="userAccount/updateUserPassword" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>原始密码：</td>
				<td><input type="text" name="oldpwd"></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="text" name="newpwd"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="text" name="confirmpwd"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测发送旧手机验证码</h2>
	<form action="userAccount/sendOldPhoneCode" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="phonecode"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测发送新手机验证码</h2>
	<form action="userAccount/sendNewPhoneCode" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>新手机号：</td>
				<td><input type="text" name="newphone"></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="phonecode"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测上传用户头像</h2>
	<form action="userAccount/upUserImg" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>选择图片</td>
				<td><input type="file" name="imgsrc" id="imgsrc"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测上传公司证件</h2>
	<form action="company/upDocumentsImage" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>选择图片</td>
				<td><input type="file" name="imgsrc" id="imgsrc"></td>
			</tr>
			<tr>
				<td>图片类型</td>
				<td><input type="text" name="type"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测修改公司</h2>
	<form action="company/updateGongsiXinxi" method="post">
		<table>

			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>provinceid：</td>
				<td><input type="text" name="provinceid"></td>
			</tr>
			<tr>
				<td>cityid：</td>
				<td><input type="text" name="cityid"></td>
			</tr>
			<tr>
				<td>areaid：</td>
				<td><input type="text" name="areaid"></td>
			</tr>
			<tr>
				<td>jiancheng：</td>
				<td><input type="text" name="jiancheng"></td>
			</tr>
			<tr>
				<td>miaoshu：</td>
				<td><input type="text" name="miaoshu"></td>
			</tr>
			<tr>
				<td>dianhua：</td>
				<td><input type="text" name="dianhua"></td>
			</tr>
			<tr>
				<td>chuanzhen：</td>
				<td><input type="text" name="chuanzhen"></td>
			</tr>
			<tr>
				<td>lianxiren：</td>
				<td><input type="text" name="lianxiren"></td>
			</tr>
			<tr>
				<td>lianxirendianhua：</td>
				<td><input type="text" name="lianxirendianhua"></td>
			</tr>
			<tr>
				<td>dizhi：</td>
				<td><input type="text" name="dizhi"></td>
			</tr>
			<tr>
				<td>yingyezhizhao：</td>
				<td><input type="text" name="yingyezhizhao"></td>
			</tr>
			<tr>
				<td>shuiwudengji：</td>
				<td><input type="text" name="shuiwudengji"></td>
			</tr>
			<tr>
				<td>zuzhidaima：</td>
				<td><input type="text" name="zuzhidaima"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测旺铺资料</h2>
	<form action="company/gotoWangpuZiliao" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h2>检测修改旺铺资料</h2>
	<form action="company/updateWangpuZiliao" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>dianpuleimu：</td>
				<td><input type="text" name="dianpuleimu"></td>
			</tr>
			<tr>
				<td>dianpujieshao：</td>
				<td><input type="text" name="dianpujieshao"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测发布公司状态</h2>
	<form action="company/fabuDongtai" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>title：</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>keywords：</td>
				<td><input type="text" name="keywords"></td>
			</tr>
			<tr>
				<td>miaoshu：</td>
				<td><input type="text" name="miaoshu"></td>
			</tr>
			<tr>
				<td>center：</td>
				<td><input type="text" name="center"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测获取公司动态信息</h2>
	<form action="company/getGongsiDongtaiData" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>page：</td>
				<td><input type="text" name="page"></td>
			</tr>
			<tr>
				<td>typeid：</td>
				<td><input type="text" name="typeid"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测删除公司动态信息</h2>
	<form action="company/deleteGongsiDongtai" method="post">
		<table>
			<tr>
				<td>newsid：</td>
				<td><input type="text" name="newsid"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测获取我的消息总数</h2>
	<form action="myMessage/getMyMessageCount" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<h2>检测获取我的消息</h2>
	<form action="myMessage/getMyMessageDatas" method="post">
		<table>
			<tr>
				<td>userid：</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>typeid：</td>
				<td><input type="text" name="typeid"></td>
			</tr>
			<tr>
				<td>page：</td>
				<td><input type="text" name="page"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
<h2>检测查询产品类目</h2>
<form action="seller/gotoSelectChanpinLeimu" method="post">
	<table>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测查询产品类目二级</h2>
<form action="seller/getFidLeimuById" method="post">
	<table>
		<tr>
			<td>Fid：</td>
			<td><input type="text" name="fid"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测查询产品类目三级</h2>
<form action="seller/getCidLeimuById" method="post">
	<table>
		<tr>
			<td>Cid：</td>
			<td><input type="text" name="cid"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测上传产品照片</h2>
<form action="seller/upProductImage" method="post"
	enctype="multipart/form-data">
	<table>
		<tr>
			<td>userid：</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>选择图片</td>
			<td><input type="file" name="imgsrc" id="imgsrc"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测添加产品信息</h2>
<form action="seller/addChanpinXinxi" method="post">
	<table>

		<tr>
			<td>userid：</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>title：</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>categoryId：</td>
			<td><input type="text" name="categoryId"></td>
		</tr>
		<tr>
			<td>keyword：</td>
			<td><input type="text" name="keyword"></td>
		</tr>
		<tr>
			<td>miaoshu：</td>
			<td><input type="text" name="miaoshu"></td>
		</tr>
		<tr>
			<td>offerDetail：</td>
			<td><input type="text" name="offerDetail"></td>
		</tr>

		<tr>
			<td>image：</td>
			<td><input type="text" name="image"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测设置交易信息</h2>
<form action="seller/addChanpinJiaoyiXinxi" method="post">
	<table>
		<tr>
			<td>chanpinid：</td>
			<td><input type="text" name="chanpinid"></td>
		</tr>
		<tr>
			<td>unit：</td>
			<td><input type="text" name="unit"></td>
		</tr>
		<tr>
			<td>jiage：</td>
			<td><input type="text" name="jiage"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>

<h2>检测获取产品信息</h2>
<form action="seller/getChanpinData" method="post">
	<table>
		<tr>
			<td>userid：</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>page：</td>
			<td><input type="text" name="page"></td>
		</tr>
		<tr>
			<td>status：</td>
			<td><input type="text" name="status"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>设置产品状态</h2>
<form action="seller/updateChanpinStatus" method="post">
	<table>
		<tr>
			<td>chanpinid：</td>
			<td><input type="text" name="id"></td>
		</tr>

		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测删除产品信息</h2>
<form action="seller/deleteAllChanpin" method="post">
	<table>
		<tr>
			<td>chanpinid：</td>
			<td><input type="text" name="ids"></td>
		</tr>

		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>

<h2>检测产品上架</h2>
<form action="seller/chanpinShangjia" method="post">
	<table>
		<tr>
			<td>chanpinid：</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测获取询价单管理信息总数</h2>
<form action="enquiry/getEnquiryCount" method="post">
	<table>
		<tr>
			<td>userid：</td>
			<td><input type="text" name="userid"></td>
		</tr>

		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测获取询价单管理信息</h2>
<form action="enquiry/getEnquiryData" method="post">
	<table>	
		<tr>
			<td>userid：</td>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<td>page：</td>
			<td><input type="text" name="page"></td>
		</tr>
		<tr>
			<td>status：</td>
			<td><input type="text" name="status"></td>
		</tr>
		<tr>
			<td>xjname：</td>
			<td><input type="text" name="xjname"></td>
		</tr>
		<tr>
			<td>sdate：</td>
			<td><input type="text" name="sdate"></td>
		</tr>
		<tr>
			<td>edate：</td>
			<td><input type="text" name="edate"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
<h2>检测更新询价单管理信息状态</h2>
<form action="enquiry/updateEnquiryStatic" method="post">
	<table>
		<tr>
			<td>xunjiaid：</td>
			<td><input type="text" name="xunjiaid"></td>
		</tr>

		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form>
</body>
</html>
