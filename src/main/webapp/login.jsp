<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>选课系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            font-family:"Microsoft YaHei";

        }

        #topbox{
            width:1920px;
            height:100px;
            background-color:#DED8D8 ;
        }
        #top{
            width:300px;
            position: relative;
            top:22px;
            left:500px;
            font-size: 25px;
        }
        #top img{
            width:50px;
            height:50px;
            vertical-align: middle;
        }
        hr{width:1920px;
            border-bottom: 50px solid green;
            position:relative;
            top:-20px;
        }
        #box{
            width: 270px;
            height: 204px;
            border: 1px solid #ddd;
            position:absolute;
            right:400px;
            z-index:9999;
        }
        #login{
            height:30px;
            background-color:#79A73B;
            line-height: 30px;
            font-size:16px;
        }
        i{
            width: 40px;
            height: 35px;
            display: block;
            float: left;
        }
        .text{
            width:200px;
            height:35px;
        }
        .lab{
            margin-bottom:20px;
        }
        #input{
            margin-left: 10px;
        }
        .btn-success{
            width:268px;
        }
        #page{
            width:1200px;
            position: relative;
            left:320px;
        }
        ul li{list-style: none;}
    </style>
</head>
<body>
<div id="topbox" >
    <div id="top"><img src="resource/img/xiaohui.gif" alt="">重庆邮电大学选课系统</div>
</div>
<hr style="">

<div id="box">
    <div id="login">
        &nbsp;选课系统登录
    </div>
    <br>
    <s:form action="user_login" method="post" namespace="/" theme="simple">
        <s:actionerror/>
    <div id="input">
        <div class="lab"><label for=""><i title="学号" style="background-image:url(resource/img/user.jpg);"></i><input class="text" name="username" type="text"></label></div>
        <div class="lab"><label for=""><i title="密码" style="background-image:url(resource/img/pwd.png);"></i><input class="text" name="password" type="password"></label></div>

    </div>
    <input type="submit" class="btn btn-success" value="登录">
    </s:form>
</div>
<!-- end #menu -->
<div id="page">
    <div id="content">
        <div class="post">
            <h2 class="title">2017-2018学年第2学期开学补选课安排</h2>
            <p class="meta">
            </p>
            <div class="entry" style="line-height: 1.5em;">
                <h2>选课时间：</h2>
                <div style="font-size: 16px;font-weight: bold;margin-top: 5px;">
                    &nbsp;&nbsp;&nbsp;&nbsp;3月9日上午9:00-12日下午18:00（行课第一周周五至第二周周一）
                </div>
                <h2>选课对象：</h2>
                <div style="font-size: 16px;font-weight: bold;margin-top: 5px;">
                    &nbsp;&nbsp;&nbsp;&nbsp;1.第二次选课后课程被关闭的学生；

                    <br>&nbsp;&nbsp;&nbsp;&nbsp;2.完成复学手续的学生和部分学籍异动学生。

                </div>

                <h2>注意事项</h2>
                <div style="margin-left: 20px;margin-top: 5px;">
                    1．根据上学期成绩，不满足先修条件的，教务处将统一删除其先修选课记录并在教务在线公示。

                    <br>2．特殊选课记录，教务处将根据学院审核结果删除审核不通过课程并在教务在线公示。

                    <br>3．实验及实践环节选课注意事项：

                    <br>（1）有随课实验的课程，选理论课的同时一定要选实验课。

                    <br>（2）实验及实践环节中多选一的课程，选定需要的课程后多余课程请及时退掉。

                    <br>（3）实践环节课程及独立设课实验（无理论环节），请根据培养方案要求确认选择。

                    <br>4.本次选课后，不再接受任何人提出的补、改选申请。




                    <h3 style="color:red">重要提醒</h3>

                    <span style="color: #FF00FF;">注意：课程成绩的取得以选课数据为基础，如果没有选课将不能获得课程成绩。</span>
                    <br><span style="color: red;">请使用IE9+浏览器或火狐浏览器访问,360浏览器请用极速模式。</span>
                </div>
            </div>
        </div>
        <div class="post">
            <h2 class="title">常见问题说明</h2>
            <p class="meta"></p>
            <div class="entry">
                <p>
                    <span style="font-weight: bold;font-size: 1.2em;">1、选课学分限制是怎样的？</span>
                    <br>&nbsp;&nbsp;&nbsp;&nbsp;
                    每一学期选修课程不得高于28学分，具备先修资格学生每学期先修选课不得超过6学分。此外因某些课程资源有限，也会根据实际情况限制某类学分。
                </p>
                <p>
                    <span style="font-weight: bold;font-size: 1.2em;">2、系统提示选课人数已满怎么办？</span>
                    <br>&nbsp;&nbsp;&nbsp;&nbsp;
                    有些教学班因各种原因限制了选课人数，重修等非正常情况修读课程也因要保证教学班人数的构成会有人数限制，所以会出现人数选满的情况。选课期间，系统数据处于动态变化中，如某个时间点系统提示选课人数已满，可稍后在其它时间再试。
                </p>
                <p>
                    <span style="font-weight: bold;font-size: 1.2em;">3、错过选课时间怎么办？</span>
                    <br>&nbsp;&nbsp;&nbsp;&nbsp;
                    每学期选课会安排2次，如果错过时间，请把握住第2次选课时间，具体时间安排会在教务在线通知。
                </p>
                <p>
                    <span style="font-weight: bold;font-size: 1.2em;">4、我应该选哪些课程？</span>
                    <br>&nbsp;&nbsp;&nbsp;&nbsp;
                    根据专业培养方案的要求，制定自己的学习计划，如果需要学习指导可向所在学院进行咨询。
                </p>
            </div>
        </div>
    </div>
</div>
<!--end #sidebar -->
<div style="clear: both;">&nbsp;</div>
</div>

</body>
</html>