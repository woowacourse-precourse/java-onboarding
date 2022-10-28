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

---

## 기능 목록

- [x] 현재 문자열에서 연속적으로 중복한 문자가 있는지 확인합니다.
- [x] 연속적으로 중복한 문자가 있다면 삭제합니다.
    - [x] 중복한 문자를 삭제 한 후 만들어지는 새로 만들어지는 문자열을 현재 문자열로 지정합니다.
- [x] 위 과정을 연속하여 중복한 문자가 없을때까지 반복합니다.
- [x] 연속적으로 중복한 문자가 없다면 현재 문자열을 return합니다.

### 필요한 메서드

- [x] isDeletable(String s) 메서드를 통해 문자열 s에서 연속하여 중복한 문자가 있다면 true를 return하고, 그렇지 않다면 false를 리턴합니다.
    - [x] isDeletable 메서드는 현재 문자열 길이만큼의 크기의 boolean 타입의 배열 isConsecutive[s.length()]을 선언하여 확인합니다.
- [x] isDeletable 메서드에서 true를 return 했다면 deleteConsecutive(String s) 메서드에서 연속하여 중복되는 문자열을 삭제합니다.
    - [x] isConsecutive 배열에서 true로 체크된 문자는 무시하고 나머지 문자열로 만들어진 새로운 문자열을 return합니다.

