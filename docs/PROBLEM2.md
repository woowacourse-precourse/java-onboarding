## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon" 
3. "browoaaon" 
4. "browoon"
5. "brown"

[기능]
1. 연속으로 중복되는 문자를 찾는다 
- 조건(condition) = 현재 문자와 다음문자가 같을때
2. 중복된 문자를 추출한다.
- 추출 (findReapeatChar) : 중복되는 앞뒤 문자를 스트링빌더에 담고 스트링으로 리턴
3. 암호문에서 중복된 문자를 제거한다. 
- 제거(delete) : 중복되는 문자를 변수에 담고 기존 암호문에서 ""로 치환한다. 
4. 기존 암호를 중복문자가 제거된 암호로 교체한다. 
- 실행 후 반복문을 첫 문자열 부터 다시 돌린다. 

* 암호가 공백이 되면 반복문 종료. 

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
