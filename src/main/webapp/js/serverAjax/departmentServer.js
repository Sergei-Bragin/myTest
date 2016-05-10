var DepartmentServer = function () {
    this.showList();
};


DepartmentServer.prototype.showList = function () {
    $.getJSON('/showAllDep', function (dep) {
        TableDraw.prototype.getTableDep(dep)
    })
};

DepartmentServer.prototype.deleteObj = function (dep) {
    var thisObj = this;
    var id = dep.id;
    $.ajax({
        url: '/delDep',
        type: 'POST',
        data: {id: id},
        success: function () {
            thisObj.showList();
        }
    });
};
DepartmentServer.prototype.sendDataForController = function () {
    var fd = new FormData(document.querySelector("form"));
    var thisObj = this;
    $.ajax({
        url: '/saveDep',
        type: 'POST',
        data: fd,
        processData: false,
        contentType: false,
        success: function () {
            thisObj.showList();
        }
    });
};

DepartmentServer.prototype.validator = function () {
    var thisObj = this;
    $('#depForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 16,
                remote: {
                    url: "/unicDepName",
                    type: "POST",
                    data: {
                        id: function() {
                            return $( "#id" ).val();
                        }
                    }
                }
            }
        },
        messages: {
            name: {
                remote: "Name already in use!"
            }
        },
        submitHandler: function () {
            thisObj.sendDataForController()
        }
    });
};
/*






/!*Valid add dep form*!/
function departmentFormValidate() {
    $('#depForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 16,
                remote: {
                    url: "/unicDepName",
                    type: "POST",
                    data: {
                        id: function() {
                            return $( "#id" ).val();
                        }
                    }
                }
            }
        },
        messages: {
            name: {
                remote: "Name already in use!"
            }
        },
        submitHandler: function () {
            sendDepForController()
        }
    });

 function showListDepartments() {
 $.getJSON('/showAllDep', function (dep) {
 drawTableDepartment(dep);
 });
 }

 /!*Delete department by id*!/
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
 /!*send department data to server*!/
 function sendDepForController() {
 /!*input file to form*!/
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
}*/
