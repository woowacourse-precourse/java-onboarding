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

### 기능 목록 - 스택을 이용한 풀이

- [ ] String을 Stack으로 바꾸는 함수
- [ ] 연속된 문자를 없는 함수
  - [ ] originalStack에서 resultStack으로 옮기기
  - [ ] 만약 resultStack과 originalStack이 같으면 두 스택 모두 pop 하기
  - [ ] 만약 resultStack과 originalStack이 다르면 옮기기
- [ ] Stack을 String으로 바꾸는 함수


- [ ] 정상적인 문자열이 입력되지 않은 경우
    - [ ] 문자열 길이가 제한 사항에 속하지 않은 경우 (1이상 1000이하)
    - [ ] 알파벳 소문자로 구성하지 않은 경우
