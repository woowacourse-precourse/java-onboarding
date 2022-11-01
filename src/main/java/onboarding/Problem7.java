package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> friendList = new HashMap<>();
        /* 유저의 친구 목록 추가하기 */
        friendList.put(user, new HashSet<>());
        /* 친구 목록 만들기 */
        for (List<String> relation: friends) {
            String name1 = relation.get(0);
            String name2 = relation.get(1);

            putNewFriendList(friendList, name1);
            putNewFriendList(friendList, name2);

            friendList.get(name1).add(name2);
            friendList.get(name2).add(name1);
        }

        HashMap<String, Integer> scoreMap = new HashMap<>();
        /* 친구 목록을 통한 점수 계산하기 */
        for (String othersName: friendList.keySet()) {
            String[] names = {user, othersName};
            calculateScoreByFriend(friendList, scoreMap, names);
        }
        /* 방문자 목록을 통해 계산하기 */
        for (String visitor: visitors) {
            HashSet<String> userFriendList = friendList.get(user);
            calculateScoreByVisitor(scoreMap, userFriendList, visitor);
        }

        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());
        /* 점수 정렬하기 */
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                /* 뒷놈이 더 크면 앞에 오도록 */
                if (o2.getValue() > o1.getValue())
                    return 1;
                /* 앞 놈이 더 크면 그대~로 */
                if (o2.getValue() < o1.getValue())
                    return -1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> answer = new ArrayList<>();
        int MAX_LOOP_SIZE = 5;
        int loopSize = Math.min(MAX_LOOP_SIZE, scoreList.size());

        for (int i=0; i<loopSize; i++) {
            Map.Entry<String, Integer> entry = scoreList.get(i);
            addNameToAnswer(answer, entry);
        }
        return answer;
    }
    public static void putNewFriendList(HashMap<String, HashSet<String>> friendList,
                                        String name) {
        if (friendList.get(name) == null)
            friendList.put(name, new HashSet<>());
    }
    public static void checkAndAddScore(HashSet<String> othersFriendList,
                                        HashMap<String, Integer> scoreMap,
                                        String[] names) {
        final int SCORE_BY_FRIEND = 10;
        String othersName = names[0];
        String userFriendName = names[1];

        if (othersFriendList.contains(userFriendName)) {
            int oldScore = scoreMap.get(othersName);
            int newScore = oldScore += SCORE_BY_FRIEND;
            scoreMap.replace(othersName, newScore);
        }
    }
    public static void calculateScoreByFriend(HashMap<String, HashSet<String>> friendList,
                                              HashMap<String, Integer> scoreMap,
                                              String[] names) {
        String user = names[0];
        String othersName = names[1];
        HashSet<String> userFriendList = friendList.get(user);
        HashSet<String> othersFriendList = friendList.get(othersName);
        if (user.equals(othersName) || userFriendList.contains(othersName))
            return;

        scoreMap.put(othersName, 0);

        for (String userFriendName: userFriendList) {
            String[] othersAndFriend = {othersName, userFriendName};
            checkAndAddScore(othersFriendList, scoreMap, othersAndFriend);
        }
    }
    public static void calculateScoreByVisitor(HashMap<String, Integer> scoreMap,
                                               HashSet<String> userFriendList,
                                               String visitor) {
        if (userFriendList.contains(visitor))
            return;
        if (!scoreMap.containsKey(visitor))
            scoreMap.put(visitor, 0);

        int oldScore = scoreMap.get(visitor);
        int newScore = oldScore += 1;
        scoreMap.replace(visitor, newScore);
    }
    public static void addNameToAnswer(List<String> answer,
                                       Map.Entry<String, Integer> entry) {
        if (entry.getValue() != 0)
            answer.add(entry.getKey());
    }
}

/*
<<요구사항>>
1. 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 주어진다
2. user와 친구가 아닌 사람들의 점수를 매긴다.
   2 - 1. 같이 아는 친구 1명당 +10점
   2 - 2. 내 타임라인 방문 1번당 +1점
3. 점수에 따라 내림차순으로 정렬해 상위 5명의 닉네임을 배열에 담아 리턴한다
 */

/*
<<기능 목록>>
- [V] 유저의 친구목록을 먼저 만든다
- [V] 친구관계를 이용해 친구 목록을 만든다
  - [V] 각 인물의 친구 목록을 담을 HashMap을 만든다
  - [V] 친구관계목록의 각 친구관계마다 두 개의 이름을 뽑아낸다
  - [V] 각 이름이 친구 목록 HashMap에 없으면 친구목록 HashMap에 넣는다
  - [V] 둘 다 친구 목록에 서로를 추가한다
- [V] 친구 목록을 통한 점수를 계산한다
  - [V] 각 사람들의 점수를 저장할 scoreMap를 만든다
  - [V] 친구 목록에서 keySet을 뽑아와 순회한다
  - [V] 현재 참조하는 사람이 user인 경우나 user의 친구인 경우는 건너뛴다
  - [V] scoreMap에 현재 참조하는 사람의 점수를 0점으로 하여 넣어준다.
  - [V] 친구 목록을 통해 user의 친구들을 순회하며 각 친구가 현재 참조하는 사람의 친구목록에 있으면 10점을 더해 교체해준다
- [V] 방문 기록을 통해 점수를 계산한다
  - [V] 현재 참조하는 방문자가 uesr의 친구인 경우는 건너뛴다
  - [V] scoreMap에 현재 참조하는 방문자가 없으면 0점으로 하여 넣어준다
  - [V] 현재 참조하는 방문자의 점수를 1점 더해서 교체해준다
- [V] 받은 점수를 토대로 정렬한다
  - [V] scoreMap을 이용해 scoreList를 만든다
  - [V] scoreList를 점수 내림차순으로 정렬하고, 점수가 같으면 이름순으로 정렬한다
- [V] 상위 5명만, 0점이 아닌 경우만 뽑아서 answer에 담는다
  - [V] scoreList를 순회하다가 5번째 순회 이후는 break로 탈출하도록 한다
  - [V] 각 순회에 대해 0점이 아니면 answer에 넣는다
 */
