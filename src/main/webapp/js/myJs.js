$(document).ready(function () {
    showListDepartments();

});
/*//////////////////////////////////////////////////*/

/*Table form */

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
    $('<button class="button primary block-shadow-success text-shadow"  onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);
}

/*function -> Draw Empl table*/
function drawTableEmpl(data, id) {
    $('#test').children().detach();

    var div = $('<div onclick="addButtonEmplHandler(event,this)"   data-id=' + id + '/>').appendTo($('#test'));
    /*Table head*/
    var table = $('<table class="table hovered"/>').appendTo(div)
        .html("<tr><th>ID</th><th>Name</th><th>Email</th><th>Date</th><th>Salary</th><th></th><th></th></tr>");
    /*Table body*/
    for (var i = 0; i < data.length; i++) {
        var emp = data[i];
        var jsonEmp = JSON.stringify(emp);
        $('<tr onclick="buttonHandlerEmpl(event,this)" data-empls=' + jsonEmp + '/>')
            .append($('<td/>').text(emp.id))
            .append($('<td/>').text(emp.name))
            .append($('<td/>').text(emp.email))
            .append($('<td/>').text(emp.date))
            .append($('<td/>').text(emp.salary))
            .append($('<td>')
                .append($('<button class="button primary" id="btn_del"/>').text("Delete")))
            .append($('<td>')
                .append($('<button class="button primary" id="btn_upd"/>').text("Update")))
            .appendTo(table);
    }
    $('<button class="button primary "  id = "addNewEmployee"/>').text("+Add Empl").appendTo(div);
    $('<button class="button primary "  id = "redirectByDep""/>').text("Return").appendTo(div);


}
/*//////////////////////////////////////////////////*/

/*Dialog forms */


/*draw form add dep*/
function addNewDepartments(dep) {

    $('#test').children().detach()
    var div = $('<div/>').appendTo($('#test'));
    /*Form*/
    var form = $('<form enctype="multipart/form-data" id="depForm"/>')
        .append($('<label/>').text("Name Department").append($('<br/>')))
        .append($('<input class="input-control text" type="text" name="name" placeholder="input you name"/>')
            .val(dep != null ? dep.name : "")).append($('<br/>'))
        .append($('<label/>').text("Icon path")).append($('<br/>'))
        .append($('<div class="input-control file" data-role="input"/>')
            .append($('<input class="input-control text" type="file" name="icon" accept="image/*"/>'))).append($('<br/>'))
        .append($('<input type="hidden" name="id"/>')
            .val(dep != null ? dep.id : "")).append($('<br/>'))
        .append($('<input class="button primary" type="submit"/>').text("Add dep"))
        .appendTo(div);

    departmentFormValidate();
}
/*draw form add empl*/
function addNewEmpl(emp) {

    $('#test').children().detach();
    var div = $('<div/>').appendTo($('#test'));

    $('<form id="empForm"/>')
        .append($('<input type="hidden" id="id" name="id"/>').val(emp != null ? emp.id : ""))
        .append($('<label/>').text("Name Employee")).append('<br/>')
        .append($('<input class="input-control text" type="text" id="name" name="name"/>')
            .val(emp != null ? emp.name : "")).append($('<br/>'))
        .append($('<label/>').text("E-mail").append('<br/>'))
        .append($('<input class="input-control text" type="text" id="email" name="email"/>')
            .val(emp != null ? emp.email : "")).append($('<br/>'))
        .append($('<label/>').text("Date").append('<br/>'))
        .append($('<input class="input-control text" type="date" id="date" name="date"/>')
            .val(emp != null ? emp.date : "")).append($('<br/>'))
        .append($('<label/>').text("Salary").append('<br/>'))
        .append($('<input class="input-control text" type="text" id="salary" name="salary"/>')
            .val(emp != null ? emp.salary : "")).append($('<br/>'))
        .append($('<input type="hidden" id="depId" name="depId"/>').val(emp != null ? emp.depId : ""))
        .append($('<button class="button primary" type="submit" "/>').text("Add employee"))
        .appendTo(div);

    emplFormValidate();

}
/*//////////////////////////////////////////////////*/
/*AJAX request by server*/

/*function -> show dep table*/
function showListDepartments() {
    $.getJSON('/showAllDep', function (dep) {
        drawTableDepartment(dep);
    });
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
/*send employee data to server*/
function sendEmpForController() {
    var dep_id = $('#depId').val();
    var id = $('#id').val();
    var name = $('#name').val();
    var email = $('#email').val();
    var date = $('#date').val();
    var salary = $('#salary').val();
    var dep = {id: dep_id};
    $.ajax({
        url: '/saveEmpl',
        type: 'POST',
        data: {
            id: id,
            name: name,
            email: email,
            date: date,
            salary: salary,
            depId: dep_id
        },
        success: function () {
            showListEmpl(dep)
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

/*delete empl by id*/
function deleteEmp(emp) {
    var id = emp.id;
    var dep = {id: emp.depId}
    $.ajax({
        url: '/delEmpl',
        type: 'POST',
        data: {id: id},
        success: function () {
            showListEmpl(dep)
        }
    });

}

/*show list empls by dep id*/
function showListEmpl(dep) {
    var id = dep.id;
    $.ajax({
        url: '/showDepEmpl',
        type: 'GET',
        dataType: 'json',
        data: {id: id},
        success: function (data) {
            drawTableEmpl(data, id)
        }
    });
}
/*//////////////////////////////////////////////////*/


/*Button handler event*/
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
    var emp = $(value).data("empls");

    var action = event.target.id;
    if ("btn_del" === action) {
        deleteEmp(emp);
    } else if ("btn_upd" === action) {
        addNewEmpl(emp);
    }
}

function addButtonEmplHandler(event, value) {
    var empl = {
        depId: $(value).data("id")
    };
    var action = event.target.id;
    if ("addNewEmployee" === action) {
        addNewEmpl(empl);
    } else if ("redirectByDep" === action) {
        showListDepartments()
    }
}
/*///////////////////////////////////////////////////////*/

/*Validation Rulse*/

/*Valid add dep form*/
function departmentFormValidate() {
    $('#depForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 16
            }
        },
        submitHandler: function () {
            sendDepForController()
        }
    });
}
/*Valid add empl form*/
function emplFormValidate() {
    $('#empForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            email: {
                required: true,
                email: true,
            },
            salary: {
                required: true,
            },
            date: {
                required: true,
            }
        },
        submitHandler: function () {
            sendEmpForController()
        }
    });
}
    
