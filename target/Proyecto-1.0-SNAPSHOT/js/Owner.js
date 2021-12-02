console.log(document.cookie)
document.getElementById("petsave-button").onclick = function(){
    var pet_Id = document.getElementById("petId-Owner").value;
    var microchip = document.getElementById("microchipPet-Owner").value;
    var petName = document.getElementById("petName-Owner").value;
    var img = document.getElementById("imgMascota-Owner").value;
    var race = document.getElementById("racePet-Owner").value;
    var species = document.getElementById("especie1Pet-Owner").value;
    var sex = document.getElementById("sexPet-Owner").value;
    var size = document.getElementById("tamañoPet-Owner").value;
    var ownerId = document.getElementById("ownerId-Owner").value;

    var petJSON = {
        "petId": pet_Id,
        "microchip": microchip,
        "name": petName,
        "species": species,
        "race": race,
        "size": size,
        "sex": sex,
        "picture": img+"",
        "ownerId": ownerId
    }

    if(pet_Id === "" || ownerId === "" || petName === "" || img === "" || race === "" || species === "" || sex === "" || size === ""){
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
    var cookies = document.cookie.split(";")
    for (var i = 0; i < cookies.length; i++){
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substring(0, eqPos) : cookie;
    }

    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "index.html";
    window.location.href = redirect;
}


document.getElementById("show-button").onclick = function (){
    var rowId = 0;
    var table = document.getElementById("table");
    var tableTr;
    var cookies = document.cookie.split(";")
    var cookieId
    for (let i = 0; i < cookies.length; i++){
        if (cookies[i].length == 5 || cookies[i].length == 4){
            cookieId = cookies[i].split("=")
        }
    }

    if (table.childElementCount !== 0){
        let trs = table.childElementCount
        for(let i = 1; i <= trs;i++){
            document.getElementById("row"+i).remove()
        }
    }

    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petsList")
        .then(response => response.json())
        .then(data => {
            data.map((element) => {
                rowId += 1;
                table = document.getElementById("table");
                tableTr = document.createElement("tr");
                tableTr.setAttribute("id", "row"+rowId);
                let tdMicrochip = document.createElement("td")
                let tdName = document.createElement("td")
                let tdSpecies = document.createElement("td")
                let tdRace = document.createElement("td")
                let tdSize = document.createElement("td")
                let tdSex = document.createElement("td")
                let tdPicture = document.createElement("img")
                if(element.ownerId == +cookieId[1]){
                    tdMicrochip.innerHTML = element.microchip;
                    tdName.innerHTML = element.name;
                    tdSpecies.innerHTML = element.species;
                    tdRace.innerHTML = element.race;
                    tdSize.innerHTML = element.size;
                    tdSex.innerHTML = element.sex;
                    var img = element.picture.substring(12)
                    tdPicture.setAttribute("src", "./imgsPets/"+ img)
                    tdPicture.setAttribute("width", "150px");
                    tableTr.appendChild(tdMicrochip)
                    tableTr.appendChild(tdName)
                    tableTr.appendChild(tdSpecies)
                    tableTr.appendChild(tdRace)
                    tableTr.appendChild(tdSize)
                    tableTr.appendChild(tdSex)
                    tableTr.appendChild(tdPicture)
                    table.appendChild(tableTr)
                }
            })
        })
}

document.getElementById("edit-button").onclick = function (){
    let modal = document.getElementById("myModal");
    modal.className ="modal fade show";
    document.getElementById("actualizarOwner").onclick = function (){
        let newAddress = document.getElementById("newaddressOwner").value
        let newNeighborhood = document.getElementById("newlocalidadOwner").value
        var cookies = document.cookie.split("; ")
        console.log(cookies)
        var cookieusername
        cookieusername = cookies[0].split("=")
        if (newAddress === "" && newNeighborhood === ""){
            modal.className ="modal fade";
        }else if(newAddress != "" && newNeighborhood === ""){
            var passwordConfirm = prompt("Escriba su contraseña para Confirmar la Actualización")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/owners/"+cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let password = passwordConfirm;
                    let address = document.getElementById("newaddressOwner").value;
                    if (data.password === password){
                        let ownerJSON = {
                            "username": username,
                            "email": data.email,
                            "password": password,
                            "personId":data.personId,
                            "name": data.name,
                            "address": address,
                            "neighborhood": data.neighborhood
                        };
                        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/owners/owner/address",{
                            method:"PUT",
                            body: JSON.stringify(ownerJSON), // enviar el JSON para la API
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
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/owners/"+cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let password = passwordConfirm;
                    let localidad = document.getElementById("newlocalidadOwner").value;
                    if (data.password === password){
                        let ownerJSON = {
                            "username": username,
                            "email": data.email,
                            "password": password,
                            "personId":data.personId,
                            "name": data.name,
                            "address": data.address,
                            "neighborhood": localidad
                        };
                        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/owners/owner/neighborhood",{
                            method:"PUT",
                            body: JSON.stringify(ownerJSON), // enviar el JSON para la API
                            headers:{
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(data =>{
                                alert("Se actualizo la Dirección")
                            })
                    }
                })
        }

    }
}

document.getElementById("editImg-button").onclick = function (){
    let modal = document.getElementById("imgModal");
    modal.className ="modal fade show";
    document.getElementById("guardarImagen").onclick = function (){

        let newImg = document.getElementById("newImgPet").value
        let petId = document.getElementById("idPet").value
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petsList")
                .then(response => response.json())
                .then(data => {
                    console.log(+petId)
                    for (let i = 0; i < data.length; i++) {
                        console.log(data[i])
                        console.log(+petId === data[i].pet_id)
                        if (+petId === data[i].pet_id) {
                            alert("GG")
                            var newPetJSON = {
                                "petId": data[i].pet_id,
                                "microchip": data[i].microchip,
                                "name": data[i].name,
                                "species": data[i].species,
                                "race": data[i].race,
                                "size": data[i].size,
                                "sex": data[i].sex,
                                "picture": newImg,
                                "ownerId": data[i].ownerId
                            }
                            fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/pets/pet/picture", {
                                method: "PUT",
                                body: JSON.stringify(newPetJSON), // enviar el JSON para la API
                                headers: {
                                    'Content-Type': 'application/json'
                                }
                            }).then(data =>{
                                alert("Presione el Boton 'Actualizar' para realizar los Cambios")
                                document.getElementById("actualizarImgPet").disabled = false;
                            })
                        }
                    }
                })
    }
}

