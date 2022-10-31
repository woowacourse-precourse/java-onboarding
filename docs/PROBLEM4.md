##  기능 목록 리스팅

- 문자열을 아스키 코드로 변환하는 기능
- 대소문자를 분류하는 기능
- 아스키 코드를 문자열로 변환하는 기능

### 생각할 사항

- enum 선언 하는 것이 깔끔하긴 하나 단순 문자열의 경우 필요한가 고민해볼 문제

```
private static final String UPPERCASE = "uppercase";
private static final String LOWERCASE = "lowerCase";
private static final String OTHER_LETTERS = "otherLetters";
```

<br>

## 🚀 기능 요구 사항

어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.

엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

| A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |

### 제한사항

- word는 길이가 1 이상 1,000 이하인 문자열이다.
- 알파벳 외의 문자는 변환하지 않는다.
- 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.

### 실행 결과 예시

| word | result |
| --- | --- |
| "I love you" | "R olev blf" |
