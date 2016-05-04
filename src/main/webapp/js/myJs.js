$(document).ready(function () {
    showListDepartments();
});

/*function -> draw department table*/
function drawTableDepartment(dep) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /*Table Head*/
    var table = $('<table class="table hovered"/>').appendTo(div).html("<tr><th></th><th> ID </th><th> Name </th><th></th><th></th><th></th></tr>");
    /*Table body*/
    for (var i = 0; i < dep.length; i++) {
        var department = dep[i];
        var jsonDep = JSON.stringify(department);
        $('<tr onclick="buttonHandlerDep(event,this)" data-dep=' + jsonDep + '/>')
            .append($('<td>')
                .append($('<div class="image-container rounded" style="width:81px; height:54px" />')
                    .append($('<img/>').attr({src: "/showDepImage?idImage=" + department.id}))))
            .append($('<td>').text(department.id))
            .append($('<td>').text(department.name))
            .append($('<td>')
                .append($('<button class="button  primary" id="btn_del"/>').text("Delete")))
            .append($('<td>')
                .append($('<button class="button  primary" id="btn_upd"/>').text("Update")))
            .append($('<td>')
                .append($('<button class="button  primary" id="bnt_list_empl"/>').text("List Employee")))
            .appendTo(table);
    }
    /*Add button*/
    $('<button class="button primary block-shadow-success text-shadow" onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);
}

/*function -> Draw Empl table*/
function drawTableEmpl(data) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /*Table head*/
    var table = $('<table class="table hovered"/>').appendTo(div).html("<tr><th>ID</th><th>Name</th><th>Email</th><th>Date</th><th>Salary</th><th></th><th></th></tr>");
    /*Table body*/
    for (var i = 0; i < data.length; i++) {
        var empl = data[i];
        var jsonEmpl = JSON.stringify(empl);
        $('<tr onclick="buttonHandlerEmpl(event,this)" data-empl=' + jsonEmpl + '/>')
            .append($('<td/>').text(empl.id))
            .append($('<td/>').text(empl.name))
            .append($('<td/>').text(empl.email))
            .append($('<td/>').text(empl.date))
            .append($('<td/>').text(empl.salary))
            .append($('<td>')
                .append($('<button class="button  primary" id="btn_del"/>').text("Delete")))
            .append($('<td>')
                .append($('<button class="button  primary" id="btn_upd"/>').text("Update")))
            .appendTo(table);
    }
    $('<button class="button primary " onclick="addNewEmpl()"/>').text("+Add Empl").appendTo(div);
    $('<button class="button primary " onclick="showListDepartments()"/>').text("Return").appendTo(div);


}

/*function -> show dep table*/
function showListDepartments() {
    $.getJSON('/showAllDep', function (dep) {
        drawTableDepartment(dep);
    });
}

/*draw form add dep*/
function addNewDepartments(dep) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /*Form*/
    var form = $('<form enctype="multipart/form-data" method="post" name="saveDep"/>')
        .append($('<label/>').text("Name Department").append($('<br/>')))
        .append($('<input class="input-control text" type="text" name="name" placeholder="input you name"/>').val(dep.name.toString())).append($('<br/>'))
        .append($('<label/>').text("Icon path").append($('<br/>')))
        .append($('<div class="input-control file" data-role="input"/>')
            .append($('<input class="input-control text" type="file" name="icon" accept="image/*"/>').append($('<br/>'))))
        .append($('<input type="hidden" name="id"/>').val(dep.id.toString())).append($('<br/>'))
        .append($('<button class="button primary" onclick="sendDepForController()"/>').text("Add dep"))
        .appendTo(div);

}

function addNewEmpl(empl) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
}

/*send department data to server*/
function sendDepForController() {
    /*input file to form*/
    var fd = new FormData(document.querySelector("form"));
    $.ajax({
        url: '/saveDep',
        type: 'POST',
        data: fd,
        processData: false,
        contentType: false,
        success: function () {
            showListDepartments();
        }
    });
}

/*Delete department by id*/
function deleteDep(dep) {
    var id = dep.id;
    $.ajax({
        url: '/delDep',
        type: 'POST',
        data: {id: id},
        success: function () {
            showListDepartments();
        }
    });
}

function deleteEmp(emp) {
    var id = emp.id;
    var dep = {id: emp.depId.toString()}
    $.ajax({
        url: '/delEmpl',
        type: 'POST',
        data: {id: id},
        success: function () {
            showListEmpl(dep)
        }
    });

}

function showListEmpl(dep) {
    var id = dep.id;
    $.ajax({
        url: '/showDepEmpl',
        type: 'GET',
        dataType: 'json',
        data: {id: id},
        success: function (data) {
            drawTableEmpl(data)
        }
    });
}


function buttonHandlerDep(event, value) {
    var dep = $(value).data("dep");

    var action = event.target.id;
    if ("btn_del" === action) {
        deleteDep(dep);
    } else if ("btn_upd" === action) {
        addNewDepartments(dep);
    } else if ("bnt_list_empl") {
        showListEmpl(dep);
    }
}

function buttonHandlerEmpl(event, value) {
    var emp = $(value).data("empl");

    var action = event.target.id;
    if ("btn_del" === action) {
        deleteEmp(emp);
    } else if ("btn_upd" === action) {
        addNewEmpl(emp)
    }
}

