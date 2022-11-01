## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

b r o w a n o o m m n a o n

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

구체적인 기능 요구사항은 다음과 같다.

1.임의의 문자열에 연속하는 중복문자들을 확인한다.
2. 1.에서 저장한 중복문자들을 제거한다.
3. 연속하는 중복문자가 모두 제거될 때 까지 1~2를 반복한다.
4. 더이상 연속하는 중복 문자가 존재하지 않는다면 문자열을 반환한다.


### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
