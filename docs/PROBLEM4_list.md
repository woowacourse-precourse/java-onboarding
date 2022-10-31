##🚀 기능목록

1. 예외사항
    1. word의 길이가 1미만, 1001초과한 경우


2. 문자열 정돈(영문자 외 제거)


3. 변환 함수 구현


4. 변환 문자열 반환


#Refactor
1. 전체 Style 수정

2. 예외사항 처리 메소드(isCheck)
   코드 수정

3. changeWord 메소드
   1. 메소드명 변경(changeWord->wordChange)
   2. 매개변수 추가(HashMap<Character, Integer> wordValue)
   3. HashMap<>형 변수 wordValue 이동(->solution 메소드)
   4. String형 changeWord 변수명 변경(→wordChange)
   
4. solution 메소드
   1. String형 변수 answer 생성
   2. HashMap<Character, Integer>형 변수 wordValue 생성
   3. 코드 수정