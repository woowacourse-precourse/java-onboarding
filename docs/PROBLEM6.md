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
-------------
## 기능 목록
forms의 크기만큼 반복해 아래 로직들 수행
* 이름을 2글자씩 잘라 List에 저장
~~~
private static void sliceName(String name, ArrayList<String> slicedNameList)
~~~

* 자른 이름들의 수만큼 반복(제이, 이엠이면 2번 반복) 자른 이름으로 map의 value를 가져오고 아래 로직들 전부 실행
~~~
private static void checkDuplication(Set<String> answer, HashMap<String, String> duplicatedNameMap, String email, ArrayList<String> slicedNameList)
~~~

* map의 값(이메일)이 null이 아닐 때 중복이므로 Set에 이메일 저장
~~~
private static void isEmailNotNull(Set<String> answer, String email, String duplicatedEmail)
~~~

* map의 값(이메일)이 null일때 Map에 key = 이름, value = 이메일 저장
~~~
private static void isEmailNull(HashMap<String, String> duplicatedNameMap, String email, String duplicatedName, String duplicatedEmail)
~~~
