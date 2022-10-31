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


---

## 기능 목록

#### 1. 연속 중복 문자를 찾는 정규식 구하기 ```getPattern```
```String cryptogram``` => ```String```(```[문자열 내 알파벳 조합]{2}```)

<br/>

#### 2. 연속 중복 문자 차례로 제거하기 ```solution```

1. 문자열 내 연속 중복 문자를 찾는 정규식 구하기
2. 1번에서 구한 정규식으로 연속 중복 문자 제거하기

더 이상 제거할 문자가 없을 때까지 1, 2번을 반복한다

