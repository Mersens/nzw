<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>公司信息</title>
     <meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<link href="/resources/css/Public.css" rel="stylesheet" />
<link href="/resources/css/resource.css" rel="stylesheet" />
  
  <link href="/resources/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="/resources/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/Header-top.js"></script>
<script src="/resources/js/Left-nav.js"></script>
<script src="/resources/js/partialfooter.js" type="text/javascript"></script>
  <script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
  <script src="/resources/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
  <script type="text/javascript" src="/resources/jquery/layer.min.js"></script>
  <script type="text/javascript" src="/resources/company/gongsixinxi.js"></script>
  </head>
  <body>
  <jsp:include page="/userCommonCenter/gotoHead" />
    <div class="main">

       <jsp:include page="/userCommonCenter/gotoLeft" />
        <div class="main_r" style="width:905px; min-height:850px; padding-bottom:20px; margin-bottom:20px;">
        
        

    <div class="right">
        <p class="r_tit">公司信息</p>
        <form id="gsform">
        <div style="margin-left:29px; margin-top:20px;" class="qiye_zliao ljgl">
            <table width="900" border="0" cellspacing="0" cellpadding="0">
                    <tbody><tr>
                        <td height="44" align="right">  <span class="red">*</span>公司名称：</td>
                        <td align="left">
                        
                            <input class="inputamp_mm"   id="gongsinama" name="gongsinama" type="text"  />
                            
                            <span class="input_Tishi" id="gongsinamaTS" style="display: block;">
                               		
                            </span>
							<div class="clear"></div>
                        </td>
                    </tr>


                <tr>
                    <td height="44" align="right">  <span class="red">*</span>公司简称：</td>
                    <td align="left">
                        <input class="inputamp_mm"  id="jiancheng" name="jiancheng" type="text"  />
                        <span class="input_Tishi" id="jianchengTS" style="display: block;">
                            </span>
							<div class="clear"></div>

                    </td>
                </tr>
                <tr>
                    <td height="77" align="right">  <span class="red">*</span>公司描述：</td>
                    <td colspan="2" align="left">
                        <textarea class="input_jian" cols="20" data-val="true" data-val-maxlength="字段 企业描述 必须是最大长度为“1000”的字符串或数组类型。" data-val-maxlength-max="1000" data-val-required="请输入企业描述" id="miaoshu" name="miaoshu" rows="2" style="height:100px;width:500px;">${user.gongsi.miaoshu }</textarea>
                      	<span class="input_Tishi" id="miaoshuTS" style="display: block;bottom:5px;">
                            </span>
							<div class="clear"></div>

                    </td>
                </tr>
                <tr>
                    <td height="44" align="right"> <span style="color:red;">*</span>所属区域：</td>
                    <td colspan="2" align="left">
                         <input class="easyui-combobox" name="language" id="provinceid"
								data-options="
								url:'/diquUtil/getProvinceData',
								method:'post',
								valueField:'provinceid',
								textField:'province',
								panelHeight:'150',
								onSelect: function(rec){
                                $('#cityid').combobox('setValue', '');
	                            $('#cityid').combobox('reload', '/diquUtil/getCityByProvinceId?id='+rec.provinceid);
								}" style="margin-left: 23px; width: 125px;height: 30px;" />
                        <input class="easyui-combobox" name="cityid" id="cityid"
								    data-options="method:'post',
								    valueField:'cityid',
								    textField:'cityname',
								    panelHeight:'150',
								    onSelect:function(rec){
								    $('#areaid').combobox('setValue', '');
	                                $('#areaid').combobox('reload', '/diquUtil/getAreaByCityId?id='+rec.cityid);
								     }" style="margin-left: 23px; width: 125px;height: 30px;" />
				         <input class="easyui-combobox" name="areaid" id="areaid"
								    data-options="method:'post',
								    valueField:'areaid',
								    textField:'area',
								    panelHeight:'150',
								    onSelect:function(){ }" style="margin-left: 23px; width: 125px;height: 30px;" />
                        	<span class="input_Tishi" id="quyuTS" style="display: block;">
                            </span>
							<div class="clear"></div>
                    </td>
                </tr>
                <tr>
                    <td height="44" align="right"> <span id="spCityId" style="color:red;">*</span>详细地址：</td>
                    <td colspan="2" align="left">
                        <input class="inputamp_mm"   id="dizhi" name="dizhi" type="text"  />
                        <span class="input_Tishi" id="dizhiTS" style="display: block;">
                            </span>
							<div class="clear"></div>

                </td></tr>
                <tr>
                    <td height="44" align="right">  <span class="red">*</span>公司电话：</td>
                    <td colspan="2" align="left">
                        <input class="inputamp_mm" data-val="true" data-val-regex="电话格式不正确,例子：0371-5877177" data-val-regex-pattern="\d{3,4}-\d{7,8}" data-val-required="必填项" id="dianhua" name="dianhua" type="text" value="${user.gongsi.dianhua }" />
                        <span class="input_Tishi" id="dianhuaTS" style="display: block;">
                            </span>
							<div class="clear"></div>

                    </td>
                </tr>
                <tr>
                    <td height="44" align="right">   <span class="red">*</span>公司传真：</td>
                    <td colspan="2" align="left">
                        <input class="inputamp_mm" data-val="true" data-val-regex="传真格式不正确,例子：0371-5877177" data-val-regex-pattern="\d{3,4}-\d{7,8}" data-val-required="必填项" id="chuanzhen" name="chuanzhen" type="text" value="${user.gongsi.chuanzhen }" />
                        <span class="input_Tishi" id="chuanzhenTS" style="display: block;">
                            </span>
							<div class="clear"></div>
                </td>
                </tr>
                <tr>
                    <td height="44" align="right">  <span class="red">*</span>联系人：</td>
                    <td height="44" colspan="2" align="left">
                        <input class="inputamp_mm" data-val="true" data-val-maxlength="字段 联系人 必须是最大长度为“10”的字符串或数组类型。" data-val-maxlength-max="10" data-val-required="必填项" id="lianxiren" name="lianxiren" type="text" value="${user.gongsi.lianxiren }" />
                       <span class="input_Tishi" id="lianxirenTS" style="display: block;">
                            </span>
							<div class="clear"></div>
                    </td>
                </tr>
                <tr>
                    <td width="100" height="44" align="right">  <span class="red">*</span>联系人手机：</td>
                    <td colspan="2" align="left">
                        <input class="inputamp_mm" data-val="true" data-val-regex="手机格式不正确" data-val-regex-pattern="(13|15|17|18|14)[0-9]{9}" data-val-required="必填项" id="lianxirendianhua" name="lianxirendianhua" type="text" value="${user.gongsi.lianxirendianhua }" />

                        <span class="input_Tishi" id="lianxirendianhuaTS" style="display: block;">
                            </span>
							<div class="clear"></div>

                    </td>
                </tr>
            </tbody></table>
         
        </div>
        <div style="width:790px; margin:0 auto;margin-top:33px;"></div>

      <div style="min-height:188px;margin-top:33px;" class="runchart">
            <ul style=" height:109px; line-height:109px;margin-top:44px; margin-left:60px;"><li>  <span class="red">*</span>公司证件：</li></ul>
            
            <input type="hidden" name="nullCount" value="3" />
                <input type="hidden" id="againRenZheng" name="againRenZheng" value="1" />
                <ul>
                    <li style=" line-height:18px;"><span style="font-weight:bold; width:167px;text-align:center; line-height:18px; display:inline-block; overflow:hidden;">营业执照</span></li>
                    <li style="position:relative;">

                        <a style="position:absolute; left:135px; top:70px; z-index:99;"></a>
                        <img class="pimg" id="previewImage" src="<c:if test="${yingyezhizhao eq null or yingyezhizhao eq '' }">/resources/images/zhengshu.png</c:if><c:if test="${yingyezhizhao ne null and yingyezhizhao ne '' }">/resources/${yingyezhizhao }</c:if> " width="167" height="102" />

                        <input type="hidden" id="yingyezhizhao" name="yingyezhizhao" value="${yingyezhizhao }" />
                    </li>
                    <li style="margin-left: 38px;"><div id="uploadify" class="uploadify" style="height: 25px; width: 77px;">
                    <div id="uploadify-button" class="uploadify-button " style="height: 25px; line-height: 25px; width: 77px;">
                    <span class="uploadify-button-text" onclick="addimg('yingyezhizhao')">上传</span></div></div><div id="uploadify-queue" class="uploadify-queue"></div></li>
                    <li><span id="spBus" style="color:red;"></span></li>
                </ul>
                <ul>
                    <li style=" line-height:18px;">
                        <span style="font-weight:bold; width:167px;text-align:center; line-height:18px; display:inline-block; overflow:hidden;">税务登记证</span>
                    </li>
                    <li style="position:relative;">
                        <a style="position:absolute; left:135px; top:70px; z-index:99;"></a>
                        <img class="pimg" id="previewImage2" src="<c:if test="${shuiwuzheng eq null or shuiwuzheng eq '' }">/resources/images/zhengshu.png</c:if><c:if test="${shuiwuzheng ne null and shuiwuzheng ne '' }">/resources/${shuiwuzheng }</c:if> " width="167" height="102" />

                        <input type="hidden" id="shuiwudengji" name="shuiwudengji" value="${shuiwuzheng }" />
                    </li>
                    <li style="margin-left:42px;"><div id="uploadify2" class="uploadify" style="height: 25px; width: 77px;">
                    <div id="uploadify2-button" class="uploadify-button " style="height: 25px; line-height: 25px; width: 77px;">
                    <span class="uploadify-button-text" onclick="addimg('shuiwuzheng')">上传</span></div></div><div id="uploadify2-queue" class="uploadify-queue"></div></li>
                    <li><span id="spTax" style="color:red;"></span></li>
                </ul>
                <ul>
                    <li style=" line-height:18px;">
                        <span style="font-weight:bold; width:167px;text-align:center; line-height:18px; display:inline-block; overflow:hidden;">组织机构代码证</span>
                    </li>
                    <li style="position:relative;">
                        <a style="position:absolute; left:135px; top:70px; z-index:99;"></a>
                        <img class="pimg" id="previewImage3" src="<c:if test="${zuzhidaima eq null or zuzhidaima eq '' }">/resources/images/zhengshu.png</c:if><c:if test="${zuzhidaima ne null and zuzhidaima ne '' }">/resources/${zuzhidaima }</c:if> " width="167" height="102" />

                        <input type="hidden" id="jigoudaima" name="jigoudaima" value="${zuzhidaima }" />
                    </li>
                    <li style="margin-left:38px;"><div id="uploadify3" class="uploadify" style="height: 25px; width: 77px;">
                    <div id="uploadify3-button" class="uploadify-button " style="height: 25px; line-height: 25px; width: 77px;">
                    <span class="uploadify-button-text" onclick="addimg('zuzhidaima')">上传</span></div></div><div id="uploadify3-queue" class="uploadify-queue"></div></li>
                    <li><span id="spOrg" style="color:red;"></span></li>
                </ul>
                <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
                    <div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div>
                </div>
            
        </div>
           </form>
            <div style="width:515px; height:32px; line-height:32px; border:1px solid #f6ecc0; background-color:#fefaec; clear:both; margin-top:22px;margin-left:166px; color:#6e6e6e; padding-left:8px; ">提示：请上传扫描件或复印件，须以图片形式上传，每个文件大小不超过2MB</div>
        <div style="width:790px; margin:0 auto;margin-top:33px; border-bottom: dashed 1px #d6d6d6;"></div> 

        <div class="information">
            <div class="information-left"></div>
            <div class="information-rightw" style="height:auto;">
            <input name="btn" id="btn" class="zhuceps colors" style="margin-left:144px; margin-top:34px; background: #ff9900;width:79px; height:31px;line-height: 31px;font-size:14px;" type="submit" value="提交审核" onclick="addgongsi()"/>
            </div>

        </div>


    </div>
</form>


<script type="text/javascript">
    $(function () {
        var msg = "";
        if (msg == "资料保存成功") {
            $("#successTip").show();
            setTimeout(function () { $("#msg").fadeOut("slow"); }, 3000);
        }
    });
</script>
        </div>
    </div>
    <div class="clear"></div>
<jsp:include page="/userCommonCenter/gotoHelp" />
<jsp:include page="/userCommonCenter/gotoFoot" />

  </body>
</html>
