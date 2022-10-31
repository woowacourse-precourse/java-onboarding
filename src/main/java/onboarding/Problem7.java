package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (List<String> list :friends) {

            for (int i = 0; i < 2; i++) {
                String name= list.get(i);
                if(!scoreMap.containsKey(name)){
                    scoreMap.put(name,0);
                }
            }
        }
        String[] nameList = new String[scoreMap.size()];
        int i=0;
        for(String name : scoreMap.keySet()){
            nameList[i]=name;
            indexMap.put(name,i);
            i++;
        }
        int[][] linkarr = new int[nameList.length][nameList.length];

        for (List<String> list : friends) {
            linkarr[indexMap.get(list.get(0))][indexMap.get(list.get(1))] = 1;
            linkarr[indexMap.get(list.get(1))][indexMap.get(list.get(0))] = 1;
        }

        List<String> answer = new ArrayList<>();

        for(String name : visitors){
            if(scoreMap.containsKey(name)){
                int score = scoreMap.get(name);
                scoreMap.put(name,score+1);
            }else {
                scoreMap.put(name,1);
            }
        }

        int userindex = indexMap.get(user);
        for (int j = 0; j < nameList.length; j++) {
            if(linkarr[userindex][j]==1){
                scoreMap.remove(nameList[j]);
                for (int k = 0; k < nameList.length; k++) {
                    if(linkarr[j][k]==1){
                        int score = scoreMap.get(nameList[k]);
                        scoreMap.put(nameList[k],score+10 );
                    }
                }
            }
        }
        scoreMap.remove(user);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort(((o1, o2) -> scoreMap.get(o2.getKey()) - scoreMap.get(o1.getKey())));

        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println("name : " + entry.getKey() + ", score : " + entry.getValue());
            answer.add(entry.getKey());
        }

        return answer;
    }
}
