$(
    function () {
        $(".create-homework").submit(function (event) {
            event.preventDefault();
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
                        alert("successfully submitted");
                    },
                    error: function (date) {
                        alert("blya");
                    }
                }
            )
        });
    }
);