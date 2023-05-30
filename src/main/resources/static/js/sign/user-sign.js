function idOnChange(){

    let inputId = document.getElementById('input_id');
    let inputIdValue = inputId.value;
    let btnCkId = document.getElementById('btn_ckId');
    let spanId = document.getElementById('span_id');
    let regex = /^[a-zA-Z0-9]{4,13}$/;

    btnCkId.disabled = false;
    btnCkId.style.background = 'white';

    if(regex.test(inputIdValue)){

        spanId.style.color = 'blue';
        spanId.innerHTML = "아이디 중복확인 해주세요.";
        btnCkId.focus();
    } else {

        alert("아이디 형식에 맞지 않습니다.");
        spanId.style.color = 'red';
        spanId.innerHTML = "아이디 형식에 맞춰주세요.";
        inputId.focus();
    }
}

function idCheck(){

    let inputId = document.getElementById('input_id');
    let inputIdValue = inputId.value;
    let spanId = document.getElementById('span_id');
    let inputNik = document.getElementById('input_nik');
    let btnCkId = document.getElementById('btn_ckId');

    btnCkId.disabled = true;
    btnCkId.style.background = '#e5e7eb';

    if(inputIdValue == ''){

        alert("아이디를 입력해주세요.");
        inputId.focus();
    }

    fetch("/sign/checkUserId?userId=" + inputIdValue)
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
        .catch(err =>{

            alert(err);
        });
}

function nikOnChange(){

    let spanNik = document.getElementById("span_nik");
    let inputNik = document.getElementById("input_nik");
    let inputNikValue = inputNik.value;
    let btnCkNik = document.getElementById('btn_ckNik');
    let regex = /^[가-힣a-zA-Z0-9]{2,10}$/;

    btnCkNik.disabled = false;
    btnCkNik.style.background = 'white';

    if(inputNikValue == ''){

        spanNik.style.color = 'red';
        spanNik.innerHTML = '닉네임을 입력해주세요.';
        inputNik.focus();
    }

    if(regex.test(inputNikValue)){

        spanNik.style.color = 'blue';
        spanNik.innerHTML = '닉네임 중복확인 해주세요.';
        btnCkNik.focus();
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
    let btnCkNik = document.getElementById('btn_ckNik');

    btnCkNik.disabled = true;
    btnCkNik.style.background = '#e5e7eb';

    if(inputNikValue == ''){

        alert("닉네임을 입력해주세요.");
        inputNik.focus();
    }

    fetch("/sign/checkUserNick?userNick=" + inputNikValue)
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
        .catch(err =>{

            alert(err);
        });
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
    let regex = /^(19\d{2}|20\d{2})(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])$/;

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
    let btnEmail = document.getElementById('btn_Email');
    let regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    btnEmail.disabled = false;
    btnEmail.style.background = 'white';

    if(regex.test(inputEmailValue)){

        spanEmail.style.color = 'blue';
        spanEmail.innerHTML = "인증번호를 받으세요.";
    } else {

        alert("이메일 형식에 맞지 않습니다.");
        spanEmail.style.color = 'red';
        spanEmail.innerHTML = "이메일 형식에 맞지 않습니다.";
        inputEamil.focus();
    }
}

function sendTempKey(){

    let inputEmail = document.getElementById("input_email");
    let inputEmailValue = inputEmail.value;
    let spanEmail = document.getElementById('span_email');
    let inputEmailNo = document.getElementById('input_emailNo');
    let btnEmail = document.getElementById('btn_Email');

    btnEmail.disabled = true;
    btnEmail.style.background = '#e5e7eb';

    fetch("/mail/sendTempkey?userEmail=" + inputEmailValue)
        .then(response => response.json())
        .then(data => {
            if(data == false){

                alert("전송에 실패하였습니다.");
            } else if(data == true){

                alert("인증번호가 전송되었습니다. 이메일을 확인해주세요.");
                spanEmail.style.color = 'green';
                spanEmail.innerHTML = "인증번호 전송 완료";
                inputEmailNo.focus();
            }
        })
        .catch(err =>{

            alert(err);
        });
}

function ckEmailNoOnChange(){

    let inputEmailNo = document.getElementById('input_emailNo');
    let inputEmailNoValue = inputEmailNo.value;
    let btnEmailNo = document.getElementById('btn_EmailNo');
    let regex = /^\d{8}$/;

    btnEmailNo.disabled = false;
    btnEmailNo.style.background = 'white';

    if(!regex.test(inputEmailNoValue)){

        alert("인증번호 형식에 맞지 않습니다.");
    }
}

