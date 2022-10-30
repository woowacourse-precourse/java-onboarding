package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        // 1) friends를 훑으면서 user와 친구인 애들을 List에 저장함.
        for (int i = 0; i < friends.size(); i++) {
            int userIndex = friends.get(i).indexOf(user);
            if (userIndex >= 0)
                userFriends.add(friends.get(i).get(1 - userIndex));
        }
        // 2) friends를 훑으면서 1)에서 저장한 친구들과 친구를 맺고 있는 애들을
        //  map에 이름을 key 점수를 value로 해서 10점씩 더해줘
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            String[] name = {friends.get(i).get(0), friends.get(i).get(1)};
            if (name[0].equals(user) || name[1].equals(user)) continue;
            for (int j = 0; j < 2; j++) {
                if (userFriends.contains(name[j]))
                    map.put(name[1 - j], map.getOrDefault(name[1 - j], 0) + 10);
            }
        }
        // 3) visitors 훑으면서 key value 저장해줘
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        // 4) map에서 mrko 친구들은 제거해줘
        for (int i = 0; i < userFriends.size(); i++) {
            if (map.containsKey(userFriends.get(i)))
                map.remove(userFriends.get(i));
        }
        // 5) map을 list로 이름과 점수 같이 옮기고,
        List<Pair> list = new ArrayList<>();
        for (Entry<String, Integer> entrySet : map.entrySet()) {
            list.add(new Pair(entrySet.getValue(), entrySet.getKey()));
        }
        // 6) list을 점수상으로 내림차순, 이름상으로 오름차순 정렬
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(final Pair o1, final Pair o2) {
                if (o1.score < o2.score) return 1;
                else if (o1.score > o2.score) return -1;
                else {
                    int nameLength = Math.min(o1.name.length(), o2.name.length());
                    for (int i = 0; i < nameLength; i++) {
                        if (o1.name.charAt(i) > o2.name.charAt(i)) return 1;
                        else if (o1.name.charAt(i) < o2.name.charAt(i)) return -1;
                    }
                    if (o1.name.length() > o2.name.length()) return 1;
                    else return -1;
                }
            }
        });
        // 7) answer용 list 하나 더 만들어서 list의 앞에 5명만 이름 전달해서 저장.
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cnt == 5) break;
            if (list.get(i).score > 0) {
                answer.add(list.get(i).name);
                cnt++;
            }
        }
        return answer;
    }
}

class Pair {
    int score;
    String name;

    Pair(Integer score, String name) {
        this.score = score;
        this.name = name;
    }
}
