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


---
## 📮 기능 구현

### 문제 분석
- 닉네임 에서 두글자 이상 반복되는 닉네임을 찾아야 한다. 
- 모든 닉네임을 두글자씩 끊어서 저장하며, 각각 저장된 횟수를 구할 경우, 닉네임 부분중복여부를 확인 가능할 것이다.
- `Map` 자료구조가 유용할 것으로 판단된다.
- 닉네임이 중복된 사람들의 이메일을 저장하여야 하며, 이때 이메일의 도메인은 email.com으로 제한되어야 한다.
- 중복된 닉네임을 가지는 크루들의 email을 담아 반환해야 한다

###  Field: 
- [x] `Map<String, Integer> repositoryOfPair` :각 사람들의 닉네임을 두글자씩 떼어, 사용된 횟수를 모두 저장하기위한 구조체

### Method
 - [x] `Set<String> pairCreator(String name)`: 닉네임을 구성하는 연속된 두글자 쌍을 Set에 담아 반환시키기 위한 메서드
 - [x] `void addPairToRepository(String name)` : `pariCreator(String name)` 을 호출. 생성된  두글자 이름쌍의 set을   `repositoryOfPair`에 이름쌍을 key값으로, 저장횟수를 value로 저장하는 메서드
 - [x] `Set<String> TransformDuplicatedPairSet()` : `repositoryOfPair`에 저장된 중복된 이름쌍을 검색하는 과정에서, 검색 속도를 개선하기 위해 중복된(이름쌍 횟수가 2이상) 이름쌍만 Set에 담아 반환하도록 하는 메서드
 - [x] `boolean isCorrectedDomain(String email)` : 이메일 도메인이 @email.com인 것을 판별하는 메서드
 - [x] `boolean hasDuplicatedPair(String name, Set<String> set)` : `name`에 대하여, `pairCreator(String name)`를 호출, 반환된 이름쌍으로 구성된 Set 중에, `Set<String> TransformDuplicatedPairSet()`에 포함된게 있는지 판별하는 메서드

### Logic
 1. `repositoryOfPair = new HashMap<>()` : 이름쌍 저장소 생성
 2. `form`의 닉네임들에 대하여, 각 닉네임마다 `void addPairToRepository(String name)`를 통해 저장소에 저장
 3. `Set<String> duplicatedPairs = TransformDuplicatedPairSet()` : 중복되지 않은 이름쌍들은 불필요 하므로(검색효율을 위하여) 차원 축소
 4. `Set<String> answer = new TreeSet<>()` 생성 : `answer` 에 담은 이메일은 오름차순 정렬되어야 하므로
 5. for each 문을 통해, `form` 자료들(이메일, 닉네임)을 읽어들임
    - `boolean hasDuplicatedPair(String name, Set<String> set)` 을 통하여 중복된 이름을 가지는지 판별
    - `boolean isCorrectedDomain(String email)` 을 통하여 올바른 도메인을 가지는지 판별
    - 중복된 닉네임을 가지며, 동시에 올바른 이메일 도메인을 가질 경우, 해당 이메일을 `answer`에 저장
 6. `answer` 반환