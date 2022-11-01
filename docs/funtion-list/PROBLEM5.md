### 🚀 기능 요구 사항

[문제5](../PROBLEM5.md)

<br>

## 📃 기능 목록

#### package onboarding

#### class Problem5

| return                | Method              | Description                                                  |
| --------------------- | ------------------- | ------------------------------------------------------------ |
| static List\<Integer> | solution(int money) | 입력받는 money를 [문제5](../PROBLEM5.md)의 최소 잔돈 조건에 맞추어 List\<Integer>로 반환하는 메소드입니다. |

<br>

#### package service.problem5

#### public interface Problem5Serviceable

| return         | Method                | Description                                                  |
| -------------- | --------------------- | ------------------------------------------------------------ |
| List\<Integer> | getChanges(int money) | 입력받는 money를 [문제5](../PROBLEM5.md)의 최소 잔돈 조건에 맞추어 List\<Integer>로 반환하는 메소드입니다. |

| type  | field name | Description                                                  |
| ----- | ---------- | ------------------------------------------------------------ |
| int[] | CASH       | [문제5](../PROBLEM5.md)에 나와있는 잔돈조건이며, 상수로 초기화해주었습니다. |
| int[] | CHANGES    | [문제5](../PROBLEM5.md)의 최소 잔돈 조건에 맞추어 getChanges(int money)를 반환할 field입니다. 이 필드는 상수 CASH만큼의 크기를 가지며 초기값은 0입니다. |

<br>

#### package service.problem4

#### class Problem5ServiceImpl implements Problem5Serviceable

| return         | Method                | Description                                                  |
| -------------- | --------------------- | ------------------------------------------------------------ |
| List\<Integer> | getChanges(int money) | 입력받는 money를 [문제5](../PROBLEM5.md)의 최소 잔돈 조건에 맞추어 List\<Integer>로 반환하는 메소드입니다. |

