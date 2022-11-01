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
<hr>

### 구현해야 할 기능 목록

1. 중복되는 문자를 제거하는 기능
    - 스택을 사용하여 문자를 쌓아나감
    - 스택의 top과 같은 문자면 다른 문자가 나올 때 까지 넘어감(인덱스 증가 x)
    - 다른 문자가 나오면 pop()을 한번 한 후 계속 진행(인덱스 다시 증가)
    - 문자열의 길이와 인덱스가 같아지면 종료


2. 중복 제거된 문자열을 반환하는 기능
