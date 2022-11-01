package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, Integer> userIndexMappingMap = new HashMap<String, Integer>();
    static int index = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        initializeMap(user,friends,visitors);

        int userNumber = userIndexMappingMap.size();
        int[] visitorArray = new int[userNumber];
        boolean[][] friendMatrix = new boolean[userNumber][userNumber];


        for (String visitor : visitors) {
            visitorArray[userToIndex(visitor)]++;
        }
        for (List<String> friend : friends) {
            friendMatrix[userToIndex(friend.get(0))][userToIndex(friend.get(1))] = true;
            friendMatrix[userToIndex(friend.get(1))][userToIndex(friend.get(0))] = true;
        }

        Map<Integer, Integer> recommendScore = makeRecommendScore(visitorArray,friendMatrix,userNumber);

        List<String> answer = new ArrayList<String>();

        List<Integer> keySet = new ArrayList<>(recommendScore.keySet());
        keySet.sort((o1, o2) -> recommendScore.get(o2).compareTo(recommendScore.get(o1)));
        for(int i = 0; i < userNumber; i++){
            if(!friendMatrix[0][keySet.get(i)] && keySet.get(i) != 0) {
                answer.add(getKey(keySet.get(i)));
            }
            if(answer.size() == 5){
                break;
            }
        }

        return answer;
    }



    public static void addMap(String userName){
        if(!userIndexMappingMap.containsKey(userName)){
            userIndexMappingMap.put(userName,index);
            index++;
        }
    }
    public static String getKey(int value) {
        for (String key : userIndexMappingMap.keySet()) {
            if (userIndexMappingMap.get(key).equals(value)) {
                return key;
            }
        }
        return "error";
    }
    public static int userToIndex(String user){
        return userIndexMappingMap.get(user);
    }

    public static void initializeMap(String user, List<List<String>> friends, List<String> visitors){
        addMap(user);

        for (List<String> friend : friends) {
            addMap(friend.get(0));
            addMap(friend.get(1));
        }
        for (String visitor : visitors) {
            addMap(visitor);
        }
    }

    public static Map<Integer, Integer> makeRecommendScore(
            int[] visitorArray, boolean[][] friendMatrix,int userNumber){
        Map<Integer, Integer> recommendScore = new HashMap<Integer, Integer>();
        for(int i = 0; i < userNumber; i++){
            recommendScore.put(i,0);
        }

        for(int i = 1; i < userNumber; i++){
            recommendScore.put(i,recommendScore.get(i)+visitorArray[i]);
        }

        for(int i = 1; i <userNumber; i++){
            for(int j = 1; j < userNumber; j++){
                if(i != j && friendMatrix[0][j] && friendMatrix[i][j]){
                    recommendScore.put(i,recommendScore.get(i)+5);
                }
            }
        }
        return recommendScore;
    }
}
