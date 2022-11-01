## ANSWER6

### solution
주어진 입력값을 차례로 순회하며 유효성 검사에 성공한 객체들을 정렬하여 반환하는 메소드
- verifyMemberList

### verifyMemberList
입력받은 회원가입 정보의 유효성을 검사하는 메소드
- verifyEmail : 입력된 이메일의 유효성을 검사하는 메소드
  - verifyEmailLength : 이메일 길이 : `11` 이상 `20` 미만
  - verifyEmailId : 이메일 아이디에 `중복값`에 대한 유효성 검사
  - verifyEmailDomain : 이메일의 도메인 : `email.com`
- verifyName : 입력된 회원 이름의 유효성을 검사하는 메소드
  - verifyNameLength : 회원 이름의 길이 : `1` 이상 `20`미만
  - verifyNameType : 회원 이름의 유형 : `영문자 소문자`

