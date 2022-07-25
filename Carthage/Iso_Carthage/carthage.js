const url = "http://localhost:7171"

document.getElementById("submit").onclick = insertEmployee

async function insertEmployee() {

  

    let username = document.getElementById("username").value
    let password  = document.getElementById("password").value
    let First_Name  = document.getElementById("First Name").value
    let Last_Name  = document.getElementById("Last Name").value
    let email  = document.getElementById("email").value
    let role  = document.getElementById("Employee_role").value
    let notes = document.getElementById("admin_notes").value

    let employeejson = {
        username: username,
        password: password,
        first_name: First_Name,
        last_name: Last_Name,
        email: email,
        employee_role: role,
        admin_notes: notes 

    }//remember variables must match Java Object

    console.log(employeejson)

    let response = await fetch(url + "/register",{

        method: "POST",
        body: JSON.stringify(employeejson),
        credentials: "include"
    })

    console.log(response.status)

    if (response.status === 202){
        let data = await response.json()

        document.getElementById("header").innerHTML = data.first_name + data.last_name + " added."
    } else {
        document.getElementById("header").innerHTML = "Failed to add employee, try again"
        document.getElementById("header").style.color = "red"
    }
}