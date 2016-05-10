/**
 * Created by user on 10.05.16.
 */
var EmployeeServer = function () {
    this.showList();
};

EmployeeServer.prototype.showList = function (dep) {
    var id = dep.id;
    $.ajax({
        url: '/showDepEmpl',
        type: 'GET',
        dataType: 'json',
        data: {id: id},
        success: function (data) {
            TableDraw.prototype.getTableEmp(data, id)
        }
    });
};

EmployeeServer.prototype.deleteObj = function(emp) {
    var thisObj = this;
    var id = emp.id;
    var dep = {id: emp.depId}
    $.ajax({
        url: '/delEmpl',
        type: 'POST',
        data: {id: id},
        success: function () {
            thisObj.showList(dep)
        }
    });
};

EmployeeServer.prototype.sendDataForController = function () {
    var thisObj = this;
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
            thisObj.showList(dep)
        }
    });
};

EmployeeServer.prototype.validator = function () {
    var thisObj = this;
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
                remote: {
                    url: "/unicEmplEmail",
                    type: "post",
                    data: {
                        id: function() {
                            return $( "#id" ).val();
                        }
                    }
                }
            },
            salary: {
                required: true,
                digits: true,
            },
            date: {
                required: true,
            }
        },
        submitHandler: function () {
            thisObj.sendDataForController()
        }
    });
};
/*
/!*send employee data to server*!/
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



/!*delete empl by id*!/
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

/!*show list empls by dep id*!/
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


/!*Valid add empl form*!/
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
                remote: {
                    url: "/unicEmplEmail",
                    type: "post",
                    data: {
                        id: function() {
                            return $( "#id" ).val();
                        }
                    }
                }
            },
            salary: {
                required: true,
                digits: true,
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
    */
