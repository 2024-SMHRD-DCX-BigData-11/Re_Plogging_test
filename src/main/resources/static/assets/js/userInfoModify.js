document.getElementById("change-password-button").addEventListener("click", function() {
    document.getElementById("password-section").style.display = "none";
    document.getElementById("change-password-section").style.display = "block";
});

document.getElementById("cancel-button").addEventListener("click", function() {
    document.getElementById("password-section").style.display = "flex";
    document.getElementById("change-password-section").style.display = "none";
});

document.getElementById("save-changes-button").addEventListener("click", function() {
    // 여기에 비밀번호 변경 로직 추가
    alert("비밀번호가 성공적으로 변경되었습니다.");
    document.getElementById("password-section").style.display = "flex";
    document.getElementById("change-password-section").style.display = "none";
});

document.getElementById("user-info-form").addEventListener("submit", function(event) {
    event.preventDefault();
    // 닉네임 변경 처리 로직 추가
    alert("정보가 성공적으로 변경되었습니다.");
});
