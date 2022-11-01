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

## 🚀 기능 먹럭
1. 임의의 문자열을 문자 단위로 나누어 저장하는 리스트를 생성하고, 각 문자를 비교하여 연속하는 중복문자들을 삭제한 문자열을 반환하는 메소드를 생성한다.
2. 임의의 문자열 Cryptogram이 매개변수로 주어질때 1에서의 과정을 반복하여 연속하는 모든 중복 문자들을 삭제한 결과를 반환하는 solugion 메소드를 완성한다. 