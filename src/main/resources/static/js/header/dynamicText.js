let dynamicText = document.querySelector("#dynamic");

/** 출력할 배열 함수 */
function randomString() {
    let stringArr = [
        "Spring of K-leage comes.."
    ];

    let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];
    let selectStringArr = selectString.split("");

    return selectStringArr;
}

/** 타이핑 리셋 */
function resetTyping() {
    dynamicText.textContent = "";
    dynamic(randomString());
}

/** 한글자 씩 텍스트 출력 함수 */
function dynamic(randomArr) {
    if (randomArr.length > 0) {
        dynamicText.textContent += randomArr.shift();
        setTimeout(function () {
            dynamic(randomArr);
        }, 80);
    } else {
        setTimeout(resetTyping, 3000);
    }
}

dynamic(randomString());

/** 커서 깜빡임 처리 */
function blink() {
    dynamicText.classList.toggle("active");
}
setInterval(blink, 300);