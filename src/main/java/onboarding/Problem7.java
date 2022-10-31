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

            if (friendList.get(name1) == null)
                friendList.put(name1, new HashSet<>());
            if (friendList.get(name2) == null)
                friendList.put(name2, new HashSet<>());

            friendList.get(name1).add(name2);
            friendList.get(name2).add(name1);
        }

        HashMap<String, Integer> scoreMap = new HashMap<>();
        /* 친구 목록을 통한 점수 계산하기 */
        for (String name: friendList.keySet()) {
            if (user.equals(name) || friendList.get(user).contains(name))
                continue;

            scoreMap.put(name, 0);

            for (String userFriendName: friendList.get(user)) {
                if (friendList.get(name).contains(userFriendName)) {
                    int oldScore = scoreMap.get(name);
                    int newScore = oldScore += 10;
                    scoreMap.replace(name, newScore);
                }
            }
        }
        /* 방문자 목록을 통해 계산하기 */
        for (String name: visitors) {
            if (friendList.get(user).contains(name))
                continue;
            if (!scoreMap.containsKey(name))
                scoreMap.put(name, 0);

            int oldScore = scoreMap.get(name);
            int newScore = oldScore += 1;
            scoreMap.replace(name, newScore);
        }

        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());
        /* 점수 정렬하기 */
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() > o1.getValue())
                    return 1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> answer = new ArrayList<>();

        for (int i=0; i<scoreList.size(); i++) {
            if (i == 5)
                break;

            Map.Entry<String, Integer> entry = scoreList.get(i);
            if (entry.getValue() != 0)
                answer.add(entry.getKey());
        }
        return answer;
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
