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

### 기능 목록 작성해보기

- Validation
  - cryptogram 1~1000 이 맞는가 ?
  - 소문자로만 이루어져 있는가 ?
    - 대문자, 특수문자, 숫자...
  - 빈 문자열은 아닌가 ?
  - 모든 예외상황에 대해선 "" 리턴해준다.

- 필요 기능
  - stack에 순차적으로 cryptogram의 요소들을 넣어줄 때, peek() 값과 요소의 값이 같다면 pop()을 진행하고, 다르다면 push()를 진행해준다.
  - 3개 이상의 요소가 똑같을 때, 위와같은 방법만으로는 모두 제거해줄 수 없기에, 변수 `tmp` 를 통해서 이전에 pop() 된 값을 기억해둔다.
    - 다음 요소가 `tmp` 와 같다면, 넣지않는다.
    - 다음 요소가 `tmp` 와 다르다면, 값을 넣어주고 tmp 값을 요소가 가질 수 없는 값으로 바꿔준다.

- 테스트 케이스 추가하기