/**
 * Created by user on 10.05.16.
 */
var TableDraw = function () {
    
};

TableDraw.prototype.getTableDep = function (dep) {
    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
   
    var table = $('<table class="table hovered"/>').appendTo(div).html("<tr><th></th><th> ID </th><th> Name </th><th></th><th></th><th></th></tr>");
    
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
    
    $('<button class="button primary block-shadow-success text-shadow"  onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);
    
};

TableDraw.prototype.getTableEmp = function (emp, id) {
    $('#test').children().detach();

    var div = $('<div onclick="addButtonEmplHandler(event,this)"   data-id=' + id + '/>').appendTo($('#test'));
    /!*Table head*!/
    var table = $('<table class="table hovered"/>').appendTo(div)
        .html("<tr><th>ID</th><th>Name</th><th>Email</th><th>Date</th><th>Salary</th><th></th><th></th></tr>");
    /!*Table body*!/
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
};



/*
function drawTableDepartment(dep) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /!*Table Head*!/
    var table = $('<table class="table hovered"/>').appendTo(div).html("<tr><th></th><th> ID </th><th> Name </th><th></th><th></th><th></th></tr>");
    /!*Table body*!/
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
    /!*Add button*!/
    $('<button class="button primary block-shadow-success text-shadow"  onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);
}

/!*function -> Draw Empl table*!/
function drawTableEmpl(data, id) {
    $('#test').children().detach();

    var div = $('<div onclick="addButtonEmplHandler(event,this)"   data-id=' + id + '/>').appendTo($('#test'));
    /!*Table head*!/
    var table = $('<table class="table hovered"/>').appendTo(div)
        .html("<tr><th>ID</th><th>Name</th><th>Email</th><th>Date</th><th>Salary</th><th></th><th></th></tr>");
    /!*Table body*!/
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


}*/
