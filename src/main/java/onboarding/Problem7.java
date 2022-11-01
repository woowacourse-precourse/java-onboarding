package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int userNumber = userIndexMappingMap.size();
        int[] visitor = new int[userNumber];
        int[][] friendMatrix = new int[userNumber][userNumber];

        for(int i = 0; i < visitors.size(); i++){
            visitor[userIndexMappingMap.get(visitors.get(i))]++;
        }
        for(int i = 0; i < friends.size(); i++){
            friendMatrix[userIndexMappingMap.get(friends.get(i).get(0))][userIndexMappingMap.get(friends.get(i).get(1))] = 1;
            friendMatrix[userIndexMappingMap.get(friends.get(i).get(1))][userIndexMappingMap.get(friends.get(i).get(0))] = 1;
        }

        







        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static void addMap(String userName){
        if(!userIndexMappingMap.containsKey(userName)){
            userIndexMappingMap.put(userName,index);
            index++;
        }
    }

}
