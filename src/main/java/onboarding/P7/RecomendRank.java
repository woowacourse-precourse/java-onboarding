package onboarding.P7;

import java.util.*;

public class RecomendRank {

    public List<String> rankFive(String user, List<List<String>> friends, List<String> visitors){
        RecommendScore recommendScore = new RecommendScore();
        Map<String, Integer> map = recommendScore.recommendScore(user, friends, visitors);
        return result(map);
    }

    private static List<String> result (Map<String, Integer> map1){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map1.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<String, Integer> valueDescendingMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            valueDescendingMap.put(entry.getKey(), entry.getValue());
        }
        List<String> rankuser = new ArrayList<>();
        for(String key : valueDescendingMap.keySet()){
            rankuser.add(key);
        }

        List<String> lastresult = new ArrayList<>();
        int cnt = 1;
        for(String s: rankuser){
            if(cnt > 5){
                break;
            }
            lastresult.add(s);
            cnt+=1;
        }
        return lastresult;
    }
}
