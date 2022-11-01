### 🚀 기능 요구 사항

[문제2](../PROBLEM2.md)

<br>

## 📃 기능 목록

#### package onboarding

#### class Problem2

| return        | Method                      | Description                                                  |
| ------------- | --------------------------- | ------------------------------------------------------------ |
| static String | solution(String cryptogram) | 입력받는 cryptogram단어에서 양옆의 글자가 같은 경우 제거하고 String으로 출력하는 메소드입니다. |

<br>

#### package service.problem2

#### public interface Problem1Serviceable

| return | Method                           | Description                                                  |
| ------ | -------------------------------- | ------------------------------------------------------------ |
| String | getCryptogram(String cryptogram) | 입력받는 cryptogram단어에서 양옆의 글자가 같은 경우 제거하고 String으로 출력하는 메소드입니다. |

<br>

#### package service.problem2

#### class Problem2ServiceImpl implements Problem2Serviceable

| return | Method                           | Description                                                  |
| ------ | -------------------------------- | ------------------------------------------------------------ |
| String | getCryptogram(String cryptogram) | 입력받는 cryptogram단어에서 양옆의 글자가 같은 경우 제거하고 String으로 출력하는 메소드로 Problem1Serviceable 인터페이스의 구현체입니다. |

