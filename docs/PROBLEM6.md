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

## 📄 기능 정리

### 0. Class 설정

#### (1) SimilarNicknameCrewSelector class

##### <멤버 필드(변수, 상수)>

- private List< List< String> > crewInformations : 크루 정보 저장. (forms 내용)
- private int numberOfCrews : 크루 전체 인원 수
- private List< Boolean > hasSimilarNicknames : 크루 별 유사한 닉네임 갖고 있는지 여부 저장
- private List< String > similarNicknameCrewsEmail : 유사한 닉네임

##### <멤버 메소드>

- 생성자
    - crewInformations : form 내용 저장
    - numberOfCrews : forms.size()
    - hasSimilarNicknames : numberOfCrews 크기로 false 채우기
    - similarNicknameCrewsEmail : 빈 ArrayList 생성

- public List< String > makeSimilarNicknameCrewEmailList(List<List< String > > forms) : 최상위 메소드
- private void compareCrewsNickname(int comparingCrewIndex) : 닉네임 비교과정 수행
- private TreeSet< String > makeDividedNickname(int comparingCrewIndex) : 두 글자씩 분할된 닉네임 생성
- private boolean isSimilar(TreeSet< String > dividedNickname, int comparedCrewIndex) : 닉네임 비슷한지 판별
- private void listSimilarNicknameCrewsEmail() : 유사한 닉네임을 쓰고 있는 크루들의 이메일 리스트 생성



### 1. 전체 동작 과정

(1) makeSimilarNicknameCrewEmailList() 호출

(2) "int i = 0~크루 인원 수"까지 반복문 설정. 내부에서 compareCrewsNickname() 호출

(3) compareCrewsNickname() 수행

- makeDividedNickname() : 닉네임을 2글자씩 나누어 저장
- isSimilar() : 2글자가 포함되는지 여부 확인.

(4) 반복문 이후 listSimilarNicknameCrewsEmail() 호출

- hasSimilarNickname이 true로 설정된 크루들의 이메일 주소 similarNicknameCrewsEmail에 저장

(5) similarNicknameCrewsEmail 반환



### 2. 함수 별 동작 과정

- public List< String > makeSimilarNicknameCrewEmailList(List<List< String > > forms)
    -  "int i = 0~크루 인원 수" for문 설정
    - i번째 인덱스의 hasSimilarNickname 값이 true이면 continue, false이면 compareCrewsNickname() 호출
    - listSimilarNicknameCrewsEmail() 호출
        - hasSimilarNickname 값이 true로 설정되어 있는 크루들의 이메일 주소를 similarNicknameCrewsEmail에 저장
        - 정렬 수행
    - 반환 : List< String > similarNicknameCrewsEmail



- private void compareCrewsNickname(int comparingCrewIndex)
    - makeDividedNickname() 호출. comparingCrewIndex 크루의 닉네임이 두글자씩 분할된 TreeSet 생성 (= TreeSet< String > dividedNickname)
    - "int i = comparingCrewIndex~크루 인원 수" for문 설정
        - i번째 인덱스의 hasSimilarNickname 값이 true이면 continue, false이면 isSimilar() 호출
        - isSimilar() 결과에 따라 다음을 수행
            - true : comparingCrewIndex와 i 의 hasSimilarNickname 값을 true로 설정



- private TreeSet< String > makeDividedNickname(int comparingCrewIndex)
    - compairingCrewIndex의 닉네임을 순회하며 2글자씩 TreeSet에 추가(= TreeSet< String > dividedNickname)
    - 반환 : TreeSet< String > dividedNickname



- private boolean isSimilar(TreeSet< String > dividedNickname, int comparedCrewIndex)
    - dividedNickname을 순회하며 comapredCrewIndex의 닉네임에 포함되는지 확인
    - 반환
        - 포함될 경우 : true
        - 포함되지 않을 경우 : false



- private void listSimilarNicknameCrewsEmail()
    - hasSimilarNickname을 순회하며 true로 설정된 크루의 Email 주소를 similarNicknameCrewsEmail에 저장 후 정렬





------

## ✋ 예외 사항

- 1 <= forms.size() <= 10,000
- 11 <= forms.get(1).length < 20
- forms.get(1).contains("@email.com") == true
- Pattern.matches("^[ㄱ-ㅎ가-힣]*$", 닉네임);
- 11 <= 닉네임.length < 20

