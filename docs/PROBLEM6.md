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

### 구현 기능 목록
1. 신청폼 리스트(forms)를 List<Form>로 변환하는 기능
    - Form은 한 신청폼의 정보(닉네임, 이메일)를 저장하는 VO 객체이다.
    - Form 객체에서 2번 기능을 제공한다.
2. 하나의 닉네임을 이루는 모든 연속된 2글자 문자열을 구하는 기능
	- Form 클래스에서 구현
    - HashSet getAllUsedTwoWordsByNickname()
    - Form객체에서 이 기능을 제공하므로 파라미터 없이 this.nickname으로 닉네임 정보를 획득한다.
    - 동일한 문자열이 여러 번 사용될 수 있으므로 중복방지를 위해 HashSet을 사용한다.
3. 신청폼 전체에 존재하는 모든 연속된 2글자 문자열에 대해, 각각 해당되는 모든 폼을 저장하고 있는 자료구조를 생성하는 기능
    - FormValidator 클래스에 usedTwoWordsInfo 필드를 정의
    - void initUsedTwoWordsInfo(List<Form> forms), void updateUsedTwoWordsInfo(Form form)
    - key: 2글자 문자열, value: 해당 문자열이 사용된 모든 신청폼 리스트
4. 특정 2글자 문자열이 여러 신청폼에서 사용됐는지 확인하는 기능
	- FormValidator 클래스에서 구현
    - usedTwoWordsInfo의 value에 담긴 list의 size가 1 이상인 경우를 확인한다.
5. 여러 신청폼에 사용된 2글자 문자열을 가진 신청폼을 구하는 기능
	- FormValidator 클래스에서 구현
	- void setInvalidForms(), Set<Form> getInvalidForms()
    - usedTwoWordsInfo의 value값을 이용해 해당하는 Form객체를 HashSet에 저장해 반환하는 기능
    - 동일한 폼이 여러 번 저장될 수 있으므로 중복방지를 위해 HashSet을 사용한다.
6. 5번에 해당하는 크루의 이메일 목록을 오름차순으로 정렬하는 기능
	-solution 메소드에서 구현
	- 5번을 반환받아 Form 객체에서 email 값을 꺼내 정렬가능한 리스트에 담는다.