package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new java.util.ArrayList<>(Collections.emptyList());
        List<String> users = new ArrayList<>();
        HashMap<String, Integer> points = new HashMap<>();
        boolean[][] graph;
        graph = new boolean[10000][10000];
        users.add(user);

        //그래프 생성
        for(int i = 0; i < friends.size();i++){
            String user_a = friends.get(i).get(0);
            String user_b = friends.get(i).get(1);

            if(users.indexOf(user_a) == -1){
                users.add(user_a);
                points.put(user_a, 0);
            }
            if(users.indexOf(user_b) == -1){
                users.add(user_b);
                points.put(user_b, 0);
            }

            graph[users.indexOf(user_a)][users.indexOf(user_b)] = true;
            graph[users.indexOf(user_b)][users.indexOf(user_a)] = true;

            if(user_a == user){
                points.put(user_b, -1);
            }
            if(user_b == user){
                points.put(user_a, -1);
            }

        }

        for(int i = 0; i < users.size();i++){
            if(graph[0][i] == true){
                for(int k = 1; k < users.size(); k++){
                    String tmp = users.get(k);
                    if(graph[i][k] == true && points.get(tmp) != -1){
                        points.put(tmp, points.get(tmp) + 10);
                    }
                }
            }
        }

        for(int i = 0; i < visitors.size(); i++){
            String visitor = visitors.get(i);
            if(users.indexOf(visitor) == -1){
                users.add(visitor);
                points.put(visitor, 1);
            }
            else{
                points.put(visitor, points.get(visitor) + 1);
            }
        }

        //정렬
        int max = 0;
        String name="";
        boolean flag = false;
        for(int i = 0; i<5;i++){
            Iterator<String> keys = points.keySet().iterator();
            max = 0;
            name = "";
            flag = false;
            while(keys.hasNext()){
                String key = keys.next();
                if(i == 0&&points.get(key) == -1) {
                    points.remove(key);
                }
                if(max < points.get(key)){
                    name = key;
                    max = points.get(key);
                    flag = true;
                }
                else if(max == points.get(key)){
                    if(name.compareTo(key)>0){
                        name = key;
                    }
                }

            }
            if(flag == false){
                break;
            }
            else{
                answer.add(name);
                points.remove(name);
            }

        }
        return answer;
    }
}
