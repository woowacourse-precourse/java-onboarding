## 🚀 기능 요구 사항

우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다. 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.

혼란을 막기 위해 크루들의 닉네임 중 **같은 글자가 연속적으로 포함** 될 경우 해당 닉네임 사용을 제한하려 한다. 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고
한다.

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

---

## 문제 해결 전략

- naive하게 접근하면 닉네임의 모든 연속하는 2글자를 다른 모든 닉네임에 대해 비교하여 중복되는 닉네임을 찾을 수 있습니다.
- 모든 사용자에 대해 자신의 닉네임과 중복되는 부분이 있는 사용자에 대해 확인하며 이메일을 answer배열에 넣어 정렬하면 해결할 수 있습니다.

## 필요 기능 목록

- [ ] 닉네임이 중복되는 사용자가 있는지 확인합니다
- [ ] 중복되는 닉네임이 있는 시용자가 있다면 answer배열에 추가합니다.
- [ ] answer배열을 정렬 후 return합니다.

## 세부 구현 사항

- [ ] 전역변수로 boolean 타입의 duplicateUser배열을 선언합니다. 배열의 크기는 forms의 크기와 같으며 이 배열의 i번째가 true라면,forms의 i번째 사용자가 중복된 닉네임을 갖는다는
  의미입니다.
- [ ] void 타입의 checkDuplicate(List<List<Integer>> forms, List<Integer> form, int index) 메서드를 구현합니다
    - [ ] forms의 index + 1번째 부터 form의 원소를 비교합니다.
    - [ ] isDuplicateNickName(String formsNickName, String formNickName) 메서드를 구현합니다.
        - [ ] 닉네임이 같은지 비교하여 같다면, duplicateUser에 true로 표시해줍니다.
- [ ] void타입의 addDuplicateUser(List<String> answer) 메서드를 구현합니다.
    - [ ] duplicateUser배열에 true로 체크되어있는 user를 answer배열에 추가합니다.
- [ ] answer배열을 정렬하여 return합니다.
