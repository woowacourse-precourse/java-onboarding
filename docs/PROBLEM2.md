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

<hr><br>

## 기능 목록
- `public static Stack<Character> removeDuplication(String cryptogram)`
  - 입력으로 String을 받는다.
  - Stack 구조를 활용하여 인접한 문자를 제거한다.
  - 결과 Stack을 return 한다.
  <br>
  
  
- `public static String reverseString(Stack<Character> st)`
  - 입력으로 Stack 값을 받는다.
  - Stack에 있는 모든 값을 pop한 다음, stringbuffer에 담아주고 순서를 뒤집어준다.
  - 결과를 String으로 반환한다, 만약 Stack이 비어있다면 ""를 return한다.
