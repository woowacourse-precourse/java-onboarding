## 기능 목록
### 오류 발생
기존 작성한 방식은 문자가 홀수번 반복될 때 뒤에 1개를 삭제 못하는 오류가 있다.\
이에 따라 기능 목록을 다시 작성한다.
### 구현에 사용한 규칙
문자열을 검사해 중복있는 부분의 인덱스값을 [시작, 끝] 형태의 리스트로 찾고, 그 부분을 삭제한다.\
위 검사, 삭제를 반복하며 삭제할 값이 없으면 종료 후 반환
### 구현 방법
1. 2개의 포인터(앞,뒤)가 각각 0,1 부터 시작하며 아래 규칙에 따라 이동 및 삭제 범위 리스트를 만드는 ~~메서드 checkLetter 생성.~~\
   (수정) 기존 메서드로 생성하려 했으나, 과한 들여쓰기 사용으로 해당 부분을 CheckLetter 클래스 구현한 후 객체 생성을 통해 구현.
   1. 포인터가 가르키는 문자가 다를 때
      1. 포인터 뒤가 문자열 마지막 : 뒤 1증가.
      2. 두 포인터 차이가 1 : 둘 다 1 증가.
      3. 두 포인터 차이가 1 이상 : 뒤를 리스트에 저장, 뒤 1증가, 앞을 (뒤-1)로 이동
   2. 포인터가 가르키는 문자가 같을 때
      1. 포인터 뒤가 문자열 마지막 : 뒤 1증가, 뒤를 리스트에 저장.
      2. 두 포인터 차이가 1 : 앞을 리스트에 저장, 뒤 1증가
      3. 두 포인터 차이가 1 이상 : 뒤만 1 증가
2. (추가)CheckLetter객체를 통해 삭제 범위가 담긴 리스트 생성하는 메서드 makeRemoveRange 생성 
3. ~~checkLetter~~makeRemoveRange가 반환한 리스트의 범위에 해당하는 문자 삭제 후 반환하는 메서드 removeLetter 생성
4. 무한루프를 돌며 위 두 메서드 반복, checkLetter가 반환하는 문자열이 빈문자열이면 루프 종료하도록 solution 메서드 생성
### 구현 클래스 상세
### class CheckLetter
1. <매개변수>\
   (String) 체크할 문자열 cryptogram
2. <변수>\
   (int) 포인터 앞 front\
   (int) 포인터 뒤 back\
   (List) 삭제할 인덱스 저장할 리스트 remove_range\
   (String) 체크할 문자열 cryptogram
3. <생성자 & 메서드>
#### (생성자) CheckLetter
1. <매개변수>\
   (String) 체크할 문자열 cryptogram
2. <변수>\
없음
3. <구현>\
cryptogram에 매개변수 값 넣기
#### boolean checkLoop
1. <매개변수>\
없음
2. <변수>\
없음
3. <구현>\
back이 끝까지 도달하면 false 반환
#### List getRemove_range
1. <매개변수>\
없음
2. <변수>\
없음
3. <구현>\
remove_range 반환
#### void workMismatch
1. <매개변수>\
없음
2. <변수>\
없음
3. <구현>\
구현 방법 중 포인터가 가르키는 문자가 다를 때의 작업
#### void workMath
1. <매개변수>\
없음
2. <변수>\
없음
3. <구현>\
구현 방법 중 포인터가 가르키는 문자가 같을 때의 작업
#### void letterCheck
1. <매개변수>\
없음
2. <변수>\
없음
3. <구현>\
workMismatch, workMatch를 사용해 단어 체크 밑 remove_range 업데이트
### 구현 메서드 상세
#### List makeRemoveRange
1. <매개변수>\
   (String) 체크할 문자열 cryptogram
2. <변수>\
   (CheckLetter) letterCheck 위해 checkletter 객체 생성
   (List) 삭제할 인덱스 저장할 리스트 remove_range
3. <구현>\
CheckLetter 클래스 활용해 remove_range 구해 반환.
#### String removeLetter
1. <매개변수>\
   (List) 삭제할 인덱스 범위가 있는 리스트 remove_range
   (String) 삭제할 문자열 cryptogram
2. <변수>\
   (StringBuilder) delete메서드 사용을 위해 cryptogram을 담을 removed_cryptogram
3. <구현>\
    remove_range 를 돌며 removed_cryptogram을 범위 삭제한 후 반환한다
#### String solution
1. <매개변수>\
   (입력값) (String) cryptogram
2. <변수>\
   (List) checkLetter가 반환할 리스트를 담을 remove_range\
   (String) removeLetter가 반환할 문자열을 담을 removed_cryptogram
3. <구현>\
while(true) 문을 돌면서 checkLetter, removeLetter 메서드를 반복 호출한다.\
remove_range 리스트가 빈 리스트가 되면 반복문 종료한다.
4. <점검 필요 사항>
   1. 무한루프를 사용하는데, 해당 방식 말고 다른 방식을 사용할 수 있을지 고민 필요하다.

# 오류 발생한 구현 방식 (사용 X)
### 구현 방법
1. 경우에 따라 문자를 제거하는 메서드 letterRemove 생성.
2. 제거 완료한 문자 및 제거 여부를 반환하는 메서드 letterCheck 생성.
3. solution 메서드에서 letterCheck 사용해 while loop 종료 판단.\
제거 완료시 while loop 종료, 최종 문자 리턴
### 구현 메서드 상세
1. letterCheck
    1. <매개변수>\
       (String) 제거 필요한 문자 crytogram (입력값)
    2. <변수>\
       (String) 문자 임시 저장 공간 temp1\
       (char) 문자 임시 저장 공간 temp2\
       (int) 삭제가 진행됐는지 확인하기 위한 변수 check_remove = 0\
       (String) 삭제된 crytogram을 저장할 변수 new_crytogram\
       (Object[]) check_remove와 new_crytogram을 동시에 반환하기 위한 리스트 check_result
    3. <구현>\
   crytogram의 첫 글자 temp1에 저장.\
   for문 돌며 crytogram의 두 번째 글자부터 하나씩 꺼냄.\
   꺼낸 글자 temp2에 저장.\
   temp1 == temp2 인 경우 temp2를 temp1에 붙이고 temp2는 초기화, check_remove = 1.\
   temp1 != temp2 인 경우 letterRemove 메서드 실행, 그 반환값 new_crytogram 에 더하기, temp1 은 temp2로 변경, temp2 초기화\
   check_result에 new_crytogram와 check_remove 담아 반환.
2. letterRemove
   1. <매개변수>\
      (String) letterCheck 메서드에서 주는 temp1
   2. <변수>\
   없음
   3. <구현>\
   temp1의 길이가 1이 아닌 경우 빈 문자열 반환.\
   temp1의 길이가 1인 경우 temp1 반환.
3. solution
    1. <매개변수>\
       (String) 제거 필요한 문자 crytogram (입력값)
    2. <변수>\
       (Object[]) letterCheck의 반환값을 받을 리스느 check_result
    3. <구현>\
       무한 루프를 돌며 letterCheck 실행, 반환값을 check_result로 받음.\
       cryptogram을 check_result[0]로 업데이트\
       check_result[1] == 0 이면 break/
       cryptogram 반환
   

## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
