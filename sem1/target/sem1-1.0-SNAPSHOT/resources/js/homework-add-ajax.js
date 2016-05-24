$(
    function () {
        $(".create-homework").submit(function (event) {
            event.preventDefault();
            var that = $(this);
            $.ajax({
                    url: "/homeworks/create",
                    method: "POST",
                    data: {
                            id: $(this).find(".groupId").val(),
                            subject: $(this).find(".subject-field").val(),
                            message: $(this).find(".message-field").val(),
                            deadline: $(this).find(".datepicker").val()
                    },
                    success: function () {
                        $(".homework-submit-"+""+that.find(".groupId").val()).css("background-color", "#5cb85c");
                    },
                    error: function () {
                        $(".homework-submit-"+""+that.find(".groupId").val()).css("background-color", "#d9534f");
                    }
                }
            )
        });
    }
);