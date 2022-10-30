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

-------------
# 기능 요구사항

## Problem2

테스트케이스
* abbaacde -> acde 
* abbbcdde -> ace
* abbcbbbbbde -> acde
  * 검사하는 문자열에서 중복이 있는 문자들은 모두 제거해야 함

- [ ] 문자열 탐색하며 중복되는 문자 기록하기
- [ ] 문자열에서 2글자 이상 중복되는 문자들 모두 제거 (replace, 정규식 활용)
- [ ] 중복된 문자가 있는지 체크하는 boolean flag
- [ ] boolean flag가 true일 때까지 while문 돌리기 (가공 이전, 이후 길이 체크)
- [ ] 문자열의 길이가 1 이하면 while문 break