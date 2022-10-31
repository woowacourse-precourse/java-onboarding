# refactor 해볼 것들

## validation

- 공통적으로 userInput이 Integer이던지, String이던지 크기나 길이 비교하는 코드가 유사하고 해야하는 행동이 비슷하다는 생각이 들어서 이를 하나의 interface로 다형성을 지원하기로 결정 - e1439eb
- 그렇게 작성한 validation의 경우 여러 곳에서 validation을 쓸 경우 무분별한 객체를 생성하는 문제를 야기 -> 싱글톤패턴을 이용하여 매번 새롭게 만드는 것이 아닌 한번 생성하고 난 뒤에는 그 객체를 불러서 사용하는 방식을 채택 - 0c0d268

## 공통 refactor 요소

- java convention, else 예약어 쓰지 않기, 변수 및 함수명 좀 더 구체화 시키기

### 1번 refactor 요소

- 상수를 쓰지 않기

### 2번 refactor 요소

- 알고리즘 자체가 너무 depth가 깊어서 줄여봐야할 것 같다.
- by using stack 리팩토리 겸 리메이크 해야할 듯 하다.
- logic : 
- 1.스택이 비어있다면 스택에 채운다.
- 2.스택에 원소가 있다면 지금 순회하고 있는 문자와 같은지 확인한다.
- 2-1.같으면 달라질때까지 찾고 달라지는 문자를 발견하면 스택에서 그 원소를 삭제한다.
- 2-2.만약 문자가 다르면 스택에 넣는다.
- 3. 최종적으로는 stack에서 빼며 StringBuilder에 추가하려 했으나...
----
이 과정속에서 stack을 사용하면 끝값부터 뺄 수 있어서 StringBuilder에 insert 메써드를 호출해야한다. 하지만 이는 append에 비해 시간복잡도의 손해를 보게된다. 그러므로 deque를 이용하여 압축을 하는 과정 속에서는 stack처럼, 최종적으로 string으로 만드는 작업은 queue처럼 이용할 것이다.

-----

- 새로운 문제에 도달 -> "assaa" -> "a"로 반환해줘야 한다.
- 기존의 로직은 ""로반환 해줬기에 변경해줘야 한다.
- 루프를 돌며 수정 전 String과 압축 후 String의 길이가 같아질때까지 압축하는 방식으로 변경

### 3번 refactor 요소

- 3, 6, 9를 상수니까 private static final로 선언하기!

### 4번 refactor 요소

- 알파벳 하드코딩 삭제(상수니까)

### 6번 refactor 요소

- Map에서 get할때 containsKey()로 바꾸기!

### 7번 refactor 요소

- 알고리즘을 단순히 할 수 있을 듯 하다.

#### 기존의 기능

- user + friends + visitors에 들어가있는 모든 유저의 아이디를 저장한다. --> A
- friends를 이용하여 친구관계를 저장한다. --> B
- B를 기준으로 함께아는 친구를 알아두기 위해 user의 친구를 저장한다. --> C
- A에서 C와 user 값을 제외한 result 후보값으로 저장한다. --> D
- D를 돌며 visitors * 1, 함께아는친구명수 * 10 한 결과값들을 저장해둔다. --> E
- E 의 상위값 5개를 반환한다.


#### 수정된 기능

- user + friends + visitors에 들어가있는 모든 유저의 아이디를 저장한다. --> A
- friends를 이용하여 친구관계를 저장한다. --> B
- A에서 C와 user 값을 제외한 추천 순위를 만든다 --> E
- E 의 상위값 5개를 반환한다.

- containsKey로 nullPointer참조 없애기!
