## 🚀 기능 요구 사항

## 기능 목록

1. 입력을 받는다
    - [예외사항] 입력이 null 임
    - [예외사항] 길이가 1~1000이 아님
    - [예외사항] 알파벳 소문자로만 이루어지지 않음
2. 지울 부분 찾기
    - String Builder와 현재 index를 통해 어디까지 중복인지 찾아줌
3. 중복인 부분만큼 삭제
4. 결과를 return 함

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
