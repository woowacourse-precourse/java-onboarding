# :pushpin: 각 문제별 기능 목록

## Problem1
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `GaneBoard` 클래스 : 게임을 진행하는 역할을 갖는다.
  > - `playtheGame(List<Integer> page1, List<Integer> page2)` : 페이지를 받아 게임을 진행한다.
  > - `calculateScore()`: 게임 룰에 따른 점수를 계산한다.
  > - `getWinner(int gamePlayer1Score, int gamePlayer2Score)`: 점수에 따라 승자를 가려 결과를 가린다.
  > - `getResult()`: 결과값을 반환한다.
  
- `GamePlayer` 클래스 : 게임 참가자의 역할을 갖으며 유효성 검사를 진행한다.
  > - `getPages()` : 페이지를 반환한다.

- `GameResults` enum: 게임 결과를 코드로 갖는 enum 값이다.
  
- `PageValidator` 클래스 : 유효성 검사를 실시한다.
  > - `getPlayer(List<Integer> pages)`: 페이지를 받아 GamePlayer를 반환한다.
  > - `validate(List<Integer> pages)`: 페이지에 대한 유효성 검사를 실시한다.
  > - `validatePageSize(List<Integer> pages)`: 페이지 사이즈에 대한 검사를 실시한다.
  > - `validateContinuousPage(Integer firstPage, Integer lastPage)`: 페이지가 연속적인지 검사한다.
  > - `validateIfFirstOrLastPage(Integer firstPage, Integer lastPage)`: 페이지가 첫페이지나 마지막 페이지인지 검사한다.
  > - `checkPageRange(Integer firstPage, Integer lastPage)`: 페이지 범위를 검사한다.
  > 
- `ScoreCalculator` 클래스 : 게임 룰에 따른 점수를 계산한다.
  > - `getGameScore(GamePlayer gamePlayer1)`: 게임 플레이어의 점수를 반환한다.
  > - `findGreaterOfSumAndProduct(int page)`: 페이지 자리수의 곱과 합 중 큰 것을 반환한다.

- `solution(List<Integer> pobi, List<Integer> crong)`: 게임 보드에서 게임을 실행한다.
</div>
</details>

## Problem2
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `characterStackToString(Stack<Character> stack)`: character형 stack을 string으로 변환해 반환한다.
- `solution(String cryptogram)`: 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 반환한다.
</div>
</details>

## Problem3
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `Game369` 클래스: 369 게임을 진행한다.
  > - `playTheGame(int number)`: 손뼉을 몇번 치는지 clapCount를 설정한다.
  > - `validate(int number)`: 숫자가 유효한지 검사한다.
  > - `isNotValidNumber(int number)`: 유효한 숫자가 아닌지를 판별한다.
  > - `countNumberThreeSixNine(int number)`: 3,6,9 숫자를 센다.
  > - `isThreeSixNine(int number)`: 일의 자리가 3, 6, 9 인지 판별한다
  > - `getClapCount()`: 손뼉 횟수를 반환한다.

- `ValidateNumber` enum: 유효한 숫자의 최댓값, 최솟값을 가진다.
- `solution(int number)`: 숫자 number가 매개변수로 주어질 때, 369 게임을 실행하고, 1부터 손뼉을 몇번 쳐야 하는지 횟수를 반환한다.
</div>
</details>

## Problem4
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `Alphabet` enum: 알파벳 A, Z, a, z를 가진다.
- `WordConverter` 클래스 : word를 사전에 맞게 변환한다.   
  > - `convertWord(String word)`: word를 convertWithDictionary 메서드를 통해 변환한다.
  > - `convertWithDictionary(char letter)`: char 변수 letter가 매개변수로 주어질 때, 청개구리 사전을 참고해 반대로 반환한 char 값을 반환한다.
 - `solution(String word)`: WordConverter 클래스를 이용해 word를 변환한다.
</div>
</details>

## Problem5
<details>
<summary><b>기능 목록</b></summary>
<div markdown="1">

- `Won` enum: won의 단위를 50,000원 부터 1원 까지 가진다.
- `MoneyChanger` 클래스 : 화폐단위에 맞게 거스름돈을 계산한다.
  > - `changeMoney(int money)`: 거스름돈을 변수 changedList에 저장한다.
  > - `getChangedList()`: changeList를 반환한다.
- `solution(int money)`: 돈의 액수 money가 매개변수로 주어질 때, MoneyChanger 클래스를 이용해 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇개로 변환되는지 금액이 큰 순서대로 리스트에 담아 반환한다.

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