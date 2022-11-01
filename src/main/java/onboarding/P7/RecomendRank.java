package onboarding.P7;

import java.util.*;

public class RecomendRank {

    public List<String> rankFive(String user, List<List<String>> friends, List<String> visitors){
        RecommendScore recommendScore = new RecommendScore();


        return getRankFive(getAllRank(rankScore(recommendScore.giveScroeAll(user, friends, visitors))));
    }

    private static List<Map.Entry<String, Integer>> rankScore(Map<String, Integer> usersScore){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(usersScore.entrySet());
        entryList.sort((o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;

            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });
        return entryList;
    }

    private static List<String> getAllRank (List<Map.Entry<String, Integer>> rankScore){
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : rankScore) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<String> allRank = new ArrayList<>(sortedMap.keySet());
        return allRank;
    }

    private static List<String> getRankFive(List<String> memberRank){
        int cnt =1;
        List<String> rankFive = new ArrayList<>();
        for(String member: memberRank){
            if(cnt>5){
                break;
            }
            rankFive.add(member);
            cnt += 1;
        }
        return rankFive;

    }



}
