### 🚀 기능 요구 사항

[문제1](../PROBLEM1.md)

<br>

## 📃 기능 목록

#### package onboarding

#### class Problem1

| return | Method                                              | Description                                                  |
| ------ | --------------------------------------------------- | ------------------------------------------------------------ |
| int    | solution(List\<Integer> pobi, List\<Integer> crong) | pobi가 승리할 경우 1을 리턴하고, crong이 승리할 경우 2를 리턴합니다. 만약 player1과 player2가 비길 경우 0을 리턴합니다. |

<br>

#### package service.problem1

#### class Problem1Service

| return  | Method                                                       | Description                                                  |
| ------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Integer | getWinner(List\<Integer> player1, List\<Integer> player2)    | player1이 승리할 경우 1을 리턴하고 player2가 승리할 경우 2를 리턴합니다. player1과 player2가 비길 경우 0을 리턴합니다. |
| Integer | isWinner(List\<Integer> player1pages, List\<Integer> player2pages) | 문제의 모든 제한 사항을 만족하는지 확인하며, 제한 사항이 있다면 true를 리턴합니다. |
| boolean | isRestrict(List\<Integer> player1pages, List\<Integer> player2pages) | 문제의 모든 제한 사항을 만족하는지 확인하며, 제한 사항이 있다면 true를 리턴합니다. |
| boolean | isWrongPageInputNumber(List\<Integer> player1pages, List\<Integer> player2pages) | 사용자들의 잘못된 입력을 판별하는 메소드입니다. 각 사용자들의 List입력값으로 첫 번째 인덱스 값이 짝수인 경우, 두 번째 인덱스가 홀수인 경우 true를 리턴합니다. 또한 각 사용자들의 List입력값을 받아서 첫 번째 인덱스에 1을 더한 값이 두 번째 인덱스와 다르다면 true를 리턴합니다. |
| boolean | isRestrictPage(List\<Integer> player1pages, List\<Integer> player2pages) | 문제에서 제한된 페이지를 판별하는 메소드로 음수 및 1, 2, 399, 400페이지라면 true를 반환합니다. |
