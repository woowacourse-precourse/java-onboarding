#### 설계

`연속하는 중복문자`를 제거하기 위해 `암호문을 처음부터 매 번 순회`하는 방식은 비효율적

스택의 `LIFO` 특성을 활용하여 `암호문 한 번의 순회`로 `연속하는 중복문자`제거

`pastChar`: 이전 문자를 저장하는 스택

`pastIdx`: 이전 문자의 idx를 저장하는 스택

`duplicateCharIdx`: 중복 문자의 idx를 저장하는 스택. `해당 스택이 비어있는 것`은 `이전에 중복된 문자가 없었음`을 의미



case1) `pastChar`이 비어있는 경우 (`논리적인 의미`에 의해 `duplicateCharIdx`도 비어있는 상태)

- `pastChar`에 `현재 문자` 추가
- `pastIdx`에 `현재 문자 idx` 추가

case2) `pastChar`이 차있는 경우

- case1) `연속하는 중복문자`인 경우 `duplicateCharIdx`에 `현재 문자 idx`추가. 단, 마지막 문자인 경우 `연속하는 중복 문자 모두 제거` 후 종료

- case2) `연속하는 중복문자`가 아닌 경우 `이전에 연속하는 중복문자`가 있었는지 확인

  - `duplicateCharIdx가 비었다면`(`이전에 연속하는 중복문자가 없었다면`) `pastChar`에 `현재문자` 추가, `pastIdx`에 `현재 문자 idx` 추가
  - `duplicateCharIdx가 차있다면`(`이전에 연속하는 중복문자가 있었다면`) `연속하는 중복 문자 모두 제거` 후, `idx -= 1`

  

#### 기능목록

`getDeduplicateCrypto`: `연속하는 중복문자`가 없는 암호문을 얻는 기능

`removeDuplicateChars`: `연속하는 중복 문자 제거`



`getFinalCrypto`: 중복을 제거한 최종 문자열 얻기











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
