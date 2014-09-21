/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function formValidation() {
// Make quick references to our fields.
var name = document.getElementById("name");
var email = document.getElementById("email");
var subject = document.getElementById("subject");
var comments= document.getElementById("comments");
// To check empty form fields.
if (name.value.length == 0) {
document.getElementById("p1").innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
name.focus();
return false;
}
if (email.value.length == 0) {
document.getElementById("p2").innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
email.focus();
return false;
}
if (subject.value.length == 0) {
document.getElementById("p3").innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
subject.focus();
return false;
}
if (comments.value.length == 0) {
document.getElementById("p4").innerText = "* All fields are mandatory *"; // This segment displays the validation rule for all fields
comments.focus();
return false;
}
// Check each input in the order that it appears in the form.
if (inputAlphabet(name, "* For your name please use alphabets only *")) {
if (emailValidation(email, "* Please enter a valid email address *")) {
if (textAlphanumeric(subject, "* For subject please use numbers and letters *")) {

return true;
}

}
}
return false;
}

// Function that checks whether input text is an alphabetic character or not.
function inputAlphabet(inputtext, alertMsg) {
var alphaExp = /^[a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("p1").innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}
// Function that checks whether input text includes alphabetic and numeric characters.
function textAlphanumeric(inputtext, alertMsg) {
var alphaExp = /^[0-9a-zA-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById("p3").innerText = alertMsg; // This segment displays the validation rule for address.
inputtext.focus();
return false;
}
}

// Function that checks whether an user entered valid email address or not and displays alert message on wrong email address format.
function emailValidation(inputtext, alertMsg) {
var emailExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
if (inputtext.value.match(emailExp)) {
return true;
} else {
document.getElementById("p2").innerText = alertMsg; // This segment displays the validation rule for email.
inputtext.focus();
return false;
}
}


