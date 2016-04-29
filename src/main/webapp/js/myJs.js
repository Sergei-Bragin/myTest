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
        $('<tr onclick="buttonHandler(event,this)" data-id='+department.id+'/>')
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

/*function -> show dep table*/
function showListDepartments() {
    $.getJSON('/showAllDep', function (dep) {
        drawTableDepartment(dep);
    });
}

/*draw form add dep*/
function addNewDepartments(id) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /*Form*/
    var form = $('<form enctype="multipart/form-data" method="post" name="saveDep"/>')
        .append($('<label/>').text("Name Department").append($('<br/>')))
        .append($('<input class="input-control text" type="text" name="name" placeholder="input you name"/>')).append($('<br/>'))
        .append($('<label/>').text("Icon path").append($('<br/>')))
        .append($('<div class="input-control file" data-role="input"/>')
            .append($('<input class="input-control text" type="file" name="icon" accept="image/*"/>').append($('<br/>'))))
        .append($('<input type="hidden" name="id"/>').val(id)).append($('<br/>'))
        .append($('<button class="button primary" onclick="sendDepForController()"/>').text("Add dep"))
        .appendTo(div);

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

function deleteDep(id) {
    $.ajax({
        contentType: "application/json",
        url: '/delDep',
        type: 'POST',
        dataType: 'json',
        timeout: 100000,
        data: {
         id:id   
        },
        success: function () {
            showListDepartments();
        }
    })
}

function updateDep(id) {

}

function buttonHandler(event, value) {
    var id = $(value).data("id");

    var action = event.target.id;
    if ("btn_del" === action) {
        deleteDep(id);
    } else if ("btn_upd" === action) {
        addNewDepartments(id);
    }

}

