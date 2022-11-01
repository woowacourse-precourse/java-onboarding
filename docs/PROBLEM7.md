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

# 개발 기록

## 기능 목록

개요
1. user의 아이디를 담은 객체
   - 아이디의 형식, 길이를 제한하는 기능
2. friends, visitors를 담은 객체
   - 길이를 제한하는 기능
3. user를 입력하면 user의 친구들의 친구를 리스트로 반환하는 기능
4. user를 입력하면 visitors 중 user의 친구를 제외한 방문자를 반환하는 기능
5. user의 친구들의 친구와 방문자의 리스트를 입력하면 각 친구 후보에 점수를 매긴 자료를 반환하는 기능
6. 친구 후보와 점수의 자료를 점수가 높은순, 점수가 같을 경우 이름순으로 정렬해서 반환하는 기능

### Class User
- User 클래스는 userId를 멤버변수로 갖는다.
- 생성자를 통해 userId를 초기화한다.
- userId를 초기화하기 전, userId를 검증한다.

#### 1. validateUserIdForm(String userId)
- userId가 소문자로 구성되었는지 확인한다. 소문자가 아닌 문자가 포함될 경우, IllegalArgumentException을 발생시킨다.
- 정규식을 활용한다.

#### 2. validateUserIdLength(String userId)
- userId의 길이가 1 이상 30 이하인지 확인한다. 범위를 벗어날 경우, IllegalArgumentException을 발생시킨다.

#### 3. getUserId()

#### 4. equals() & hashCode()
- User 객체들 간의 비교 시 활용하기 위해 equals()와 hashCode()를 오버라이드 한다.
- User 객체의 멤버변수 userId를 활용한다.

### Class Friend
- Friend 클래스는 userA와 userB를 멤버변수로 갖는다.

#### 1. contains(User user)
- Friend 인스턴스에 대해 user 포함 여부를 확인해서 반환한다.

#### 2. getAnotherUserNot(User user)
- Friend 인스턴스에 대해 user가 아닌 다른 User를 반환한다.

#### 3. getFriendOf(User user)
- Friend 인스턴스에 대해 user가 아닌 다른 User를 반환한다.
- 단, Friend 인스턴스에 user가 포함되어 있지 않다면, null을 반환한다.

### Class FriendList
- FriendList 클래스는 List\<Friend> friendList를 유일한 멤버변수로 갖는 일급 컬렉션이다.
- 컬렉션 연산에 관한 메소드를 갖는다.

#### 1. validateFriendsLength(List\<Friend> friends)
- FriendList 생성 시, friends의 길이가 1이상 10000이하인지 확인한다. 범위를 벗어날 경우, IllegalArgumentException을 발생시킨다.

#### 2. getFriendListOf(User user)
- user를 입력하면 FriendList에서 user의 친구들만 List\<User>로 반환한다.

#### 3. getFriendsOfFriendBy(User user, List\<User> friendListOfUser)
- user와 friendListOfUser를 입력하면 FriendList에서 user의 친구의 친구들만 List\<User>로 반환한다.

### Class VisitorList
- VisitorList 클래스는 List\<User> visitorList를 유일한 멤버변수로 갖는 일급 컬렉션이다.
- 컬렉션 연산에 관한 메소드를 갖는다.

#### 1. validateVisitorListLength(List\<User> visitorList)
- VisitorList 생성 시, visitors 길이가 1이상 10000이하인지 확인한다. 범위를 벗어날 경우, IllegalArgumentException을 발생시킨다.

#### 2. getVisitorListExcluding(List\<User> friendListOfUser)
- VisitorList 중 입력된 user의 친구 목록을 제외한 VisitorList를 List\<User>로 반환한다.

### Class CollectionMaker
- FriendList, VisitorList 일급 컬렉션의 생성 및 반환을 담당한다.

#### 1. makeUser(String userId)
- userId를 입력받아 User 객체를 생성해 반환한다.

#### 2. makeFriendWithAAndB(User userA, User userB)
- user 객체를 입력받아 Friend 객체를 생성해 반환한다.

#### 3. makeFriendList(List<List\<String>> friends)
- friends 리스트를 입력받아 FriendList를 생성해 반환한다.

#### 4. makeVisitorList(List\<String> visitors)
- visitors 리스트를 입력받아 VisitorList를 생성해 반환한다.

#### 5. getFriendList() & getVisitorList()

### Class UserAndScore
- User newFriendUser와 int score를 멤버변수로 갖는 클래스이다.
- 정렬 시 활용된다.

#### 1. getUser() & getScore()

### Class FriendAndScore
- FriendList, VisitorList, User 등의 자료를 조작해 user 별로 추천점수를 매기고, 상위 다섯명의 목록을 반환하는 등의 기능을 갖춘 클래스이다.
- FriendList, VisitorList, FRIENDS_OF_FRIEND_POINT, VISITORS_POINT 를 멤버변수로 갖는다.

#### 1. getVisitorsNotFriendOf(User user)
- user를 입력하면 user의 친구가 아닌 방문자들을 리스트로 반환한다.

#### 2. getFriendsOfUserFriend(User user)
- user를 입력하면 user의 친구의 친구들을 리스트로 반환한다.

#### 3. addTwoListsWithoutDuplicate(List\<User> friendsOfUserFriends, List\<User> visitorsOfNotFriendOfUser)
- user의 친구의 친구 리스트와 user의 친구가 아닌 방문자 리스트를 입력하면, 중복을 제거한 친구 리스트를 반환한다.

#### 4. mapNewFriendAndScore(List\<User> friendsOfUserFriends, List\<User> visitorsOfNotFriendOfUser)
- user의 친구의 친구 리스트와 user의 친구가 아닌 방문자 리스트를 입력해 새 친구와 점수를 매핑한 Map 자료를 반환한다.

#### 5. transformMapIntoList(Map\<User, Integer> newFriendAndScore)
- Map 인스턴스 newFriendAndScore를 입력하면, List\<UserAndScore> newFriendAndScoreList로 변환해 반환한다.

#### 6. getNewFriendAndScoreListByFriendsOfFriendAndVisitors(List\<User> friendsOfUserFriends, List\<User> visitorsOfNotFriendOfUser)
- user의 친구의 친구 리스트와 user의 친구가 아닌 방문자 리스트를 입력하면 List\<UserAndScore> newFriendAndScoreList를 반환한다.

#### 7. sortListByScoreAndUserId(List\<UserAndScore> newFriendAndScoreList)
- List\<UserAndScore> newFriendAndScoreList를 입력하면 점수가 높은 순으로 정렬하고, 점수가 같은 경우 이름 순으로 정럴해 반환한다.

#### 8. getRecommendationList(List\<UserAndScore> newFriendAndScoreList)
- List\<UserAndScore> newFriendAndScoreList를 입력하면 친구 추천 리스트의 이름을 리스트로 반환한다.

### Class FriendAndScoreMapper
- Map\<User, Integer> newFriendAndScore 자료의 연산을 담당하는 클래스이다.

#### 1. setNewFriendAndScore(List\<User> newFriend)
- List\<User> newFriend 가 입력되면 stream 연산을 통해 User를 key, INITIAL_POINT를 value로 하는 Map 자료를 생성해 반환한다.

#### 2. calculateScoreOfNewFriendWith(List\<User> friendList, int point)
- friendList와 point가 입력되면, friendList에 존재하는 친구의 수를 세어 point를 곱해 점수를 업데이트한다.

#### 3. getFriendAndScore()