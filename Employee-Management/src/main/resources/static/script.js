const API_URL = "http://localhost:8080/employees";

// CREATE
function saveEmployee() {
    const employee = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        clearForm();
        getEmployees();
    });
}

// READ
function getEmployees() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("employeeList");
            list.innerHTML = "";

            data.forEach(emp => {
                const li = document.createElement("li");
                li.innerHTML = `
                    ${emp.name} - ${emp.email} - ${emp.phone}
                    <button onclick="editEmployee(${emp.id})">Edit</button>
                    <button onclick="deleteEmployee(${emp.id})">Delete</button>
                `;
                list.appendChild(li);
            });
        });
}

// DELETE
function deleteEmployee(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        getEmployees();
    });
}

// LOAD DATA INTO FORM (for update)
function editEmployee(id) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(emp => {
            document.getElementById("empId").value = emp.id;
            document.getElementById("name").value = emp.name;
            document.getElementById("email").value = emp.email;
            document.getElementById("phone").value = emp.phone;
        });
}

// UPDATE
function updateEmployee() {
    const id = document.getElementById("empId").value;

    const employee = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value
    };

    fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        clearForm();
        getEmployees();
    });
}

// CLEAR FORM
function clearForm() {
    document.getElementById("empId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
}
