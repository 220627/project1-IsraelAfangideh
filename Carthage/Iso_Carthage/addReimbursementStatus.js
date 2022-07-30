const url = "http://localhost:7171"

document.getElementById("submit").onclick = insertReimbursementStatus

async function insertReimbursementStatus() {

  

    let status = document.getElementById("status").value
   

    let statusjson = {
        status: status

    }//remember variables must match Java Object

    console.log(statusjson)

    let response = await fetch(url + "/addstatus",{

        method: "POST",
        body: JSON.stringify(statusjson),
        credentials: "include"
    })

    console.log(response.status)

    if (response.status === 202){
        let data = await response.json()

        document.getElementById("header").innerHTML = data.status + " added."
    } else {
        document.getElementById("header").innerHTML = "Failed to add status, try again"
        document.getElementById("header").style.color = "red"
    }
    window.location.reload
}