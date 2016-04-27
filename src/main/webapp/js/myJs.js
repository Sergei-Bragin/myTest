$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/showAllDep",
        dataType: "json",
        timeout: 10000,
        data: "dep",
        success: function (dep) {
            var div = $('<div/>').appendTo($('#test'));

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
            }
            /*$("img").attr({
                src: "/images/hat.gif",
                title: "jQuery",
                alt: "jQuery Logo"

             .append($('<div class="image-container rounded" style="width:81px; height:54px" />'))
             .append($('<img/>')).attr({
             src: "/showDepImage?idImage="+department.id
             }))


            });*/
            /*var compiled = _.template("<tr/>" +
             "<th/>" +
             "<th/><%= id %>" +
             "<th/><%= name %>" +
             "<th/>");
             $("#test").append(compiled(dep[1]));*/
        }

    })
});