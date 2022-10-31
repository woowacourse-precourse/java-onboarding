## ✔ 구현할 기능 목록

### 기능
- 입력 암호문 문자열을 문자 리스트로 바꾸는 기능
- 바로 옆의 문자와 비교해 중복 문자라면 제거할 인덱스 목록에 해당 인덱스를 추가하는 기능
- 중복되는 문자의 인덱스에 해당하는 글자를 삭제하는 기능
- 중복되는 문자들을 전부 제거한 character list를 String 타입으로 반환하는 기능


### 예외처리
- cryptogram(입력값)이 입력되지 않은 경우 예외처리
- cryptogram(입력값)에 공백이 입력된 경우 예외처리
- cryptogram(입력값)의 길이가 1이상 1000이하가 아니면 예외처리
- cryptogram(입력값)에 알파벳 소문자가 아닌 문자가 있으면 예외처리
  - cryptogram(입력값)에 영어만 있는지 확인
  - cryptogram(입력값)에 소문자만 있는지 확인


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
