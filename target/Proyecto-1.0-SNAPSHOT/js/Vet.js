
document.getElementById("visitsave-button").onclick = function (){

    let visitId = document.getElementById("idVisit").value;
    let typeVisit = document.getElementById("typeVisitVet").value;
    let createdAt = document.getElementById("fechaVisit").value;
    let vetId = document.getElementById("idVet-Visit").value;
    let petId = document.getElementById("idPet-Visit").value;
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
        let elementP = document.getElementById("MensajeError").innerHTML = "Debe ingresar datos de la Visita para registrarla";
    }else{
        if (typeVisit === "microchip"){
            let newMicrochip = document.getElementById("newMicroShip")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petsList")
                .then(response => response.json())
                .then(data => {
                    data.map((element) =>{
                        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/visits/visit/microchip/"+newMicrochip.value,{
                            method:"PUT",
                            body: JSON.stringify(visitJSON), // enviar el JSON para la API
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(data => {
                                alert("Se Guardo El Microchip")
                            })
                    })
                })
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits/", {
                method: "POST",
                body: JSON.stringify(visitJSON), // enviar el JSON para la API
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    alert("Visita Creada Exitosamente!")
                    var path = window.location.pathname.split("/");
                    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                    window.location.href = redirect;
                })
        }else if (typeVisit === "esterilizacion"){
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList")
                .then(response => response.json())
                .then(data =>{
                    console.log(Object.keys(data).length === 0)
                    if (Object.keys(data).length === 0){
                        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits/", {
                            method: "POST",
                            body: JSON.stringify(visitJSON), // enviar el JSON para la API
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(response => response.json())
                            .then(data => {
                                alert("Visita Creada Exitosamente!")
                                var path = window.location.pathname.split("/");
                                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                                window.location.href = redirect;
                            })
                    }else{
                        let datosDiferentes
                        let datosIguales
                        for (let i = 0; i < data.length; i++){
                            console.log("data "+data[i].type)
                            datosDiferentes = 0
                            datosIguales = 0
                            if (data[i].type === typeVisit && data[i].petId === +petId){
                                console.log("GG")
                                datosIguales += 1
                            }else if(data[i].type !== typeVisit && data[i].petId === +petId){
                                datosDiferentes += 1
                            }
                        }
                        if (datosIguales === 0){
                            console.log("else if")
                            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits/", {
                                method: "POST",
                                body: JSON.stringify(visitJSON), // enviar el JSON para la API
                                headers: {
                                    'Content-Type': 'application/json'
                                }
                            })
                                .then(response => response.json())
                                .then(data => {
                                    alert("Visita Creada Exitosamente!")
                                    var path = window.location.pathname.split("/");
                                    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                                    window.location.href = redirect;
                                })
                        }else{
                            alert("La mascota ya fue esterilizada")
                            var path = window.location.pathname.split("/");
                            var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                            window.location.href = redirect;
                        }
                    }
                })
        }else{
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visits/", {
                method: "POST",
                body: JSON.stringify(visitJSON), // enviar el JSON para la API
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    alert("Visita Creada!")
                    var path = window.location.pathname.split("/");
                    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                    window.location.href = redirect;
                })
        }
    }
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
    var table =document.getElementById("table")
    let tableTr
    let tdVisitId
    let tdCreatedAt
    let tdType
    let tdDescription
    let tdPetId
    let tdVetId
    var cookies = document.cookie.split(";")
    let userCookie
    if (cookies.length === 3){
        userCookie = cookies[1].length
    }else {
        userCookie = cookies[0].length
    }
    var cookieId
    for (let i = 0; i < cookies.length; i++){
        if (cookies[i].length == userCookie){
            cookieId = cookies[i].split("=")
        }
    }

    if (table.childElementCount != 0){
        let trs = table.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(table.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList")
        .then(response => response.json())
        .then(data => {
            data.map((element) => {
                console.log(cookieId[1])
                rowId += 1;
                table = document.getElementById("table");
                tableTr = document.createElement("tr");
                tableTr.setAttribute("id", "row"+rowId);
                tdVisitId = document.createElement("td")
                tdCreatedAt = document.createElement("td")
                tdType = document.createElement("td")
                tdDescription = document.createElement("td")
                tdPetId = document.createElement("td")
                tdVetId = document.createElement("td")
                if(element.vetId === cookieId[1]){
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

                    var textFiltro = document.getElementById("filtroVisit")
                    textFiltro.disabled = false;
                    var botonFiltro = document.getElementById("filter")
                    botonFiltro.disabled = false;
                    if (!textFiltro.disabled){
                        botonFiltro.onmouseenter = function (){
                            let mensajefiltro = document.getElementById("mensajeFiltro").innerHTML = "Click Dos veces para aplicar filtro"
                        }
                        botonFiltro.onmouseleave = function (){
                            let mensajefiltro = document.getElementById("mensajeFiltro").innerHTML = ""
                        }
                    }
                    botonFiltro.onclick = function (){
                        rowId = 0;
                        if (textFiltro.value != ""){
                            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList/visitNamePet/"+textFiltro.value)
                                .then(response => response.json())
                                .then(data => {
                                    if (table.childElementCount != 0){
                                        let trs = table.childElementCount
                                        for(let i = 1; i <= trs;i++){
                                            console.log(table.childElementCount)
                                            document.getElementById("row"+i).remove()
                                        }
                                    }else if (table.childElementCount == 0){
                                        data.map((element) => {
                                            if(element.vetId === cookieId[1]) {
                                                rowId += 1;
                                                table = document.getElementById("table");
                                                tableTr = document.createElement("tr");
                                                tableTr.setAttribute("id", "row"+rowId);
                                                tdVisitId = document.createElement("td")
                                                tdCreatedAt = document.createElement("td")
                                                tdType = document.createElement("td")
                                                tdDescription = document.createElement("td")
                                                tdPetId = document.createElement("td")
                                                tdVetId = document.createElement("td")
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
                                    }
                                })
                        }
                    }
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

document.getElementById("messages-button").onclick = function (){
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "message.html";
    window.location.href = redirect;
}