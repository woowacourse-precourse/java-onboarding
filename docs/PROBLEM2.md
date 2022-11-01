## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 기능목록

- cryptogram의 반복되는 문자를 찾는 checkString 함수 구현
- 연속된 중복 문자열이 있는지 확인해주는 validCheck 함수 구현
- 문자열 내에 중복 문자의 인덱스를 저장하는 catchSameIndex 함수 구현 
- 반복된 문자의 인덱스와 문자열을 이용하여 갱신할 splitString 함수 구현
- 문자열 길이만큼 해당 인덱스가 중복했던 자리인지 확인하는 checkIndex 함수 구현

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
