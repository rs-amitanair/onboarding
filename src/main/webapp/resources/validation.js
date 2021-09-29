function test(){
    let pass=document.getElementById("pass").value;
    let conf=document.getElementById("conf").value;
    let mail=document.getElementById("mail").value;
    let egmail= /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    let passw=  /^[A-Za-z]\w{8,10}$/;
    if(!(mail.match(egmail))){
        alert("Invalid email");
        event.preventDefault();
    }
    if(!(pass.match(conf))){
        alert("Passwords do not match!")
        event.preventDefault();
    }else if(!(pass.match(passw))){
        alert("Passwords should between 8 to 10 and must contain" +
            "characters, numeric digits, underscore and first character must be a letter");
        event.preventDefault();
    }
}