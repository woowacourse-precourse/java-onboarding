# 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

### 1. pobi와 crong의 페이지가 예외사항에 포함된것이 있는지 검사합니다.
#### validatePobi(List<Integer> pobi)  -->  boolean
-  입력 중 조건에 맞지 않는 입력이 있을 수 있기에 firstPage, secondPage가 조건에 맞는지 검사합니다. 조건에 맞으면 true를 맞지 않으면 false를 반환합니다.
   예외 사항은 아래와 같습니다.
- firstPage은 홀수, secondPage는 짝수여야 합니다.
- firstPage, secondPage 간의 차는 1이어야 합니다.
- firstPage가 1페이지거나 secondPage가 400페이지면 안됩니다.

#### validateCrong(List<Integer> crong)  -->  boolean
-  입력 중 조건에 맞지 않는 입력이 있을 수 있기에 firstPage, secondPage가 조건에 맞는지 검사합니다. 조건에 맞으면 true를 맞지 않으면 false를 반환합니다.
   예외 사항은 아래와 같습니다.
- firstPage은 홀수, secondPage는 짝수여야 합니다.
- firstPage, secondPage 간의 차는 1이어야 합니다.
- firstPage가 1페이지거나 secondPage가 400페이지면 안됩니다.


### 2. 두 페이지를 입력받아 각 페이지의 자릿수의 합과 곱중 큰값을 구한 다음 두 페이지의 값중 더 큰값을 반환
#### findMaxValue(int firstPage, int secondPage) --> int maxValue  
- firstPage와 secondPage를 calculate() 메소드에 넣은 뒤 반환 된 값을 비교해 큰 값을 반환합니다.
- 반환된 값이 최종 점수입니다.
 

### 3. 2번의 기능중 페이지를 입력받아 자릿수의 합과 곱중 큰값을 반환합니다.
#### calculate(int page) --> int max
- 입력받은 page의 각 자릿수의 합과 자릿수의 곱중 더 큰 값을 반환합니다.

### 4. pobi와 crong 중 승자를 찾아 반환합니다.
#### findWinner(List<Integer> pobi, List<Integer> crong) --> int
- pobi와 crong의 리스트를 validatePobi(), validateCrong()을 통해 예외사항이 있는지 검사하고 예외사항이 존재하면 -1을 반환하고 없으면 밑의 과정을 진행합니다.
- findMaxValue()를 통해 pobi의 페이지 최댓값과 crong 페이지 최댓값을 구합니다.
- pobi의 최댓값이 더 크면 1, crong의 최댓값이 더 크면 2, 같으면 0을 반환합니다.


# 전체 동작 과정
1. 입력받은 pobi의 n1, n2 crong의 n1, n2를 inputValidation()에 넣어 예외 사항을 검사합니다
2. 예외 사항에 걸리면 answer = -1, 통과한다면 maxValue()를 실행합니다.
3. pobi와 crong의 최댓값을 얻은 뒤 pobi가 크면 answer = 1, crong이 크면 answer = 2, 동일하다면 answer = 0을 넣고 answer를 반환합니다.
