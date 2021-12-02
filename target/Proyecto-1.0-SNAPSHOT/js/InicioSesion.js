let officialJSON = {
    "username":"admin",
    "password":123,
    "email":"admin@hotmail.com",
    "name":"Admin",
    "personId": 1
}
let cokies = document.cookie.split(";")
console.log(cokies)
if (document.cookie.length != 0){
    let cookieRedirect
    for (let i = 0; i < cokies.length; i++){
        let tamano = cokies[i].indexOf("=")
        console.log("Tamaño "+tamano)
        if (tamano === 5){
           cookieRedirect = cokies[i].split("=")
        }
    }
    console.log("Redireccion "+cookieRedirect)
    if (cookieRedirect[1] === "owner"){
        alert("Seras redirigido a tu cuenta porque NO CERRASTE SESIÓN la ultima vez que te fuiste")
        var path = window.location.pathname.split("/");
        var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "owner.html";
        window.location.href = redirect;
    }else if (cookieRedirect[1] === "VET"){
        alert("Seras redirigido a tu cuenta porque NO CERRASTE SESIÓN la ultima vez que te fuiste")
        var path = window.location.pathname.split("/");
        var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
        window.location.href = redirect;
    }else if (cookieRedirect[1] === "official"){
        alert("Seras redirigido a tu cuenta porque NO CERRASTE SESIÓN la ultima vez que te fuiste")
        var path = window.location.pathname.split("/");
        var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "official.html";
        window.location.href = redirect;
    }
}

fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/officials",{
    method:"POST",
    body: JSON.stringify(officialJSON), // enviar el JSON para la API
    headers:{
        'Content-Type': 'application/json'
    }
})
    .then(data => alert("Para ingresar como Funcionario: \nUsuario:admin\nContraseña:123"))

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

    if(roleChoosen === "Rol"){
        var elementP = document.getElementById("MensajeError").innerHTML = "Seleccione su Rol para Iniciar Sesion" ;
    }

    if(roleChoosen === "Owner"){
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/owners/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "owner" || data.role === "propietario")){
                document.cookie = "username=" + userValue;
                document.cookie = "id=" + data.personId;
                document.cookie = "role="+data.role;
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "owner.html";
                window.location.href = redirect;
            }
        }) 
    }
    if(roleChoosen === "Official"){
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/officials/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "official" || data.role === "funcionario")){
                document.cookie = "username=" + userValue;
                document.cookie = "id=" + data.personId;
                document.cookie = "role="+data.role;
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "official.html";
                window.location.href = redirect;
            }else {
                var elementP = document.getElementById("MensajeError").innerHTML = "Usuario o contraseña incorrecta" ;
            }
        })
    }
    if(roleChoosen === "Vet"){
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
        fetch('http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/vets/' + userValue)
        .then(response => response.json())
        .then(data => {
            if(userValue === data.username  && passWordValue === data.password && (data.role === "VET" || data.role === "veterinaria")){
                document.cookie = "username=" + userValue;
                document.cookie = "role="+data.role;
                var path = window.location.pathname.split("/");
                var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "vet.html";
                window.location.href = redirect;
            }
        })
    }
}