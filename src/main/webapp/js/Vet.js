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
        //Aqui va para comprobar el tipo
        //if (typeVisit === "microchip"){
            //fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList/1")
              //  .then(response => response.json())
              //  .then(data => console.log(data))
        //}
        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits/", {
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
    document.getElementById("filtroVisit").disable = false;
}

document.getElementById("volver-button").onclick = function (){
    var cookies = document.cookie.split(";")
    for (var i = 0; i < cookies.length; i++){
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substring(0, eqPos) : cookie;
    }
    var ruta = window.location.pathname.split("/");
    var ir = window.location.protocol + "//" + window.location.host + "/" + ruta[1] + "/" + "index.html";
    window.location.href = ir;
}

document.getElementById("showVisits-button").onclick = function (){

    var rowId = 0;
    var table;
    var tableTr;
    console.log(document.cookie)
    var cookies = document.cookie.split(";")
    var cookieId
    for (let i = 0; i < cookies.length; i++){
        if (cookies[i].length == 11 || cookies[i].length == 10){
            cookieId = cookies[i].split("=")
        }
    }

    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            console.log(cookieId)
            data.map((element) => {
                rowId += 1;
                table = document.getElementById("table");
                tableTr = document.createElement("tr");
                tableTr.setAttribute("id", "row"+rowId);
                let tdVisitId = document.createElement("td")
                let tdCreatedAt = document.createElement("td")
                let tdType = document.createElement("td")
                let tdDescription = document.createElement("td")
                let tdPetId = document.createElement("td")
                let tdVetId = document.createElement("td")
                console.log(element.vetId)
                if(element.vetId == cookieId[1]){
                    tdVisitId.innerHTML = element.visitId;
                    tdCreatedAt.innerHTML = element.createdAt;
                    tdType.innerHTML = element.type;
                    tdDescription.innerHTML = element.description;
                    tdPetId.innerHTML = element.petId;
                    tdVetId.innerHTML = element.vetId;
                    tableTr.appendChild(tdVisitId)
                    tableTr.appendChild(tdCreatedAt)
                    tableTr.appendChild(tdType)
                    tableTr.appendChild(tdDescription)
                    tableTr.appendChild(tdPetId)
                    tableTr.appendChild(tdVetId)
                    table.appendChild(tableTr)
                }
            })
        })
}

document.getElementById("edit-button").onclick = function (){
    let modal = document.getElementById("myModal");
    modal.className ="modal fade show";
    document.getElementById("actualizarVet").onclick = function (){
        let newAddress = document.getElementById("newaddressVet").value
        let newNeighborhood = document.getElementById("newlocalidadVet").value
        var cookies = document.cookie.split("; ")
        console.log(cookies)
        var cookieusername
        cookieusername = cookies[1].split("=")
        console.log(cookieusername)
        if (newAddress === "" && newNeighborhood === ""){
            modal.className ="modal fade";
        }else if(newAddress != "" && newNeighborhood === ""){
            var passwordConfirm = prompt("Escriba su contraseña para Confirmar la Actualización")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/"+cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let address = document.getElementById("newaddressVet").value;
                    if (data.password === passwordConfirm){
                        let vetJSON = {
                            "username": username,
                            "password": data.password,
                            "email": data.email,
                            "name": data.name,
                            "address": address,
                            "neighborhood": data.neighborhood
                        };
                        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/vets/vet/address",{
                            method:"PUT",
                            body: JSON.stringify(vetJSON), // enviar el JSON para la API
                            headers:{
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(data =>{
                                alert("Se actualizo la Dirección")
                            })
                    }
                })
        }else if (newAddress === "" && newNeighborhood != ""){
            var passwordConfirm = prompt("Escriba su contraseña para Confirmar la Actualización")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/"+cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let password = passwordConfirm;
                    let localidad = document.getElementById("newlocalidadVet").value;
                    if (data.password === password){
                        let vetJSON = {
                            "username": username,
                            "password": password,
                            "email": data.email,
                            "name": data.name,
                            "address": data.address,
                            "neighborhood": localidad
                        };
                        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/vets/vet/neighborhood",{
                            method:"PUT",
                            body: JSON.stringify(vetJSON), // enviar el JSON para la API
                            headers:{
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(data =>{
                                alert("Se actualizo la Localidad")
                            })
                    }
                })
        }else if (newAddress != "" && newNeighborhood != "") {
            var passwordConfirm = prompt("Escriba su contraseña para Confirmar la Actualización")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/" + cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let address = document.getElementById("newaddressVet").value;
                    let localidad = document.getElementById("newlocalidadVet").value;
                    if (data.password === passwordConfirm) {
                        let vetJSON = {
                            "username": username,
                            "password": data.password,
                            "email": data.email,
                            "name": data.name,
                            "address": address,
                            "neighborhood": localidad
                        };
                        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/vet/address/neighborhood", {
                            method: "PUT",
                            body: JSON.stringify(vetJSON), // enviar el JSON para la API
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(data => {
                                alert("Se actualizo la Dirección y la Localidad")
                            })
                    }
                })
        }
    }
}