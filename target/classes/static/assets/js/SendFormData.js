$(document).ready(function() {
    $("#submitForm").click(function(event) {
        event.preventDefault(); // 防止表單的默認提交行為

        var formData = $("#dataForm").serialize(); // 獲取表單數據

        $.ajax({
            type: "POST",
            url: "/api/getParam", // 這是後端的路由
            data: formData,
            success: function(data) {
                alert("資料已成功送簽!"); // 成功時的提示
            },
            error: function(err) {
                alert("發生錯誤: " + err.responseText); // 錯誤時的提示
            }
        });
    });
});