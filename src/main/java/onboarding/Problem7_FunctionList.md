# 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

### 1. user의 친구목록 생성  
#### makeUserFriendList(List<List<String>> friends) --> List<String> userFriendList
- 제공된 friends에서 user와 같은 리스트에 포함된 친구들을 userFriendList에 넣습니다.


### 2. friends중 user와 user 친구를 제외한 사람들을 모아 추천목록 생성
#### makeRecommendList(List<List<String>> friends, List<String> userFriendList) --> Map<String, Integer> recommendList
- 제공된 friends에서 user를와 함께 리스트에 포함된 친구들을 제외한 나머지 친구들을 Map에 저장합니다.
- 친구들의 이름이 key값이며 친구들에 대한 추천 점수가 value값입니다.

### 3.visitors중 user의 친구를 제외한 사람들 추천목록에 추가
#### updateRecommendList(List<String> visitors, List<String> userFriendList ,Map<String, Integer> recommendList) --> Map<String, Integer> recommendList
- 제공된 visitor 목록에서 user의 친구들을 제외한 이름들을 makeRecommendList()에서 만든 recommendList에 추가합니다. 

### 4. 제공된 firends에서 user의 친구와 친구이면 추천 점수 증가
#### addScoreByFriends(List<List<String>> friends, List<String> userFriendList ,Map<String, Integer> recommendList) --> Map<String, Integer> recommendList
- for문을 수행하며 제공된 friends의 각 친구관계를 firstFriend와 secondFriend에 넣습니다.
- 입력받은 userFriend 목록에 firstFried의 이름이 있고 seconFriend의 이름이 user가 아니라면 해당 second 사람의 추천점수를 10 증가합니다.
- for문이 끝난 후 점수가 갱신된 recommendList를 반환합니다.

### 5. 제공된 visitors에 이름이 있고 user의 친구가 아니면 해당 visitor의 친구 추천 점수 증가
#### addScoreByVisitor(List<String> visitors, List<String> userFriendList,Map<String, Integer> recommendList) --> Map<String, Integer> recommendList
- for문을 수행하며 제공된 visitor 요소 중 userFriendList에 없는 사람이면 recommendList에서 조회 한 뒤 추천점수를 1 증가합니다.

### 6. 추천목록을 추천점수가 높은순으로 정렬
#### sortByScore(Map<String, Integer> recommendList) --> LinkedList<Map.Entry<String, Integer>> recommendEntryList
- 입력받은 recommendList를 comparator 기능을 사용하여 recommendList의 value가 높은순으로 정렬한뒤 recommendEntryList를 반환합니다.

### 7. 추천목록의 추천점수가 같으면 이름순으로 정렬
#### sortByName(LinkedList<Map.Entry<String, Integer>> recommendEntryList) --> LinkedList<Map.Entry<String, Integer>> recommendEntryList
- 입력받은 recommendEntryList를 comparator 기능을 사용하여 추천점수가 같다면 이름순으로 정렬한 뒤 recommendEntryList를 반환합니다.

### 8. 추천목록이 5명을 넘을수 추천점수가 높은순서대로 점수가 높은 5명의 이름을 반환한다. 단 점수가 같을시에는 이름순으로 리스트에 넣는다.
#### filterRecommendList(LinkedList<Map.Entry<String, Integer>> recommendEntryList, List<String> result, int length) --> List<String> result
- 입력받은 recommendEntryList의 길이만큼 result 리스트에 recommendList의 이름을 넣습니다. 이때 입력받은 length가 5를 초과하면 5명만 reuslt 리스트에 넣습니다. 

### 9. 8번에서 recommendList의 이름을 result 리스트에 넣어줍니다. 이때 추천점수인 score가 0이면 넣지 않습니다.
#### addList(LinkedList<Map.Entry<String, Integer>> recommendEntryList, List<String> result, int length)
- 입력받은 recommendList의 이름을 result에 넣어줍니다.
- 단 score가 0점 초과여야지 reuslt에 넣어줍니다.


# 전체 동작 과정

