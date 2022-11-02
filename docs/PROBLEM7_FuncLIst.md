## 기능 목록
1. 나와 친구들간의 연결고리를 그래프로 나타낸다.
   1. HashMap<String, HashSet<String>> 으로 구현
      - 사용이유 : friends 데이터를 넣는 과정에서 중복값 없이 name 값을 넣기 위해서
         - Map<String, Set<String>> createGraph(List<List<String>> friends)
2. 친구간의 점수 리스트를 key : value 형식으로 구현한다.
   1. HashMap<String, Integer> 형식을 사용한다.(LinkedHashMap : 순서를 보장 / HashMap : 순서보장 x)
      - 사용이유 : key 값을 이용하여 점수를 추가하기 용이하며, 데이터 가공이 편리하기 때문에 사용하였다.
        - Map<String, Integer> createScoreMap(String user, List<List<String>> friends, List<String> visitors) 
   2. 리스트 key 값을 정렬한 상태로 구현한다.
      - stream().sorted() 매서드를 활용한다.
        - HashMap<String, Integer> sortByKey(Map<String, Integer> scoreMap)
   3. 내 자신은 점수 리스트에 포함되지 않는다.
      - friends list 값에 자기 자신의 닉네임이 있을 시 추가하지 않는다.
        - createScoreMap 메서드 내부 **if(!name.equals(user))** 
3. 그래프를 활용하여 친구의 친구 리스트에 점수 10점을 부여한다.
   1. 내 친구는 점수를 추가하지 않는다.
      - solution 메서드 내 첫번째 2중 for 문 내부 if(scoreList.containsKey(friendOfFriend)) 구문
4. 사용자 타임 라인 방문 횟수에 따라 점수를 추가한다.
   1. 내 친구는 점수를 추가하지 않는다.
      - solution 메서드 내 두번째 for 문 내부 if(!myFriends.contains(visitor)) 구문
5. 친구 추천 리스트를 점수 > 이름 순으로 정렬하여 결과값을 List 형식으로 반환한다.(**단 점수 0점은 반환 x**)
   1. 이름 순은 2번에서 이미 정렬되어있으므로 점수가 높은 순으로 정렬 후 반환.
      - sorted(Collections.reverseOrder()) 을 활용하여 높은 순으로 정렬.
      - Map 의 .keySet() 값으로 List 를 반환한다.
        - HashMap<String, Integer> recommendFriends(Map<String, Integer> map)