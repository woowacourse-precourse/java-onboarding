### problem7 기능 명세서

### Problem7.java
- 1. 해당하는 유저의 친구 목록 리스트를 알아냅니다.
- 2. 위의 친구 목록 리스트를 기반으로 함께 아는 친구 리스트를 구합니다.
- 3. 함께 아는 친구 리스트에서는 이미 나의 친구 리스트와 내가 중복되지 않도록 제거해줍니다.
- 4. 함께 아는 친구 리스트는 recommends hash map 에 저장해줍니다.
- 5. 방문 기록에 따른 점수의 경우의 경우에도 hash map 에 방문자를 저장해줍니다.(중복 제거)
- 6. 이 후 recommends hash map 을 점수 내림차순으로, 추천 점수가 같을 시 이름 오름차순으로 정렬합니다.
- 7. 정렬된 hash map 에서 최대 5명을 리스트로 리턴하도록 하여 구현하였습니다.   

| 이름 | 기능 | 
| --- | --- | 
| findFriendInPairs | friends 각 원소에서 친구 찾기 함수 |
| getfriendListOfUser | 유저의 친구 리스트 얻는 함수 |
| setScoreToFriendOfUserFriend | 사용자와 함께 아는 친구에게 점수를 부여하는 함수 |
| getFriendsScore | 친구 관계 정보에 따른 점수 부여 함수 (+ 기존의 내 친구 목록 중복 제거) |
| getVisitorsScore | 방문 기록에 따른 점수 부여 함수 (+ 기존의 내 친구 목록 중복 제거) |
| compareByScoreAndName / sort | HashMap 정렬 기능 구현 -> 점수 내림차순 , 점수 같을 시 이름 오름차순 |
| convertEntriesToList | Entry -> List 로 변환하는 함수 |