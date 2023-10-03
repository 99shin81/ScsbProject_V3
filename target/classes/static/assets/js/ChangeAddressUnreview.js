document.addEventListener('DOMContentLoaded', function() {
    var linkElement = document.getElementById('unreview');
    linkElement.addEventListener('click', function(event) {
        var empId = document.getElementById('EmpId').textContent;
        var newHref = "/api/findByCurrentEmpId?empIdData=" + encodeURIComponent(empId);
        linkElement.setAttribute('href', newHref);
    });
});