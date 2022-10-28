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

### 풀이 방법
- Deque 를 사용해 같은 단어가 2번이상 반복될 때 그 단어를 저장해두고 한번에 지워버리는 방식으로 코드 구성
1. 마지막 단어를 저장할 변수 선언, queue 가 비어있으면 offer
2. 중복인지 확인할 단어와 queue 의 마지막 단어가 같으면 그대로 진행
3. 중복인 단어가 나오면 lastWord 에 중복인 단어를 넣어주고, 비교할 단어와 같으면 그대로 진행
4. 그대로 진행하다 다른 단어가 나오면 lastWord 비워주고, 다른 단어는 queue 에 넣어줌