$(document).ready(function () {
    console.log($("#principalName").val());

    $("#submitBtn").on("click", {}, function (e) {
        e.preventDefault();
        var policyId = $("#policy_number").val();
        var description = $("#claim_description").val();
        var accidentDate = $("#incident_date").val();
        var repairPrice = $("#claim_amount").val();
        var images = $("#images")[0];
        var arrayOfBytesArray = [];

        var promises = [];
        console.log(images);
        if (images.files) {
            for (var file of images.files) {
                var reader = new FileReader();
                var promise = new Promise(function (resolve) {
                    reader.onload = function (event) {
                        const fileContent = event.target.result;
                        const byteArray = new Uint8Array(fileContent);

                        var b64encoded = btoa(
                            byteArray.reduce(function (data, byte) {
                                return data + String.fromCharCode(byte);
                            }, '')
                        );
                        arrayOfBytesArray.push(b64encoded);
                        resolve();
                    };
                });

                reader.readAsArrayBuffer(file);
                promises.push(promise);
            }
        }

        Promise.all(promises).then(function () {
            console.log(arrayOfBytesArray);

            var imag = arrayOfBytesArray.map((array) => String.fromCharCode(...[array]));

            var claims = {
                policyId,
                description,
                accidentDate,
                repairPrice,
                images: arrayOfBytesArray,
                status: "Pending",
                username: $("#principalName").val(),
            };

            console.log(claims);

            $.ajax({
                type: "POST",
                url: "http://localhost:8383/createClaim",
                contentType: "application/json",
                data: JSON.stringify(claims),
                success: function (response) {
                    console.log(response);
        window.location.href = "http://localhost:8282/profile";
                },
            });
        });
    });

    $("#plansB").click(function (e) {
        window.location.href = "http://localhost:8282/plans";
    });
});
