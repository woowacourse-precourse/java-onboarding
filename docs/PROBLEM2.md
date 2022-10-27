## 기능 목록
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
