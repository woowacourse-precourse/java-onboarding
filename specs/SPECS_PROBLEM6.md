# [우테코5기 프리코스] 문제6번 문제풀이
## 개요
본 문서는 [우테코 5기 프리코스 1주차 문제 6번의 기능 요구사항 기술서](https://github.com/DevJay1024/java-onboarding/blob/main/docs/PROBLEM6.md)를 분석하여 기능의 구현방법을 상세히 작성한 문서입니다.


## 목차
* [개요](#개요)
* [목차](#목차)
* [요구사항 및 제한사항 분석](#요구사항-및-제한사항-분석)
    + [길어지는 용어의 정리](#길어지는-용어의-정리)
    + [요구사항](#요구사항)
    + [최초 입력](#최초-입력)
    + [최종 결과](#최종-결과)
    + [세부 기능 소요](#세부-기능-소요)
    + [예외처리가 필요한 경우](#예외처리가-필요한-경우)
* [기능 구현방법 설계](#기능-구현방법-설계)
    + [메소드](#메소드)
    + [테스트 케이스](#테스트-케이스)


## 요구사항 및 제한사항 분석
### 길어지는 용어의 정리
- forms(교육생들의 이메일과 닉네임 리스트)의 index : id

### 요구사항
헷갈리는 닉네임을 신청한 지원자의 이메일 목록을 return 하도록 solution 메서드의 완성
- 헷갈리는 닉네임: 닉네임 중에서 같은 글자가 두 글자 이상 연속적으로 순서에 맞추어 포함되는 경우

### 최초 입력
- List<List<String>> forms
    - [ ["email", "nickname"], ["email", "nickname"], ... ]
    - forms의 길이는 1 이상 10,000 이하이다.
    - "email"은 이메일 형식에 부합하며, `email.com` 도메인이고, 전체 길이는 11자 이상 20자 미만이다.
    - "nickname"은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.

### 최종 결과
- List<String>
    - 이메일 문자열이 중복 없이 오름차순으로 정렬된 리스트

### 세부 기능 소요
1. 주어진 닉네임에 대해 연속된 두 글자의 문자열 부분집합을 생성하는 기능
   - 두 글자가 겹치면 세 개 이상의 글자도 당연히 겹치므로, 두 글자만 확인한다
2. 기능#1을 실행해, 모든 닉네임에 대해 헷갈리는 닉네임이면 해당되는 신청자들의 id를 Set<Integer>에 저장하여 반환하는 기능
   - 닉네임이 1글자인 경우에는 다음 닉네임으로 넘어간다.
   - 기능#1을 실행해 닉네임 부분집합을 생성하여 `Map<String, Integer>`에 저장한다.
   - Map의 String은 `닉네임에서 연속된 두 글자 이상의 문자`이며, Integer는 `id`이다.
   - 저장하려는 부분집합이 이미 저장된 경우에는 Set에 id를 저장한다. 
     - Set에는 `Map에 이미 저장된 엔트리에 들어있는 id`와 `저장하려는 부분집합이 만들어진 닉네임의 id`를 저장한다.
     - Java의 Set은 중복 원소 추가를 자동 방지한다.
3. 기능#2를 실행해 그 결과(헷갈리는 닉네임을 신청한 교육생의 id Set)가 주어지면, 이에 따른 오름차순 이메일 리스트를 만드는 기능

### 예외처리가 필요한 경우
- (이메일) 또는 (이메일, 닉네임)이 동일한 경우 => 별도 식별값으로 구분 (입력 List의 인덱스로 대체)
- `email`은 모두 도메인이 `example.com`이며 이메일 형식에 맞게 길이가 제한되어 주어지므로, 유효 이메일 확인은 불필요할 것으로 예상됨
- `nickname`의 길이가 제한되어 있으며 한글로 한정되므로, 유효 닉네임 확인은 불필요할 것으로 예상


## 기능 구현방법 설계
### 메소드
1.`Set<String> makeContinuousSubSet(String)`
  - 역할: 기능1 (주어진 닉네임에 대해 연속된 두 글자의 문자열 부분집합을 생성)
  - 입력: String (교육생 한 명의 nickname)
  - 동작: 주어진 닉네임에서 두 글자 이상의 연속된 문자열로 구성된 부분집합 생성
  - 결과: Set<String> (동작 결과 생성된 문자열 집합)
2. `Set<Integer> makeIdSetByConfusingNickname(List<List<String>>)`
   - 역할: 기능2 (기능#1을 실행해, 모든 닉네임에 대해 헷갈리는 닉네임이면 해당되는 신청자들의 id를 Set<Integer>에 저장하여 반환)
   - 입력: List<List<String>> forms (전체 교육생의 이메일-닉네임 목록)
   - 동작:
     1. 모든 닉네임에 대해 메소드1이 만든 문자열 집합에 대해 반복
        1. 닉네임이 1글자인 경우에는 메소드1을 호출하지 않고, 다음 닉네임으로 넘어간다.
        2. 닉네임이 2글자 이상이어서 메소드1이 호출되면 그 결과값인 부분-문자열들을 받아서 반복
        3. 부분-문자열이 저장되지 않은 경우에는 Map<String, Integer>에 저장한다.
           1. (해당 부분-문자열, 부분-문자열의 원래 nickname의 id)의 원소 1개
        4. Map에 이미 저장된 경우에는 중복 닉네임 Set<Integer>에 저장한다.
           1. (Map에 이미 저장된 엔트리의 id)와 (저장하려는 부분집합이 만들어진 닉네임의 id) 원소 2개
     2. 반복이 끝나면, Set<Integer>을 반환한다.
   - 결과: Set<Integer> (헷갈릴 수 있는 닉네임을 신청한 교육생들의 id)
3. `List<String> solution(List<List<String>>)`
    - 역할: 기능3 (기능#2를 실행해 그에 따른 오름차순 이메일 리스트를 만듦)
    - 입력: List<List<String>> (전체 교육생의 이메일-닉네임 목록)
    - 동작:
      1. 메소드2를 실행해서 받은 Set<Integer>의 원소(id)에 해당되는 이메일들을 Set<String>으로 만들어 중복된 이메일을 제거한다.
      2. Set<String>의 원소(email)을 오름차순으로 정렬된 리스트로 만들어 반환한다.
    - 결과: List<String>: 이메일 문자열이 중복 없이 오름차순으로 정렬된 리스트

### 테스트 케이스

| case for | forms | result |
|---|---|---|
| 정상작동| [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |
| 닉네임 완전 중복 신청 | [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "엠제이"] ] | ["jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com"] |
| (예외처리) 이메일 중복 신청 | [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["munj@email.com", "문제이"], ["munj@email.com", "먼제이"] ] | ["jason@email.com", "jm@email.com", "munj@email.com"] |
| (예외처리) 이메일 & 닉네임 중복 신청 | [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["munk@email.com", "먼케이"], ["munk@email.com", "먼케이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com", "munk@email.com"] |