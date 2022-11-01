## 👀 생각할 점

1. 입력 받은 문자열을 순서 대로 stack에 넣으면서 암호를 해독한다.
    + stack이 비어있을 때는 차례인 문자를 push 한다.
    + stack이 비어있지 않을 때는 stack의 top과 차례인 문자를 비교한다.
        + top과 차례인 문자가 같을 경우 => stack을 pop하고 차례를 넘긴다.
        + top과 차례인 문자가 다른 경우 => stack의 차례인 문자를 push 한다.
    + 위 과정을 문자열의 마지막 차례까지 반복한다.
    + 순서가 모두 끝나면 stack 에 남은 값을 return 한다.
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
