# 🚀 기능 구현 목록
## Class
### Problem_7_Restriction
문제 7번에 대한 예외 처리를 하는 클래스
#### Methods
1. 생성자 (In : None / Out : None)
2. 생성자 (In : String / Out : None)
### RecommandAlgorithm
#### Methods
1. 생성자 (In : String, List<List<String>>, List<String>)
<br>주인공 user를 (String) user에 저장, user와 친구 관계인 사용자들을 (List<String>) userFriends에 저장하고, 친구 관계가 아닌 visitors만 (List<Stirng>) visitors에 저장. 모든 user와 친구관계가 아닌 사람들은 (List<String>) unknownUsers에 저장.
2. checkException (In : String, List<List<String>>, List<String>)
<br>주어진 제한 사항에 따라 예외 처리
3. findFriendOfUserFriend (In : List<List<String>>, String)
<br>user와 친구가 아니면서 user와 함께 아는 친구를 찾아 (List<String>) friendsOfUserFriends에 저장.
4. scoringUnknownUsers (In : None / Out : List<String)
<br>먼저 모든 unknownUsers들을 이름순으로 정렬한 뒤, visitors는 +1점, 사용자와 함께 아는 친구는 +10점을 메긴다. 그리고 점수순으로 정렬하고 0점인 사람은 제외한다.
최대 5명까지 반환한다.