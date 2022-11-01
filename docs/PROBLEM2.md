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
- `decode(String cryptogram)` : 중복 문자들을 검증하는 부분과 검증이 끝난 뒤 결과를 String으로 변환하는 기능으로 나눈다.
- `checkDuplicateCharacter(String cryptogram)` : 스택을 생성하고, cryptogram 문자열의 각 글자들을 검증한다.
- `removeDuplicateCharacter(Stack<Character> stack, String cryptogram, int idx)` : 중복되는 글자들을 스택에서 제거하고, 중복되지 않은 글자는 스택에 삽입한다.
- `getDecodingResult(Stack<Character> stack)` : 중복 문자 검증이 끝난 뒤 스택에 남아있는 문자들을 꺼내어 String으로 변환한다.