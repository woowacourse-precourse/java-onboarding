PROBLEM 1
기능 목록
1. int showScore(List<Integer> pages) - 점수 표시: List<Integer>로 받은 페이지 번호를 String로 바꾼 후, 점수 계산 메소드를 이용해 계산한 점수를 표시한다.
2. int calScore(String str) - 점수 계산: String으로 표시된 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. int versusScore(List<Integer> pobi, List<Integer> crong) - 점수 비교: 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.

부가적인 요소 
예외 사항 : 페이지는 연속된 숫자여야 한다 != ex) (101, 110), 
          시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다 != ex) (1,2), (399, 400)


