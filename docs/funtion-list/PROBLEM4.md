### 🚀 기능 요구 사항

[문제4](../PROBLEM4.md)

<br>

## 📃 기능 목록

#### package onboarding

#### class Problem4

| return        | Method                | Description                                                  |
| ------------- | --------------------- | ------------------------------------------------------------ |
| static String | solution(String word) | 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 문자를 변형하고 변형되어진 메소드를 리턴합니다. |

<br>

#### package service.problem4

#### public interface Problem4Serviceable

| return | Method                                                 | Description                                                  |
| ------ | ------------------------------------------------------ | ------------------------------------------------------------ |
| String | getConvertSentence(String word)                        | 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 문자를 변형하고 변형되어진 메소드를 리턴합니다. |
| void   | convertUpperCase(List\<Character> charList, char word) | 대문자로 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 변형후, charList에 치환하여 저장합니다. |
| void   | convertLowerCase(List\<Character> charList, char word) | 소문자로 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 변형후, charList에 치환하여 저장합니다. |

<br>

#### package service.problem4

#### class Problem4ServiceImpl implements Problem4Serviceable

| return | Method                                                 | Description                                                  |
| ------ | ------------------------------------------------------ | ------------------------------------------------------------ |
| String | getConvertSentence(String word)                        | 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 문자를 변형하고 변형되어진 메소드를 리턴하며 Problem3Serviceable의 구현체입니다. |
| void   | convertUpperCase(List\<Character> charList, char word) | 대문자로 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 변형후, charList에 치환하여 저장하며 Problem3Serviceable의 구현체입니다. |
| void   | convertLowerCase(List\<Character> charList, char word) | 소문자로 입력받는 word를 [문제4](../PROBLEM4.md)의 치환조건에 맞추어 변형후, charList에 치환하여 저장하며 Problem3Serviceable의 구현체입니다. |

