package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 사용자와 친구인 아이디를 구하는 기능
        List<String> userFriends = new ArrayList<>(); // 사용자의 친구들
        for (int i = 0; i < friends.size(); i++) {
            // 사용자에 관한 친구 정보일 경우
            if (friends.get(i).contains(user)) {
                String user1 = friends.get(i).get(0);
                String user2 = friends.get(i).get(1);

                if (user1.equals(user)) {
                    userFriends.add(user2);
                } else if (user2.equals(user)) {
                    userFriends.add(user1);
                }
            }
        }

        // <아이디, 추천 점수>를 저장하는 해시맵
        HashMap<String, Integer> score = new HashMap<>();

        // 사용자와 함께 아는 친구의 수를 구하는 기능
        for (int i = 0; i < userFriends.size(); i++) {
            String friend = userFriends.get(i); // 사용자와 친구

            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(friend)) { // 사용자와의 친구의 친구일 경우
                    String user1 = friends.get(j).get(0);
                    String user2 = friends.get(j).get(1);

                    if (user1.equals(friend)) {
                        if (!user2.equals(user)) { // 사용자가 아닐 경우
                            if (!userFriends.contains(user2)) // 사용자와 친구가 아닐 경우
                                if (score.containsKey(user2)) { // 아이디가 이미 존재할 경우
                                    score.put(user2, score.get(user2) + 10);
                                } else { // 아이디가 존재하지 않을 경우
                                    score.put(user2, 10);
                                }
                        }
                    } else if (user2.equals(friend)) {
                        if (!user1.equals(user)) { // 사용자가 아닐 경우
                            if (!userFriends.contains(user1)) { // 사용자와 친구가 아닐 경우
                                if (score.containsKey(user1)) { // 아이디가 이미 존재할 경우
                                    score.put(user1, score.get(user1) + 10);
                                } else { // 아이디가 존재하지 않을 경우
                                    score.put(user1, 10);
                                }
                            }
                        }
                    }
                }
            }
        }

        // 사용자의 타임 라인에 방문한 횟수를 구하는 기능
        for(int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (!userFriends.contains(visitor)) { // 친구 관계가 아닐 경우
                if (score.containsKey(visitor)) { // 아이디가 이미 존재할 경우
                    score.put(visitor, score.get(visitor) + 1);
                } else { // 아이디가 존재하지 않을 경우
                    score.put(visitor, 1);
                }
            }
        }

        return answer;
    }
}
