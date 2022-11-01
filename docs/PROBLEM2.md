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



## 🚀 기능 요구 사항
1.문자열에 한 문자씩을 더할 떄 ,더해짐을 받는 문자열 맨마지막 문자가 더해야할 문자랑 다르면 더해주고 같으면 2번메소드를 실행시키는 메소드
2. 문자끼리 같을 때 실행하는 메소드로 더해야하는 문자열의 몇번째 문자까지 같은지 인덱스를 확인해주는 메소드 

