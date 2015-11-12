// JavaScript Document

if(document.getElementById("jsfoot01")){
	var scrollup = new ScrollText("jsfoot01");
	scrollup.LineHeight = 22;        //单排文字滚动的高度
	scrollup.Amount = 1;            //注意:子模块(LineHeight)一定要能整除Amount.
	scrollup.Delay = 20;           //延时
	scrollup.Start();             //文字自动滚动
	scrollup.Direction = "up";   //默认设置为文字向上滚动
}