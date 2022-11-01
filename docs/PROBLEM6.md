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

- public List< String > makeSimilarNicknameCrewEmailList() : 최상위 메소드
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

- public List< String > makeSimilarNicknameCrewEmailList()
    -  "int i = 0~(크루 인원 수 - 1)" for문 설정
    - i번째 인덱스의 hasSimilarNickname 값이 true이면 continue, false이면 compareCrewsNickname() 호출
    - listSimilarNicknameCrewsEmail() 호출
        - hasSimilarNickname 값이 true로 설정되어 있는 크루들의 이메일 주소를 similarNicknameCrewsEmail에 저장
        - 정렬 수행
    - 반환 : List< String > similarNicknameCrewsEmail



- private void compareCrewsNickname(int comparingCrewIndex)
    - makeDividedNickname() 호출. comparingCrewIndex 크루의 닉네임이 두글자씩 분할된 TreeSet 생성 (= TreeSet< String > dividedNickname)
    - dividedNickname.isEmpty() == false 이면 아래 내용 수행
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



---

## ✏️ 새로 배운 내용



### 1. Set

- 중복 제거 기능을 활용하기 위해 Set 자료구조에 대해 알아보았다.
- Set은 **중복을 제거**해주는 자료구조이며, 인터페이스이다.
    - 구현 클래스는 대표적으로 **HashSet, TreeSet** 등이 있다.
- 저장 순서는 보장되지 않는다.
    - 데이터 조회에 iterator가 활용된다.
- add, iterator, size, remove, clear 등의 메소드는 Set 컬렉션에 의해 기본적으로 제공된다.

##### < HashSet >

- Hash Table 구조를 이용하는 HashMap을 이용하여 생성되는 Set이다.
    - 중복 Key가 제거되는 Map의 특성을 활용하여, Key를 Set 값으로, value에는 더미Object를 저장하는 방식으로 원소가 추가된다.
- 중복을 제거하며, 원소의 순서가 보장되지 않는다.
    - 삽입된 순서를 기억하고 싶을 경우, LinkedHashSet을 활용한다.
- 이에 따라 HashSet으로는 정렬이 어렵다. List로 변환 후 정렬하는 등의 다른 방안이 필요하다.
    - 중복 제거가 필요하고, 정렬된 상태가 필요할 경우 TreeSet을 쓰는게 좋다.
- 삽입과 삭제가 빈번하게 발생하는 경우에 활용하면 좋다고 한다.

##### < TreeSet >

- Tree 구조를 이용하는 TreeMap을 이용하여 생성되는 Set이다.
- 이진트리 구조가 이용되므로, 삽입과 삭제에 오랜 시간이 걸린다.
- 하지만 정렬된 상태로 저장된다는 것과 조회에 빠르다는 장점을 갖고 있다.
- 따라서 삽입과 삭제가 빈번하지 않고, 조회가 빈번하며 정렬된 상태가 필요할 때 활용하면 좋다.
- HashSet은 접해본 적이 있었지만 TreeSet은 처음 접해보았고, 본 문제에서는 TreeSet을 활용해 보았다.

```java
private TreeSet<String> makeDividedNickname(int comparingCrewIndex) {
		TreeSet<String> dividedNickname = new TreeSet<>();
		String nickname = crewInformations.get(comparingCrewIndex).get(1);

		if (nickname.length() > 1) {
			for (int i = 0; i < nickname.length() - 1; i++) {
				dividedNickname.add(nickname.substring(i, i + 2));
			}
		}

		return dividedNickname;
	}
```

- 본 문제에서는 간단히 활용해 보았지만, 후에 또 중복 제거 조건이 주어질 때 TreeSet도 고려 대상이 될 수 있을 것이다.

