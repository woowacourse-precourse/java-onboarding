# [Problem 3](https://www.notion.so/3-256d114c566c41059bf2087c8a2b0d64) 기능별 명세

## 1. public static int countClapsPerANumber(int number){}
### input
- **int number** : 박수쳐야 할 횟수를 구하고자 하는 수.

### output
- **(int)** number에 대해 쳐야 할 박수 횟수.

### 기능 상세
파라미터로 하나의 정수(int 타입) number를 넘겨 받은 후, number에 대하여 박수를 쳐야 할 횟수를 구하는 기능을 합니다.
number의 각 자릿수를 하나씩 구하고, 그 값이 3, 6, 9 중 하나라면 count를 1씩 증가시켜 리턴합니다.