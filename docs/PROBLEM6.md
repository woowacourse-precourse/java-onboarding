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

# 개발 기록

## 기능 목록

개요
1. 크루원의 이메일과 닉네임을 담은 객체
   - 이메일의 형식, 길이를 제한하는 기능
   - 닉네임의 언어, 길이를 제한하는 기능
2. 닉네임을 두 글자로 나눈 리스트를 반환하는 기능
3. 자신을 제외한 다른 크루원과 닉네임을 비교해 중복을 확인하는 기능
4. 닉네임이 중복되는 크루원의 객체 리스트를 반환하는 기능(단, 중복 제거)
5. 객체 리스트에서 이메일을 오름차순 정렬해서 반환하는 기능

### Class Crew
- Crew 클래스는 email과 nickname을 멤버변수로 갖는다.
- 생성자를 통해 email과 nickname을 초기화한다.
- 생성자 호출을 통해 email과 nickname을 초기화하기 전에, 각 멤버변수의 타당성을 검증한다.
#### 1. validateNicknameLanguage(String nickname)
- nickname의 언어가 한글인지 확인한다. 한글이 아닌 경우, IllegalArgumentException 을 발생시킨다. 
- 정규식을 활용한다.

#### 2. validateNicknameLength(String nickname)
- nickname의 길이가 1자 이상 20자 미만인지 확인한다. 범위를 벗어날 경우, IllegalArgumentException 을 발생시킨다.

#### 3. validateEmailForm(String email)
- email의 형식이 주어진 조건과 일치하는지 확인한다. 일치하지 않을 경우, IllegalArgumentException 을 발생시킨다.
  - 이메일의 보편적인 형식 '계정@도메인.최상위도메인'을 띄어야 한다.
  - 도메인은 "email.com"만 허용한다.
  - (계정은 영어 소문자, 대문자, 숫자만 허용한다.)
- 정규식을 활용한다.

#### 4. validateEmailLength(String email)
- email의 길이가 11자 이상 20자 미만인지 확인한다. 범위를 벗어날 경우, IllegalArgumentException 을 발생시킨다.

#### 5. getTwoLetterListFromNickname()
- 인스턴스의 nickname을 두 글자씩 순서대로 나눈 문자열을 리스트에 담아 반환한다.
- 리스트는 다른 nickname에 같은 글자가 연속해서 포함되는지 여부를 확인할 때 사용된다.

#### 6. isOverlappedWith(Crew crew)
- 매개변수로 입력된 crew와 인스턴스의 닉네임이 중복되는지(같은 글자가 연속해서 포함되는지) 여부를 확인한다.
- crew으로 getTwoLetterListFromNickname()을 호출해 twoLetterList 를 초기화한다.
- twoLetterList를 순회해 인스턴스의 nickname에 두 글자 요소가 포함되는지 여부를 확인한다.
- 포함 여부를 반환한다.

#### 7. equals() & hashCode()
- Crew 객체들 간의 비교 시 활용하기 위해 equals()와 hashCode()를 오버라이드 한다.
- Crew 객체의 멤버변수 email, nickname 를 활용한다. 

#### 8. getEmail()
- Crew 객체에서 email만 추출하는 과정이 필요하므로 getEmail() 메소드를 둔다.

### Class Crews
- Crews 클래스는 List<Crew> crews를 유일한 멤버변수로 갖는 일급컬렉션이다.
- 컬렉션 연산에 관한 메소드를 갖는다.

#### 1. getCrewSetOverlappingWith(Crew crew)
- 인스턴스 crew를 매개변수로 받는다.
- crew와 nickname이 중복되는(같은 글자가 연속해서 포함되는) Crew 인스턴스들을 Set으로 반환한다.
- 단, nickname이 중복되는지 여부를 확인할 때 자기자신은 제외한다.

#### 2. getCrewListWithOverlappingNickname()
- 일급컬렉션 crews을 순회하며 getCrewSetOverlappingWith()을 호출해 Set에 그 반환값을 저장한다.
- Set을 List로 변환해 반환한다.

### Class Main

#### 1. makeCrewByNicknameAndEmail(String email, String nickname)
- 매개변수로 email과 nickname을 받아 Crew 객체를 생성해 반환한다.

#### 2. makeCollectionCrews(List<List\<String>> emailAndNicknames)
- email과 nickname이 담긴 2차원 리스트를 받아, Crew 객체들을 생성한다.
- ArrayList\<Crew> crewList 에 Crew 객체를 담는다.
- Crews 클래스 생성자에 crewList를 전달해, Crews 일급컬렉션 객체를 생성하고 반환한다.

#### 3. getAscendingEmailListFrom(List\<Crew> overlappingCrewList)
- List\<Crew> overlappingCrewList 에서 Crew의 email만 오름차순 정렬해서 리스트로 반환한다.


## Test code

### CrewTest
- Crew 클래스를 테스트한다.

1. 닉네임, 이메일 등의 예외 케이스 입력 시 IllegalArgumentException 을 발생시키는지 확인한다.
2. getTwoLetterListFromNickname() 메소드 호출 시 nickname을 두 글자로 나눈 List를 반환하는지 확인한다.
3. isOverlappedWith(Crew crew) nickname 중복 여부를 반환하는지 확인한다.

### CrewsTest
- Crews 클래스를 테스트한다.

1. getCrewSetOverlappingWith(Crew crew) 한 crew의 인스턴스를 전달했을 때 nickname이 중복되는 크루원들의 Set을 반환하는지 확인한다.
2. getCrewListWithOverlappingNickname() 컬렉션 전체에서 nickname이 중복되는 크루원들의 List를 반환하는지 확인한다.

#### MainTest
- Main 클래스를 테스트한다.

1. makeCrewByEmailAndNickname(String email, String nickname) 메소드가 Crew 객체를 반환하는지 확인한다.
2. makeCollectionCrews(List<List\<String>> emailAndNicknames) Crews 일급 컬렉션을 반환하는지 확인한다.
3. getAscendingEmailListFrom(List\<Crew> overlappingCrewList) Crew의 이메일만 오름차순 정렬해서 List로 반환하는지 확인한다.
