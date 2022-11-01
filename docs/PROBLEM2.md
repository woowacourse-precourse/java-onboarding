## 📝 기능 목록

1. 현재 문자열의 모든 중복 문자 제거하기
2. 현재 문자열의 중복 문자 한번 제거하기
3. 중복 일때 첫 인덱스 구하기
4. 중복 일때 끝 인덱스 구하기
5. 중복 문자열 남아있는 지 체크하기
6. String 길이가 남았는지 체크하기
7. 두 문자가 같은 지 체크하기

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
