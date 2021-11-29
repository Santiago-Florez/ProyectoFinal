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

document.getElementById("volver-button").onclick = function (){
    var ruta = window.location.pathname.split("/");
    var ir = window.location.protocol + "//" + window.location.host + "/" + ruta[1] + "/" + "index.html";
    window.location.href = ir;
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
                    let address = document.getElementById("newaddressVet").value;
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
                    let localidad = document.getElementById("newlocalidadVet").value;
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