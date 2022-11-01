### 🚀 기능 요구 사항

[문제3](../PROBLEM3.md)

<br>

## 📃 기능 목록

#### package onboarding

#### class Problem3

| return     | Method               | Description                                                  |
| ---------- | -------------------- | ------------------------------------------------------------ |
| static int | solution(int number) | 입력받는 number이하의 숫자에서 3, 6, 9가 들어간 숫자의 개수를 구하는 메소드입니다. 만약, number 이하의 숫자 중에서 26의 경우는 숫자를 한 번 세어야하고, 33인 경우는 2번 세어야합니다. |

<br>

#### package service.problem3

#### public interface Problem3Serviceable

| return | Method                   | Description                                                  |
| ------ | ------------------------ | ------------------------------------------------------------ |
| int    | getClapCount(int number) | 입력받는 number이하의 숫자에서 3, 6, 9가 들어간 숫자의 개수를 구하는 메소드입니다. 만약, number 이하의 숫자 중에서 26의 경우는 숫자를 한 번 세어야하고, 33인 경우는 2번 세어야합니다. |

<br>

#### package service.problem3

#### class Problem3ServiceImpl implements Problem3Serviceable

| return | Method                   | Description                                                  |
| ------ | ------------------------ | ------------------------------------------------------------ |
| int    | getClapCount(int number) | 입력받는 number이하의 숫자에서 3, 6, 9가 들어간 숫자의 개수를 구하는 메소드입니다. 만약, number 이하의 숫자 중에서 26의 경우는 숫자를 한 번 세어야하고, 33인 경우는 2번 세어지는 메소드로 Problem3Serviceable의 구현체입니다. |

