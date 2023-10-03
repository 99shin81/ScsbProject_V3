$(document).ready(function () {
    console.log("ready!");
    let btnAct = document.getElementsByClassName("btn-sign");
    let btnInfoState = document.getElementsByClassName("btn-info-state");

    for (let i = 0; i < btnAct.length; i++) {
        btnAct[i].addEventListener("click", function () {
            //	console.log(btnAct[i].parentNode.parentNode.parentNode);
            let Ftd = btnAct[i].parentNode.parentNode.parentNode;
            let formName = Ftd.id;
            // console.log(formName);
            let formId = Ftd.children[0].innerHTML;
            // console.log(formId);
            let formInfo = formName + " " + formId;
            console.log("按下簽名進入js事件url=", encodeURIComponent(formInfo));
            // url: "/api/signForm/formInfo=" + encodeURIComponent(formInfo),
            $.ajax({
                url: "/api/signForm?formInfo=" + encodeURIComponent(formInfo),
                method: "GET",
                success: function (response) {
                    console.log(response);
                },
                error: function (error) {
                    console.error("Error sending formInfo to server: ", error);
                },
            });
        });
    }
    for (let i = 0; i < btnInfoState.length; i++) {
        btnInfoState[i].addEventListener("click", function () {
            //	console.log(btnAct[i].parentNode.parentNode.parentNode);
            let Ftd = btnInfoState[i].parentNode.parentNode.parentNode;

            //console.log(Ftd);
            console.log(Ftd.children[0].innerHTML);
            $.ajax({
                url:
                    "/api/returnInfo?formId=" +
                    encodeURIComponent(Ftd.children[0].innerHTML), // Append as query parameter
                method: "GET",
                success: function (response) {
                    console.log(response);
                },
                error: function (error) {
                    console.error("Error sending EmpId to server: ", error);
                },
            });
        });
    }
});