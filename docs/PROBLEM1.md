## 🚀 기능 요구 사항

포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다. 
책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다. 
책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 
페이지 번호 게임의 규칙은 아래와 같다.

1. 책을 임의로 펼친다.
2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.

포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 
포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

### 제한사항

- pobi와 crong의 길이는 2이다.
- pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

### 실행 결과 예시

| pobi | crong | result |
| --- | --- | --- |
| [97, 98] | [197, 198] | 0 |
| [131, 132] | [211, 212] | 1 |
| [99, 102] | [211, 212] | -1 |

### 기능목록

> **<공통기능><br>
두 수 중에 큰 값을 반환한다.**<br>
*private static int getMaxValue(int number1, int number2)*

> **<기능 1><br>
플레이어 둘 다 게임을 진행할 수 있는지 확인한다.**<br>
*private static boolean isValidGame(List<Integer> player1, List<Integer> player2)* <br>
> - 기능 1-1<br>
플레이어의 페이지가 게임을 할 수 있는지 판단한다.<br>
펼쳐진 페이지에서 양쪽 수의 차이가 1보다 크거나 펼쳐진 면이<br>
첫 번째 면 혹은 마지막 면이면 게임을 진행 할 수 없다.<br>
   *private static boolean isValidPage(List<Integer> player)*


> **<기능 2><br>
플레이어가 가진 페이지의 최대값을 반환한다.**<br>
*private static int getMaxPageValue(List<Integer> player)*
> - 기능 2-1<br>
한 페이지의 자릿수에 대한 덧셈과 곱셈 값의 최대값을 반환한다.<br>
*private static int getMaxValueOfPage(int page)*<br><br>
>   - 기능 2-1-1<br>
>   페이지가 몇 자리 수인지 파악한다.<br>
*private static int getMaxValueOfPage(int page)*<br><br>
>   - 기능 2-1-2<br>
>   페이지의 각 자릿수로 덧셈연산을 하고 결과를 반환한다.<br>
*private static int addByDigits(int page, int numberLength)*<br><br>
>   - 기능 2-1-3<br>
>   페이지의 각 자릿수로 곱셈연산을 하고 결과를 반환한다.<br>
*private static int productByDigits(int page, int numberLength)*<br><br>

> **<기능 3><br>
게임의 규칙대로, 플레이어의 값을 비교해 승자를 결정한다.**<br>
*private static int decideWinner(int player1Value, int player2Value)*




