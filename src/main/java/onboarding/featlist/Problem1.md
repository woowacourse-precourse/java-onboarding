# Problem-1

## Explanation
   - 좌, 우 페이지가 주어질 떄 승자를 구해 반환한다.

## Function
### Interface

### Class
1. `BookPage`
   - 좌, 우 페이지의 값을 가져온다.
   - 예외상황인지 확인한다.
2. `BookPageCalculator implements Calculator`
   - 페이지를 계산한다.

### Enum
1. `Page`
   - 좌, 우 페이지의 위치 정보를 저장한다.
2. `Winner`
   - 승자, 무승무, 예외 값을 저장한다.

### Method
1. `Integer calculation()`
   - 최대 수를 반환한다.
2. `boolean isValud()` 
    - 입력 페이지가 올바른지 확인한다.
3. `int maxSum()`
    - 최대 자릿수 덧셈을 구한다.
4. `int maxMultiply()`
    - 최대 자릿수 곱셈을 구한다.
5. `int sum()`
    - 자릿수 합 덧셈을 구한다.
6. `int multiply()`
   - 자릿수 합 덧셈을 구한다.
   
### Parameter
