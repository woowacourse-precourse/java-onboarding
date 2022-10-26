# 미션 - 온보딩

## ✅ 기능 목록


## PROBLEM1

### 작동 순서

```
1. 두 명의 사용자마다 왼쪽 페이지 번호와 오른쪽 페이지 번호를 입력받는다.
   - 만약 왼쪽 페이지 번호가 홀수가 아니라면 에러 
   - 만약 오른쪽 페이지 번호가 짝수가 아니라면 에러
   - 왼쪽 페이지 번호가 1 또는 2가 펼쳐지면 에러
   - 오른쪽 페이지 번호가 399 또는 400이 펼쳐지면 에러

2. 사용자의 왼쪽 페이지 번호를 다 더한다. 
3. 사용자의 왼쪽 페이지 번호를 다 곱한다. 
4. 2번과 3번 중 더 큰 숫자를 저장한다.
5. 사용자의 오른쪽 페이지 번호를 다 더한다. 
6. 사용자의 오른쪽 페이지 번호를 다 곱한다. 
7. 5번과 6번 중 더 큰 숫자를 저장한다.
8. 사용자의 저장된 결과값 중 더 큰 숫자를 점수로 한다.
10. 각 사용자의 점수를 비교해 더 큰 숫자가 나온 사용자를 반환한다. 
```

### 메서드 기능 목록

#### solution 메서드
- 게임이 진행되는 클래스

---

#### sumEachNumber

- 번호의 각 자리 숫자를 모두 더하는 메서드
- [x] 매개변수로 들어온 값(번호)을 모두 더한다. 

--- 

#### multEachNumber

- 번호의 각 자리 숫자를 모두 곱하는 메서드
- [x] 매개변수로 들어온 값(번호)을 모두 곱한다.

---

#### validateBiggerNumber

- 두 수를 비교해 더 큰 수를 반환하는 메서드
- [x] 매개변수로 들어온 두 수를 비교해서 큰 수 반환

---

#### saveUserBiggerPageNumber

- 사용자의 각 페이지 번호를 모두 더하고, 모두 곱한 값 중 큰 값을 저장하는 메서드
- [x] 사용자의 각 페이지 번호를 돌면서 모두 더한 값과 모두 곱한 값 중 큰 값을 저장

---

#### winnerUser

- 점수를 비교해 가장 높은 유저를 반환하는 메서드
- [x] 매개변수로 사용자들의 점수를 받고 비교한 후 더 큰 점수를 반환한다.

---

#### validatePageNumber
- 페이지 번호 검증 메서드
- [ ] 검증
    - 만약 왼쪽 페이지 번호가 홀수가 아니라면
    - 만약 오른쪽 페이지 번호가 짝수가 아니라면
    - 왼쪽 페이지 번호가 1 또는 2가 펼쳐지면
    - 오른쪽 페이지 번호가 399 또는 400이 펼쳐지면
    - -1 반환

---

#### isPageOdd
- 홀수인지 판단하는 메서드
- [x] 페이지가 홀수면 true 반환

----

#### isFirstPage
- 첫번째 페이지인지 판단하는 메서드
- [x] 페이지가 1 또는 2라면 true

----

#### isEndPage
- 마지막 페이지인지 판단하는 메서드
- [ ] 페이지가 399 또는 400이면 true