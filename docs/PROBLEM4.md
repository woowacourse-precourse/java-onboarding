## 청개구리 문제

## 기능 목록

- [x] Map을 사용하여 청개구리의 사전을 만들어 사용할 수 있다. DictionaryGenerator#createDictionary()
- [x] word 데이터를 하나씩 나눌수 있고, word를 다시 병합할 수 있다. CompareWords#wordConversion()
- [x] 특정자리가 소문자인지 대문자인지 알수 있고 변환 할수 있다. PlaceCheck#wordCompare()
- [x] 특정자리가 공백인지 아닌지 알수 있다. CompareWords#SpacesCompare()


## 기능 요구 사항

어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 
청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.

엄마 말씀 word가 매개변수로 주어질 때, 
아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

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
