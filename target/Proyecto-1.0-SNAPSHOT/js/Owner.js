document.getElementById("petsave-button").onclick = function(){
    var petId = document.getElementById("petId-Owner").value;
    var microchip = document.getElementById("microchipPet-Owner").value;
    var petName = document.getElementById("petName-Owner").value;
    var img = document.getElementById("imgMascota-Owner").value;
    var race = document.getElementById("racePet-Owner").value;
    var species = document.getElementById("especie1Pet-Owner").value;
    var sex = document.getElementById("sexPet-Owner").value;
    var size = document.getElementById("tamañoPet-Owner").value;
    var ownerId = document.getElementById("ownerId-Owner").value;

    var petJSON = {
        "petId": petId,
        "microchip": microchip,
        "name": petName,
        "species": species,
        "race": race,
        "size": size,
        "sex": sex,
        "picture": img,
        "ownerId": ownerId
    }

    if(petId === "" || ownerId === "" || petName === "" || img === "" || race === "" || species === "" || sex === "" || size === ""){
        var elementP = document.getElementById("MensajeError").innerHTML = "Debe ingresar datos del Usuario para registrarlo" ;
    }else{
        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/pets",{
            method:"POST",
            body: JSON.stringify(petJSON), // enviar el JSON para la API
            headers:{
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            alert("Mascota Creada Exitosamente!")
            var path = window.location.pathname.split("/");
            var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "owner.html";
            window.location.href = redirect;
        })
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
    }
}

document.getElementById("back-button").onclick = function (){
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "index.html";
    window.location.href = redirect;
}

document.getElementById("show-button").onclick = function (){
    console.log(document.cookie)
    var cookies = document.cookie.split(";")
    var cookieId = cookies[1].split("=")
    console.log(cookieId[1])
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/pets/" + cookieId[1])
        .then(response => response.json())
        .then(data => console.log(data))
    var section = document.getElementById("table");
    var tableTr = document.createElement("tr")

}