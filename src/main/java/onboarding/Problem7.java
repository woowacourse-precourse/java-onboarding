package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> userIndexMappingMap = new HashMap<String, Integer>();
    static int index = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        addMap(user);

        //initailize( maybe scheduled to be refactorized )
        for(int i = 0; i < friends.size(); i++){
            addMap(friends.get(i).get(0));
            addMap(friends.get(i).get(1));
        }
        for(int i = 0; i < visitors.size(); i++){
            addMap(visitors.get(i));
        }
        int userNumber = userIndexMappingMap.size();
        int[] visitorArray = new int[userNumber];
        int[][] friendMatrix = new int[userNumber][userNumber];


        for(int i = 0; i < visitors.size(); i++){
            visitorArray[userIndexMappingMap.get(visitors.get(i))]++;
        }
        for(int i = 0; i < friends.size(); i++){
            friendMatrix[userIndexMappingMap.get(friends.get(i).get(0))][userIndexMappingMap.get(friends.get(i).get(1))] = 1;
            friendMatrix[userIndexMappingMap.get(friends.get(i).get(1))][userIndexMappingMap.get(friends.get(i).get(0))] = 1;
        }

        Map<Integer, Integer> recommendScore = new HashMap<Integer, Integer>();
        for(int i = 0; i < userNumber; i++){
            recommendScore.put(i,0);
        }

        for(int i = 1; i < userNumber; i++){
            recommendScore.put(i,recommendScore.get(i)+visitorArray[i]);
        }
        for(int i = 1; i <userNumber; i++){
            for(int j = 1; j < userNumber; j++){
                if(i != j && friendMatrix[0][j] == 1 && friendMatrix[i][j] == 1){
                    recommendScore.put(i,recommendScore.get(i)+5);
                }
            }
        }
        List<Integer> keySet = new ArrayList<>(recommendScore.keySet());
        keySet.sort((o1, o2) -> recommendScore.get(o2).compareTo(recommendScore.get(o1)));
        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < userNumber; i++){
            if(friendMatrix[0][keySet.get(i)] != 1 && keySet.get(i) != 0) {
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

}
