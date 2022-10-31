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



# 🚀 Problem2

# ✅ 알고리즘 로직 순서

- 아래서부터 차례로 로직 구현

1. cryptogram을 문자열 메서드 활용 유연성을 위해 stringBuilder 로 변환

2.중복된 것이 없을때까지 순회 (무한루프)
- cryptogram 을 char 단위로 순회
    - 순회하면서 뒤에 문자(char)와 같은지 체크
        - 만약 같은 문자가 있으면 같은 문자 삭제
- 무한루프 break 조건: 문자열 길이에 변화가 있는지 없으면 break

3. 최종 문자열 반환

# 📈 기능 목록

## 구현 기능 목록

### ✅ 중복 문자 체크 기능

- [X] cryptogram 을 char 단위로 순회
    - 순회하면서 바로 다음 문자(char)와 같은지 체크
        - 만약 같은 문자가 있으면 같은 문자 삭제


