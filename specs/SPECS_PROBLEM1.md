# [우테코 5기 프리코스] 문제 1번 기능 명세서
## 개요
본 문서는 [우테코 5기 프리코스 1주차 문제 1번의 기능 요구사항 기술서](https://github.com/DevJay1024/java-onboarding/blob/main/docs/PROBLEM1.md)를 분석하여 기능의 요구사항을 상세히 작성한 문서입니다.

## 길어지는 용어의 정리
- 왼쪽 페이지 번호 : left
- 오른쪽 페이지 번호 : right

## 필요한 세부 기능 분석
[기능 요구사항 기술서](https://github.com/DevJay1024/java-onboarding/blob/main/docs/PROBLEM1.md)
아래의 각 기능은 기능 요구사항 기술서를 만족하기 위한 세부 기능 목록으로서, 해당 단위에 따른 커밋을 해야 한다.

1. 입력값이 유효하지 않은 입력인지 확인하는 기능
2. 주어진 정수의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 반환
3. 주어지는 List의 left, right에 대해 2번을 실행하고, 더 큰 수를 반환하는 기능
4. (1과 3을 실행하여) 상황에 맞는 결과값을 반환하는 기능
   1. 포비와 크롱에 대해 1번을 확인 하고 유효한 입력이 아니면 -1을 반환
   2. 3번의 결과를 비교하여 적절한 값 반환(무승부에 해당되면 0, 포비의 승리는 1, 크롱의 승리는 2를 반환)

## 최초 입력값
### 최초 입력값 형태
- 포비의 입력값은 pobi, 크롱의 입력값은 crong에 주어진다.
- pobi, crong은 길이가 2인 리스트/배열로서, [left, right]가 순서대로 들어있다.

### 유효하지 않은 경우
1. left가 홀수가 아닌 경우
2. right가 짝수가 아닌 경우
3. 페이지 번호가 책(1p~400p)의 범위를 벗어난 경우 중에서, 1 미만의 값을 갖는 경우
4. 페이지 번호가 책(1p~400p)의 범위를 벗어난 경우 중에서, 400 초과의 값을 갖는 경우
5. left와 right가 연속적인 값을 갖지 않은 경우
6. left가 right보다 큰 값을 갖는 경우
7. 주어진 페이지 번호가 시작 면을 의미하는 경우
8. 주어진 페이지 번호가 마지막 면을 의미하는 경우

## 최종 결과값
- 포비의 승리 : 1
- 크롱의 승리 : 2
- 무승부 : 0
- 예외사항(유효하지 않은 입력) : -1

## 메소드 상세 설계
- boolean isInvalidInput(List)
  - 동작: 주어진 리스트의 left, right 집합이 유효하지 않은 입력인지 확인
  - 결과: boolean(true: 유효하지 않음, false: 유효함)
- int calculatePageScore(int)
  - 동작: 주어진 정수의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 반환
  - 결과: int (모두 더하거나 모두 곱해 더 큰 값)
- int calculatePlayerScore(List)
  - 동작: 해당 리스트의 left, right에 대해 calculatePageScore()를 실행하고 더 큰 값을 반환
  - 결과: int (left와 right의 calculatePageScore()결과 값 중에서 더 큰 값)
- int solution(List, List)
  - 동작
    1. 포비와 크롱 리스트에 대해 isInvalidInput( )를 호출하고 true가 반환되면 -1을 반환
    2. 각 리스트에 대해 calculatePlayerScore()를 호출해서 비교한 뒤, 그 결과에 맞는 값 반환 
  - 결과: int (무승부 0, 포비 승리 1, 크롱 승리 2)
