# Solution: bunsung92

배달이가 좋아하는 369게임을 하고자 한다.
놀이법은 1부터 숫자를 하나씩 대면서,
3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 
3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 
1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
***

## `playGame(int number)` 사용
- what does means playGame
  - `number` 가 매개변수로 주어질 때 1 부터 `number` 까지 for 문 사용함.
  - for 문을 돌면서 현재 숫자가 손뼉을 치는지 확인 함.

## `countClap(int checkNum)` 사용
- what does means countClap
  - `checkNum` 가 매개변수로 주어질 때 각 자리수를 연산 함.
    - how?
    - 각 자리수를 연산하기 위해 while 문 사용.
    - checkNum % 10 을 통해 마지막 자리수의 값을 구함.
    - 연산된 값이 3,6,9 이면 손뼉치는 횟수 증가.
    - while 문 종료전 checkNum /= 10 을 통해 다음 자리수로 이동.

### Commit
- [x] feat: add play game method
- [x] feat: add count clap method
- [x] refactor: refactor magic number
