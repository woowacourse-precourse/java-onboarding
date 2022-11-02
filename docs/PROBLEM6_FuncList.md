## 기능 목록
1. 리스트 안의 닉네임을 가져와서 2음절 단위로 나눈 후 비교한다.
    - boolean isDuplicateNicName(String name, String compare)
2. 중복문자가 존재 할 시 이메일을 중복없이 저장 후 정렬하여 리턴한다.
    - solution 내의 2중 for문 을 통하여 닉네임 추출 및 검증(1번)
    - sendEmailList 통하여 중복제거된 이메일 리스트를 정렬하여 반환.
3. 이메일 양식 및 길이 / 닉네임 양식 및 길이 예외처리
   - isEmailFormatArgumentException(forms) 
     - if(!checkNicName.matches()) 정규표헌식을 이용한 예외처리 
     - if(isNotNicNameSize(nicName)) length 를 활용하여 길이 제한
   - isNicNameFormatArgumentException(forms)
     - if(isNotEmailSize(email)) length 를 활용하여 길이 제한
     - if(!checkEmail.matches()) 졍규표현식을 이용한 예외처리