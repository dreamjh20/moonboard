const main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            //버튼 이벤트 발생 시 제목이 비었는지 확인
            const title = $("#title").val();
            if (title.replace(/\s|　/gi, "").length === 0) {
                alert('OH Title Is Empty!')
                $("$title").focus();
            }

            _this.save();
            console.log("Clicked")

        });
    },
    save: function () {
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Your post has been uploaded.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
