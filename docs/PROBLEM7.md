## 기능 목록
### 구현에 사용한 규칙
* Friend 객체를 생성해 점수 높은 5명만 정렬해 출력한다.
### 구현 방법
1. Friend 클래스를 만들어 객체 생성을 통해 점수 정보를 담는다.
2. friends 에서 user와 친구인 사람 리스트를 리턴하는 메서드 findUserFriends 생성
3. friends 에서 user의 친구와 친구인 사람의 리스트를 리턴하는 메서드 findFriendsOfFriend 생성
4. **(추가) 이름이 주어질 때 그 이름의 Friend 객체가 만들어졌나 확인하고, 포인트를 더하는 addPointToFriendsObject 메서드 생성**
5. 친구의 친구 리스트를 통해 Friend 객체 생성하며, addPointToFriendObject 메서드 실행하는 메서드 friendPointCalculate 생성
6. visitors 리스트를 통해 Friend 객체 생성하며, addPointToFriendObject 메서드 실행하는 메서드 visitorPointCalculate 생성
7. Friend 객체 리스트에서 점수 상위 5명만 추려 이름을 리스트로 반환하는 메서드 findTopFive 생성
8. 각 객체를 리스트에 담아 정렬을 통해 문제에서 원하는 조건으로 리턴
### 구현 메서드 상세
#### 클래스 변수
(ArrayList) Friend 객체를 아이템으로 갖는 friends_list 리스트
#### Friend 클래스
   1. <변수>\
      (String) 이름을 담을 변수 name\
      (Int) 점수를 담을 변수 point
   2. <구현>\
   생성자로 매개변수를 통해 name에 매개변수로 들어온 문자열을 넣는다.\
      **(추가) name, point가 매개변수로 주어졌을 때 이것으로 객체 만드는 생성자.**\
   point를 리턴하는 getPoing 메서드 생성\
   point를 더하는 addPoint 메서드 생성\
      **(추가) 이름을 반환하는 getName 메서드 생성**
#### List findUserFriends 메서드
   1. <매개변수>\
      (String) user (입력값)\
      (List<List<String) friends (입력값)
   2. <변수>\
      (ArrayList) 리턴할 친구 리스트를 담을 user_friends 리스트
   3. <구현>\
      Stream을 이용해 friends에서 user와 친구 상태만 찾아 user_friends에 넣어 반환한다.
#### List findFriendsOfFriend 메서드
   1. <매개변수>\
      (List<List<String) friends (입력값)\
      (List) user_friends (findUserFriends 반환값)
   2. <변수>\
      (ArrayList) 리턴할 친추와 친구 리스트를 담을 user_unknown_friends 리스트
   3. <구현>\
      Stream을 이용해 fiends에서 user_friends와 친구 상태만 찾아 user_unknown_friends에 넣어 반환한다.
#### **(추가) boolean (수정)addPointTOFriendObject 메서드**
1. **<매개변수>\
   (String) 확인 필요한 친구 이름 name**
   (int) 더할 포인트 point
2. **<변수>\
없음**
3. **<구현>\
클래스 변수 friends_list 리스트 를 돌며 매개변수 name과 동일한 이름이 있으면\
   (추추가) point 객체에 추가 및 true 반환.**

#### void friendPointCalculate 메서드
   1. <매개변수>\
      (ArrayList) findFriendsOfFriend로 찾은 친구 리스트 user_unknown_friends
   2. <변수>\
      (Int 상수) 친구의 친구 점수 10점을 담을 FRIENDSPOINT 상수

   3. <구현>\
      user_unknown_friends 에서 한명씩 꺼내기\
      friends_list에 꺼낸 이름을 가진 객체가 없으면 객체 생성 후 10점 추가\
      (삭제)~~있으면 그 객체에 10점 추가~~
#### void visitorPointCalculate 메서드
   1. <매개변수>\
      (List) visitors (입력값)
   2. <변수>\
      (Int 상수) 방문자 점수 1점을 담을 VISITPOINT 상수
   3. <구현>\
      visitors 에서 한명씩 꺼내기\
      friends_list에 꺼낸 이름을 가진 객체가 없으면 객체 생성 후 1점 추가\
      (삭제)~~있으면 그 객체에 1점 추가~~
#### List findTopFive 메서드
   1. <매개변수>\
      (클래스변수)(ArrayList) Friend 객체를 아이템으로 갖는 friends_list 리스트
   2. <변수>\
      (ArrayList) 최종 Top 5만 담을 리스트 top_five 리스트
   3. <구현>\
       Stream 을 사용해 각 객체를 point순, 이름 순으로 정렬한다.\
       point 가 0이면 삭제하고 5명만 남겨 top_five에 넣어 반환한다.
       
#### List solution 메서드
   1. <매개변수>\
(입력값)
   2. <변수>\
      (ArrayList) findUserFriends 의 리턴값을 담을 user_friends 리스트\
      (ArrayList) findFriendsOfFriend의 리턴값을 담을 user_unknown_friends 리스트
   3. <구현>\
friends_list 초기화\
      findUserFriends, findFriendsOfFriend를 사용해 user_unknown_friends구하기\
**(추가) user_unknown_friends 에서 user지우기, visitors에서 user_friends 지우기**\
      user_unknown_friends를 매개변수로 friendPointCalculate 메서드 수행\
      visitors 를 매개변수로 visitorPointCalculate 메서드 수행\
      findTopFive 메서드를 수행해 리턴값을 최종 반환

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
