$(function(){
	$("#sendBtn").click(send_letter);
	$(".close").click(delete_msg);
});

function send_letter() {
	$("#sendModal").modal("hide");

	var toName = $("#recipient-name").val();
	var content = $("#message-text").val();
	$.post(										/*jQuery发送异步请求*/
		CONTEXT_PATH + "/letter/send",			/*访问路径*/
		{"toName":toName, "content":content},	/*传的数据参数*/
		function(data) {						/*处理服务端返回结果*/
			data = $.parseJSON(data);			/*转换为JS对象*/
			if (data.code == 0) {
				$("#hintBody").text("发送成功！");
			} else {
				$("#hintBody").text(data.msg);
			}

			$("#hintModal").modal("show");
			setTimeout(function(){
				$("#hintModal").modal("hide");
				location.reload();	/*刷新页面*/
			}, 2000);
		}
	);
}

function delete_msg() {
	// TODO 删除数据
	$(this).parents(".media").remove();
}