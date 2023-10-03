function loadEmpId() {
    var EmpId = localStorage.getItem("EmpId");
    if (EmpId) {
        document.getElementById("EmpId").textContent = EmpId;

        $.ajax({
            url: '/api/findByEmpId?empIdData=' + encodeURIComponent(EmpId),  // Append as query parameter
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
function saveEmpId() {
    var EmpId = document.getElementById("EmpId").value;
    localStorage.setItem("EmpId", EmpId);
    window.location.href = "index.html"; // Redirect to index.html
}