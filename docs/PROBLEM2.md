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

### 요구사항 분석
- 주어진 문자열에서 중복을 제거하고, 이에 만들어진 결과를 기반으로 다시 중복을 제거하는 것을 반복한다.
- 문자열의 길이가 1인 경우, 입력값을 반환한다.
- 해독의 결과가 빈 문자열인 경우, 빈 문자열을 반환한다.
- 문자의 중복은 좌우 한 칸의 문자와 비교해서 같은 문자가 있는 경우 중복 문자로 판단한다.

### 메서드 구현 목록
- boolean isDuplicated(String str, int i) : 문자열의 i번째 인덱스의 문자가 중복문자인지를 판단하는 메서드
- String deleteDuplicated(String str) : 현재 주어진 문자열에서 중복을 제거하는 메서드
- String getAnswer(String str) : deleteDuplicated()를 더 이상 중복을 제거 할 수 없을때까지 반복해 결과를 반환하는 메서드