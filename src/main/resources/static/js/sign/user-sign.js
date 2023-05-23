function idOnChange(){

    let spanId = document.getElementById('span_id');
    spanId.style.color = 'red';
    spanId.innerHTML = "아이디 중복확인 해주세요.";
    alert("아이디 중복확인 해주세요.");
}

function idCheck(){

    let inputId = document.getElementById('input_id');
    let inputIdValue = inputId.value;
    let spanId = document.getElementById('span_id');
    let inputNik = document.getElementById('input_nik');

    let requestData = { userId : inputIdValue };

    if(inputIdValue == ''){

        alert("아이디를 입력해주세요.");
        inputId.focus();
    }

    fetch("/sign/checkUserId" ,{

        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body : JSON.stringify(requestData)
    })
        .then(response => response.json())
        .then(data => {
            if(data == false){

                alert("아이디가 중복됩니다.");
            } else if(data == true){

                alert("확인 완료 되었습니다.");

                spanId.style.color = 'green';
                spanId.innerHTML = "중복확인완료";
                inputNik.focus();
            }
        })
}

function nikOnChange(){

    let spanNik = document.getElementById("span_nik");
    let inputNik = document.getElementById("input_nik");
    let inputNikValue = inputNik.value;
    let regex = /^[가-힣a-zA-Z0-9]{2,10}$/;

    if(inputNikValue == ''){

        spanNik.style.color = 'red';
        spanNik.innerHTML = '닉네임을 입력해주세요.';
        inputNik.focus();
    }

    if(regex.test(inputNikValue)){

        alert("닉네임 중복확인 해주세요.");
        spanNik.style.color = 'red';
        spanNik.innerHTML = '닉네임 중복확인 해주세요.';
    } else {

        alert("닉네임 형식이 일치하지 않습니다.");
        spanNik.style.color = 'red';
        spanNik.innerHTML = '닉네임 형식에 맞지 않습니다.';
        inputNik.focus();
    }
}

function nikCheck(){

    let inputNik = document.getElementById("input_nik");
    let inputNikValue = inputNik.value;
    let spanNik = document.getElementById("span_nik");
    let inputPwd = document.getElementById('input_pwd');

    if(inputNikValue == ''){

        alert("닉네임을 입력해주세요.");
        inputNik.focus();
    }

    let requestData = { userNik : inputNikValue };

    fetch("/sign/checkUserNik",{

        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(requestData)
    })
        .then(response => response.json())
        .then(data => {
            if(data == false){
                alert("닉네임이 중복 됩니다.")
            } else if(data == true){

                alert("확인완료 되었습니다.");

                spanNik.style.color = 'green';
                spanNik.innerHTML = "중복확인완료.";
                inputPwd.focus();
            }
        })
}

function pwdOnChange(){

    let inputPwd = document.getElementById('input_pwd');
    let inputPwdValue = inputPwd.value;
    let spanPwd = document.getElementById('span_pwd');
    let inputCkPwd = document.getElementById('input_checkPwd');
    let inputCkValue = inputCkPwd.value;
    let spanCkPwd = document.getElementById('span_checkPwd');
    let regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()])[a-zA-Z\d!@#$%^&*()]{8,}$/;

    if(regex.test(inputPwdValue)){

        spanPwd.style.color = 'green';
        spanPwd.innerHTML = "확인완료.";

        if(inputCkValue ==''){

            inputCkPwd.focus();
        } else if(inputPwdValue != inputCkValue){

            alert("비밀번호가 일치하지 않습니다.")
            spanCkPwd.style.color = "red";
            spanCkPwd.innerHTML = "비밀번호가 일치하지 않습니다.";
        } else if(inputPwdValue == inputCkValue){

            spanCkPwd.style.color = "green";
            spanCkPwd.innerHTML = "확인완료.";
        }
    } else {

        alert("비밀번호 형식에 맞지 않습니다.")
        spanPwd.style.color = 'red';
        spanPwd.innerHTML = "비밀번호 형식에 맞지 않습니다.";
        inputPwd.focus();
    }

    if(inputPwdValue == ''){

        spanPwd.style.color = 'red';
        spanPwd.innerHTML = "비밀번호를 입력해주세요.";
        inputPwd.focus();
    }
}

function ckPwdOnChange(){

    let inputPwd = document.getElementById('input_pwd');
    let inputPwdValue = inputPwd.value;
    let inputCkPwd = document.getElementById('input_checkPwd');
    let inputCkPwdValue = inputCkPwd.value;
    let spanCkPwd = document.getElementById('span_checkPwd');
    let inputBirth = document.getElementById('input_birth');
    let regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()])[a-zA-Z\d!@#$%^&*()]{8,}$/;

    if(regex.test(inputCkPwdValue)){

        if(inputCkPwdValue != inputPwdValue){

            alert("비밀번호가 일치하지 않습니다.");

            spanCkPwd.style.color = "red";
            spanCkPwd.innerHTML = "비밀번호가 일치하지 않습니다.";
            inputCkPwd.focus();

        } else if(inputCkPwdValue == inputPwdValue){

            spanCkPwd.style.color = "green";
            spanCkPwd.innerHTML = "확인완료.";
            inputBirth.focus();
        }

    } else {

        alert("비밀번호 형식에 맞지 않습니다.")
        spanCkPwd.style.color = 'red';
        spanCkPwd.innerHTML = "비밀번호 형식에 맞지 않습니다.";
        inputCkPwd.focus();
    }

    if(inputCkPwdValue == ''){

        spanCkPwd.style.color = 'red';
        spanCkPwd.innerHTML = "비밀번호를 입력해주세요.";
        inputCkPwd.focus();
    }
}

function ckBirthOnChange(){

    let inputBirth = document.getElementById('input_birth');
    let inputBirthValue = inputBirth.value;
    let spanBirth = document.getElementById('span_birth');
    let inputEmail = document.getElementById('input_email');
    let regex = /^\d{4}\d{2}\d{2}$/;

    if(regex.test(inputBirthValue)){

        spanBirth.style.color = 'green';
        spanBirth.innerHTML = "확인완료";
        inputEmail.focus();
    } else {

        alert("생년월일 형식에 맞지 않습니다.");

        spanBirth.style.color = 'red';
        spanBirth.innerHTML = "생년월일 형식에 맞지 않습니다.";
        inputBirth.focus();
    }
}

function ckEmailOnChange(){

    let inputEamil = document.getElementById("input_email");
    let inputEmailValue = inputEamil.value;
    let spanEmail = document.getElementById('span_email');
    let regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if(regex.test(inputEmailValue)){

        alert("이메일 인증을 진행하세요.");
        spanEmail.style.color = 'blue';
        spanEmail.innerHTML = "인증번호를 받으세요.";
    } else {

        alert("이메일 형식에 맞지 않습니다.");
        spanEmail.style.color = 'red';
        spanEmail.innerHTML = "이메일 형식에 맞지 않습니다.";
        inputEamil.focus();
    }
}