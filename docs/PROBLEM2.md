###Process
1. 문자를 입력받는다
2. 문자가 연속으로 중복된 경우 그 부분을 삭제한다 만약 문자열의 끝에 도달했을 때 삭제기록이 없다면 해독완료
3. 2번을 반복

###기능
####문자열을 입력받는다
`boolean isInvalidData(String cryptogram)`
- 올바른 데이터가 전달되었는지 확인하는 메소드
    - return true : 올바른 데이터
    - return false : 예외 데이터

####문자가 연속으로 중복된 경우 그 부분을 삭제한다 만약 문자열의 끝에 도달했을 때 삭제기록이 없다면 해독완료

`String removeContinuity(String subString, char c)`
- 전달된 부분문자열의 연속성을 제거하는 함수
    - 문자열의 0번 인덱스에 문자 c와 중복되는 문자가 없을때까지 문자를 삭제

`boolean isContinuitySubstring(String subString)`
- 연속성 여부를 확인하는 함수
    - `index`에 위치한 문자가 `index + 1`에 위치한 문자와 같은지(연속성이 존재하는지) 확인

`String decodeOneCycle(String cryptogram)`
- 암호 해독을 위한 사이클 1회 함수
- 문자열의 끝에 도달할때까지 연속성 검사 함수 호출
    - 문자열이 수정되지 않았다면 `null`반환

`String decode(String cryptogram)`
- 암호가 완전히 해독될때까지 사이클 함수를 호출하는 함수b

---------------------------------

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