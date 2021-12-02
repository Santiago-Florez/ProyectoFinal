console.log("GG")
document.getElementById("neighborhood-user").onclick = function (){
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/ownerLocalidad/")
}

document.getElementById("message-Button").onclick = function (){
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "message.html";
    window.location.href = redirect;
}