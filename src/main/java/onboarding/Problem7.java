package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class Problem7 {
    static void isCheck(String user, List<List<String>> friends, List<String> visitors) {
        userCheck(user);
        friendsCheck(friends);
        visitorsCheck(visitors);
    }

    static void userCheck(String user) {
        if(user.length()<1 || user.length()>30) {
            System.out.println("user의 길이가 잘못되었습니다.");
        }
        if(!Pattern.matches("[a-z]*$", user)) {
            System.out.println("user는 알파벳 소문자만 입력가능합니다.");
        }
    }

    static void friendsCheck(List<List<String>> friends) {
        if(friends.size()<1 || friends.size()>10000) {
            System.out.println("친구관계정보는 1이상 10,000이하까지 입력이 가능합니다.");
        }
        for(int i=0; i<friends.size(); i++) {
            for(int j=0; j<=1; j++) {
                if(friends.get(i).get(j).length()<1 || friends.get(i).get(j).length()>30) {
                    System.out.println("친구아이디 길이는 1이상 30이하까지 입력이 가능합니다.");
                }
            }
        }
    }

    static void visitorsCheck(List<String> visitors) {
        if(visitors.size()<0 || visitors.size()>10000) {
            System.out.println("방문기록은 0이상 10,000이하까지 입력이 가능합니다.");
        }
    }

    static List<String> createFriendsList(String user, List<List<String>> friends, List<String> alreadyFriends) {
        for (int i=0; i<friends.size(); i++) {
            for (int j = 0; j <= 1; j++) {
                if (friends.get(i).get(j).contains(user) && j==0) {
                    alreadyFriends.add(friends.get(i).get(1));
                } else if (friends.get(i).get(j).contains(user) && j==1) {
                    alreadyFriends.add(friends.get(i).get(0));
                }
            }
        }
        return alreadyFriends;
    }

    static HashMap<String, Integer> friendsScore(String user, List<List<String>> friends, List<String> alreadyFriends, HashMap<String, Integer> friendsRecommendation) {
        createFriendsList(user, friends, alreadyFriends);

        for(int i=0; i<alreadyFriends.size(); i++) {
            for(int j=0; j<friends.size(); j++) {
                for(int k=0; k<=1; k++) {
                    if(friends.get(j).get(k).contains(alreadyFriends.get(i)) && k==0 && friends.get(j).get(1) != user) { // 이미친구목록에 있지 않으면서 0번 배열에 도넛이나 사케반이 있고 user와 일치하지않는 경우 > 1번 넣어줘야함
                        if(isContains(i, j, friends, friendsRecommendation)) { // containCheck가 참이라면(해시맵에 있다면)
                            friendsRecommendation.put(friends.get(j).get(1), friendsRecommendation.get(friends.get(j).get(1))+10);
                        } else {
                            friendsRecommendation.put(friends.get(j).get(1), 10); // 없다면
                        }

                    } else if(friends.get(j).get(k).contains(alreadyFriends.get(i)) && k==1 && friends.get(j).get(0) != user) { // 1번 배열에 있는 경우 > 0번 넣어줘야함
                        if(isContains(i, j, friends, friendsRecommendation)) { // containCheck가 참이라면(해시맵에 있다면)
                            friendsRecommendation.put(friends.get(j).get(0), friendsRecommendation.get(friends.get(j).get(1))+10);
                        } else {
                            friendsRecommendation.put(friends.get(j).get(0), 10); // (j)(0)를 넣어줘라
                        }
                    }
                }
            }
        }
        return friendsRecommendation;
    }

    static boolean isContains(int i, int j, List<List<String>> friends, HashMap<String, Integer> friendsRecommendation) {
        if(friendsRecommendation.containsKey(friends.get(j).get(1))) {
            return true;
        }
        return false;
    }

    static HashMap<String, Integer> visitorsScore(String user, List<String> visitors, List<String> alreadyFriends, HashMap<String, Integer> friendsRecommendation) {

        for(int i = 0; i < visitors.size(); i++) {
            if(friendsRecommendation.containsKey(visitors.get(i)) && !alreadyFriends.contains(visitors.get(i))) {
                friendsRecommendation.put(visitors.get(i), friendsRecommendation.get(visitors.get(i)) + 1);
            } else if(!alreadyFriends.contains(visitors.get(i))) {
                friendsRecommendation.put(visitors.get(i), 1);
            }
        }
        return friendsRecommendation;
    }

    static List<String> sort(HashMap<String, Integer> friendsRecommendation, List<String> answer) {
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(friendsRecommendation.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return (obj2.getValue().compareTo(obj1.getValue()));
            }
        });

        if(list.size() > 5) {
            for(int i=0; i<5; i++) {
                answer.add(list.get(i).getKey());
            }
        } else {
            for(int i=0; i<list.size(); i++) {
                answer.add(list.get(i).getKey());
            }
        }
        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriends = new ArrayList<>();
        HashMap<String, Integer> friendsRecommendation = new HashMap<>();

        isCheck(user, friends, visitors);

        friendsScore(user, friends, alreadyFriends, friendsRecommendation);
        visitorsScore(user, visitors, alreadyFriends, friendsRecommendation);

        sort(friendsRecommendation, answer);

        return answer;
    }
}
