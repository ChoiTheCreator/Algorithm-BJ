# 🚀 알고리즘 레포지토리

이 레포지토리는 **JavaScript**와 **Java**를 사용하여 코딩 테스트 문제를 해결하는 공간입니다. ✨

자동 업데이트되므로 항상 최신 상태로 유지됩니다.

---

## 🛠️ 사용 언어
- 🚀 **JavaScript**: Node.js (권장 버전: 18 이상)
- ☕ **Java**: JDK 17 이상

---


## 💡 핵심 아이디어 (JavaScript)
🔹 이 섹션에는 각 문제에 대한 **핵심 아이디어**를 기록할 수 있습니다


📌 Spread 연산자로 문자열을 하나하나 벗겨서 ...문자열 
-> 이걸로 배열 만들면 되겠다


📌 숫자 문자들이 뭉쳐 있는 문자열에서 숫자를 추출할때 -> REGEX /\D+/ 쓰면 //["", "1", "2", "34", ""]  -> 이러케댐 
-> 이거 다 더하고싶다 (배열의 값 다 더하고 싶다) 반복문 쓰던가, reduce((acc,cur)) 쓰던가 하면 될거같은데요
-> 근데 ParseFloat() vs Number() -> 전자는 보수적임 (ParseFloat('') -> NaN , Number('') -> 0) 
-> Regexing 한다면 Number()이 좀 더 현명하겠다



---

