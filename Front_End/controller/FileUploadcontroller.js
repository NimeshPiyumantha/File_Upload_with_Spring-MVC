/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
let baseUrl = "http://localhost:8080/Back_End_war/";

loadTheLastUploadedImage();
$("#btnUpload").click(function () {
    var data = new FormData();
    let file = $("#formFileMultiple")[0].files[0];
    let fileName = $("#formFileMultiple")[0].files[0].name;
    data.append("image", file, fileName);

    $.ajax({
        url: baseUrl + "upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {
            $('#display').attr('src', `data:image/png;base64,${resp}`);
            loadTheLastUploadedImage();
        },
        error: function (err) {
            console.log(err);
        }
    });
});

loadTheLastUploadedImage();

function loadTheLastUploadedImage() {
    $.ajax({
        url: baseUrl + "upload",
        method: 'get',
        dataType: 'json',
        success: function (resp) {

            $('#display').attr('src', `${resp}`);
            console.log(resp)

        },
        error: function (err) {
            console.log(err);
        }
    });
}
