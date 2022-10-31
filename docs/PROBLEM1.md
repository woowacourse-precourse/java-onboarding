# 🚀 기능 구현 목록
## Outter Class :
### RestricException
문제1 ~ 문제6까지 제한 사항에 대한 예외 처리를 위한 클래스
## Inner Class :
### Splitting
생성자에서 예외 처리 및 입력값들을 자리수별로 Split.
### SelfMax
자신의 최댓값을 구하는 클래스.
#### methods
1. 생성자 : 왼쪽 페이지와 오른쪽 페이지를 받아 각각의 덧셈, 곱셈의 결과를 저장.
2. findMaximum : 객체별 private 멤버 변수 maximumCandidates를 정렬하여 최댓값 반환.
### Winner
이긴 사람에 맞는 리턴값을 반환하는 클래스
#### methods
1. 생성자 : 포비와 크롱의 최댓값을 저장
2. findWinner : 포비와 크롱의 최댓값을 비교하여 결과 반환.
