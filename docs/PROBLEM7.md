## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점 
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
  - A와 B는 친구라는 의미이다.
  - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

---

## 기능 요구사항 및 체크리스트 정리(1차)

### 1. 문제풀이 기본 요구사항 정리
- ✅ solution 메소드 구현
  - ✅ makePeopleMap 메소드를 사용하여 친구관계 정보가 저장된 HashMap 클래스 객체 생성
  - ✅ calculateFriendsScore 메소드를 사용하여 HashMap 내 People 객체마다 함께 아는 친구에 대한 점수 계산
  - ✅ calculateVisitorsScore 메소드를 사용하여 HashMap 내 People 객체마다 사용자의 타임 라인에 방문한 횟수에 대한 점수를 계산
  - ✅ makeRecommendedList 메소드를 사용하여 점수가 높은 순으로 정렬된 추천 친구 리스트 생성

<br/>

- ✅ People 클래스 구현
  - ✅ 이름, 사용자와의 친구 여부, 친구리스트, 점수 속성 변수 선언
  - ✅ 점수 속성 변수로 비교를 할 수 있도록 Comparable 클래스 상속하여 compareTo 메소드 오버라이딩

<br/>

- ✅ putPeopleToMap 메소드 구현
  - ✅ HashMap 내에 찾고자하는 이름 키값이 없으면 새로운 People 객체를 생성해서 추가

<br/>

- ✅ addFriendToPeople 메소드 구현
  - ✅ People 객체에 새로운 친구 관계 정보를 저장
  - ✅ user가 친구로 입력되었을 때 userFriendStatus 값을 true로 변경

<br/>

- ✅ removeUserFriend 메소드 구현
  - ✅ map 내에서 userFriendStatus 속성이 true인 people 객체들을 삭제

<br/>

- ✅ makePeopleMap 메소드 구현
  - ✅ 사람의 친구 관계 정보를 담고있는 people 객체들을 생성하여 HashMap에 삽입 후 반환
  - ✅ user 정보를 저장하는 People 객체는 따로 생성하여 HashMap에 삽입
  - ✅ friends 리스트에서 주어지지 않은 새로운 사람이 visitors 리스트에서 등장 시 새로운 people 객체 생성 후 HashMap에 삽입
  - ✅ friends 리스트에 명시된 친구 관계정보에 따라 해당하는 people 객체에 친구명을 저장
  - ✅ user와 친구관계인 People 객체는 삭제 (사용자와 이미 친구관계인 경우는 점수를 계산하지 않는다.)

<br/>

- ✅ scoreToUserFriend 메소드 구현
  - ✅ userFriendList에 이름이 존재하는 People 객체에 10점을 부여

<br/>

- ✅ calculateFriendsScore 메소드 구현
  - ✅ 사용자와 함께 아는 친구수에 대한 점수를 계산

<br/>

- ✅ calculateVisitorsScore 메소드 구현
  - ✅ 사용자의 타임 라인에 방문한 횟수에 대한 점수를 계산
  - ✅ HashMap 객체를 이용해 visitors 이름 등장 시마다 People 객체에 1점 부여

<br/>

- ✅ addEmailList 메소드 구현
  - ✅ user이거나 추천점수가 0점인 people 객체들을 제외한 people 객체를 recommendList에 삽입한다.

<br/>

- ✅ makeRecommendedList 메소드 구현
  - ✅ user와 친구가 아닌 people 객체의 이름 속성을 점수 순으로 내림차순 정렬한 리스트를 반환
  - ✅ 점수가 가장 높은 5명까지만 반환

---

## 기능 요구사항 및 체크리스트 정리(2차)

### 1. 리펙토링
- ✅ isZeroScore 메소드 코드 수정
- ✅ calculateVisitorsScore 메소드 코드 수정
  - ✅ 사용하지 않는 매개 변수 삭제
- ✅ People 클래스 내 변수명, 메소드명 수정
  - ✅ userFriendStatus 변수명을 isUserFriend로 수정
  - ✅ setUserFriendStatus 메소드명을 makeUserFriend로 수정
  - ✅ getUserFriendStatus 메소드명을 isUserFriend로 수정
- ⬜ makeUserFriend 메소드 코드 수정
  - ⬜ 매개 변수를 제거하고 isUserFriend 속성 변수를 바로 변경하도록 수정
