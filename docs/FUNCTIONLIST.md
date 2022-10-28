# :pushpin: 각 문제별 기능 목록

## Problem1
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `getGameScore(List<Integer> pages)` : 책 페이지인 Integer형 List를 매개변수로 받아 게임 룰에 맞는 수를 반환한다.
- `findGreaterOfSumAndProduct(int number)` : number의 각 수를 곱한 수과 더한 수 중 더 큰 수를 반환한다.
- `solution(List<Integer> pobi, List<Integer> crong)` : 기능 요구사항을 구현 해 적절한 값을 반환한다.
</div>
</details>

## Problem2
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `String characterStackToString(Stack<Character> stack)`: character형 stack을 string으로 변환해 반환한다.
- `solution(String cryptogram)`: 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 반환한다.
</div>
</details>

## Problem3
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `solution(int number)`: 숫자 number가 매개변수로 주어질 때, 1부터 손뼉을 몇번 쳐야 하는지 횟수를 반환한다.
- `isThreeSixNine(int number)`: 숫자 number가 매개변수로 주어질 때, 1의 자리(10으로 나눈 나머지)가 3, 6, 9 중 하나 이면 true를, 그렇지 않으면 false를 반환한다.
</div>
</details>

## Problem4
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `solution(String word)`: 엄마 말씀 word가 매개변수로 주어질 때, 청개구리 사전을 참고해 반대로 반환하여 return 한다.
- `convertWithDictionary(char letter)`: char 변수 letter가 매개변수로 주어질 때, 청개구리 사전을 참고해 반대로 반환한 char 값을 반환한다.
</div>
</details>

## Problem5
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `solution(int money)`: 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇개로 변환되는지 금액이 큰 순서대로 리스트에 담아 반환한다.

</div>
</details>

## Problem6
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `solution(List<List<String>> forms)`: ["이메일", "닉네임"] 형식으로 신청 받은 form을 매개변수로 주어질 때, 신청 받은 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 반환한다.

</div>
</details>

## Problem 7
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `solution(String user, List<List<String>> friends, List<String> visitors)`:
  사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬해 
  최대 5명을 반환한다. 추천 점수가 0점인 경우 추천하지 않으며 추천 점수가 같은 경우 이름순으로 정렬 한다.
- `User` 클래스 : 아이디와 친구 목록, 추천 점수를 필드로 가진다
  > - `compareTo(User o)`: Comparable 인터페이스를 상속받아 implement한 메소드로 추천 점수가 가장 높은 순으로 정렬하며, 추천 점수가 같은 경우 이름순으로 정렬한다.
  > - `addOnePoint()`: User의 추천 점수를 1 증가 시킨다.
  > - `addTenPoint(int value)`: User의 추천 점수를 value 만큼 10 증가 시킨다.
- `ListGraph` 클래스 : 친구 목록을 담고 있는 클래스로 친구 간 연결에 대한 정보를 가진다.
  > - `getUser(User user)`: 특정 User를 반환한다.
  > - `put(User userA, User userB)`: userA와 userB의 친구 관계를 형성해 각 클래스의 친구 목록에 추가한다.
</div>
</details>