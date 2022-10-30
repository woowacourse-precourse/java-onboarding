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

### 기능 구현
1. solution
    - 입력을 받는다.
    - 결과를 리턴한다.
2. decrypt
    - 암호문을 입력받는다.
    - 암호문을 매번 순회한다.
    - 만약 연속된 중복 단어가 있어 삭제해야할 경우에는 그 인덱스를 isDeleted 배열을 활용하여 표시해둔다.
    - isDeleted 배열을 순회하며 StringBuilder를 이용하여 삭제할 문자를 제거한 새로운 문자열을 만든다.
    - 더 이상 삭제할 단어가 없으면 복호화가 된 것으로 보고 문자열을 리턴한다.