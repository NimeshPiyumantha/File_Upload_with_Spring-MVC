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
            alert("Uploaded Successfully");
            loadTheLastUploadedImage();
        },
        error: function (err) {
            console.log(err);
        }
    });
});

function loadTheLastUploadedImage() {
    $.ajax({
        url: baseUrl + "upload",
        method: 'get',
        dataType: 'json',
        success: function (resp) {
            let url = resp[resp.length - 1];

            $("#display").css({
                "background": `url(${baseUrl + url})`,
                "background-size": "cover",
                "height": "450px"
            });

        },
        error: function (err) {
            console.log(err);
        }
    });
}
