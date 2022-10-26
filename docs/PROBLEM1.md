### ****📈****기능 요구사항

- [x]  최대값 도출 전 페이지 유효성 검사 필요 : `validatePage()`
- [x]  pobi, crong에 대해 각각 페이지 자리수 별로 더한 값 중 최대값 구하기 : `findSumMaximumValue()`
    - ex) (77,78) return 15
- [x]  pobi, crong에 대해 각각 페이지 자리수 별로 곱한 값 구하기 : `findMulMaxValue()`
    - ex) (77,78) return 56
- [x]  pobi, crong에 대해 각각 페이지 별 합, 곱 중 최대값 도출 : `findMaxValue()`
- [x]  승부 결과 반환

### 🫵승부 결과

- pobi승리 시 return 1
- crong 승리 시 return2
- 무승부 return 0
- 예외사항 return -1

### ✅예외사항

- [x]  주어진 페이지 값에 대한 유효성 검사 : `validatePage`
    - [x]  페이지의 시작 면과 마지막 면 : `validateStartOrLastPage`
        - 시작 면 : 책을 펴지 않은 상태 : (1, 2)
        - 마지막 면 : 책을 펴지 않고 뒷면인 상태: (399,400)
    - [x]  pobi, crong 의 0 index는 홀수 ,1 index는 짝수가 아닌 경우 : `checkOddEvenValidation`
    - [x]  주어진 페이지가 연속되지 않는 경우 : `checkSequenceValidation`