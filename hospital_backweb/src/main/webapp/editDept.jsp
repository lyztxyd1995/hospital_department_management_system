<%--
  Created by IntelliJ IDEA.
  User: yizeliu
  Date: 8/5/18
  Time: 2:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新建</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/dept/list.do">
                慕课网科室分类管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <form class="form-horizontal" action="/dept/edit.do" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" placeholder="${dept.name}">
                <select id="categoryId" name="categoryId" class="col-sm-2 form-control">
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${category.id==dep.category_id}">
                            <option value="${category.id}" selected="selected">${category.name}</option>
                        </c:if>
                        <c:if test="${category.id!=dep.category_id}">
                            <option value="${category.id}">${category.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <input type="hidden" name="id" value="${dept.id}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>
