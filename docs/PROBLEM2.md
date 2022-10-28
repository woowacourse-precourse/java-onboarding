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

## 구현 과정

Stack 자료구조를 이용

주어진 문자열 : `cryptogram`



1. `cryptogram`의 각 문자에 접근

2. 조건에 따라 Stack에 문자를 `add` / Stack에 존재하는 문자를 `pop`
3. `cryptogram`의 모든 문자를 탐색한 후, <br>Stack에 남은 문자를 역순으로 연결

---
**문자가 Stack에 add될 조건**
- Stack이 비어있을 경우
- 현재 탐색중인 문자와 Stack의 최상단에 위치하는 문자가
  <br>일치하지 않을 경우

**문자가 스택에서 pop될 조건**
- Stack의 최상단에 위치하는 문자와 현재 탐색중인 문자가 동일할 경우
- 위의 과정이 가능할 때까지 반복 후 Stack의 최상단 문자

   
    