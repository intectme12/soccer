
<!-- 약관 동의 확인 스크립트-->
document.getElementById('userSign').onclick = function (){

    let isChecked = document.getElementById('isChecked');
    let terms = document.getElementById('ck_termsOfUse').checked;
    let policy = document.getElementById('ck_privacyPolicy').checked;
    let age = document.getElementById('ck_ageLimit').checked;

    if(!terms || !policy || !age){
        alert("모든 약관에 동의하여 주세요.");
        return false;
    } else {

        isChecked.submit();
    }
}
