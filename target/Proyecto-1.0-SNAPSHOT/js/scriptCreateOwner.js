document.getElementById("registrarOwner").onclick = function(){
    let userName = document.getElementById("userProp").value
    let email = document.getElementById("emailProp").value
    let passWord = document.getElementById("passwordProp").value
    let personId = document.getElementById("idProp").value
    let name = document.getElementById("nombreProp").value
    let address = document.getElementById("addressProp").value
    let vecindario = document.getElementById("localidadProp").value

    var ownerJson ={
        "username":document.getElementById("userProp").value,
        "email":document.getElementById("emailProp").value,
        "password":document.getElementById("passwordProp").value,
        "personId":document.getElementById("idProp").value,
        "name":document.getElementById("nombreProp").value,
        "address":document.getElementById("addressProp").value,
        "neighborhood":document.getElementById("localidadProp").value
    }

    if(userName === "" || email === "" || passWord === "" || personId == null || name === "" || address === "" || vecindario === ""){
        var elementP = document.getElementById("MensajeError").innerHTML = "Debe ingresar datos del Usuario para registrarlo" ;
    }else{
        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/owners",{
            method:"POST",
            body: JSON.stringify(ownerJson), // enviar el JSON para la API
            headers:{
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data)
            window.location.reload;
        })
        var elementP = document.getElementById("MensajeError");
        elementP.innerHTML = "";
    }

    
}