function ckEmailNo(){

    let inputEmailNo = document.getElementById('input_emailNo');
    let inputEmailNoValue = inputEmailNo.value;
    let inputEmail = document.getElementById("input_email");
    let inputEmailValue = inputEmail.value;
    let btnEmailNo = document.getElementById('btn_EmailNo');
    let spanEmailNo = document.getElementById('span_emailNo');
    let btnSign = document.getElementById('btn_sign');

    btnEmailNo.disabled = true;
    btnEmailNo.style.background = '#e5e7eb';

    fetch("/mail/ckEmailNo?emailNo=" + inputEmailNoValue + "&userEmail=" + inputEmailValue)
        .then(response => response.json())
        .then(data => {
            if(data == false){

                alert("인증번호가 일치하지 않습니다.");
                spanEmailNo.style.color = 'red';
                spanEmailNo.innerHTML = '인증번호를 다시 확인해주세요.';
                btnEmailNo.disabled = 'false';
                btnEmailNo.style.background = 'white';
                inputEmailNo.focus();
            } else if(data == true){

                alert("인증번호가 일치합니다.");
                spanEmailNo.style.color = 'green';
                spanEmailNo.innerHTML = '확인완료.';
                btnSign.focus();
            }
        })
        .catch(err =>{

            alert(err);
        });
}

function userSignSubmit(){

    let spanId = document.getElementById('span_id').style.color;
    let spanNick = document.getElementById('span_nik').style.color;
    let spanPwd = document.getElementById('span_pwd').style.color;
    let spanCkPwd = document.getElementById('span_checkPwd').style.color;
    let spanBirth = document.getElementById('span_birth').style.color;
    let spanEmail = document.getElementById('span_email').style.color;
    let spanEmailNo = document.getElementById('span_emailNo').style.color;

    let userId = document.getElementById('input_id');
    let userIdValue = userId.value;
    let userNick = document.getElementById('input_nik');
    let userNickValue = userNick.value;
    let userPwd = document.getElementById('input_pwd');
    let userPwdValue = userPwd.value;
    let userCkPwd = document.getElementById('input_checkPwd');
    let userBirth = document.getElementById('input_birth');
    let userBirthValue = userBirth.value;
    let userEmail = document.getElementById('input_email');
    let userEmailValue = userEmail.value;
    let userEmailNo = document.getElementById('input_emailNo');

    if(spanId != 'green'){
        alert("아이디를 다시 확인해주세요.");
        userId.focus();
        return;
    }

    if(spanNick != 'green'){
        alert("닉네임을 다시 확인해주세요.");
        userNick.focus();
        return;
    }

    if(spanPwd != 'green'){
        alert("비밀번호를 다시 확인해주세요.");
        userPwd.focus();
        return;
    }

    if(spanCkPwd != 'green'){
        alert("비밀번호를 다시 확인해주세요.");
        userCkPwd.focus();
        return;
    }

    if(spanBirth != 'green'){
        alert("생년월일을 다시 확인해주세요.");
        userBirth.focus();
        return;
    }

    if(spanEmail != 'green'){
        alert("이메일을 다시 확인해주세요.");
        userEmail.focus();
        return;
    }

    if(spanEmailNo != 'green'){
        alert("인증번호를 다시 확인해주세요.");
        userEmailNo.focus();
        return;
    }

    let userInfo = {
        userId: userIdValue,
        userNick: userNickValue,
        userPwd: userPwdValue,
        userBirth: userBirthValue,
        userEmail: userEmailValue
    };

    fetch('/sign/userSign', {
        method: 'POST',
        headers: { 'Content-Type' : 'application/json' },
        body: JSON.stringify(userInfo)
    })
        .then(response => response.json())
        .then(data => {
            if(data == true){

                alert("회원가입이 완료되었습니다.");
                window.open('/login/loginPopup', 'LOGIN', 'width=400, height=300');
            } else if(data == false){

                alert("서버 오류로 인한 회원가입 실패입니다. 관리자에게 문의해주세요.");
            }
        })
        .catch(err => {

            alert("서버 오류로 인한 회원가입 실패입니다. 관리자에게 문의해주세요.");
        });

}