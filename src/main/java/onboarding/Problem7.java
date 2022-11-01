package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static Map<String, Integer> userIndexMappingMap = new HashMap<String, Integer>();
    static int index = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {



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
