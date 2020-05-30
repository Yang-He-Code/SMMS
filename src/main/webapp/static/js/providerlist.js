var providerObj;

//供应商管理页面上点击删除按钮弹出删除框(providerlist.jsp)
function deleteProvider(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:{method:"delprovider",proid:obj.attr("proid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
				changeDLGContent("对不起，删除供应商【"+obj.attr("proname")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
				changeDLGContent("对不起，供应商【"+obj.attr("proname")+"】不存在");
			}else{
				//alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
				changeDLGContent("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeProv').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
function parseDate(milliseconds){
    var d = new Date(milliseconds);
    return d.getFullYear()+"-"+zore(d.getMonth()+1)+"-"+zore(d.getDate())+" "+zore(d.getHours())+":"+zore(d.getMinutes())+":"+zore(d.getSeconds());
}
function zore(str){
    return str<10?"0"+str:str;
}
function getProviderList(params){
	$.post("jsp/getProviderList",params,function(result){
		 params["currentPage"] = result.currentPage;
	     params["pageSize"] = result.pageSize;
	     params["procode"] = result.procode;
	     params["proname"] = result.proname;
	        
	        //加载分页图标
		 var spans = "<span class=\"first\">首页</span><span class=\"prev\">上一页</span>";
	        $.each(result.navigatepageNums, function(){
	            if(isNaN(this)){
	                return;
	            }
	            if(result.currentPage==this){
	                spans+="<span class=\"currentPage\">"+this+"</span>";
	            }else{
	                spans+="<span class=\"other\">"+this+"</span>";
	            }
	        });
	        spans+="<span class=\"next\">下一页</span><span class=\"last\">尾页</span>";
	        $(".page>span").remove();
	        $(".page").html(spans);
	        
	        if(result.isFirst){
	            $(".first,.prev").css("background","#eee");
	        }else{
	            $(".first").click(function(){
	                params["currentPage"] = 1;
	                getProviderList(params);
	            });
	            $(".prev").click(function(){
	                params["currentPage"]--;
	                getProviderList(params);
	            });
	        }
	        
	        if(result.isLast){
	            $(".last,.next").css("background","#eee");
	        }else{
	            $(".last").click(function(){
	                params["currentPage"] = result.pageCount;
	                getProviderList(params);
	            });
	            $(".next").click(function(){
	                params["currentPage"]++;
	                getProviderList(params);
	            });
	        }
	        $(".other").click(function(){
	            params["currentPage"] = $(this).text();
	            getProviderList(params);
	        });
	        
	        $(".providerTable>tbody>tr:gt(0)").remove();
	        $.each(result.rows, function(){
	            var $tr = $("<tr>"+
	                          "<td>"+this.procode+"</td>"+
	                          "<td>"+this.prodesc+"</td>"+
	                          "<td>"+this.procontact+"</td>"+
	                          "<td>"+this.prophone+"</td>"+
	                          "<td>"+this.profax+"</td>"+
	                          "<td>"+parseDate(this.creationdate)+"</td>"+
	                          " <td><span><a class=\"viewProvider\" href=\"javascript:;\" proid=><img src=\"static/images/read.png\" alt=\"查看\" title=\"查看\" /></a></span> <span><aclass=\"modifyProvider\" href=\"javascript:;\" proid=proname=><img src=\"static/images/xiugai.png\" alt=\"修改\" title=\"修改\" /></a></span> <span><aclass=\"deleteProvider\" href=\"javascript:;\" proid=><img src=\"static/images/schu.png\" alt=\"删除\" title=\"删除\" /></a></span></td>"+
	                        "</tr>");
	            $(".providerTable>tbody").append($tr);
	        });
	    });
}
$(function(){
	
	 var  params={"pageNum":1,"pageSize":5};
	getProviderList(params);
	$("#searchbutton").click(function(){
		 var procode = $("input[name=queryProCode]").val();
	        var queryProName = $("input[name=queryProName]").val();
	        params["procode"] = procode;
	        params["queryProName"] = queryProName;
	        params["currentPage"] = 1;
	        getBillPage(params);
	})
	$(".viewProvider").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/jsp/provider.do?method=view&proid="+ obj.attr("proid");
	});
	
	$(".modifyProvider").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/provider.do?method=modify&proid="+ obj.attr("proid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteProvider(providerObj);
	});

	$(".deleteProvider").on("click",function(){
		providerObj = $(this);
		changeDLGContent("你确定要删除供应商【"+providerObj.attr("proname")+"】吗？");
		openYesOrNoDLG();
	});
	
/*	$(".deleteProvider").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除供应商【"+obj.attr("proname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/provider.do",
				data:{method:"delprovider",proid:obj.attr("proid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
					}else{
						alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});