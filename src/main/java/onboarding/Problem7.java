package onboarding;

import java.util.*;

public class Problem7 {

    public static void addRelations(String a, String b, HashMap<String, List<String>> relations) {
        if (!relations.containsKey(a)) {
            relations.put(a, new ArrayList<String>());
        }
        if (!relations.containsKey(b)) {
            relations.put(b, new ArrayList<String>());
        }
        relations.get(a).add(b);
        relations.get(b).add(a);
    }

    public static void setScores(List<String> friendList, HashMap<String, Integer> scores, String user, List<String> userFriend) {
        for (String name : friendList){
            if (!scores.containsKey(name) && name != user && !userFriend.contains(name)) {
                scores.put(name, 10);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> relations = new HashMap<>();
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> sortValueList;
        int cnt;
        // key -> 이름, value -> 친구 관계인 사람들
        for (List<String> people : friends) {
            String name1 = people.get(0);
            String name2 = people.get(1);
            addRelations(name1, name2, relations);
        }

        // user의 친구의 친구인 사용자를 10점으로 설정
        for (String name : relations.get(user)) {
            setScores(relations.get(name), scores, user, relations.get(user));
        }

        // 방문한 횟수만큼 1 증가
        for (String name : visitors) {
            if (!scores.containsKey(name)) {
                scores.put(name, 1);
            }
            else {
                scores.put(name, scores.get(name)+1);
            }
        }

        // score 기준으로 사용자 내림차순 정렬, 점수가 같을 경우 사용자 이름순(오름차순)으로 정렬
        sortValueList = new ArrayList<>(scores.keySet());
        Collections.sort(sortValueList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int comparison = (scores.get(o1) - scores.get(o2)) * -1;
                return comparison == 0 ? o1.compareTo(o2) : comparison;
            }
        });
        cnt = 0;
        answer = new ArrayList<>();

        // 최대 5개까지 출력하도록 설정
        for (String name : sortValueList) {
            if (cnt == 5) {
                break;
            }
            else if (!relations.get(user).contains(name)) {
                answer.add(name);
                cnt += 1;
            }
        }

        return answer;
    }
}
