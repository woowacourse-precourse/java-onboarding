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

# 개발 기록

## 기능 목록

개요
1. 문자열이 특정한 문자열을 갖고 있는지 확인하는 메소드
   - 정규식을 활용하자
   - boolean 값을 반환하자
2. 문자열에서 특정한 문자열을 삭제하는 메소드
   - replaceAll() 메소드와 정규식을 활용하자
   - String 값을 반환하자

### 1. public boolean isStringContainingRegularExpression(String string, String regex)
- 문자열이 정규식 표현을 포함하는지 확인하는 메소드
- 기능 : 정규식 표현을 포함하면 `true`, 포함하지 않으면 `false`를 반환

### 2. public String deleteStringByRegularExpression(String string, String regex)
- 문자열에서 정규식 표현에 해당하는 문자열을 삭제하는 메소드
- 기능 : 문자열에서 정규식 표현에 해당하는 문자열을 모두 ""으로 바꾸고 반환한다.

## Test Code
### 1. void isStringContainingRegularExpressionTest()
- regex = "(.*)(\w)\2{1,}(.*)"
- 거짓 테스트 입력 시 `false` 반환 확인
  - 테스트 : "brown", "", "ab"
- 참 테스트 입력 시 `true` 반환 확인
  - 테스트 : "browoanoommnaon", "ababb", ""
   
### 2. void deleteStringByRegularExpressionTest()
- regex = "(\w)\1{1,}"
- 테스트 입력 시 연속되는 중복 문자 제거 확인
  - 테스트 : "browoanoommnaon", "aabbb", "brown"
  - 정답 : "browoannaon", "", "brown"