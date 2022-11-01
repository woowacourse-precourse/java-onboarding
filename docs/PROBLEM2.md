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

1. 중복 검사
   - 문자열의 길이가 없으면 중복 검사 불가(중복이 없는 경우이므로)
   - 앞 뒤 문자 중 겹치는 문자가 있을 경우를 검사
     - 없으면, 그대로 return
     - 있으면, 중복 제거

2. 중복 제거 기능
   - 문자열에서 앞 뒤 문자 중 겹치는 중복 문자 있을 시에 삭제
   - 결과는 빈 문자열도 가능
