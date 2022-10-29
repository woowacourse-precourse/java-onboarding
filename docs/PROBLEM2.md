## 기능 목록
### 중복이 있는 곳 찾기
- 앞 글자와 같을 경우
    - end 값 증가한다.
- 앞 글자와 다를 경우
    - start와 end가 다를 경우(중복 범위가 있다)
        - 리스트에 저장한다.
    - start와 end값을 현재 인덱스 값으로 바꾼다.

### 중복이 있는 곳 지우기
- 인덱스 값이 큰 중복 범위부터 지운다.

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
