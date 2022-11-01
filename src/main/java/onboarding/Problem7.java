package onboarding;

import java.util.*;

/*
========================================Problem7 기능 목록========================================
- user에 따라 같은 list에 속해있는 문자열을 찾아 배열로 저장하는 기능
- 배열을 리스트로 변환하는 기능
- 리스트를 배열로 변환하는 기능 (1차원, 2차원)
- map type 변수에 모든 user의 점수를 0으로 초기화하는 기능
- user와 친구인 user의 점수는 0으로 만드는 기능
 */

public class Problem7 {
    public static String[][] listToArray2D(List<List<String>> list){
        String[][] array = new String[list.size()][];

        for(int i = 0;i < array.length;i++)
            array[i] = list.get(i).stream().toArray(String[]::new);
        return array;
    }
    public static String[] listToArray(List<String> list){
        return list.toArray(new String[list.size()]);
    }
    public static String[] findFriend(String user, List<List<String>> friends, List<String> visitors){
        String[][] friendsArray = listToArray2D(friends);
        String[] visitorsArray = listToArray(visitors);
        HashSet<String> set = new HashSet<>();
        int outLen = friendsArray.length;
        int inLen = friendsArray[0].length;
        int len = visitorsArray.length;

        set.add(user);
        for(int i = 0;i < outLen;i++){
            for(int j = 0;j < inLen;j++){
                set.add(friendsArray[i][j]);
            }
        }
        for(int i = 0;i < len;i++) {
            set.add(visitorsArray[i]);
        }
        return set.toArray(new String[0]);
    }
    public static HashMap<String, Integer> initializationFirstScore(String[] users){
        HashMap<String, Integer> map = new HashMap<>();
        int len = users.length;

        for(int i = 0;i < len;i++){
            map.put(users[i], 0);
        }
        return map;
    }
    public static HashMap<String, Integer> resetRealFriendScore(HashMap<String, Integer> map, String[] friends){
        int len = friends.length;

        for(int i = 0;i < len;i++){
            map.put(friends[i], 0);
        }
        return map;
    }
    public static String[] linkFriend(String user, String[][] friends){
        List<String> userFriend = new ArrayList<>();

        int outLen = friends.length;
        int inLen = friends[0].length;

        for(int i = 0;i < outLen;i++){
            for(int j = 0;j < inLen;j++){
                if(friends[i][j].equals(user)){
                    if(j == 0)
                        userFriend.add(friends[i][1]);
                    else
                        userFriend.add(friends[i][0]);
                }
            }
        }
        return userFriend.toArray(new String[userFriend.size()]);
    }
    public static boolean checkStringExist(String str, String[] array){
        int len = array.length;

        for(int i = 0;i < len;i++){
            if(array[i].equals(str))
                return true;
        }
        return false;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
