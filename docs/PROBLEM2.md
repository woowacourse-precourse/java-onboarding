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
1. 문자열 cryptogram의 길이가 1인 경우 
   - 길이가 1인 문자열은 바로 출력
2. 연속된 문자를 중복 제거
   1. 마지막 삭제 원소를 초기화하는 기능 : ' ' 또는 마지막 삭제 원소로 초기화
   2. 변경된 새로운 문자를 반환하는 기능
3. 연속된 문자가 있는 경우 = 이전의 원소 또는 마지막 삭제 원소와 현재 원소가 같은 경우 
   1.결과 값이 비어있으면, (deque가 빈 경우) "" 출력, 아니면 string 출력 
   - 이전의 값과 현재의 값이 같은 경우 deque의 마지막 element를 삭제
4. deque 의 문자 값들을 string 으로 변환하는 기능

### 문제 접근 : 어떤 방법으로 string을 저장
- 마지막 원소 값을 확인하기 쉬운 stack
- stack의 연산은 synchronized 되어있어, 모든 연산에 동기화가 보장되면 동기화 비용이 계속 든다는 단점
- 메모리 소모량이 적은 경우 iterate 효율이 좋은 ArrayDeque 사용
- 스택의 잦은 사이즈 변동이 있는 경우 LinkedList 사용
- 이 문제에서는 ArrayDeque 를 사용했습니다.