<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <style type="text/css">
        .pagination{
            margin-left:430px;
        }
    </style>
</head>
<body>
<div class="container">
	<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			校内任选课程
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
            <th>限选人数</th>
            <th>操作</th>
 </tr>
   </thead>
   <tbody>
   <s:iterator value="list" var="course">
      <tr>
         <td><s:property value="#course.courseName"/></td>
         <td><s:property value="#course.courseId"/></td>
          <td><s:property value="#course.teacherName"/></td>
           <td><s:property value="#course.classroom"/></td>
            <td><s:property value="#course.number"/></td>
            <td><a>选课</a></td>
      </tr>
   </s:iterator>
  </tbody>
</table>
       <div><ul class="pagination">
            <s:if test="currPage != 1">
                <li><a href="${pageContext.request.contextPath }/course_findAll.action?currPage=1">首页</a></li>
                <li><a href="${pageContext.request.contextPath }/course_findAll.action?currPage=<s:property value="currPage-1"/>">&laquo;</a></li>
            </s:if>
            <s:else>
                <li><a>首页</a></li>
                <li><a>&laquo;</a></li>
            </s:else>
            <s:iterator begin="1" end="totalPage" status="st">
                <s:if test="%{#st.index+1==currPage}">
                    <li><a><s:property value="%{#st.index+1}"></s:property></a></li>
                </s:if>
                <s:else>
                    <li><a href="${pageContext.request.contextPath }/course_findAll.action?currPage=<s:property value='%{#st.index+1}'/>"><s:property value="%{#st.index+1}"></s:property></a></li>
                </s:else>
            </s:iterator>
            <s:if test="currPage != totalPage">
                <li><a href="${pageContext.request.contextPath }/course_findAll.action?currPage=<s:property value="currPage+1"/>">&raquo;</a></li>
                <li><a href="${pageContext.request.contextPath }/course_findAll.action?currPage=<s:property value="totalPage"/>">尾页</a></li>
            </s:if>
            <s:else>
                <li><a>&raquo;</a></li>
                <li><a>尾页</a></li>
            </s:else>
        </ul>
       </div>
    </div>
	</div>
</div>
</body>
</html>