## 🚀 기능 요구 사항

포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다. 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다. 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 페이지 번호 게임의 규칙은 아래와 같다.

1. 책을 임의로 펼친다.
2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.

포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

### 제한사항

- pobi와 crong의 길이는 2이다.
- pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

### 실행 결과 예시

| pobi | crong | result |
| --- | --- | --- |
| [97, 98] | [197, 198] | 0 |
| [131, 132] | [211, 212] | 1 |
| [99, 102] | [211, 212] | -1 |

---

## 구현 기능 목록

- (1) 페이지 번호의 각 자리 숫자를 더하는 기능

  ```java
  public static int getAddDigitsResult(int pageNumber)
  ```
- (2) 페이지 번호의 각 자리 숫자를 곱하는 기능

  ```java
  public static int getMultiplyDigitsResult(int pageNumber)
  ```

- (3) 왼쪽 페이지 큰 수 구하는 기능

  ```java
  public static int getLeftPageMaximum(List<Integer> pageList)
  ```

  - 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱한 수 중 큰 값 반환

- (4) 오른쪽 페이지 큰 수 구하는 기능

  ```java
  public static int getRightPageMaximum(List<Integer> pageList)
  ```

  - 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱한 수 중 큰 값 반환

- (5) 본인의 점수를 결정 하는 기능

  ```java
  public static int getScore(List<Integer> pageList)
  ```

  - 왼쪽, 오른쪽 페이지 수 중 가장 큰 수를 본인의 점수로 반환

- (6) 게임 결과를 얻는 기능

  ```java
  public static int getGameResult(List<Integer> pobi, List<Integer> crong)
  ```

  - pobi win : 1
  - crong win : 2
  - draw : 0
  - Exceptions : -1

- (7) 예외 처리 기능

  ```java
  public static boolean isWrongInput(List<Integer> user)
  ```

  - case1 : pobi, crong 각각의 길이가 2가 아닌 경우
  - case2 : pobi, crong 의 첫 번째 값이 홀수가 아닌 경우
  - case3 : pobi, crong 의 두 번째 값이 짝수가 아닌 경우
  - case4 : pobi, crong 의 (두 번째 원소 - 첫 번째 원소) != 1 인 경우
  - case5 : pobi, crong 이 값이 시작 면[1, 2] or 마지막 면[399, 400] 인 경우
  - case6 : pobi, crong 의 값이 범위(1 이상 400 이하)를 벗어난 경우
