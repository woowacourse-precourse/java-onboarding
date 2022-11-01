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

## 기능 구현

- longTextDeduplication()
    - 문자열의 크기가 3이상일 때 중복이 모두 제거될 때까지 중복 제거
- shortTextDeduplication()
    - 문자열의 크기가 3미만일 때 중복이 모두 제거 되거나, 문자열 길이가 0이 될 때 까지 중복 제거
- checkModify()
    - preCheck(i, i-1번째의 중복 확인)와 currentCheck(i, i+1번쩨의 중복 학인)를 통해 중복이 발생하면 true를 반환
- checkDuplicate()
    - pre(문자열의 i번째 문자), current(문자열의 i+1번째 문자)가 같은면 true 반환
- initailValue()
    - 문자열의 첫 문자의 중복여부를 확인하기 위한 메서드 
- lastValue()
    - 문자열의 마지막 문자의 중복여부를 확인하기 위한 메서드
- verifyStringChange()
    - 문자열에 중복된 값이 있으면 true를 반환
- stringLengthException()
    - 문자 길이 예외처리
- isIncludedNotLowerCase()
    - 문자열에 소문자를 제외한 다른 문자가 존재하면 true를 반환
- exceptionMethod()
    - 입력에 대한 제한사항들을 체크하는 메서드