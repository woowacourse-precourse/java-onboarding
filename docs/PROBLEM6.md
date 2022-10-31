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


<br>

---

## 기능 구현 목록

- checkException(List<List<String>> forms)
  - forms의 값에 대해 예외처리를 해준다.
- isValidCrewRange(List<List<String>> forms)
  - 올바른 크루원의 범위인지 확인해준다.
- isValidEmailLength(List<List<String>> forms)
  - 이메일의 길이가 유효 길이인지 확인해준다.
- isValidDomain(List<List<String>> forms)
  - 신청 가능한 이메일의 도메인인지 확인해준다.
- isValidNicknameRegex(List<List<String>> forms)
  - 닉네임이 한글로 이뤄져있는지 확인해준다.
- isValidNicknameLength(List<List<String>> forms)
  - 닉네임의 유효길이를 확인해준다.
- nicknameDecomposition(String nickname)
  - 인수로 들어온 닉네임을 2자씩 끊어서 Set<String> 에 넣는다.
- setUpData(List<List<String>> forms)
  - forms에서 닉네임을 꺼내서 분해하고 partsOfNicknameList에 채운다. 그리고 이를 바탕으로 nicknameAndCountMap 변수를 채운다.