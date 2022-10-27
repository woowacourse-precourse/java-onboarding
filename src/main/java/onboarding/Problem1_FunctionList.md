# 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

1. inputValidation(n1, n2)
   입력 중 조건에 맞지 않는 입력이 있을 수 있기에 n1, n2가 조건에 맞는지 검사합니다. 조건에 맞으면 true를 맞지 않으면 false를 반환합니다.
   예외 사항은 아래와 같습니다.
- n1은 홀수, n2는 짝수여야 합니다.
- n1, n2 간의 차는 1이어야 합니다.



2. maxValue(n1, n2)
   n1과 n2를 각각 charArray로 변환한 뒤 자릿수의 덧셈과 곱셈을 실행합니다.
   각각 n1과 n2의 덧셈과 곱셈 중 큰 수를 얻은 뒤 해당 두 수를 다시 비교하여 큰 수를 반환합니다.


# 전체 동작 과정
1. 입력받은 pobi의 n1, n2 crong의 n1, n2를 inputValidation()에 넣어 예외 사항을 검사합니다
2. 예외 사항에 걸리면 answer = -1, 통과한다면 maxValue()를 실행합니다.
3. pobi와 crong의 최댓값을 얻은 뒤 pobi가 크면 answer = 1, crong이 크면 answer = 2, 동일하다면 answer = 0을 넣고 answer를 반환합니다.
