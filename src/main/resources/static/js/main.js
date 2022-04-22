const main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            let flag = 0;

            let arr = ['#title', '#author', '#content']
            for (let i = 0; i < arr.length; i++) {
                let input = arr[i]
                let ipt = $(input).val()
                if (ipt.replace(/\s|　/gi, "").length === 0) {
                    flag = i + 1
                    break
                }
            }

            switch (flag) {
                case 0:
                    _this.save();
                    console.log("Clicked")
                    break
                case 1:
                    alert('OH Title Is Empty!')
                    console.log("Null Title")
                    $('#title').focus();
                    break
                case 2:
                    alert('OH Author Is Empty!')
                    console.log("Null Author")
                    $('#author').focus();
                    break
                case 3:
                    alert('OH Content Is Empty!')
                    console.log("Null Content")
                    $('#content').focus();
                    break
            }
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.detele();
        })
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
            alert('post has been uploaded.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        let id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Post modified');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    delete: function () {
        let id = $('$id').val();

        $.ajax({
            type: 'DELETE',
            url: 'api/vi/posts/' + id
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert("Post Deleted");
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    }
};

main.init();