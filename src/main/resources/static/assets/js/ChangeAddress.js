document.addEventListener('DOMContentLoaded', function() {
    var linkElement = document.getElementById('ggyy');
    linkElement.addEventListener('click', function(event) {
        var empId = document.getElementById('EmpId').textContent;
        var newHref = "/api/findByEmpId?empIdData=" + encodeURIComponent(empId);
        linkElement.setAttribute('href', newHref);
    });
});

