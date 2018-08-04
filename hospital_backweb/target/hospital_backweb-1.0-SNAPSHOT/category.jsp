<%--
  Created by IntelliJ IDEA.
  User: yizeliu
  Date: 8/5/18
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室列表</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">

    <c:forEach items="${categories}" var="item">
        <nav>
            <a href="/dept/list.do?category_id=${item.id}">${item.name}</a>
        </nav>
    </c:forEach>
        <nav>
            <a href="/category/list.do" >分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>分类</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${item.update_time}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <a href="toEdit.do?id=${item.id}">修改</a>&nbsp;&nbsp;
                        <a href="remove.do?id=${item.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="addPrompt.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>
