package onboarding;

import java.util.*;

public class Problem7 {
    public static TreeMap<String, List<String>> graph = new TreeMap<>();

    //기능2
    public static List<String> getFriendsOfUser(String user){
        return graph.get(user);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //기능 1
        for(int i=0;i<friends.size();i++){
            String str1 = friends.get(i).get(0);
            String str2 = friends.get(i).get(1);
            if(graph.get(str1) == null) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str2);
                graph.put(str1, temp);
            }
            else graph.get(str1).add(str2);
            if(graph.get(str2) == null) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str1);
                graph.put(str2, temp);
            }
            else graph.get(str2).add(str1);
        }

        //기능 3
        TreeMap<String, Integer> score_table = new TreeMap<>();
        List<String> user_friends = getFriendsOfUser(user);

        Set<String> users_list = graph.keySet();
        for(String username : users_list){
            if(username.equals(user)) continue;
            if(user_friends.contains(username)) continue;
            int score = 0;
            for(String friend : graph.get(username)){
                if(user_friends.contains(friend)) score += 10;
            }
            score_table.put(username, score);
        }

        //기능 4
        for(String visitor : visitors) {
            if(visitor.equals(user)) continue;
            if(user_friends.contains(visitor)) continue;

            if(score_table.containsKey(visitor)) score_table.replace(visitor, score_table.get(visitor)+1);
            else score_table.put(visitor, 1);
        }
        //기능 5
        Set<String> keys = score_table.keySet();
        int[] counts = new int[10001];
        String[][] arr = new String[10001][10001];
        for(String key : keys) {
            int idx = score_table.get(key);
            arr[idx][counts[idx]++] = key;
        }

        int count = 0;
        for(int i=10000;i>=0;i--) {
            for(int j=0;j<counts[i];j++) {
                answer.add(arr[i][j]);
                count += 1;
                if(count == 5) break;
            }
        }
        return answer;
    }
}
