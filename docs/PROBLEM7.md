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
## 도메인 목록

### FriendGroup
**한 유저의 친구 정보를 저장하고, 관련 기능을 수행하는 클래스**


    boolean isFriendWith(String userId)
- id가 userId인 사람과의 친구 여부를 반환


    void addFriendIfNotExist(String userId)
- id가 userId인 사람과 친구가 아니라면 친구 목록에 추가


    int getNumberOfCommonFriends(FriendGroup otherFriends)
- 입력으로 들어온 friendGroup 과 공통으로 가진 친구 수를 반환

### FriendGroupRepository
**각 유저 별 FriendGroup 을 관리하는 저장소 클래스**


    FriendGroup getFriendGroupOfUser(String userId)
- id가 userId인 사람의 friendGroup 을 반환


### Timeline
**한 유저의 타임라인 방문 기록과 관련 기능을 제공하는 클래스**


    int getTimelineVisitTime(String userId)
- id가 userId인 사람이 이 타임라인을 몇번 방문했는지 확인


    void addTimelineVisitInfo(String userId)
- id가 userId인 사람이 이 타임라인을 방문한 횟수를 1회 추가


### TimelineRepository
**각 유저별 Timeline 을 관리하는 저장소 클래스**


    Timeline getTimelineOfUser(String userId)
- id가 userId인 사람의 Timeline 반환

### UserRepository
**전체 유저 목록을 관리하는 저장소 클래스**


    void addUserIfNotExist(String userId)
- id가 userId인 사람이 회원으로 등록되지 않았다면, 회원으로 등록


    Set<String> getUserGroup()
- 전체 유저 목록을 복사해 반환

### FriendRecommender
**주어진 친구 관계 / 유저 ID / 타임라인 정보를 바탕으로 추천 친구 목록을 반환하는 클래스**

    
    FriendRecommender(List<List<String>> friendGroup)
- 주어진 친구 관계 목록을 바탕으로 각 Repository 에 유저 정보를 등록하는 메서드


    List<String> (String userId, List<String> visitors)
- 유저 아이디와 타임라인 방문 정보를 제공받아 최대 5명의 친구를 추천하는 메서드