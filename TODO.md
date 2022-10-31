# 우테코 프리코스 1주차 추가 요구사항 및 설계 정리

<hr>

## 설계 및 추가 사항, 구현된 기능은 체크됨

<span style="font-size:13pt"> 

<details>
<summary>문제 1</summary>

[문제 1](./docs/PROBLEM1.md)

추가 사항<br/>

- 제한사항으로 pobi와 crong의 길이는 항상 2이므로 null check를 하지 않아도 된다.(선택)
- 1부터 400페이지의 책을 주웠으나, 입력 제한사항에 값의 범위가 기재되지 않아 입력된 값이 400이상인지 판단해야한다.
- 왼쪽, 오른쪽 페이지가 순서대로 들어 왔지만 왼쪽, 오른쪽 값이 연속된 수 인지 제한이 없어 판단해야한다.

설계<br/>

- [x] PageGame은 int getResult() 를 통해 결과 2, 1, 0, -1을 반환한다.
- [x] PageScore는 int getScore()를 통해 참가자 개인의 점수를 반환하고 예외의 경우 -1로 처리한다.
- [x] PageValidator는 boolean isValid(List\<Integer> user)를 통해 입력값이 유효한지 판단한다.

</details><br/>


<details>

<summary>문제 2</summary>

[문제 2](./docs/PROBLEM2.md)

설계<br/>

- [x] TextDecoder는 String getCipher() 와 String getPlainText()로 원문과 해독된 평문을 반환한다.
- [x] TextDecoderV1 구현체는 문자열과 Stack 구조체를 사용하여 getPlainText()를 구현한다.

</details><br/>


<details>

<summary>문제 3</summary>

[문제 3](./docs/PROBLEM3.md)

설계<br/>

- [x] ClapGame은 int getResult() 를 통해 결과를 반환하며 몇 번 박수를 쳤는지 나타낸다.
- [x] ClapGame의 구현체는 각자의 기준에 따라 박수를 치며, 이번 구현체는 3, 6, 9가 포함 된 만큼 박수를 치게 된다.

</details><br/>


<details>

<summary>문제 4</summary>

[문제 4](./docs/PROBLEM4.md)

설계<br/>

- [x] 인터페이스 Frog는 String repeatAfter() 메소드를 통해 엄마 개구리의 말을 따라한다.
- [x] Frog의 구현체 청개구리 TreeFrog는 생성 시 엄마 개구리의 말을 저장한다.
- [x] TreeFrog는 요구사항의 문제4의 규칙에 따라 알파벳을 변환하여 출력한다.

</details><br/>


<details>

<summary>문제 5</summary>

[문제 5](./docs/PROBLEM5.md)

설계<br/>

- [x] 인터페이스 CurrencyExchanger는 List<Integer> exchange(int money) 메소드를 통해 최소 화폐의 갯수의 리스트를 반환한다.
- [x] CurrencyExchangerV1은 문제 규칙에 따라 최소 화폐의 갯수의 리스트를 exchange(int money)로 반환한다.

</details><br/>


<details>

<summary>문제 6</summary>

[문제 6](./docs/PROBLEM6.md)

설계<br/>

- [x] 인터페이스 Crew는 String getNickname(), getEmail()을 통해 크루원의 정보를 전달한다.
- [x] 인터페이스 CrewVailator는 boolean isValid(List<String> data)를 통해 입력된 정보가 유효한지 검사해준다.
- [x] 인터페이스 CrewFinder는 요구사항 조건에 맞는 List<String> result를 반환하는 findCrews(List<Crew>)를 가진다.

- [x] 문제 요구사항에 맞는 Crew의 구현체는 WooaCrew이다.
- [x] WooaCrew는 CrewValidator를 주입 받아 입력이 유효한지 판단한다.
- [x] CrewFinder의 구현체 DuplicateWarningCrewFinder는<br/>
  문제의 조건에 따라 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루의 이메일 리스트를 반환한다.

</details><br/>


<details>

<summary>문제 7</summary>

[문제 7](./docs/PROBLEM7.md)

설계<br/>

FriendSystem

- [x] void connectFriend(String userA, String userB): 입력된 두 친구들을 친구 상태로 연결
- [x] Set<String> getFriendsOf(String user): 해당 유저의 친구의 목록을 조회
- [x] List<String> getRecommendFriendsOf(String user, List<String> visitor): 해당 유저의 추천 목록 조회

</details>


</span>