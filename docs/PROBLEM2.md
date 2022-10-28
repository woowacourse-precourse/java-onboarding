### 설계

#### 1. 프로세스

pastCharAndIdx: 이전의 문자(ASCII)들과 위치를 담은 스택

문자열을 순회하며, 

1. 스택이 비었다면 현재 문자(ASCII)와 위치 추가
2. 아니라면, 스택의 TOP(아직 중복제거되지 않은 직전문자)와 현재문자 비교
   - 같다면 POP, 직전문자와 현재문자 제거
   - 다르다면 스택에 현재문자 추가

문자열 순회 종료시,

1. 스택이 비었다면 answer = ""
2. 아니라면 answer = 남아있는 문자열

#### 2. 기능목록

1. findDuplicateChars: 중복문자 확인 기능

#### 3. 시간복잡도

- O(문자열길이)





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
