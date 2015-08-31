<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>手动执行</title>
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/ace.min.css'/>"/>
</head>
<body>
 <div style="height: 100px">

 </div>
     <form id="formId" style="text-align: center">
         <input readonly class="date-input" name="startDateStr"  type="text" id="from_datepicker" placeholder="请选择开始日期">
         <span>至</span>
         <input readonly class="date-input" name="endDateStr"  type="text" id="to_datepicker" placeholder="请选择结束日期">
            <select id="type">
                <option >--请选择--</option>
                <option value="<c:url value='/inn/active.json'/>">活跃报表</option>
                <option value="<c:url value='/inn/customer.json'/>">客户区域</option>
                <option value="<c:url value='/operate/data.json'/>">运营报表</option>
                <option value="<c:url value='/order/source.json'/>">订单来源</option>
            </select>
         <input type="button" id="butId" class="btn btn-info btn-sub" value="执行">
     </form>
     <script src="<c:url value='/js/jquery-2.0.3.min.js'/>"></script>
     <script src="<c:url value='/js/jquery-ui-1.10.3.full.min.js'/>"></script>
     <script src="<c:url value='/js/dateSelecter_room_price.js'/>"></script>
     <script type="text/javascript">
         $("#butId").on("click",function(){
             var from_date = $("#from_datepicker").val();
             var to_date = $("#to_datepicker").val();
             var value = $("#type").val();
             var reg = new RegExp("^[+-]?[0-9]+(.[0-9]{1,3})?$");
             if(from_date.length==0){
                 alert("开始时间不能为空!");
                 return false;
             }if(to_date.length==0){
                 alert("结束时间不能为空!");
                 return false;
             }else{
                 to_date = to_date+" 23:59:59"
             }
             if(value.length==0){
                 alert("类型不能为空");
                 return false;
             }
             $.ajax({
                 type:'POST',
                 url:value,
                 dataType:'json',
                 data:{'from':from_date,'to':to_date},
                 success:function(data){
                     alert("执行成功");
                 },error:function(data){
                     alert("执行异常，请稍后再试;");
                 }
             })
         })
     </script>
</body>
</html>
