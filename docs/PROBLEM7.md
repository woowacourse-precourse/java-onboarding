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
## 📄 기능 정리

### 0. Class 설정

#### (1) FriendsRecommender class

##### <멤버 필드(변수, 상수)>

- String user : 유저
- HashMap< String, HashSet< String > > friendsInformation : 사용자 별 친구 목록
- HashMap< String, Integer > recommendScore : 사용자 별 추천 점수

##### <멤버 메소드>

- public FriendsRecommender(String user, List<List< String >> friends, List< String > visitors) : 생성자

- public List< String > makeRecommendedFriendsList() : 친구 추천 목록 생성 함수 (최상위 함수)

- private void scoreFriendsUserKnow() : 함께 아는 친구 점수 반영

- private void scoreOtherEachUsers(HashSet< String > otherUserFriends) : 각 사용자 별 함께 아는 친구 점수 반영

- private int countFriendsUserKnow(HashSet< String > otherUserFriends) : 각 사용자 별 함께 아는 친구 수 반환

- private List< String > makeSortedRecommendlist() : 문제의 조건대로 정렬 후 리스트로 변환 후 반환



### 1. 전체 동작 과정

(1) 생성자를 통해 다음과 같이 설정된다.

- 사용자 별 친구 목록 생성 (이미 user와 친구관계인 사용자 제외)
- 방문자 점수 반영

(2) makeRecommendedFriendsList() 호출. 내부에서 scoreFriendsUserKnow(), makeSortedRecommendlist() 호출.

- scoreFriendsUserKnow() 내부에서 friendsInformation 순회하며 scoreOtherEachUsers() 호출

    - scoreOtherEachUsers() countFriendsUserKnow() 호출
        - countFriendsUserKnow() 내부에서 user의 friendsInformation을 순회하며 함께 아는 친구 수 반환

    - 함께 아는 친구 수 만큼 recommendScore 에 반영

- makeSortedRecommendlist() : recommendScore 정렬 후 리스트로 변환하여 반환

(3) 정렬된 친구 목록 리스트 반환



### 2. 함수 별 동작 과정

- 생성자
    - 입력 : String user, List<List< String >> friends, List< String > visitors
    - this.user 초기화
    - friends를 토대로 this.friendsInformation 초기화
        - key : 사용자 이름
        - value : 친구 목록 HashSet
        - 초기화 이후 user와 친구 관계인 사용자 내용 삭제(remove)
            - 이미 친구 관계인 사용자는 고려 대상에서 제외
    - recommendScore 초기화
        - key : friendsInformation의 key값
        - value : 0
    - visitors 순회하며 recommendScore에 반영
        - recommendScore의 Key에 없는 사용자의 경우 continue
            - 이미 user와 친구 관계이므로



- public List< String > makeRecommendedFriendsList()
    - scoreFriendsUserKnow() 호출
    - makeSortedRecommendlist() 호출 : 정렬된 리스트 반환
    - 반환 : 정렬된 리스트



- private void scoreFriendsUserKnow()
    - friendsInformation 순회하며 scoreOtherEachUsers() 호출



- private void scoreOtherEachUsers(HashSet< String > otherUserFriends)
    - countFriendsUserKnow() 호출 : 함께 아는 친구 수 반환
    - 함께 아는 친구 수 만큼 recommendScore 에 반영



- private int countFriendsUserKnow(HashSet< String > otherUserFriends)
    - user의 friendsInformation을 순회하며 otherUserFriends에 존재하는지 여부 확인(contains)
        - true : numberOfFriendsUserKnow += 1
    - 반환 : int numberOfFriendsUserKnow



- private List< String > makeSortedRecommendlist()
    - 문제의 조건대로 recommendScore 정렬 
      - 점수 기준 내림차순
      - 같은 점수일 경우 이름 기준 오름차순
    - Collection.sort, Comparator 활용
    - 정렬된 recommendScore의 Key 값을 모아 리스트로 생성
    - 반환 : 정렬된 리스트





------

## ✋ 예외 사항

- 1 <= user.length() <= 30
- 1 <= friends.size() <= 10,000
- 0 <= visitors.size() <= 10,000
- id는 모두 소문자

