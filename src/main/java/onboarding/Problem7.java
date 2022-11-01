package onboarding;

import java.util.*;

public class Problem7 {

    static List<String> getNameOfDirectFriend(String user, List<List<String>> friends){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++){
            String firName = friends.get(i).get(0);
            String secName = friends.get(i).get(1);

            if(firName == user){
                res.add(secName);
            }else if(secName == user){
                res.add(firName);
            }
        }
        return res;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> nameOfDirectFriendOfUser = new ArrayList<>();
        // user와 친구인 사람들의 이름 목록
        nameOfDirectFriendOfUser = getNameOfDirectFriend(user, friends);


        // 함께 아는 사람에게 점수 부여
        Map<String, Integer> scoreOfFriendsOfUser = new HashMap<>();
        for(int i = 0; i < friends.size(); i++){
            String firName = friends.get(i).get(0);
            String secName = friends.get(i).get(1);

            if(user.equals(firName) || user.equals(secName)) {
                continue;
            }

            // firName은 user랑 친구고 secNAme은 아닐경우
            if(nameOfDirectFriendOfUser.contains(firName) && !nameOfDirectFriendOfUser.contains(secName)){
                if(scoreOfFriendsOfUser.containsKey(secName)){
                    int oldScore = scoreOfFriendsOfUser.get(secName);
                    scoreOfFriendsOfUser.put(secName, oldScore+10);
                }else{
                    scoreOfFriendsOfUser.put(secName, 10);
                }
            }
            // firName은 user랑 친구가 아니고 secName은 친구일경우
            else if(!nameOfDirectFriendOfUser.contains(firName) && nameOfDirectFriendOfUser.contains(secName)){
                if(scoreOfFriendsOfUser.containsKey(firName)){
                    int oldScore = scoreOfFriendsOfUser.get(firName);
                    scoreOfFriendsOfUser.put(firName, oldScore+10);
                }else {
                    scoreOfFriendsOfUser.put(firName, 10);
                }
            }
        }

        System.out.println("10점씩 점수 부여 후 결과");
        for (String name : scoreOfFriendsOfUser.keySet()) {
            System.out.println("name = " + name + " score = " + scoreOfFriendsOfUser.get(name));
        }


        // 방문한 횟수에 따라 1점씩 부여
        for(int i = 0; i < visitors.size(); i++){
            if(scoreOfFriendsOfUser.containsKey(visitors.get(i))){
                int oldValue = scoreOfFriendsOfUser.get(visitors.get(i));
                scoreOfFriendsOfUser.replace(visitors.get(i), oldValue+1);
            }else{
                scoreOfFriendsOfUser.put(visitors.get(i), 1);
            }
        }

        System.out.println("1점씩 점수 부여 후 결과");
        for (String name : scoreOfFriendsOfUser.keySet()) {
            System.out.println("name = " + name + " score = " + scoreOfFriendsOfUser.get(name));
        }


        // 점수 높은 순대로 친구 5명 뽑기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreOfFriendsOfUser.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int cnt = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if(cnt == 5) break;
            if(entry.getValue() != 0 && !nameOfDirectFriendOfUser.contains(entry.getKey())){
                answer.add(entry.getKey());
                cnt++;
            }
        }

        return answer;
    }
}
