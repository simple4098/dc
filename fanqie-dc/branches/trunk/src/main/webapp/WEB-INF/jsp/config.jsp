<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/ace.min.css'/>">
    <title>配置</title>

</head>
<body>


<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="col-xs-12">
                    <%--<h3 class="header smaller lighter blue">${companyName}-渠道列表</h3>--%>
                    <div class="table-responsive">
                        <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                            <thead style="font-size: 14px;">
                            <tr>
                                <td>OTA_ID</td>
                                <td>OTA_CODE</td>
                                <td>百分比</td>
                                <td>account</td>
                                <td>password</td>
                                <td>是否默认</td>
                                <td>爬虫天数</td>
                                <th class="hidden-480">操作</th>
                            </tr>
                            </thead>

                            <tbody style="font-size: 14px;">
                            <tr>
                                <td>${config.otaId}</td>
                                <td>${config.otaCode}</td>
                                <td>${config.percentage}</td>
                                <td>${config.account}</td>
                                <td>${config.password}</td>
                                <td>${config.compareDefault}</td>
                                <td>${config.spiderDay}</td>
                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                        <a class="green" href="<c:url value="/compare/configView?id=${config.id}"/>">
                                            修改
                                        </a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
