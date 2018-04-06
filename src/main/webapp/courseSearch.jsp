<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="resource/js/jquery-1.11.1.min.js"></script>
    <script src="resource/js/search.js"></script>
</head>
<body>
<div class="container">
    <h3>欢迎<strong id="name"><s:property value="#session.userexist.name"/></strong>登陆</h3>
    <h2><a href="${pageContext.request.contextPath }/course_findAll.action">返回</a></h2>
    <div class="panel panel-primary">
        <div class="search"><input type="text" style="width: 200px;" placeholder="请输入课程名"> <button class="btn btn-primary">搜索</button></div>
       <div class="panel-heading">
            <h3 class="panel-title text-center">
                校内任选课程
            </h3>
        </div>
<div class="panel-body">
    <table class="table table-hover" id="table">
        <s:set var="flag" value="0"/>
        <thead>
        <tr>
            <th>课程名</th>
            <th>课程编号</th>
            <th>教师</th>
            <th>课程教室</th>
            <th>限选人数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#request.list" var="course">
            <tr>
                <td class="d1" ><s:property value="#course.courseName"/></td>
                <td class="d2" ><s:property value="#course.courseId"/></td>
                <td class="d3" ><s:property value="#course.teacherName"/></td>
                <td class="d4" ><s:property value="#course.classroom"/></td>
                <td><s:property value="#course.number"/></td>
                <s:if test="#session.userexist.state==2">
                    <td id="test1" class="ss"><a href="course_updateUI.action?courseId=<s:property value="#course.courseId"/>">修改</a></td>
                </s:if>
                <s:else>
                    <s:iterator value="#request.studentlist" var="c">
                        <s:if test="#c.courseId==#course.courseId">
                            <td><a>已选</a></td>
                            <s:set var="flag" value="1"/>
                        </s:if>
                    </s:iterator>
                    <s:if test="#flag==0">
                        <td id="test1" class="ss"><a href="javascript:void(0)" class="choose">选课</a></td>
                    </s:if>
                </s:else>
            </tr>
        </s:iterator>
</tbody>
    </table>
</div>
    </div>
</div>
<input type="hidden" id="username" value="<s:property value="#session.userexist.username"/>">
</body>
</html>
