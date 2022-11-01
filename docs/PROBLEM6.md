# 🎈 민주

## ✔ 기능 정의
### 컬렉션
- { index : userEmail}의 userEmailMap
- { subString : 초기 index}인 subStrUserIndexMap 
  - 초기 index = 처음으로 해당 subString 값이 나온 닉네임에 해당하는 user의 index
- 중복 닉네임 가진 user의 index 값 넣는 duplicatedIndexList 

### 기능
- [X] forms를 활용하여, userEmailMap 초기화 (initUserEmailMap)
- [X] subStrUserIndexMap 초기화 (initSubStrUserIndexMap)
- [X] duplicatedIndexList 초기화 (initDuplicatedIndexList)
- [X] 각 user의 nickname을 활용해 duplicatedIndexList 값 추가 (modifyDuplicatedIndexList)
  - user의 nickname을 2자리씩 subString 처리
  - 해당 subStr을 키로 가지는 user가 이미 있으면
    - 그 user id값과, 해당 닉네임의 user id 값을 추가
  - 없으면
    - subStr에 해당 키로 값 초기화
- [X] duplicatedIndexList에서 중복 제거한 list 반환 (getDistinctIndexList)
- [X] indexList에 포함된 index를 가진 user의 email을 반환 (getSortedEmailListByIndex)
  - duplicatedIndexList에 있는 index의 user email을 저장 -> userEmailMap 활용
  - 해당 collection을 정렬


# 🎈 본문
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
