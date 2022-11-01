기능 목록
---
1. 페이지의 각 숫자 자리를 더한 것과 곱한 것 중 큰 수 구하는 기능 (getLargerValue)

2. 왼쪽 페이지 점수와 오른쪽 페이지 점수 중 큰 값(= 사용자 점수) 구하는 기능 (getUserScore)

3. pobi와 crong의 점수 비교해 결과값 반환하는 기능 (solution)

검증 & 예외처리 목록
---
* 2페이지 입력 검증 (validateListSize)
  * ex) pobi = [97, 98, 99] -> 예외처리


* 페이지 범위 검증(1 ~ 400) (validatePageRange)
  * ex) pobi = [401, 402] -> 예외처리


* 인접한 페이지 검증 (validateAdjacentPage)
  * ex) pobi = [99, 102] -> 예외처리


* 왼쪽 페이지 홀수, 오른쪽 페이지 짝수 검증 (validateLeftPageOddAndRightPageEven) 
  * ex) pobi = [100, 101] -> 예외처리