document.getElementById("message-button").onclick = function (){
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "message.html";
    window.location.href = redirect;
}

document.getElementById("savePetCase").onclick = function () {
    let caseId = document.getElementById("caseId").value
    let createdAt = document.getElementById("fechaCracionCaso").value
    let typeCase = document.getElementById("tipoDeCaso").value
    let descriptionCase = document.getElementById("descripcionCaso").value
    let petId = document.getElementById("idMascotaCaso").value
    let petCaseJSON={
        "caseId":caseId,
        "createdAt":createdAt,
        "type":typeCase,
        "description":descriptionCase,
        "petId":petId
    }
    if (caseId === "" || createdAt === "" || typeCase === "" || descriptionCase === "" || petId === ""){
        let elementP = document.getElementById("MensajeErrorCase").innerHTML = "Debe ingresar datos del Usuario para registrarlo" ;
    }else{
        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petcase",{
            method:"POST",
            body: JSON.stringify(petCaseJSON), // enviar el JSON para la API
            headers:{
                'Content-Type': 'application/json'
            }
        }).then(data =>{
            alert("Se creo el Caso de su Mascota")
        })
        let elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
    }
}

document.getElementById("verHistoriaC").onclick = function (){
    var rowId = 0;
    let table =document.getElementById("tableVisits")
    let tableTr
    let tdVisitId
    let tdCreatedAt
    let tdType
    let tdDescription
    let tdPetId
    let tdVetId
    let namePet = document.getElementById("namePet").value
    let cookies = document.cookie.split(";")
    let cookieId
    for (let i = 0; i < cookies.length; i++){
        if (cookies[i].length == 5 || cookies[i].length == 4){
            cookieId = cookies[i].split("=")
        }
    }
    if (table.childElementCount !== 0) {
        console.log("here")
        let trs = table.childElementCount
        for (let i = 1; i <= trs; i++) {
            console.log(table.childElementCount)
            document.getElementById("row" + i).remove()
        }
    }
    console.log(table.childElementCount)

    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/petsList")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            for (let k = 0; k < data.length; k++) {
                    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/visitsList")
                        .then(response => response.json())
                        .then(datos => {
                            for (let i = 0; i < datos.length; i++) {
                                if (datos[i].petId === +namePet && data[k].ownerId === +cookieId[1]) {
                                    rowId += 1;
                                    table = document.getElementById("tableVisits");
                                    tableTr = document.createElement("tr");
                                    tableTr.setAttribute("id", "row" + rowId);
                                    tdVisitId = document.createElement("td")
                                    tdCreatedAt = document.createElement("td")
                                    tdType = document.createElement("td")
                                    tdDescription = document.createElement("td")
                                    tdPetId = document.createElement("td")
                                    tdVetId = document.createElement("td")
                                    tdVisitId.innerHTML = datos[i].visitId;
                                    tdCreatedAt.innerHTML = datos[i].createdAt;
                                    tdType.innerHTML = datos[i].type;
                                    tdDescription.innerHTML = datos[i].description;
                                    tdPetId.innerHTML = datos[i].petId;
                                    tdVetId.innerHTML = datos[i].vetId;
                                    tableTr.appendChild(tdVisitId)
                                    tableTr.appendChild(tdCreatedAt)
                                    tableTr.appendChild(tdType)
                                    tableTr.appendChild(tdDescription)
                                    tableTr.appendChild(tdPetId)
                                    tableTr.appendChild(tdVetId)
                                    table.appendChild(tableTr)
                                }else{
                                    continue
                                }
                            }
                        })

            }
        })
}