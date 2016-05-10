/**
 * Created by user on 10.05.16.
 */
var FormDraw = function () {
};

FormDraw.prototype.getFormDep = function (dep) {
    $('#test').children().detach()
    var div = $('<div/>').appendTo($('#test'));
    /!*Form*!/
    var form = $('<form enctype="multipart/form-data" id="depForm"/>')
        .append($('<label/>').text("Name Department").append($('<br/>')))
        .append($('<input class="input-control text" type="text" id="name" name="name" placeholder="input you name"/>')
            .val(dep != null ? dep.name : "")).append($('<br/>'))
        .append($('<label/>').text("Icon path")).append($('<br/>'))
        .append($('<div class="input-control file" data-role="input"/>')
            .append($('<input class="input-control text" type="file" name="icon" accept="image/!*"/>'))).append($('<br/>'))
        .append($('<input type="hidden" id="id" name="id"/>')
            .val(dep != null ? dep.id : "")).append($('<br/>'))
        .append($('<input class="button primary" type="submit"/>').text("Add dep"))
        .appendTo(div);

    DepartmentServer.prototype.validator();
};

FormDraw.prototype.getFormEmp = function (emp) {
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

    EmployeeServer.prototype.validator();
};
/*


function addNewDepartments(dep) {

    $('#test').children().detach()
    var div = $('<div/>').appendTo($('#test'));
    /!*Form*!/
    var form = $('<form enctype="multipart/form-data" id="depForm"/>')
        .append($('<label/>').text("Name Department").append($('<br/>')))
        .append($('<input class="input-control text" type="text" id="name" name="name" placeholder="input you name"/>')
            .val(dep != null ? dep.name : "")).append($('<br/>'))
        .append($('<label/>').text("Icon path")).append($('<br/>'))
        .append($('<div class="input-control file" data-role="input"/>')
            .append($('<input class="input-control text" type="file" name="icon" accept="image/!*"/>'))).append($('<br/>'))
        .append($('<input type="hidden" id="id" name="id"/>')
            .val(dep != null ? dep.id : "")).append($('<br/>'))
        .append($('<input class="button primary" type="submit"/>').text("Add dep"))
        .appendTo(div);

    DepartmentServer.prototype.validator();
    //departmentFormValidate();
}
/!*draw form add empl*!/
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

    EmployeeServer.prototype.validator();

}*/
