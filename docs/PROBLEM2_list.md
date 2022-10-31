##🚀 기능목록

1. 예외사항
   1. 길이가 1미만, 1001초과한 경우
   2. 알파벳 소문자가 아닌 경우


2. 중복 문자열 제거


3. 해독문 반환


#Refactor
1. 전체 Style 수정

2. 예외사항 처리 메소드(check)
   1. 메소드명 변경(check->isCheck)
   2. 반환타입 변경(String->void)
   3. 코드 수정

3. removeDuplication 메소드
   1. 메소드명 변경(removeDuplication->removeDupliLetter)
   2. 반환타입 변경(String->StringBuilder)
   3. String형 변수 str 삭제
   4. StringBuilder형 변수 sb 이동(->solution 메소드)
   5. Stack<>형 변수 st 변수명 변경(st->removeDupliLetter)

4. solution 메소드
   1. StringBuilder형 변수 sb 생성
   2. 코드 수정