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
1. 입력으로 들어온 cryptogram의 제일 첫 문자부터 마지막 문자까지 반복하며 연속으로 중복되는 문자들을 삭제한다.
2. 반복을 마쳤을 때, 연속으로 중복된 문자 삭제 여부를 확인한다.
3. 문자를 삭제 했다면 1~2번 단계를 다시 반복한다.
4. 결과 문자열을 리턴한다.