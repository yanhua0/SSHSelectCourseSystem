<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>修改课程</title>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="resource/js/jquery-1.11.1.min.js"></script>
    <style type="text/css">
        .lab{
            margin-top:30px;
        }
        ul li{list-style: none;color:red;font-size: 30px;}
    </style>
    <script type="text/javascript">
        $(function () {
            $("#sub").click(function () {
                var number=$("#number").val();
                if($("#num").val()<number)
                {
                    alert("数量不能减少！");
                }
                else{
                    window.document.f.submit();
                }
            })
        })

    </script>
</head>
<body>
<s:actionerror/>
<s:form action="course_update" name="f" method="post" namespace="/" theme="simple">
    <s:textfield name="courseId" type="hidden"  value="%{model.courseId}"/>
    <s:textfield id="number" type="hidden" value="%{model.number}" readonly="true"/>
    <s:textfield name="teacherId" type="hidden" value="%{model.teacherId}" readonly="true"/>
    <div class="lab"><label>课&nbsp;&nbsp;程&nbsp;&nbsp;名 <s:textfield name="courseName" value="%{model.courseName}"/></label></div>
    <div class="lab"><label>上课教室 <s:textfield name="classroom" value="%{model.classroom}"/></label></div>
    <div class="lab"><label>教师姓名 <s:textfield name="teacherName" value="%{model.teacherName}"/></label></div>
    <div class="lab"><label>限选人数 <s:textfield name="number" id="num" value="%{model.number}"/></label></div>
    <div class="lab">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="sub" value="提交" class="btn btn-success"></div>
</s:form>
</body>
</html>
