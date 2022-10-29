## 기능 목록
### 구현에 사용한 규칙
* 구현 방법 참고
### 구현 방법
1. 두 개의 String을 비교해 같은 글자가 연속적으로 포함되는지 확인하는 checkSame 메서드 생성
2. 주어진 forms를 Map 구조로 바꿔 반환하는 changeToMap 메서드 생성
3. 주어진 forms에서 닉네임만 따로 추출해 리스트로 반환하는 extractNickname 메서드 생성
4. 닉네임 리스트를 돌며 checkSame메서드를 사용해 특정 닉네임에 중복이 있나 확인하는 checkID 메서드 생성
5. checkID를 사용해 중복 닉네임 리스트를 만들어 리턴하는 findSameNickname 메서드 생성
6. 중복 닉네임 리스트로 changeToMap에서 반환한  Map 에서 해당 닉네임에 해당하는 이메일 리턴하는 findEmail 메서드 생성
7. solution 메서드에서 findEmail 메서드를 사용해 이메일 리스트 반환
### 구현 메서드 상세
#### boolean checkSame 메서드
1. <매개변수>\
   (String) 비교 필요 닉네임 nickname1\
   (String) 비교 대상 닉네임 nickname2
2. <변수>\
   (String) nickname1 에서 2개씩 가져와 임시로 담기 위한 문자열 변수 temp
3. <구현>\
temp에 nickname1을 연속적으로 2개씩 잘라 넣으며 nickname2에 있는지 확인\
있으면 true, 없으면 false 반환
#### Map changeToMap 메서드
1. <매개변수>\
   (입력값) forms
2. <변수>\
   (Map) 변환한 Map을 담을 nickname_email_map
3. <구현>\
Stream을 통해 닉네임을 key로, 이메일을 value로 갖는 Map 만들어 반환\
(!!check 사항: 닉네임이 동일한 경우는??)\
**-> (추가) 동일하면 오류 발생.  Map 에서 List 로 변경**
#### List extractNickname 메서드
1. <매개변수>\
   (입력값) forms
2. <변수>\
   (ArrayList) 닉네임을 담을 nickname_list
3. <구현>\
Stream을 통해 닉네임만 추출해 리스트에 담아 반환한다
#### boolean checkID 메서드
1. <매개변수>\
   (String) 비교 필요한 닉네임 nickname\
   (ArrayList) extractNickname 통해 반환된 nickname_list
2. <변수>\
   없음
3. <구현>\
   **(추가) nickname_list에 나의 닉네임도 있으므로, 이런 경우 continue로 ckeckSame 건너뛰기**
   nickname_list를 돌며 checkSame을 사용해 nickname과 중복이 있는지 확인\
   중복 있으면 멈추고 true 리턴
#### List findSameNickname 메서드
1. <매개변수>\
   (ArrayList) extractNickname 통해 반환된 nickname_list
2. <변수>\
   (ArrayList) 중복 닉네임을 담을 same_nickname_list
3. <구현>\
   nickname_list에서 닉네임을 하나씩 꺼내기\
   checkID를 통해 리턴값이 true면 해당 닉네임 same_nickname_list에 저장
#### List findEmail 메서드
1. <매개변수>\
   (ArrayList) findSameNickname 통해 반환된 same_nickname_list
   (Map) changeToMap 통해 반환된 nickname_email_map
2. <변수>\
   (ArrayList)닉네임에 해당하는 이메일을 담을 email_list
3. <구현>\
   same_nickname_list에서 닉네임을 하나씩 꺼내기\
   닉네임을 키로 해 value값을 nickname_email_map에서 찾아 email_list에 넣어 반환
#### List solution 메서드
1. <매개변수>\
   (입력값) forms
2. <변수>\
   (Map) nickname_email_map\
   (ArrayList) nickname_list\
   (ArrayList) same_nickname_list\
   (ArrayList) findEmail의 반환값을 담을 email_list
3. <구현>\
   위 메서드 사용해 최종적으로 findEmail 메서드 호출해 email_list로 받기
   email_list 오름차순, 중복 제거해 최종 반환
## 🚀 기능 요구 사항

우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다. 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.

혼란을 막기 위해 크루들의 닉네임 중 **같은 글자가 연속적으로 포함** 될 경우 해당 닉네임 사용을 제한하려 한다. 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.


신청받은 닉네임 중 **같은 글자가 연속적으로 포함** 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.

### 제한사항

- 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
- 크루는 1명 이상 10,000명 이하이다.
- 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
- 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
- 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
- result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

### 실행 결과 예시

| forms | result |
| --- | --- |
| [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |
