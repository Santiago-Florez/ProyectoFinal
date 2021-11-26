
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