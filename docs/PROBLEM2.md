## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

- [ ] 중복 문자가 있는지 체크한다.
  - [x] String을 char 배열(chars)로 만든다.
  - [x] 정답을 나타내는 String 객체(answer)를 생성한다.
  - [x] 중복된 문자가 있었는지 체크하는 hasNotDuplicate = false로 생성하고 초기화한다..
  - [ ] hasNotDuplicate가 true가 될 때 까지 무한루프를 돌린다.
    - [ ] hasNotDuplicate를 true로 초기화한다.
      - [x] 새로운 문자열이 만들기 위해 StringBuiler 객체를 생성한다.
      - [ ] char 배열이 첫 번째부터 마지막-1 번째 까지 for문을 돈다.
        - [ ] 첫 번째일 때 
          - [ ] 배열의 첫 번째 값이 배열의 두 번째 값과 같지 않다면 StringBuilder에 추가한다.
        - [ ] 마지막일 때 
          - [ ] 배열의 마지막 값이 그 전 배열의 값과 다르고 중복된 문자(duplicateChar)가 아니면 StringBuilder에 추가한다.
        - [ ] 배열의 i번째 값이 i + 1 값과 같다면 
          - [ ] duplicateChar의 값은 배열의 i 번째 값이 된다.
          - [ ] hasNotDuplicate의 값을 false로 변경한다. 
        - [ ] 배열의 i번째 값이 i + 1 값과 같지 않다면
          - [ ] 중복된 문자(duplicateChar)와 값이 다르면 StringBuilder에 추가한다.
          - [ ] duplicateChar의 값을 ' '로 변경한다.
      - [ ] for문이 끝나면
        - [ ] char 배열의 값을 StringBuilder를 String으로 변환 후 다시 char 배열로 만든 값으로 변경한다.
        - [ ] hasNotDuplicate의 값이 true이면 
          - [ ] answer의 값은 현재 StringBuilder로 만들어진 문자열이 된다. 
      - [ ] 무한 루프에 탈출하면 answer 객체를 반환한다.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
