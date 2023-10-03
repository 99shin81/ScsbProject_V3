
function loadEmpIdUnreview() {
    var EmpId = localStorage.getItem("EmpId");
    if (EmpId) {
        document.getElementById("EmpId").textContent = EmpId;
        console.log(EmpId)

        $.ajax({
            url: '/api/findByCurrentEmpId?empIdData=' + encodeURIComponent(EmpId),  // Append as query parameter
            method: 'GET',
            success: function(response) {
                console.log(response);
            },
            error: function(error) {
                console.error("Error sending EmpId to server: ", error);
            }
        });



    }


}