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
        .test{
            height: 20px;
        }
        .test ul{

            position: absolute;
            left: 50%;
            top: -30%;
            transform:translate(-50%,-50%);
        }
    </style>
    <script src="resource/js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $(".btn").click(function () {
                var input=$(this).siblings("input").val();
                window.location.href="/course_findName.action?courseName="+input;
            })
            $(".choose").click(function () {
                var courseName= $(this).parent().siblings(".d1").html();
                var courseId= $(this).parent().siblings(".d2").html();
                var teacherName= $(this).parent().siblings(".d3").html();
                var classroom= $(this).parent().siblings(".d4").html();
                var name=$("#name").html();
                var username=$("#username").val();
                console.log($(this).parent().html());
                $.ajax({
                  url:"${pageContext.request.contextPath }/student_save.action",
                  type:"POST",
                  dataType:"json",
                  data:{"username":username,"studentName":name,
                  "courseId":parseInt(courseId),"courseName":courseName,
                  "teacherName":teacherName,"classroom":classroom},
                    // ajax里面取不到this
                success:function (data) {
                      console.log(data);
                },
                error:function () {
                    console.log("失败");
                }
              })
                $(this).parent().html("<a>已选</a>");
            })
        })
    </script>
</head>
<body>
<div class="container">
    <h3>欢迎<strong id="name"><s:property value="#session.userexist.name"/></strong>登陆</h3>
	<div class="panel panel-primary">
        <div class="search"><input type="text" style="width: 200px;" placeholder="请输入课程名"> <button class="btn btn-primary">搜索</button></div>
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
   <tbody id="table1">
   <s:iterator value="list" var="course">
       <s:set var="flag" value="0"/>
      <tr>
         <td class="d1"><s:property value="#course.courseName"/></td>
         <td class="d2"><s:property value="#course.courseId"/></td>
          <td class="d3"><s:property value="#course.teacherName"/></td>
           <td class="d4"><s:property value="#course.classroom"/></td>
            <td><s:property value="#course.number"/></td>

          <s:iterator value="#request.studentlist" var="c">
          <s:if test="#c.courseId==#course.courseId">
              <td><a>已选</a></td>
              <s:set var="flag" value="1"/>
          </s:if>
          </s:iterator>
          <s:if test="#flag==0">
              <td id="test1" class="ss"><a href="javascript:void(0)" class="choose">选课</a></td>
          </s:if>
      </tr>

   </s:iterator>
  </tbody>
</table>
       <div class="test" style="position: relative;"><ul class="pagination">
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
<input type="hidden" id="username" value="<s:property value="#session.userexist.username"/>">
</body>
</html>