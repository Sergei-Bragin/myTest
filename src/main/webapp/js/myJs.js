$(document).ready(function() {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/showAllDep",
        dataType : "json",
        timeout : 10000,
        data : "dep",
        success : function(dep) {
            
           var showDep = ""
        }

    })
});