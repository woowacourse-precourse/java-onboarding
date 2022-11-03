# [Problem 3](https://www.notion.so/3-256d114c566c41059bf2087c8a2b0d64) 기능별 명세

## 1. public static int countClapsPerANumber(int number){}
### input
- **int number** : 손뼉쳐야 할 횟수를 구하고자 하는 수.

### output
- **(int)** number에 대해 쳐야 할 손뼉 횟수.

### 기능 상세
파라미터로 하나의 정수(int 타입) number를 넘겨 받은 후, number에 대하여 손뼉을 쳐야 할 횟수를 구하는 기능을 합니다.
number의 각 자릿수를 하나씩 구하고, 그 값이 3, 6, 9 중 하나라면 count를 1씩 증가시켜 리턴합니다.

## 2. public static int getGameResult(int number) {}
### input
- **int number** : 369 게임 마지막 수. 1부터 number까지 369 게임을 진행합니다.

### output
- **(int)** 1부터 number까지 369 게임이 진행되는 동안 쳐야 하는 손뼉 횟수.

### 기능 상세
파라미터로 주어진 number 값으로 369 게임을 진행하는 기능을 합니다.</br>
i를 1부터 number까지 증가시키며 countClapsPerANumber()를 호출합니다. 그리고 이 메소드의 모든 리턴 값을 count에 누적하여 반환합니다.