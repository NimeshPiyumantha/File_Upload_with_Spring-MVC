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
        },
        error: function (err) {
            console.log(err);
        }
    });
});


$.ajax({
    url: baseUrl + "uploads", method: 'get', dataType: 'json', success: function (resp) {
        console.log(resp.responseText);
        $("#display").css({
            "background": `url(${baseUrl + resp.responseText})`, "background-size": "cover", "height": "300px"
        });
    }, error: function (err) {
        console.log(err);
    }
});
