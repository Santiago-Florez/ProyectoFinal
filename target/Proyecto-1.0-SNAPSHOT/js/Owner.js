
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
        fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/pets",{
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
    var rowId = 0;
    var table;
    var tableTr;
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
        console.log("Datos " + data)
        console.log(cookieId)
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
            console.log("Owner Id " + element.ownerId)
            if(element.ownerId == +cookieId[1]){
                tdMicrochip.innerHTML = element.microchip;
                tdName.innerHTML = element.name;
                tdSpecies.innerHTML = element.species;
                tdRace.innerHTML = element.race;
                tdSize.innerHTML = element.size;
                tdSex.innerHTML = element.sex;
                var img = element.picture.substring(12)
                console.log("Img " + img)
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
        var cookiename
        var cookierole
        var cookieemail
        cookieusername = cookies[0].split("=")
        cookiename = cookies[1].split("=")
        cookierole= cookies[2].split("=")
        cookieemail = cookies[3].split("=")
        if (newAddress === "" && newNeighborhood === ""){
            modal.className ="modal fade";
        }else if(newAddress != "" && newNeighborhood === ""){
            var passwordConfirm = prompt("Escriba su contraseña para Confirmar la Actualización")
            fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/"+cookieusername[1])
                .then(response => response.json())
                .then(data => {
                    let username = cookieusername[1];
                    let password = passwordConfirm;
                    let email = cookieemail[1];
                    let name = cookiename[1];
                    let address = document.getElementById("newaddressOwner").value;
                    let localidad = data.neighborhood;
                    if (data.password === password){
                        let vetJSON = {
                            "username": username,
                            "password": password,
                            "email": email,
                            "name": name,
                            "address": address,
                            "neighborhood": localidad
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
                    let email = cookieemail[1];
                    let name = cookiename[1];
                    let address = data.address;
                    let localidad = document.getElementById("newlocalidadOwner").value;
                    if (data.password === password){
                        let vetJSON = {
                            "username": username,
                            "password": password,
                            "email": email,
                            "name": name,
                            "address": address,
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
                                alert("Se actualizo la Dirección")
                            })
                    }
                })
        }

    }
}