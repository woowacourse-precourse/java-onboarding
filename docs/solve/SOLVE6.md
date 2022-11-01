### 🚀 기능 목록

####  problem6 - solution()
[요구] 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return
- Map\<String, String> emailToNameMap: 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵
- makeEmailToNameMap(): emailToNameMap을 초기화하는 메서드
- Set\<String> emailSet: 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록
- makeEmailSetByDuplicatedName(): 
  - 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 이메일을 찾아 emailSet에 저장한다.
  - emailToNameMap.forEach((email, name) ->
    - for (int i = 0; i <= name.length() - 2; i++)
      - String word: 닉네임을 2글자씩 나눈 부분 닉네임
      - emailSet.addAll: emailSet과 합집합
      - emailToNameMap.entrySet().stream()
        - filter(e -> !Objects.equals(e.getKey(), email)): 이메일이 같으면 동일한 지원자이므로 제외
        - filter(e -> e.getValue().contains(word)): 같은 글자가 연속적으로 포함된 경우
        - map(Map.Entry::getKey).collect(Collectors.toSet()): Key인 이메일만 Set으로 생성
- sortListByAsc(): 이메일 목록 Set을 오름차순 정렬된 List로 변환 후 리턴 
