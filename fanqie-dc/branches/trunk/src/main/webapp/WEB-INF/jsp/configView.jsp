<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>配置信息</title>
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/ace.min.css'/>">
    <script src='/js/jquery-2.0.3.min.js'></script>
</head>
<body>
<div class="page-content">
    <div class="page-header">
        </h1>
    </div>
    <div class="row">
        <div class="col-xs-12">


            <form id="form-id-companyId" class="form-horizontal" >
                <input type="hidden" name="id" value="${data.id}"/>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> OTA_ID </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace " id="form-input-readonly" name="otaId"
                               value="${data.otaId}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> OTA_CODE </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace "  name="otaCode"
                               value="${data.otaCode}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> 百分比 </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace "  name="percentage"
                               value="${data.percentage}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> account </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace "  name="account"
                               value="${data.account}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> password </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace "  name="password"
                               value="${data.password}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> 爬虫天数 </label>
                    <div class="col-sm-9">
                        <input type="text" class="col-xs-10 col-sm-5 ace "  name="spiderDay"
                               value="${data.spiderDay}"/>
                        <span class="help-tel col-xs-12 col-sm-7"></span>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="space-4"></div>
               <%-- <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> 默认 </label>
                    <div class="col-sm-9">
                        <input type="radio"  name="compareDefault" value="true" <c:if test="${data.compareDefault==true}">checked</c:if>> ON
                        <input type="radio"  name="compareDefault" value="false" <c:if test="${data.compareDefault==false}">checked</c:if>> OFF
                    </div>
                </div>--%>
                <div class="space-4"></div>

                <div class="space-4"></div>
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="submit">
                             确认
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".btn-info").bind("click",function(){
            $.ajax({
                url: '<c:url value="/compare/configUpdate.json"/>',
                type: 'post',
                dataType: 'json',
                data: $('#form-id-companyId').serialize(),
                success: function (data) {
                    if (data.status==200) {
                        window.location.href = '<c:url value="/compare/config"/>';
                    } else {
                        alert(data.message);
                    }
                },
                error: function (data) {
                    alert(data.message);
                }
            });
        })
    })
</script>
</body>
</html>
