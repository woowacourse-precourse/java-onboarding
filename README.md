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

2. 각 사용자의 왼쪽, 오른쪽 페이지 번호를 더한 후 더 큰 숫자를 구한다.
3. 각 사용자의 왼쪽, 오른쪽 페이지 번호를 곱한 후 더 큰 숫자를 구한다. 
4. 각 사용자의 2번 결과 값과 3번 결과값 중 더 큰 숫자를 점수로 한다.
5. 각 사용자의 점수를 비교해 더 큰 숫자가 나온 사용자를 반환한다. 
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

