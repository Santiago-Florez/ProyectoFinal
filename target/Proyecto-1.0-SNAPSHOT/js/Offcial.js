console.log("GG")
document.getElementById("show-button").onclick = function (){

    let rowLocalidadId = 0
    let tableLocalidad = document.getElementById("tableLocalidad")
    let trLocalidad
    let tdNarino
    let tdBUnidos
    let tdBosa
    let tdBolivar
    let tdChapi
    let tdEngativa
    let tdFonti
    let tdKennedy
    let tdCandelaria
    let tdMartires
    let tdPAranda
    let tdUribe
    let tdSCristobal
    let tdSantaFe
    let tdSuba
    let tdSumapaz
    let tdTeusaquillo
    let tdTunjuelito
    let tdUsaguen
    let tdUsme

    if (tableLocalidad.childElementCount != 0){
        let trs = tableLocalidad.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableLocalidad.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numNarino = 0
    let numUnidos = 0
    let numBosa = 0
    let numBolivar = 0
    let numChapi = 0
    let numEngativa = 0
    let numFonti = 0
    let numKennedy = 0
    let numCandelaria = 0
    let numMartires = 0
    let numPAranda = 0
    let numUribe = 0
    let numSCristobal = 0
    let numSantaFe = 0
    let numSuba = 0
    let numSumapaz = 0
    let numTeusaquillo = 0
    let numTunjuelito = 0
    let numUsaquen = 0
    let numUsme = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/ownerLocalidad/")
        .then(response1 => response1.json())
        .then(data1 => {
            console.log(data1[0].neighborhood)
            for (let i = 0; i < data1.length; i++){
                if (data1[i].neighborhood === "A. Nariño"){
                    numNarino += 1
                }else if (data1[i].neighborhood === "B. UNIDOS"){
                    numUnidos += 1
                }else if (data1[i].neighborhood === "BOSA"){
                    numBosa += 1
                }else if (data1[i].neighborhood === "C. BOLIVAR"){
                    numBolivar += 1
                }else if (data1[i].neighborhood === "CHAPINERO"){
                    numChapi += 1
                }else if (data1[i].neighborhood === "ENGATIVA"){
                    numEngativa += 1
                }else if (data1[i].neighborhood === "FONTIBON"){
                    numFonti += 1
                }else if (data1[i].neighborhood === "KENNEDY"){
                    numKennedy += 1
                }else if (data1[i].neighborhood === "LA CANDELARIA"){
                    numCandelaria += 1
                }else if (data1[i].neighborhood === "LOS MARTIRES"){
                    numMartires += 1
                }else if (data1[i].neighborhood === "P. ARANDA"){
                    numPAranda += 1
                }else if (data1[i].neighborhood === "R. URIBE"){
                    numUribe += 1
                }else if (data1[i].neighborhood === "SAN CRISTOBAL"){
                    numSCristobal += 1
                }else if (data1[i].neighborhood === "SANTA FE"){
                    numSantaFe += 1
                }else if (data1[i].neighborhood === "SUBA"){
                    numSuba += 1
                }else if (data1[i].neighborhood === "SUMAPAZ"){
                    numSumapaz += 1
                }else if (data1[i].neighborhood === "TEUSAQUILLO"){
                    numTeusaquillo += 1
                }else if (data1[i].neighborhood === "TUNJUELITO"){
                    numTunjuelito += 1
                }else if (data1[i].neighborhood === "USAQUEN"){
                    numUsaquen += 1
                }else if (data1[i].neighborhood === "USME"){
                    numUsme += 1
                }
            }
            rowLocalidadId += 1
            trLocalidad = document.createElement("tr")
            trLocalidad.setAttribute("id", "row"+rowLocalidadId)
            tdNarino = document.createElement("td")
            tdBUnidos = document.createElement("td")
            tdBosa = document.createElement("td")
            tdBolivar = document.createElement("td")
            tdChapi = document.createElement("td")
            tdEngativa = document.createElement("td")
            tdFonti = document.createElement("td")
            tdKennedy = document.createElement("td")
            tdCandelaria = document.createElement("td")
            tdMartires = document.createElement("td")
            tdPAranda = document.createElement("td")
            tdUribe = document.createElement("td")
            tdSCristobal = document.createElement("td")
            tdSantaFe = document.createElement("td")
            tdSuba = document.createElement("td")
            tdSumapaz = document.createElement("td")
            tdTeusaquillo = document.createElement("td")
            tdTunjuelito = document.createElement("td")
            tdUsaguen = document.createElement("td")
            tdUsme = document.createElement("td")

            tdNarino.innerHTML = numNarino
            tdBUnidos.innerHTML = numUnidos
            tdBosa.innerHTML = numBosa
            tdBolivar.innerHTML = numBolivar
            tdChapi.innerHTML = numChapi
            tdEngativa.innerHTML = numEngativa
            tdFonti.innerHTML = numFonti
            tdKennedy.innerHTML = numKennedy
            tdCandelaria.innerHTML = numCandelaria
            tdMartires.innerHTML = numMartires
            tdPAranda.innerHTML = numPAranda
            tdUribe.innerHTML = numUribe
            tdSCristobal.innerHTML = numSCristobal
            tdSantaFe.innerHTML = numSantaFe
            tdSuba.innerHTML = numSuba
            tdSumapaz.innerHTML = numSumapaz
            tdTeusaquillo.innerHTML = numTeusaquillo
            tdTunjuelito.innerHTML = numTunjuelito
            tdUsaguen.innerHTML = numUsaquen
            tdUsme.innerHTML = numUsme

            trLocalidad.appendChild(tdNarino)
            trLocalidad.appendChild(tdBUnidos)
            trLocalidad.appendChild(tdBosa)
            trLocalidad.appendChild(tdBolivar)
            trLocalidad.appendChild(tdChapi)
            trLocalidad.appendChild(tdEngativa)
            trLocalidad.appendChild(tdFonti)
            trLocalidad.appendChild(tdKennedy)
            trLocalidad.appendChild(tdCandelaria)
            trLocalidad.appendChild(tdMartires)
            trLocalidad.appendChild(tdPAranda)
            trLocalidad.appendChild(tdUribe)
            trLocalidad.appendChild(tdSCristobal)
            trLocalidad.appendChild(tdSantaFe)
            trLocalidad.appendChild(tdSuba)
            trLocalidad.appendChild(tdSumapaz)
            trLocalidad.appendChild(tdTeusaquillo)
            trLocalidad.appendChild(tdTunjuelito)
            trLocalidad.appendChild(tdUsaguen)
            trLocalidad.appendChild(tdUsme)
            tableLocalidad.appendChild(trLocalidad)
        })

    let rowSpecieId = 0
    let tableSpecie = document.getElementById("tableSpeciePet")
    let trSpecie
    let tdDog
    let tdCat

    if (tableSpecie.childElementCount != 0){
        let trs = tableSpecie.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableSpecie.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numDog = 0
    let numCat = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/petSpecies/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                if (data[i].species === "Perro"){
                    numDog += 1
                }else if(data[i].species === "Gato"){
                    numCat += 1
                }
            }
            rowSpecieId += 1
            trSpecie = document.createElement("tr")
            trSpecie.setAttribute("id", "row"+rowSpecieId)
            tdDog = document.createElement("td")
            tdCat = document.createElement("td")
            tdDog.innerHTML = numDog
            tdCat.innerHTML = numCat
            trSpecie.appendChild(tdDog)
            trSpecie.appendChild(tdCat)
            tableSpecie.appendChild(trSpecie)
        })

    let rowMicrochipId = 0
    let tableMicrochip = document.getElementById("tableMicrochip")
    let trMicrochip
    let tdMicroSi
    let tdMicroNo

    if (tableMicrochip.childElementCount != 0){
        let trs = tableMicrochip.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableMicrochip.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numSi = 0
    let numNo = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/statusMicrochip/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length;i++){
                console.log(data[i].microchip)
                if (data[i].microchip === ""){
                    numNo += 1
                }else if (data[i].microchip !== ""){
                    numSi += 1
                }
            }
            rowMicrochipId += 1
            trMicrochip = document.createElement("tr")
            trMicrochip.setAttribute("id", "row"+rowMicrochipId)
            tdMicroSi = document.createElement("td")
            tdMicroNo = document.createElement("td")
            tdMicroSi.innerHTML = numSi
            tdMicroNo.innerHTML = numNo
            trMicrochip.appendChild(tdMicroSi)
            trMicrochip.appendChild(tdMicroNo)
            tableMicrochip.appendChild(trMicrochip)
        })

    let rowEsterilizacionId = 0
    let tableSterilization = document.getElementById("tableEsterilizacion")
    let trEsterilizacion
    let tdEsteSi
    let tdEsteNo

    if (tableSterilization.childElementCount != 0){
        let trs = tableSterilization.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableSterilization.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numEsterilizacionSi = 0
    let numEsterilizacionNo = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/sterilization/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                if (data[i].type === "esterilizacion"){
                    numEsterilizacionSi += 1
                }else if (data[i].type !== "esterilizacion"){
                    numEsterilizacionNo += 1
                }
            }
            rowEsterilizacionId += 1
            trEsterilizacion = document.createElement("tr")
            trEsterilizacion.setAttribute("id", "row"+rowEsterilizacionId)
            tdEsteSi = document.createElement("td")
            tdEsteNo = document.createElement("td")
            tdEsteSi.innerHTML = numEsterilizacionSi
            tdEsteNo.innerHTML = numEsterilizacionNo
            trEsterilizacion.appendChild(tdEsteSi)
            trEsterilizacion.appendChild(tdEsteNo)
            tableSterilization.appendChild(trEsterilizacion)
        })

    let rowCaseTypeId = 0
    let tableCaseType = document.getElementById("tableCasoPet")
    let trCaseType
    let tdRobo
    let tdPerdida
    let tdFallecimiento

    if (tableCaseType.childElementCount != 0){
        let trs = tableCaseType.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableCaseType.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numRoboTipo = 0
    let numPerdidaTipo = 0
    let numFallecimientoTipo = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/caseType/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                if (data[i].type === "perdida"){
                    numPerdidaTipo += 1
                }else if (data[i].type === "robo"){
                    numRoboTipo += 1
                }else if (data[i].type === "fallecimiento"){
                    numFallecimientoTipo += 1
                }
            }
            rowCaseTypeId += 1
            trCaseType = document.createElement("tr")
            trCaseType.setAttribute("id", "row"+rowCaseTypeId)
            tdRobo = document.createElement("td")
            tdPerdida = document.createElement("td")
            tdFallecimiento = document.createElement("td")
            tdRobo.innerHTML = numRoboTipo
            tdPerdida.innerHTML = numPerdidaTipo
            tdFallecimiento.innerHTML = numFallecimientoTipo
            trCaseType.appendChild(tdPerdida)
            trCaseType.appendChild(tdRobo)
            trCaseType.appendChild(tdFallecimiento)
            tableCaseType.appendChild(trCaseType)
        })

    let rowNameVetId = 0
    let tableNameVet = document.getElementById("tableNameVet")
    let numVetVisit = 0
    let trVetName
    let tdVetName

    if (tableNameVet.childElementCount != 0){
        let trs = tableNameVet.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableNameVet.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let vetName = document.getElementById("nombre-vet").value
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/vetName/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                console.log(data[i].vetId === vetName)
                if (data[i].vetId === vetName){
                    numVetVisit += 1
                }
            }
            rowNameVetId += 1
            trVetName = document.createElement("tr")
            trVetName.setAttribute("id", "row"+rowNameVetId)
            tdVetName = document.createElement("td")
            tdVetName.innerHTML = numVetVisit
            trVetName.appendChild(tdVetName)
            tableNameVet.appendChild(trVetName)
        })

    let rowVisitTypeId = 0
    let tableVisitType = document.getElementById("tableVisitasVet")
    let trVisitType
    let tdEsterilizacion
    let tdMicrochip
    let tdVacunacion
    let tdDesparacitacion
    let tdUrgencia
    let tdControl

    if (tableVisitType.childElementCount != 0){
        let trs = tableVisitType.childElementCount
        for(let i = 1; i <= trs;i++){
            console.log(tableVisitType.childElementCount)
            document.getElementById("row"+i).remove()
        }
    }

    let numEsterilizacionTipo = 0
    let numMicrochipTipo = 0
    let numVacunacionTipo = 0
    let numDesparacitacionTipo = 0
    let numUrgenciaTipo = 0
    let numControlTipo = 0
    fetch("http://localhost:8080/Proyecto-1.0-SNAPSHOT/api/filtersOfficial/visitType/")
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < data.length; i++){
                if (data.type === "esterilizacion"){
                    numEsterilizacionTipo += 1
                }else if(data.type === "microchip"){
                    numMicrochipTipo += 1
                }else if (data.type === "vacunacion"){
                    numVacunacionTipo += 1
                }else if (data.type === "desparasitacion"){
                    numDesparacitacionTipo += 1
                }else if (data.type === "urgencia"){
                    numUrgenciaTipo += 1
                }else if (data.type === "control"){
                    numControlTipo += 1
                }
            }
            rowVisitTypeId += 1
            trVisitType = document.createElement("tr")
            trVisitType.setAttribute("id", "row"+rowVisitTypeId)
            tdEsterilizacion = document.createElement("td")
            tdMicrochip = document.createElement("td")
            tdVacunacion = document.createElement("td")
            tdDesparacitacion = document.createElement("td")
            tdUrgencia = document.createElement("td")
            tdControl = document.createElement("td")
            tdEsterilizacion.innerHTML = numDesparacitacionTipo
            tdMicrochip.innerHTML = numMicrochipTipo
            tdVacunacion.innerHTML = numVacunacionTipo
            tdDesparacitacion.innerHTML = numDesparacitacionTipo
            tdUrgencia.innerHTML = numUrgenciaTipo
            tdControl.innerHTML = numControlTipo
            trVisitType.appendChild(tdEsterilizacion)
            trVisitType.appendChild(tdMicrochip)
            trVisitType.appendChild(tdVacunacion)
            trVisitType.appendChild(tdDesparacitacion)
            trVisitType.appendChild(tdUrgencia)
            trVisitType.appendChild(tdControl)
            tableVisitType.appendChild(trVisitType)
        })
}

document.getElementById("message-Button").onclick = function (){
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "message.html";
    window.location.href = redirect;
}

document.getElementById("back-button").onclick = function (){
    var cookies = document.cookie.split(";")
    for (var i = 0; i < cookies.length; i++){
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substring(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
    var path = window.location.pathname.split("/");
    var redirect = window.location.protocol + "//" + window.location.host + "/" + path[1] + "/" + "index.html";
    window.location.href = redirect;
}