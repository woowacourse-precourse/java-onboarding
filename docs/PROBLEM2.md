## 📝 기능 목록

1. `isRepetitive()` : 주어진 문자열에 연속하는 중복 문자가 있는지 확인하는 기능
2. `deleteRepetittion()` : 연속하는 중복 문자를 제거하는 기능

## 🔍 구현 중 이해가 안된 부분
* 처음에 설계한 `isRepetitive()` 메소드는 연속하는 중복 문자 있을 경우 `true`를 반환하고 없을 경우 `false`를 반환하는 것으로 하였다. 
* 하지만 문자열의 첫번째 인덱스부터 마지막까지 for문으로 확인하여 중복이 있는 경우와 중복이 없는 경우도 있는데 이 경우 `false`가 반환되는 것으로 보여 int타입으로 바꾸었다.
* int타입으로 바꿔 `true`를 1로, `false`를 0으로 반환하는 것으로 수정하였는데, 이 경우에는 왜 문제 없이 실행되는 것인지 이해가 가지 않았다.
- [ ] 위 내용 공부 후 체크

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
