<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>我的课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript" src="resource/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        function deleteRow(r)
        { var i=r.parentNode.parentNode.rowIndex;
                document.getElementById('table').deleteRow(i);
      }
    </script>
</head>
<body>
<div class="container">
    <h3>欢迎<strong id="name"><s:property value="#session.userexist.name"/></strong>登陆</h3>
    <h2><a href="${pageContext.request.contextPath }/course_findAll.action">返回</a></h2>
    <div class="panel panel-primary">
      <div class="panel-heading">
            <h3 class="panel-title text-center">
                我的课程
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover" id="table">
                <thead>
                <tr>
                    <th>课程名</th>
                    <th>课程编号</th>
                    <th>教师</th>
                    <th>课程教室</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="table1">
                <s:iterator value="#request.list" var="course">
                  <tr>
                        <td class="d1"><s:property value="#course.courseName"/></td>
                        <td class="d2"><s:property value="#course.courseId"/></td>
                        <td class="d3"><s:property value="#course.teacherName"/></td>
                        <td class="d4"><s:property value="#course.classroom"/></td>
                         <td id="test1" class="ss"><a href="student_deleteCourse.action?id=<s:property value="#course.id"/>" class="choose" target="hidden" onclick="deleteRow(this)">删除</a>
                        </td>

                 </tr>
               </s:iterator>
                </tbody>
            </table>

</div>
    </div>
</div>
</body>
<iframe name="hidden" id="hidden" style="display:none" target="hidden"></iframe>
</html>
