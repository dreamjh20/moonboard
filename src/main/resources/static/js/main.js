let flag = 0
const main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            flag = 0;

            //버튼 이벤트 발생 시 제목이 비었는지 확인
            const title = $('#title').val();
            if (title.replace(/\s|　/gi, "").length === 0) {
                alert('OH Title Is Empty!')
                console.log("Null Title")
                $('#title').focus();
                flag = 1
            }

            //버튼 이벤트 발생 시 작성자가 비었는지 확인
            const author = $('#author').val();
            if (author.replace(/\s|　/gi, "").length === 0) {
                alert('OH Author Is Empty!')
                console.log("Null Author")
                $('#author').focus();
                flag = 1
            }

            //버튼 이벤트 발생 시 내용이 비었는지 확인
            const content = $('#content').val();
            if (content.replace(/\s|　/gi, "").length === 0) {
                alert('OH Content Is Empty!')
                console.log("Null Content")
                $('#content').focus();
                flag = 1
            }
            if(flag === 0) {
                _this.save();
                console.log("Clicked")
            }
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
