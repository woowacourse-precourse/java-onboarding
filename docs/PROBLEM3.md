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

---

## 구현 기능 목록

- (1) int를 String로 변환하는 기능

  ```java
  private static String toString(int number)
  ```
- (2) 3, 6, 9 가 존재하면 손뼉을 한번 치는 기능

  ```java
  public static int hasThreeSixNine(String number, int length)
  ```
- (3) 문자열 길이 계산 기능

  ```java
  public static int getStringLength(String number)
  ```
- (4) 369게임 시작 기능

  ```java
  public static int runGame(int number)
  ```

  - (1), (2), (3) 기능을 이용해 369게임 시작
