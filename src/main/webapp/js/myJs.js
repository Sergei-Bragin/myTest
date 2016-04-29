$(document).ready(function () {
    showList();
});

/*function -> draw department table*/
function showAllDepartment(dep) {

    $('#test').children().detach();
    var div = $('<div/>').appendTo($('#test'));
    /*Table Head*/
    var table = $('<table class="table hovered"/>').appendTo(div).html("<tr><th></th><th> ID </th><th> Name </th><th></th><th></th><th></th></tr>");
    /*Table body*/
    for (var i = 0; i < dep.length; i++) {
        var department = dep[i];
        $('<tr/>')
            .append($('<td>')
                .append($('<div class="image-container rounded" style="width:81px; height:54px" />')
                    .append($('<img/>').attr({src: "/showDepImage?idImage=" + department.id}))))
            .append($('<td>').text(department.id))
            .append($('<td>').text(department.name))
            .append($('<td>')
                .append($('<button class="button  primary">Delete</button>')))
            .append($('<td>')
                .append($('<button class="button  primary">Update</button>')))
            .append($('<td>')
                .append($('<button class="button  primary">List Employee</button>')))
            .appendTo(table);
    }
    /*Add button*/
    $('<button class="button primary block-shadow-success text-shadow" onclick="addNewDep()"/>').text("+Add dep").appendTo(table);
}
/*function -> show dep table*/
function showList() {
    $.getJSON('/showAllDep', function (dep) {
        showAllDepartment(dep);
    });
}

function addNewDep(id) {

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
    /*Button*/
    /*$('<button class="button primary" id="addNewDepartment"/>').text("Add department").appendTo(form);*/



    /*var formData = document.forms.namedItem('saveDep');
    form.addEventListener('submit',function (ev) {
        oData = new FormData(formData);

        oData.append("CustomField", "This is some extra data");
        var oReq = new XMLHttpRequest();
        oReq.open("POST","/saveDep",true);
        oReq.onload = function (oEvent) {
            if(oReq.status==200){
                showList();
            }else {
                alert("FUUK");
            }
        };
        oReq.send(oData);
        ev.preventDefault();
    }, false);*/


}
function sendDepForController() {
    var fd = new FormData(document.querySelector("form"));
    $.ajax({
        url : '/saveDep',
        type : 'POST',
        data: fd,
        processData: false,
        contentType: false
    });
}

function deleteDep(id) {

}
function updateDep(id) {

}

/*var div = $('<div/>').appendTo($('#test'));

 var table = $('<table class="table hovered"/>').appendTo(div)
 .append($('<tr/>')
 .append($('<th/>').html(''))
 .append($('<th/>').html('ID'))
 .append($('<th/>').html('Name'))
 .append($('<th/>').html(''))
 .append($('<th/>').html(''))
 .append($('<th/>').html(''))
 );

 for (var i = 0; i < dep.length; i++) {
 var department = dep[i];
 $('<tr/>')
 .append($('<td>')
 .append($('<div class="image-container rounded" style="width:81px; height:54px" />')
 .append($('<img/>').attr({
 src :  "/showDepImage?idImage="+department.id
 }))))
 .append($('<td>').text(department.id))
 .append($('<td>').text(department.name))
 .append($('<td>')
 .append($('<button class="button  primary"  type="submit">Delete</button>')))
 .append($('<td>')
 .append($('<button class="button  primary"  type="submit">Update</button>')))
 .append($('<td>')
 .append($('<button class="button  primary"  type="submit">List Employee</button>')))
 .appendTo(table);
 }*/