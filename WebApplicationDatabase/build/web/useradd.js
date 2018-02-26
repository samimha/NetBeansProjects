/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function (event) {
    showUsers();
    //--------Show Users--------//
    function showUsers() {
        const output = document.querySelector("p");
        output.innerHTML = "Fetching JSON data...";
        const getAll = "http://localhost:8080/WebApplicationDatabase/model/generic/all";
        const processJSON = (function (json) {
            let = itemStr = "";
            for (let item of json) {
                itemStr += `<p>id:${item.id} name: ${item.firstName}  ${item.lastName}</p>`;
            }
            ;
            output.innerHTML = "Users: " + itemStr;
        });
        fetch(getAll)
                .then(response => response.json())    //Returns a promise that resolves JSON object
                .then(processJSON)
                .catch(error => (output.textContent = "Fetch crashed due to " + error));
    }
    
    //-----Delete user-------//
    const url = "http://localhost:8080/WebApplicationDatabase/model/generic/del";
    const deleteBtn = document.querySelector("#delete-button");
    deleteBtn.addEventListener("click", function () {
        const id = document.querySelector("#id").value;
        let delUrl = url + "?id=" + id;
        return fetch(delUrl, {
            method: 'delete'
        })
                .then(showUsers);
    });
    //---------Add user-------//
    const addUrl = "http://localhost:8080/WebApplicationDatabase/model/generic/insert";
    const submitBtn = document.querySelector("#submit-button");
    submitBtn.addEventListener("click", function () {
        const fname = document.querySelector("#firstName").value;
        const lname = document.querySelector("#lastName").value;
        let data = {
            lastName: lname,
            firstName: fname
        };
        //alert(data.lastName);
        return fetch(addUrl, {
            headers: {'content-type': 'application/json'},
            body: JSON.stringify(data),
            method: 'post'
        })
                .then(showUsers);
    });
    //------Update user-------//
    const updateUrl = "http://localhost:8080/WebApplicationDatabase/model/generic/update";
    const editBtn = document.querySelector("#edit-button");
    editBtn.addEventListener("click", function () {
        const editid = document.querySelector("#edit-id").value;
        const editFname = document.querySelector("#edit-firstName").value;
        const editLname = document.querySelector("#edit-lastName").value;
        let data = {
            id: editid,
            firstName: editFname,
            lastName: editLname
        };
        
        return fetch(updateUrl, {
            headers: {'content-type': 'application/json'},
            body: JSON.stringify(data),
            method: 'put'
        })
                .then(showUsers);
    });
    //----------Find by Id----------//
    const byIdurl = "http://localhost:8080/WebApplicationDatabase/model/generic/byid";
    const byIdBtn = document.querySelector("#by-id-button");
    const outputId = document.querySelector("h3");

    byIdBtn.addEventListener("click", function () {
        const byId = document.querySelector("#by-id").value;
        let findUrl = byIdurl + "?id=" + byId;
        
        const processJSON = (function (json) {
            let itemStr = `<p>id:${json.id} name: ${json.firstName}  ${json.lastName}</p>`;

            outputId.innerHTML = "User: " + itemStr;
        });
        fetch(findUrl)
                .then(response => response.json())    //Returns a promise that resolves JSON object
                .then(processJSON)
                .catch(error => (outputId.textContent = "Fetch crashed due to " + error));
    });

});

