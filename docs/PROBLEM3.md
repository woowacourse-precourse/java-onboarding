## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |

### 기능 목록
- 주어진 한 자리수의 값이 3, 6, 9인지 확인하는 함수
  - input: 한 자리수 정수
  - return: 3, 6, 9의 값이라면 1, 아니면 0
```java
int checkSingleDigitNumber(int)
```

- 주어진 여러 자리수의 값에 3, 6, 9가 몇 개 들어있는지 확인하는 함수
  - return: 정수에 있는 3, 6, 9 개수
  - input: 정수
```java
int calcMultiDigitNumbers(int)
```

- 1부터 number까지의 3, 6, 9 개수를 구하는 함수
  - input: number
  - return: 1부터 number까지 손뼉을 쳐야하는 횟수
```java
int calcNumberOfClap(int)
```