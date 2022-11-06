## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |


---
## 📄 기능 목록

### 전체 동작 과정
1. **decryption()** : 암호문 해독
2. **boolean isRemoved** : decryption이 한 번 작동하는 동안 중복 문자를 지웠는지 확인
3. **isRemoved==false** 가 될 때까지 decryption 반복

### 함수별 입출력 및 동작 과정
1. **decryption()**
    - 입력 : 암호문 (String cipher)
    - 동작과정 :
      - cipher(n) == cipher(n+1)일 때까지 탐색
      - cipher(n) != cipher(n+m)일 때까지 탐색
      - cipher(n) ~ cipher(n+m-1)을 제거한 문장으로 cipher 초기화
      - cipher(n+1)부터 다시 탐색 시작 -> 문장이 끝날때까지
    - 출력 : boolean result

---
## 💡 기타 내용 정리

### 문자열 자르기
1. substr(int start,int length)
    - 시작위치, 길이
    - 시작위치
2. substring(int indexStart,int indexEnd)
    - 시작위치, 종료위치
    - 시작위치
