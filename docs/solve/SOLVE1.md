### 🚀 기능 목록

####  problem1 - solution()
[요구] 포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return
- Map<String, Integer> returnMenu
  - pobi: 1
  - crong: 2
  - draw: 0
  - exception: -1
- Person[] personList : name, leftPageNumber, rightPageNumber 를 생성자 인자로 갖는 Person 객체을 요소로 갖는 배열
- for (Person person : personList)
  - [예외처리] 페이지 번호
    - isOutRange(): 책의 범위 (0<=x<=400)를 벗어난 경우
    - isOddNumber(): 왼쪽페이지가 홀수가 아닌 경우
    - isEvenNumber(): 오른쪽페이지가 짝수가 아닌 경우
    - if (rightPageNumber-leftPageNumber != 1): 왼쪽 페이지와 오른쪽 페이지 차이가 1이 아닌 경우
  - [기능] 가장 큰 수 구하기 
    - getDigitList(): 페이지 번호 자릿수 구하기
      - int[] leftDegitList: 왼쪽 페이지 자릿수 배열
      - int[] rightDegitList: 오른쪽 페이지 자릿수 배열
    - getPlusScore(): 페이지 번호 자릿수 모두 더한 값
    - getMultiplyScore(): 페이지 번호 자릿수 모두 곱한 값
    - (1) int leftScore: 왼쪽 페이지 번호 자릿수 모두 더한 값, 모두 곱한 값 중 가장 큰 수 
    - (2) int rightScore: 오른쪽 페이지 번호 자릿수 모두 더한 값, 모두 곱한 값 중 가장 큰 수 
    - (3) person.setMaxScore(): (1)과 (2) 중 가장 큰 수를 본인 점수로 한다.
- [기능] 게임 승자 구하기
  - Person winner: 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
  - if (Stream.of(personList).filter(p->p.getMaxScore()==winner.getMaxScore()).count() > 1): 승자와 같은 점수를 가진 사람이 1명 이상이면 무승부 
scoreMenu.get(winner.getName()): pobi가 승자면 1, crong이 승자면 2를 리턴 
