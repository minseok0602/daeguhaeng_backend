async function sendRequest() {
    const age = document.getElementById("age").value;
    const gender = document.getElementById("gender").value;
    const spending = document.getElementById("spending").value;

    const payload = {
        age: parseInt(age),
        gender: gender,
        spending: parseInt(spending),
        clusterId: 1 // 클러스터 ID는 기본값으로 설정
    };

    try {
        const response = await fetch("http://127.0.0.1:8080/api/recommend", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        const data = await response.json();
        document.getElementById("result").innerText = JSON.stringify(data, null, 2);
    } catch (error) {
        document.getElementById("result").innerText = "Error: " + error.message;
    }
}
