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

### 기능 목록
1. deleteDuplicate : Stack을 이용해 연속하는 중복 문자 제거 
    1. Stack 비어있으면 문자 저장
    2. Stack이 비어있지 않고 Stack 가장 위의 글자와 현재 글자가 일치하는 경우
        1. Stack에서 해당 글자 제거
    4. Stack이 비어있지 않고 Stack 가장 위의 갈자와 현재 글자가 일치하지 않는 경우
        1. Stack에 해당 글자 저장
2. stackToString : Stack에 남은 글자 합쳐서 문자열로 변환
