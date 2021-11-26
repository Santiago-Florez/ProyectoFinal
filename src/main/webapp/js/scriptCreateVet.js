document.getElementById("registrarVet").onclick = function(){
    let userName = document.getElementById("userVet").value
    let email = document.getElementById("emailVet").value
    let passWord = document.getElementById("passwordVet").value
    let name = document.getElementById("nombreVet").value
    let address = document.getElementById("addressVet").value
    let vecindario = document.getElementById("localidadVet").value

    var vetJSON ={
        "username":document.getElementById("userVet").value,
        "password":document.getElementById("passwordVet").value,
        "email":document.getElementById("emailVet").value,
        "name":document.getElementById("nombreVet").value,
        "address":document.getElementById("addressVet").value,
        "neighborhood":document.getElementById("localidadVet").value
    }

    if(userName === "" || email === "" || passWord === "" || name === "" || address === "" || vecindario === ""){
        var elementP = document.getElementById("MensajeError").innerHTML = "Debe ingresar datos del Usuario para registrarlo" ;
    }else{
        fetch("http://localhost:8080/Taller5-1.0-SNAPSHOT/api/vets",{
            method:"POST",
            body: JSON.stringify(vetJSON), // enviar el JSON para la API
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