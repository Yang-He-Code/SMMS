<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>订单管理页面</span>
	</div>
	<div class="search">
		
			<span>商品名称：</span> <input name="queryProductName" type="text"
				value=""> <span>供应商：</span> <select name="queryProviderId">
				<option value="0">--请选择--</option>
			</select> <span>是否付款：</span> <select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1">未付款</option>
				<option value="2">已付款</option>
			</select> <input value="查 询" type="submit" id="searchbutton"> <a
				href="jsp/billadd.do">添加订单</a>
	</div>
	<!--账单表格 样式和供应商公用-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">订单编码</th>
			<th width="20%">商品名称</th>
			<th width="25%">供应商</th>
			<th width="10%">订单金额</th>
			<th width="10%">是否付款</th>
			<th width="15%">创建时间</th>
			<th width="10%">操作</th>
		</tr>
	</table>
	<div id="page">
		<div class="page">
			<span>首页</span> <span>上一页</span> <span>1</span> <span>2</span> <span>3</span>
			<span>4</span> <span>5</span> <span>下一页</span> <span>尾页</span>
		</div>

	</div>
</div>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该订单吗？</p>
			<a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
		</div>
	</div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript" src="static/js/billlist.js"></script>