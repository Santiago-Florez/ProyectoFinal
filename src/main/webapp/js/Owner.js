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
        "picture": img+"",
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

var rowId = 0;
var table;
var tableTr;
document.getElementById("show-button").onclick = function (){
    console.log(document.cookie)
    var cookies = document.cookie.split(";")
    var cookieId
    for (let i = 0; i < cookies.length; i++){
        if (cookies[i].length == 5 || cookies[i].length == 4){
            cookieId = cookies[i].split("=")
        }
    }

    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petsList")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                var ownerIdStr = ""+data[i].ownerId;
                if (ownerIdStr === cookieId[1]){
                    data.map((element) => {
                        rowId += 1;
                        table = document.getElementById("table");
                        tableTr = document.createElement("tr");
                        tableTr.setAttribute("id", "row"+rowId);
                        let tdId = document.createElement("td");
                        let tdMicrochip = document.createElement("td")
                        let tdName = document.createElement("td")
                        let tdSpecies = document.createElement("td")
                        let tdRace = document.createElement("td")
                        let tdSize = document.createElement("td")
                        let tdSex = document.createElement("td")
                        let tdPicture = document.createElement("img")
                        tdId.innerHTML = element.petId+"";
                        tdMicrochip.innerHTML = element.microchip;
                        tdName.innerHTML = element.name;
                        tdSpecies.innerHTML = element.species;
                        tdRace.innerHTML = element.race;
                        tdSize.innerHTML = element.size;
                        tdSex.innerHTML = element.sex;
                        tdPicture.setAttribute("src", "")
                        tdPicture.setAttribute("width", "150px");
                        tableTr.appendChild(tdId)
                        tableTr.appendChild(tdMicrochip)
                        tableTr.appendChild(tdName)
                        tableTr.appendChild(tdSpecies)
                        tableTr.appendChild(tdRace)
                        tableTr.appendChild(tdSize)
                        tableTr.appendChild(tdSex)
                        tableTr.appendChild(tdPicture)
                        table.appendChild(tableTr)
                    })
                }
            }
        })
}