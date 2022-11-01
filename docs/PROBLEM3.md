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

### 기능목록

> **<기능 1><br>
number와 number의 자리수에 따라 쳐야할 박수의 횟수를 계산한다.**<br>
*private static int countClapNumber(int number, int digits)* <br>

> **<기능 2><br>
현재 게임의 수가 몇 자리인지 확인하다.**<br>
*private static int identifyDigits(int number)*

> **<기능 3><br>
자릿수의 숫자가 3,6,9중 하나라면 true를 반환한다.**<br>
*private static boolean isClap(int number)*
