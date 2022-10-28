##  기능 목록 리스팅

- ~~예외 처리 기능~~
    1. ~~cryptogram의 길이가 1미만, 1000 초과인 경우~~
  2. ~~cryptogram에 대문자가 포함되어 있을 경우~~  
<p style="color:red">제한사항대로 cryptogram이 주어질 것으로 판단하여 불필요한 예외 처리 삭제</p>

- 인접 중복문자 제거 기능
- 인접 중복문자 제거된 문자들을 요구하는 반환타입으로 변환하는 기능 

### 생각할 사항

- 배열 / 스택 데이터 타입 / 정규 표현식 (가장 효율적인 로직은 무엇인가?)

| 배열 | 스택 | 정규 표현식 |
|:---:|:---:|:---:|
| pop, push 과정을 직접 구현해야 함 | LIFO 방식이기 때문에 값을 반환할 때 reverse 과정이 필요함 | a부터 z까지 전부 정규 표현식을 작성해야 함 |

<br>

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
