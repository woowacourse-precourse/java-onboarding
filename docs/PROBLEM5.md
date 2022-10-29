## 🚀 기능 요구 사항

계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.

돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.

### 제한사항

- money는 1 이상 1,000,000 이하인 자연수이다.

### 실행 결과 예시

| money | result |
| --- | --- |
| 50237	| [1, 0, 0, 0, 0, 2, 0, 3, 7] |
| 15000	| [0, 1, 1, 0, 0, 0, 0, 0, 0] |

# 개발 기록

## 기능 목록

개요
1. 두 숫자 A와 B를 입력하면 A를 B로 나눠서 몫을 반환하는 기능
    - 나눗셈을 할 때 에러 처리가 필요하다.
2. 두 숫자 A와 B를 입력하면 A를 B로 나눈 나머지를 반환하는 기능
   - 나눗셈을 할 때 에러 처리가 필요하다.
3. 리스트를 입력하면 내림차순 정렬해서 반환하는 기능
4. 현금 단위와 돈 액수를 입력하면 금액이 큰 순서대로 각각의 현금 단위가 몇 개 필요한지 세서 리스트에 담아 반환하는 기능

### 1. public int divideNumberAByNumberB(int numberA, int numberB)
- 숫자 A와 숫자 B를 입력받아 A를 B로 나눈 몫을 반환하는 메소드
- 기능 : numberA / numberB 연산을 수행 후 int 값을 반환한다.
   - ArithmeticException 예외를 throw한다.
  
### 2. public int moduloNumberAByNumberB(int numberA, int numberB)
- 숫자 A와 숫자 B를 입력받아 A를 B로 나눈 나머지를 반환하는 메소드
- 기능 : numberA % numberB 연산을 수행 후 int 값을 반환한다.
   - ArithmeticException 예외를 throw한다.

### 3. public List\<T> sortListDescendingOrder(List\<T> list)
- 리스트를 입력받으면 내림차순 정렬해서 반환하는 메소드

### 4. public List\<Integer> countEachDenominations(List\<Integer> denominations, int money)
- 현금 단위와 돈 액수를 입력하면 각각의 필요한 현금 단위를 세서 리스트에 담아 반환하는 메소드
- 기능 : 
  - 새로운 리스트를 생성한다.
  - 돈 액수를 내기 위해 각각의 현금 단위가 몇 개씩 필요한지 세서 리스트에 담는다.
  - 리스트를 반환한다.

## Test code
### 1. divideNumberAByNumberBTest()
- 숫자 A와 B를 입력하면 A를 B로 나눈 몫을 반환하는지 확인
- 숫자 B가 0이 아닌 경우
  - 테스트 : (5, 3) 정답 : 1
- 숫자 B가 0인 경우
  - 테스트 : (5, 0) 반환 : ArithmeticException

### 2. moduloNumberAByNumberBTest()
- 숫자 A와 B를 입력하면 A를 B로 나누고 남은 나머지를 반환하는지 확인
- 숫자 B가 0이 아닌 경우
    - 테스트 : (5, 3), 정답 : 2
- 숫자 B가 0인 경우
    - 테스트 : (5, 0), 반환 : ArithmeticException

### 3. sortListDescendingOrderTest()
- 리스트를 입력하면 내림차순으로 정렬해서 반환하는지 확인
- 테스트 : {1, 5, 3, 4, 2}, 정답 : {5, 4, 3, 2, 1}

### 4. countEachDenominationsTest()
- 돈 액수와 현금 단위 리스트를 입력하면 필요한 현금 단위의 개수를 세서 리스트로 반환하는지 확인
- 테스트 : (15000, {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}), 정답 : ({0, 1, 1, 0, 0, 0, 0, 0, 0})
