package onboarding;

import java.util.*;

public class Problem7 {

    public static ArrayList<Integer> graph[];
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //1. 친구 정보가 주어진 모든 사용자명을 추출한다.
        //2. 친구 정보를 담는 그래프(연결리스트)를 생성하여 데이터를 저장한다.
        List<String> users = initData(friends, visitors);

        //3. 주어진 사용자 아이디와 친구인 사용자를 조사하여 점수를 부여한다.
        List<String> answer;
        int[] score = new int[users.size()];
        int userIdx = users.indexOf(user);

        for(int w : graph[userIdx]){
            score = calculateScore(score, w);
        }

        //4. visitor 리스트를 조사하여, 방문한 사용자에게 1점씩 부여한다.
        for(String visitor : visitors){
            int visitorIdx = users.indexOf(visitor);
            score[visitorIdx]++;
        }

        //5. 모든 점수를 부여했다면 점수가 높은 5명을 추린다.
        answer = sortUserByScore(users, score, user);

        return answer;
    }

    public static List<String> sortUserByScore(List<String> users, int[] score, String user){
        Map<String, Integer> userMap = new HashMap<>();
        for(int i = 0; i < users.size(); i++){
            userMap.put(users.get(i), score[i]);
        }
        userMap.remove(user);

        List<Map.Entry<String, Integer>> entry = new LinkedList<>(userMap.entrySet());
        entry.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue() == o1.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });

        int userIdx = users.indexOf(user);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Map.Entry<String, Integer> e = entry.get(i);
            String name = e.getKey();
            if(!graph[userIdx].contains(users.indexOf(name))) {
                result.add(e.getKey());
            }
        }

        return result;
    }

    public static int[] calculateScore(int[] score, int friendNumber){
        for(int w : graph[friendNumber]){
            score[w] += 10;
        }

        return score;
    }

    public static List<String> initData(List<List<String>> friends, List<String> visitors){
        Set<String> userSet = new HashSet<>();

        for(List<String> data : friends){
            String user1 = data.get(0);
            String user2 = data.get(1);
            userSet.add(user1);
            userSet.add(user2);
        }

        for(String data : visitors)
            userSet.add(data);

        graph = new ArrayList[userSet.size()];
        List<String> users = new ArrayList<>(userSet);

        for(int i = 0; i < userSet.size(); i++) {
            graph[i] = new ArrayList<>();
        }

        for(List<String> data : friends){
            int user1 = users.indexOf(data.get(0));
            int user2 = users.indexOf(data.get(1));
            graph[user1].add(user2);
            graph[user2].add(user1);
        }

        return users;
    }
}