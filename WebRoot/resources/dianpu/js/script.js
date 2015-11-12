// JavaScript Document
window.onload=function()
{
	var oTab=document.getElementById("cen_right_top");
	var aH3=oTab.getElementsByTagName("h3");
	var aDiv=oTab.getElementsByTagName("div");
	for(var i=0;i<aH3.length;i++)
	{
		aH3[i].index=i;
		aH3[i].onmouseover=function()
		{
			for(var i=0;i<aH3.length;i++)
			{
				aH3[i].className="";
				aDiv[i].style.display="none";
			}
			this.className="active";
			aDiv[this.index].style.display="block";
		}
	}
	
	var oTab2=document.getElementById("cen_right_top2");
	var aH4=oTab2.getElementsByTagName("h3");
	var aDiv2=oTab2.getElementsByTagName("div");
	for(var i=0;i<aH4.length;i++)
	{
		aH4[i].index=i;
		aH4[i].onmouseover=function()
		{
			for(var i=0;i<aH4.length;i++)
			{
				aH4[i].className="";
				aDiv2[i].style.display="none";
			}
			this.className="active";
			aDiv2[this.index].style.display="block";
		}
	}
	
	
	var oTab3=document.getElementById("cen_right_top3");
	var aH5=oTab3.getElementsByTagName("h3");
	var aDiv3=oTab3.getElementsByTagName("div");
	for(var i=0;i<aH5.length;i++)
	{
		aH5[i].index=i;
		aH5[i].onmouseover=function()
		{
			for(var i=0;i<aH5.length;i++)
			{
				aH5[i].className="";
				aDiv3[i].style.display="none";
			}
			this.className="active";
			aDiv3[this.index].style.display="block";
		}
	}
	
	
	
	var oTab4=document.getElementById("cen_right_top4");
	var aH6=oTab4.getElementsByTagName("h3");
	var aDiv4=oTab4.getElementsByTagName("div");
	for(var i=0;i<aH6.length;i++)
	{
		aH6[i].index=i;
		aH6[i].onmouseover=function()
		{
			for(var i=0;i<aH6.length;i++)
			{
				aH6[i].className="";
				aDiv4[i].style.display="none";
			}
			this.className="active";
			aDiv4[this.index].style.display="block";
		}
	}
	
	
	var oTab5=document.getElementById("cen_right_top5");
	var aH7=oTab5.getElementsByTagName("h3");
	var aDiv5=oTab5.getElementsByTagName("div");
	for(var i=0;i<aH7.length;i++)
	{
		aH7[i].index=i;
		aH7[i].onmouseover=function()
		{
			for(var i=0;i<aH7.length;i++)
			{
				aH7[i].className="";
				aDiv5[i].style.display="none";
			}
			this.className="active";
			aDiv5[this.index].style.display="block";
		}
	}
	
	
	
}
	

