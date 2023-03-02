/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
let baseUrl = "http://localhost:8080/Back_End_war/";

$("#btnUpload").click(function () {
    let formData = new FormData($("#formFile")[0]);
    $.ajax({
        url: baseUrl + "uploads",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: formData,
        success: function (resp) {
            alert("Successfully upload;");
            imageLoad();
        },
        error: function (err) {
            console.log(err);
        }
    });
});
imageLoad();
function imageLoad() {
    $.ajax({
        url: baseUrl + "uploads/lastImageLoad",
        method: 'get',
        success: function (resp) {
            console.log(resp.data);
            url1 = resp.data
            $("#display").css({
                "background": `url(${baseUrl + url1})`, "background-size": "cover"
            });
        },
        error: function (err) {
            console.log(err);
        }
    });
}