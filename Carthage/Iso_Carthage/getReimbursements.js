const url = "http://localhost:7171";
const comparer = (idx, asc) => (a, b) =>
  ((v1, v2) =>
    v1 !== "" && v2 !== "" && !isNaN(v1) && !isNaN(v2)
      ? v1 - v2
      : v1.toString().localeCompare(v2))(
    getCellValue(asc ? a : b, idx),
    getCellValue(asc ? b : a, idx)
  );

const getCellValue = (tr, idx) =>
  tr.children[idx].innerText || tr.children[idx].textContent;

document.getElementById("getallreimbursements").onclick = getEnglishWords;

document.getElementById("homebtn").onclick = TAKEMEHOME;

function TAKEMEHOME() {
  console.log("clicked home button");
  window.location.href = "index.html";
}

async function getEnglishWords() {
  let response = await fetch(url + "/reimbursements");

  //log the response in the console just to see the respons eobject

  console.log(response);

  //control flow on status code

  if (response.status == 200) {
    let data = await response.json(); //translate json and set it equal to data
    //. json is the function that turns our json back into JS
    console.log(data);
    for (let reimb_id of data) {
      // for each english word, do something

      let row = document.createElement("tr");
      let cell = document.createElement("td");

      cell.innerHTML = reimb_id.reimb_id;
      cell.setAttribute("id", "cell1");
      row.appendChild(cell);

      let cell2 = document.createElement("td");

      cell2.innerHTML = reimb_id.reimb_amount;
      row.appendChild(cell2);

      let cell3 = document.createElement("td");
      cell3.innerHTML = reimb_id.reimb_submitted;
      row.appendChild(cell3);
      let cell4 = document.createElement("td");
      cell4.innerHTML = reimb_id.reimb_description;
      row.appendChild(cell4);
      let cell5 = document.createElement("td");
      cell5.innerHTML = reimb_id.reimb_status;
      row.appendChild(cell5);
      let cell6 = document.createElement("td");
      cell6.innerHTML = reimb_id.reimb_author;
      row.appendChild(cell6);
      // let cell7 = document.createElement("td")
      // cell7.innerHTML = reimb_id.reimb_author
      // row.appendChild(cell7)
      // let cell8 = document.createElement("td")

      // cell8.innerHTML = reimb_id.reimb_resolver
      // row.appendChild(cell8)

      // let cell9 = document.createElement("button")
      // cell9.setAttribute("id", "cell9")
      // cell9.innerHTML = "Approve"
      // row.appendChild(cell9)

      // let cell19 = document.createElement("button")
      // cell19.setAttribute("id", "cell19")
      // cell19.innerHTML = "Deny"
      // row.appendChild(cell19)

      console.log(cell);

      // A new row will be appended FOR EVERY EMPLOYEE that got
      document.getElementById("tablebody").appendChild(row);
    }
  } else {
    alert("Something went wrong, make sure your Java is running");
  }

  //     document.getElementById("cell19").onclick = denyReimb
  //     document.getElementById("cell9").onclick = approveReimb

  //  async   function approveReimb (){

  //             let id = document.getElementById("cell1").value
  //             console.log(document.getElementById("cell1")).value
  //         //0 1 2 = pend, approve, deny

  //             let response = await fetch(url + "/reimbursements/" + id, {
  //                 method:"PUT",
  //                 body: "1" //no need to turn this into JSON, it's just one number
  //             })

  //             if(response.status === 202){ //if the update was successful...

  //                 document.createElement("h3").innerHTML("Update Successful")
  //             } else {
  //                 document.createElement("h3").innerHTML("Update Failed")
  //             }
  //     }

  //   async  function denyReimb () {
  // console.log("cell1").value
  //         let id = document.getElementById("cell1").value
  //         console.log(document.getElementById("cell1")).value
  //         //0 1 2 = pend, approve, deny

  //             let response = await fetch(url + "/reimbursements/" + id, {
  //                 method:"PUT",
  //                 body: "2" //no need to turn this into JSON, it's just one number
  //             })

  //             if(response.status === 202){ //if the update was successful...

  //                 document.createElement("h3").innerHTML("Update Successful")
  //             } else {
  //                 document.createElement("h3").innerHTML("failed update, you're fired")
  //             }

  //     }

  document.getElementById("submitReimbUpdate").onclick = updateReimb;

  async function updateReimb() {
    let id = document.getElementById("reimbid").value;
    let status = document.getElementById("newReimbStatus").value;

    //fetch request to update role salary (PUT)
    //it will take the role title as a path param, and it will take the new salary as the body
    let response = await fetch(url + "/reimbursements/" + id, {
      method: "PUT", //send a PUT request (check the endpoint handler in the launcher, it takes a PUT to /roles/:title)
      body: status, //no need to turn this into JSON, it's just one number
    });

    if (response.status === 202) {
      document.getElementById("h1").innerText = "Update Successful";
    } else {
      document.getElementById("h1").innerText = "failed update, you're fired";
    }
  }

  document.querySelectorAll("th").forEach((th) =>
    th.addEventListener("click", () => {
      const table = th.closest("table");
      Array.from(table.querySelectorAll("tr:nth-child(n+2)"))
        .sort(
          comparer(
            Array.from(th.parentNode.children).indexOf(th),
            (this.asc = !this.asc)
          )
        )
        .forEach((tr) => table.appendChild(tr));
    })
  );
}
