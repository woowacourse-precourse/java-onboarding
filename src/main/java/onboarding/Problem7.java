package onboarding;

import java.util.*;

public class Problem7 {
    public static boolean checkParameter(String user, List<List<String>> friends, List<String> visitors) {
        //user는 길이가 1 이상 30 이하인 문자열이다.
        if(user.length() < 1 || user.length() > 30) {
            return false;
        }

        //friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
        if(friends.size() < 1 || friends.size() > 10000) {
            return false;
        }

        //visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        if(visitors.size() > 10000) {
            return false;
        }

        return true;
    }

    public static boolean isAlpa(String userA, String userB) {
        for(int i=0 ; i<userA.length() ; i++) {
            char word = userA.charAt(i);
            if (!(word >= 'a' && word <= 'z')) {
                return false;
            }
        }

        for(int i=0 ; i<userB.length() ; i++) {
            char word = userB.charAt(i);
            if (!(word >= 'a' && word <= 'z')) {
                return false;
            }
        }

        return true;
    }

    public static boolean makeUserFriendList(String user, List<List<String>> friends, List<String> userFriendList) {
        for(int i=0 ; i< friends.size() ; i++) {
            //friends의 각 원소는 길이가 2인 리스트/배열이다.
            if(friends.get(i).size() != 2) {
                return false;
            }

            String userA = friends.get(i).get(0);
            String userB = friends.get(i).get(1);

            //아이디는 길이가 1 이상 30 이하인 문자열이다.
            if(userA.length() < 1 || userA.length() > 30 || userB.length() < 1 || userB.length() > 30) {
                return false;
            }

            if(!isAlpa(userA, userB)) {
                return false;
            }

            if(userA.equals(user)) {
                userFriendList.add(userB);
            }

            if(userB.equals(user)) {
                userFriendList.add(userA);
            }
        }
        return true;
    }

    public static void makeFriendScore(String user, List<String> userFriendList, Map<String, Integer> friendScoreBoard ,List<List<String>> friends) {
        for(int i=0 ; i<friends.size() ; i++) {
            String userA = friends.get(i).get(0);
            String userB = friends.get(i).get(1);

            if(userFriendList.contains(userA)) {
                if(userB == user) break;

                if(!userFriendList.contains(userB)) {
                    if(!friendScoreBoard.containsKey(userB)) {
                        friendScoreBoard.put(userB, 10);
                    }

                    if(friendScoreBoard.containsKey(userB)) {
                        friendScoreBoard.put(userB, friendScoreBoard.get(userB) + 10);
                    }
                }
            }

            if(userFriendList.contains(userB)) {
                if(userA == user) break;

                if(!userFriendList.contains(userA)) {
                    if(!friendScoreBoard.containsKey(userA)) {
                        friendScoreBoard.put(userA, 10);
                    }

                    if(friendScoreBoard.containsKey(userA)) {
                        friendScoreBoard.put(userA, friendScoreBoard.get(userA) + 10);
                    }
                }
            }
        }
    }





    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if(!checkParameter(user, friends, visitors)) {
            return answer;
        }

    }
}
