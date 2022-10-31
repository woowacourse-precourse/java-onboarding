# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.  

### 1. 자료구조로 deque을 사용
- 중복을 제거하는 방식으로 stack 구조에 입력받은 문자열을 하나씩 저장하며 stack의 peak와 저장 할 문자가 동일할 때 두 문자를 삭제하는 방식을 사용합니다.
- 이후 중복 제거가 끝난 문자열을 string으로 반환하기 위해서 stack에 저장된 문자들을 queue 구조처럼 앞에서 꺼내 answer 변수에 저장해야합니다.
- 따라서 stack, queue 구조가 둘 다 필요하기에 deque을 사용했습니다


### 2. 입력받은 문자열을 deque에 저장하며 중복을 제거
#### decoding(String cryptogram) --> Deque<Character> deque  
- 입력받은 cryptogram의 첫 문자를 deque에 저장합니다.
- 이후 저장되는 문자는 deque의 맨 위 요소와 같은지 비교하여 같다면 맨 위 요소를 지우고 해당 저장하려했던 문자도 생략합니다. deque의 맨 위 요소와 저장 할 요소가 같지 않을때까지 반복합니다.
- deque의 맨 위 요소와 저장 할 요소가 같지않다면 deque의 맨 위에 저장합니다.
- 

### 3. 중복이 제거된 deque을 문자열로 변환
#### dequeueToString(Deque<Character> deque) --> String convert;
- deque의 문자들을 앞에서부터 꺼내 convert에 넣어준 뒤 반환합니다.


# 전체 동작 과정
1. 입력받은 cryptogram을 decoding()에 넣어 연속된 중복 값을 제거합니다.
2. 연속 중복 값이 제거된 dequeue를 dequeueToString()을 통해 문자열로 변환한 뒤 answer에 넣어줍니다.
3. answer을 반환합니다.