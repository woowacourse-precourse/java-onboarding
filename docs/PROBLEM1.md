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

## 개발 기록

### 기능 목록
#### 개요
1. public boolean checkException(List\<Integer> list)</br>
   1.1. public boolean checkPageNumberValidityException(List\<Integer> list)</br>
   1.2. public boolean checkOutOfRangeException(List\<Integer> list)</br>
   </br>
2. public List\<Integer> calculateEachDigitOfPageNumber(List\<Integer> list)</br>
   2.1 public List\<Integer> addEachDigitOfPageNumber(List\<Integer> list)</br>
   2.2 public List\<Integer> multiplyEachDigitOfPageNumber(List\<Integer> list)</br>
</br>
3. public int getMaxValue(List\<Integer> list)</br>
</br>
4. public int findWinner(List\<Integer> list)</br>

### 1. public boolean checkException(List\<Integer> list)
- 예외사항을 확인하는 메소드
- 기능 : 예외사항에 해당하면 `false`, 예외사항에 해당하지 않으면 `true` 를 return
- 예외사항 :
  - [99, 102]와 같이 왼쪽 페이지 번호, 오른쪽 페이지 번호의 차이가 1을 초과하는 경우
  - [100,101]과 같이 왼쪽 페이지 번호가 짝수이고 오른쪽 페이지 번호가 홀수인 경우
  - [101,100]과 같이 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 큰 경우
  - [1,2], [399,400]과 같이 책의 양 끝단을 펼친 경우
  - [-1,0], [401,402]와 같이 책의 범위를 초과한 경우

#### 하위 메소드
- #### 1.1 public boolean checkPageNumberValidityException(List\<Integer> list)
  - 기능 : (왼쪽 페이지 번호 % 2 == 1) && (오른쪽 페이지 번호 - 왼쪽 페이지 번호 == 1)
  - 처리 가능 예외 :
      - [99, 102]와 같이 왼쪽 페이지 번호, 오른쪽 페이지 번호의 차이가 1을 초과하는 경우
      - [100,101]과 같이 왼쪽 페이지 번호가 짝수이고 오른쪽 페이지 번호가 홀수인 경우
      - [101,100]과 같이 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 큰 경우
- #### 1.2 public boolean checkOutOfRangeException(List\<Integer> list)
    - 기능 : (왼쪽 페이지 번호 > 1) && (오른쪽 페이지 번호 < 400)
    - 처리 가능 예외 :
      - [1,2], [399,400]과 같이 책의 양 끝단을 펼친 경우
      - [-1,0], [401,402]와 같이 책의 범위를 초과한 경우

### 2. public List\<Integer> calculateEachDigitOfPageNumber(List\<Integer> list)
- 입력된 리스트 각 숫자의 자릿수에 대해 연산하는 메소드
- 필요한 연산의 종류
  - 각 자릿수의 덧셈
  - 각 자릿수의 곱셈
#### 하위 메소드
#### 2.1 public List\<Integer> addEachDigitOfPageNumber(List\<Integer> list)
- 기능 
  - 리스트가 입력되면 리스트 각 요소의 자릿수를 분리해서 더한다.
  - 자릿수의 대한 덧셈을 List\<Integer>에 저장해 반환한다.
#### 2.2 public List\<Integer> multiplyEachDigitOfPageNumber(List\<Integer> list)
- 기능
    - 리스트가 입력되면 리스트 각 요소의 자릿수를 분리해서 더한다.
    - 자릿수의 대한 덧셈을 List\<Integer>에 저장해 반환한다.

### 3. public int getMaxValue(List\<Integer> list)
- 입력된 리스트의 Max 값을 찾는 메소드
- 기능 : 리스트가 입력되면 리스트 요소 중 최댓값을 반환한다.

### 4. public int findWinner(List\<Integer> maxValues)
- 입력된 pobi, crong의 maxValues 리스트로 승부의 결과를 판단하고 result 값을 반환한다.
- 기능 
  - maxValues 리스트의 값을 비교하여 승부의 결과를 판단한다.
  - 승부 결과에 맞는 result 값을 반환한다.

### Test code

#### 1.1 void checkPageNumberInvalidExceptionTest()
- 예외 테스트 입력 시 `false` 반환 확인
  - 테스트 : [99, 102], [100,101], [101,100]
- 정상 테스트 입력 시 `true` 반환 확인
  - 테스트 : [99, 100], [101, 102]
#### 1.2 void checkOutOfRangeExceptionTest()
- 예외 테스트 입력 시 `false` 반환 확인
  - 테스트 : [1,2], [399,400], [-1,0], [401,402]
- 정상 테스트 입력 시 'true' 반환 확인
  - 테스트 : [3,4], [397, 398]
#### 1.3 void checkExceptionTest()
- 예외 테스트 입력 시 `false` 반환 확인
  - 테스트 : [99, 102], [100,101], [101,100], [1,2], [399,400], [-1,0], [401,402]

#### 2.1 void addEachDigitOfPageNumberTest()
- 테스트 입력 시 덧셈 값 리스트 반환 확인
  - 테스트 : [99, 100], [101, 102]
  - 정답 : [18,1], [2,3]
#### 2.2 void multiplyEachDigitOfPageNumberTest()
- 테스트 입력 시 곱셈 값 리스트 반환 확인
  - 테스트 : [99, 100], [101, 102]
  - 정답 : [81, 0], [0, 0]
#### 2.3 void calculateEachDigitOfPageNumberTest()
- 테스트 입력 시 덧셈 및 곱셈 값 리스트 반환 확인
  - 테스트 : [99, 100], [101, 102]
  - 정답 : [18, 1, 81, 0], [2, 3, 0, 0]

#### 3. void getMaxValueTest()
- 테스트 입력 시 Max 값 반환 확인
  - 테스트 : [1,2,4,7]
  - 정답 : 7

#### 4. void findWinnerTest()
- 테스트 입력 시 올바른 승부 결과 판단 확인
  - pobi 승리 테스트 : [7, 1], 정답 : 1
  - crong 승리 테스트 : [5, 6], 정답 : 2
  - 무승부 테스트 : [3, 3], 정답 : 0