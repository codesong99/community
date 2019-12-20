/*异步提交头像到七牛云需要的js文件*/
$(function () {
    $("#uploadForm").submit(upload);
});

function upload() {
    $.ajax({
        url:"http://upload.qiniup.com",  /*七牛云华东存储区域*/
        method:"post",
        processData:false,  /*不把表单内容转换为字符串*/
        contentType:false,  /*不用jQuery设置上传类型，浏览器会自动设置*/
        data:new FormData($("#uploadForm")[0]), /*jQuery对象 -> JS对象*/
        success:function (data) {
            if(data && data.code == 0) {
                // 更新头像访问路径
                $.post(
                    CONTEXT_PATH + "/user/header/url",
                    {"fileName":$("input[name='key']").val()},
                    function (data) {
                        data = $.parseJSON(data);
                        if (data.code == 0) {
                            window.location.reload();
                        } else {
                            alert(data.msg);
                        }
                    }
                );
            } else {
                alert("上传失败！");
            }
        }

    });
    return false;
}