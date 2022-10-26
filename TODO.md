# 우테코 프리코스 1주차 추가 요구사항 및 설계 정리
<hr>

## 설계 및 추가 사항, 구현된 기능은 체크됨


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

</details>


<details>

<summary>문제 2</summary>

[문제 2](./docs/PROBLEM2.md)

설계<br/>

- [x] TextDecoder는 String getCipher() 와 String getPlainText()로 원문과 해독된 평문을 반환한다.
- [x] TextDecoderV1 구현체는 문자열과 Stack 구조체를 사용하여 getPlainText()를 구현한다.

</details>


<details>

<summary>문제 3</summary>

[문제 3](./docs/PROBLEM3.md)

설계<br/>

- [x] ClapGame은 int getResult() 를 통해 결과를 반환하며 몇 번 박수를 쳤는지 나타낸다.
- [x] ClapGame의 구현체는 각자의 기준에 따라 박수를 치며, 이번 구현체는 3, 6, 9가 포함 된 만큼 박수를 치게 된다.

</details>


<details>

<summary>문제 4</summary>

[문제 4](./docs/PROBLEM4.md)

설계<br/>

- [ ] Frog는 String repeatAfter(String speak) 메소드를 통해 엄마 개구리의 말을 따라한다.
- [ ] Frog의 구현체 TreeFrog는 요구사항의 문제4의 규칙에 따라 알파벳을 변환하여 출력한다. 


</details>


<details>

<summary>문제 5</summary>

[문제 5](./docs/PROBLEM5.md)

설계<br/>


</details>


<details>

<summary>문제 6</summary>

[문제 6](./docs/PROBLEM6.md)

설계<br/>


</details>


<details>

<summary>문제 7</summary>

[문제 7](./docs/PROBLEM7.md)

설계<br/>


</details>