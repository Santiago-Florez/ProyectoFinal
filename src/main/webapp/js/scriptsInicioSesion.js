document.getElementById("registrar-button").onclick = function () {
    var roleChoosen = document.getElementById("roleReg").value;
    console.log(roleChoosen);
    if(roleChoosen === "Rol"){
        var elementP = document.getElementById("MensajeError").innerHTML = "Debe seleccionar un Rol de Usuario para registrarlo" ;
    }

    if(roleChoosen === "Owner"){
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
        var path = window.location.pathname.split("/");
        var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "createdOwner.html";
        window.location.href = redirect;
    }else if(roleChoosen === "Vet"){
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
        var path = window.location.pathname.split("/");
        var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "createVet.html";
        window.location.href = redirect;
    }
}

document.getElementById("inicia-button").onclick = function(){
    var userValue = document.getElementById("username").value;
    var passWordValue = document.getElementById("password").value;
    var roleChoosen = document.getElementById("roleReg").value;
    console.log(roleChoosen)
    if(roleChoosen === "Owner"){
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/owners/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "owner" || data.role === "propietario")){
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "owner.html";
                window.location.href = redirect;
            }
        }) 
    }
    if(roleChoosen === "Official"){
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/officials/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "official" || data.role === "funcionario")){
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "official.html";
                window.location.href = redirect;
            }
        })
    }
    if(roleChoosen === "Vet"){
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "VET" || data.role === "veterinaria")){
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                window.location.href = redirect;
            }
        })
    }
}