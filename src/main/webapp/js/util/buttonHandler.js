/**
 * Created by user on 11.05.16.
 */
var ButtonHandler = function () {
    
};

ButtonHandler.prototype.DepTable = function (event, value) {
    var dep = $(value).data("dep");
    var action = event.target.id;

    if ("btn_del" === action) {
        DepartmentServer.prototype.deleteObj(dep);
    } else if ("btn_upd" === action) {
        FormDraw.prototype.getFormDep(dep);
    } else if ("bnt_list_empl"===action) {
        EmployeeServer.prototype.showList(dep);
    }
};

ButtonHandler.prototype.DepAddBtn = function (event, value) {
    var action = event.target.id;
    if ("btn_add_dep" === action){
        FormDraw.prototype.getFormDep()
    }
};


ButtonHandler.prototype.EmpTable = function (event, value) {
    var emp = $(value).data("empls");
    var action = event.target.id;

    if ("btn_del" === action) {
        EmployeeServer.prototype.deleteObj(emp);
    } else if ("btn_upd" === action) {
        FormDraw.prototype.getFormEmp(emp);
    }
};

ButtonHandler.prototype.EmplAddBtn = function (event, value) {
    var empl = {
        depId: $(value).data("id")
    };
    var action = event.target.id;

    if ("addNewEmployee" === action) {
        FormDraw.prototype.getFormEmp(empl);
    } else if ("redirectByDep" === action) {
        DepartmentServer.prototype.showList();
    }
};

/*
function buttonHandlerDep(event, value) {
    var dep = $(value).data("dep");
    var action = event.target.id;

    if ("btn_del" === action) {
        DepartmentServer.prototype.deleteObj(dep);
    } else if ("btn_upd" === action) {
        FormDraw.prototype.getFormDep(dep);
    } else if ("bnt_list_empl") {
        EmployeeServer.prototype.showList(dep);
    }
}

function buttonHandlerEmpl(event, value) {
    var emp = $(value).data("empls");
    var action = event.target.id;

    if ("btn_del" === action) {
        EmployeeServer.prototype.deleteObj(emp);
    } else if ("btn_upd" === action) {
        FormDraw.prototype.getFormEmp(emp);
    }
}

function addButtonEmplHandler(event, value) {
    var empl = {
        depId: $(value).data("id")
    };
    var action = event.target.id;

    if ("addNewEmployee" === action) {
        FormDraw.prototype.getFormEmp(empl);
    } else if ("redirectByDep" === action) {
        DepartmentServer.prototype.showList();
    }
}*/
