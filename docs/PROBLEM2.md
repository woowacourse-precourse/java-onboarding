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

### 기능 목록
- 문자열의 한 글자씩 중복 문자 확인
  - [x] stack이 비어 있거나 중복 문자가 확인되지 않았다면 stack에 문자 저장
  - [x] stack이 비어 있지 않은 상태에서 중복 문자가 있다면 stack에서 해당 문자들을 꺼냄
  - [x] stack의 문자들을 문자열로 바꾸어 결과 반환
