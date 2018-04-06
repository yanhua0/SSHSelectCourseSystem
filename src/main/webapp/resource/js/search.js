$(function () {
    $(".btn").click(function () {
        var input=$(this).siblings("input").val();
        window.location.href="/course_findName.action?courseName="+input;
    });
    $(".choose").click(function () {
        var courseName= $(this).parent().siblings(".d1").html();
        var courseId= $(this).parent().siblings(".d2").html();
        var teacherName= $(this).parent().siblings(".d3").html();
        var classroom= $(this).parent().siblings(".d4").html();
        var teacherId=$(this).parent().siblings(".d5").html();

        console.log($(this).parent().html());
        $.ajax({
            url:"${pageContext.request.contextPath }/student_save.action",
            type:"POST",
            dataType:"json",
            data:{"courseId":parseInt(courseId),"courseName":courseName,
                "teacherName":teacherName,"teacherId":teacherId,"classroom":classroom},
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