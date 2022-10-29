## 기능 목록
1. 리스트 안의 닉네임을 가져와서 2음절 단위로 나눈 후 비교한다.
    - boolean isDuplicateNicName(String name, String compare)
2. 중복문자가 존재 할 시 이메일을 중복없이 저장 후 정렬하여 리턴한다.
    - solution 내의 2중 for문 을 통하여 닉네임 추출 및 검증(1번)
    -  sendEmailList 통하여 중복제거된 이메일 리스트를 정렬하여 반환.