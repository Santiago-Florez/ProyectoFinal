document.getElementById("visitsave-button").onclick = function (){

    let visitId = document.getElementById("idVisit").value;
    let createdAt = document.getElementById("fechaVisit").value;
    let vetId = document.getElementById("idVet-Visit").value;
    let petId = document.getElementById("idPet-Visit").value;
    let typeVisit = document.getElementById("typeVisitVet").value;
    let description = document.getElementById("descriptionVisitVet").value;

    let visitJSON = {
        "visitId": visitId,
        "createdAt": "" + createdAt,
        "type": typeVisit,
        "description": description,
        "vetId": vetId,
        "petId": petId
    };

    if (visitId === "" || createdAt === "" || typeVisit === "" || description === "" || vetId === "" || petId === ""){
        var elementP = document.getElementById("MensajeError").innerHTML = "Debe ingresar datos de la Visita para registrarla";
    }else{
        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits", {
            method: "POST",
            body: JSON.stringify(visitJSON), // enviar el JSON para la API
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => {
                alert("Mascota Creada Exitosamente!")
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                window.location.href = redirect;
            })
    }
}

document.getElementById("back-button").onclick = function (){
    var ruta = window.location.pathname.split("/");
    var ir = window.location.protocol + "//" + window.location.host + "/" + ruta[1] + "/" + "index.html";
    window.location.href = ir;
}