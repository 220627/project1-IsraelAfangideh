const url = "http://localhost:7171"

document.getElementById("submit").onclick = insertReimbursement

async function insertReimbursement() {

  

    let amount = document.getElementById("amount").value
    let timestamp  = document.getElementById("timestamp").value
    let description  = document.getElementById("Description").value
    let Receipt  = document.getElementById("Receipt").value

    

    let reimbjson = {
        reimb_amount: amount,
        reimb_submitted: timestamp,
        reimb_description: description,
        reimb_receipt: Receipt,

    }//remember variables must match Java Object

    console.log(reimbjson)
    console.log(Receipt)

    let response = await fetch(url + "/addreimbursement",{

        method: "POST",
        body: JSON.stringify(reimbjson),
        credentials: "include"
    })

    console.log(response.status)

    if (response.status === 202){
        let data = await response.json()//"Reimbursement for  " + reimbursement.getReimb_description() + " has been submitted and will be reviewed very soon"

        document.getElementById("header").innerHTML = "Reimbursement for  " + data.reimb_description + " has been submitted and will be reviewed very soon"
    } else {
        document.getElementById("header").innerHTML = "Failed to add reimbursement, try again"
        document.getElementById("header").style.color = "red"
    }
}