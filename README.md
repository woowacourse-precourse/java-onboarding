# 미션 - 온보딩

## 기능 목록

### 문제 1

[문제 1 기능 요구 사항](./docs/PROBLEM1.md)

- 예외 상황 확인(정상적인 페이지인지 확인)
    - 주어진 페이지에 값이 있는지 확인
    - 주어진 페이지의 모든 값이 3 ~ 398 사이에 있는지 확인
      - 페이지의 전체 범위인 1 ~ 400 사이에 있는지 확인
      - 페이지의 첫 번째 면(1, 2), 마지막 면(399, 400)이 아닌지 확인
    - 페이지의 왼쪽 값이 오른쪽 값보다 `1`만큼 작은지 확인
    - 페이지의 왼쪽 값이 홀수인지 확인
    - 페이지의 오른쪽 값이 짝수인지 확인
- 페이지 점수를 구하는 기능
  - 페이지 번호의 각 자릿수를 더하고 곱한 값 중 가장 큰 값을 구하는 기능
- 본인의 점수를 구하는 기능
  - 왼쪽 페이지의 점수와 오른쪽 페이지의 점수 중 가장 큰 값을 구하는 기능
- 게임 결과를 구하는 기능

### 문제 2

[문제 2 기능 요구 사항](./docs/PROBLEM2.md)

- 암호문을 복호화한 문자를 문자열로 반환하는 기능
    - 암호문에서 연속하는 중복 문자를 찾는 기능
    - 암호문에서 연속하는 중복 문자라면 지우고, 아니라면 그대로 유지하는 기능
    - 해독한 암호문을 문자열로 반환하는 기능

### 문제 3

[문제 3 기능 요구 사항](./docs/PROBLEM3.md)

- 1부터 주어진 범위까지 반복하며 모든 박수의 횟수를 구하는 기능
- 주어진 숫자의 박수 횟수를 구하는 기능
  - 주어진 숫자의 박수 횟수를 이미 구했는지 확인하는 기능
  - 주어진 숫자가 박수를 쳐야 하는 숫자인지 확인하는 기능

### 문제 4

[문제 4 기능 요구 사항](./docs/PROBLEM4.md)

- 문자가 알파벳인지 확인하는 기능
  - 문자가 대문자인지 확인하는 기능
  - 문자가 소문자인지 확인하는 기능
- 주어진 문자열을 변환하는 기능
  - 문자를 변환하는 기능
  - 변환한 문자를 문자열로 반환하는 기능

### 문제 5

[문제 5 기능 요구 사항](./docs/PROBLEM5.md)

- 각 금액권이 몇 개 사용되었는지 구하는 기능

### 문제 6

[문제 6 기능 요구 사항](./docs/PROBLEM6.md)

- 해당 닉네임이 중복된 닉네임인지 확인하고 분류하는 기능
  - 해당 닉네임의 길이가 2자 이상인지 확인
  - 닉네임의 일부를 구하는 기능
  - 닉네임이 중복되었는지 확인
  - 중복된 이메일과 닉네임을 분류하는 기능
- 중복된 닉네임을 가진 이메일 목록을 구하는 기능
  - 이메일 목록에서 중복을 제거하는 기능
  - 이메일 목록을 오름차순으로 정렬하는 기능

### 문제 7

[문제 7 기능 요구 사항](./docs/PROBLEM7.md)

- 친구 관계를 구하는 기능
- 친구 추천 점수를 구하는 기능
  - 사용자와 함께 아는 친구의 수로 인한 점수를 구하는 기능
  - 사용자의 타임 라인에 방문한 횟수로 인한 점수를 구하는 기능
- 친구 추천 결과를 구하는 기능