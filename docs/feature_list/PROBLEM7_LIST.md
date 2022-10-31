기능 목록
1. List<String> checkUserFriend(String user, List<List<String>> friends)- friends를 분석해 user가 아는 사람을 반환한다.
2. Map<String,Integer> recommendScore(String user, List<List<String>> friends, List<String> userFriend) - 사용자와 함께 아는 친구 수를 세어 점수를 집계한 후 저장하여 반환한다.
3. Map<String, Integer> viewScore(List<String> userFriend, List<String> visitors) - 사용자의 타임라인을 방문한 횟수를 세어 점수를 집계한 후 저장하여 반환한다.
4. List<String> totalScore(String user, List<List<String>> friends, List<String> visitors) - 최종 점수를 집계하고 오름차순하여 상위 5명의 이름을 반환한다. 이 때 동점자끼리는 이름을 기준으로 오름차순하여 반환한다.

예외사항
1. 0점 미만은 출력하지 않는다.