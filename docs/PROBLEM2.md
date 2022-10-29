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

------------
### 기능 리스트업
1. 문자열 cryptogram의 길이가 1인 경우 바로 출력하는 기능
2. 문자열을 하나의 문자 배열로 쪼개는 기능
3. deque에 문자 원소를 넣는 기능
4. deque에 문자 원소를 삭제하는 기능
5. 연속하는 중복 문자가 있는 경우, 중복 문자를 삭제하는 함수
   1. 연속 문자를 확인하기 위한, 마지막에 제거된 문자를 초기화&저장하는 기능
   2. deque에 값을 넣어야 하는 경우 : index가 0이거나, deque가 비어있는 경우 
   3. 마지막으로 삭제한 중복 값과 현재의 값이 중복되는 경우 값을 입력하지 않는 기능
   4. 이전의 값과 현재의 값이 같은 경우 deque의 마지막 element를 삭제하는 기능 
   5. 마지막으로 삭제한 중복 값을 초기화하는 기능 
   6. 결과 값이 비어있는지 확인하는 기능 : deque가 빈 경우 "" 출력, 아니면 string 출력 
   7. deque의 문자 값들을 string으로 변환하는 기능

### 문제 접근 : 어떤 방법으로 string을 저장
- 마지막 원소 값을 확인하기 쉬운 stack
- stack의 연산은 synchronized 되어있어, 모든 연산에 동기화가 보장되면 동기화 비용이 계속 든다는 단점
- 메모리 소모량이 적은 경우 iterate 효율이 좋은 ArrayDeque 사용
- 스택의 잦은 사이즈 변동이 있는 경우 LinkedList 사용
- 이 문제에서는 ArrayDeque 를 사용했습니다.