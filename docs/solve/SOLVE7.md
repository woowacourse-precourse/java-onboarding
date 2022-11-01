### 🚀 기능 목록

####  problem7 - solution()
[요구] 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
- Integer friendScore: 사용자와 함께 아는 친구의 수 = 10점
- Integer visitScore: 사용자의 타임 라인에 방문한 횟수 = 1점
- Map\<String, List<String>> friendToFriendsMap: 아이디를 KEY, 아이디와 친구인 아이디 리스트를 VALUE로 갖는 맵
- makeUserToFriendsMap(): 아이디끼리의 친구 관계 초기화하는 메서드
- Boolean isExistUserFriend: 사용자의 친구가 존재하면 TRUE, 없으면 FALSE
  - TRUE
    - calculateFriendScore(user): 사용자와 함께 아는 친구의 수 점수 계산하는 메서드
      - friendToFriendsMap.forEach((otherUser, friends) -> 
        - otherUser: 아이디A
        - friends: 아이디A와 친구인 아이디B, C, D 등의 리스트
        - if (otherUser.equals(user)): (아이디A == 사용자 아이디)이면 제외 
        - if (friendToFriendsMap.get(user).contains(otherUser)): 아이디A가 이미 사용자의 친구 리스트에 들어있으면 제외
        - int friendCount: 사용자와 함께 아는 친구의 수 
        - for (String friend : friends) 
          - if (friendToFriendsMap.get(user).contains(friend)): 아이디B, C, D 등이 사용자와 친구이면 friendCount 1씩 증가
        - Map<String, Integer> friendToScoreMap: 아이디를 KEY, 아이디의 추천 점수를 VALUE로 갖는 맵
        - friendToScoreMap에 otherUser를 KEY로 (friendCount * friendScore) 점수를 VALUE에 저장 
- calculateVisitScore(): 사용자의 타임 라인에 방문한 횟수 점수 계산하는 메서드
  - for (String visitor : visitors) 
    - if (isExistUserFriend): 사용자의 친구가 존재할 때
      - if (friendToFriendsMap.get(user).contains(visitor)) : visitor가 사용자의 친구 리스트에 포함되면 점수를 계산하지 않는다.
    - if (friendToScoreMap.containsKey(visitor)): friendToScoreMap에 이미 visitor가 KEY로 있는 경우 (VALUE + visitScore)를 VALUE에 저장 
    - else: friendToScoreMap에 visitor를 KEY, visitScore를 VALUE에 저장
- friendToScoreMap.entrySet().stream()
  - [조건] 점수가 가장 높은 순으로 정렬, 점수가 같은 경우 이름순 정렬
    - sorted(valueComparator.thenComparing(keyComparator)): 
      - Comparator<Map.Entry<String, Integer>> valueComparator: Map의 VALUE 값 기준으로 내림차순 정렬하는 Comparator
      - Comparator<Map.Entry<String, Integer>> keyComparator: Map의 KEY 값 기준으로 사전순 정렬하는 Comparator
  - [조건] 추천 점수가 0점인 경우 추천하지 않는다.
    - filter(s -> s.getValue() > 0)
  - [조건] 최대 5명
    - limit(5)
  - map(Entry::getKey).collect(Collectors.toList()): KEY인 아이디만 추출해서 리스트 변환