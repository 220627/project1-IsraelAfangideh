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

document.getElementById("getallreimbursements").onclick = getmyreimbs;
document.getElementById("refresh").onclick = Refresh;
function Refresh () {
  window.location.href = "getmyreimbs.html"
}
async function getmyreimbs() {
  let eid = document.getElementById("employeenumber").value;
  console.log(eid);
  let response = await fetch(url + "/reimbursementsbyauthor/" + eid);

  // .then((result) => {
  //   return result.json();
  // })
  // .then((result) => {
  //   console.log(result);
  // });

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
      // let cell7 = document.createElement("td")
      // cell7.innerHTML = reimb_id.reimb_author
      // row.appendChild(cell7)
      // let cell8 = document.createElement("td")

      // cell8.innerHTML = reimb_id.reimb_resolver
      // row.appendChild(cell8)

      // A new row will be appended FOR EVERY EMPLOYEE that got
      document.getElementById("tablebody").appendChild(row);
    }
  } else {
    alert("Something went wrong, try again");
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
