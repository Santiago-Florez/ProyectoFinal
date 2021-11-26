document.getElementById("registrarOwner").onclick = function(){
    var ownerJson ={
        "username":document.getElementById("userProp").value,
        "email":document.getElementById("emailProp").value,
        "password":document.getElementById("passwordProp").value,
        "personId":document.getElementById("idProp").value,
        "name":document.getElementById("nombreProp").value,
        "address":document.getElementById("addressProp"),
        "neighborhood":document.getElementById("localidadProp").value
    }
}