package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

        List<String> answer = Collections.emptyList();
        System.out.println(Arrays.toString(nameList));
        for (int j = 0; j < linkarr.length; j++) {
            System.out.println(Arrays.toString(linkarr[j]));
        }

        int userindex = indexMap.get(user);
        for (int j = 0; j < nameList.length; j++) {
            if(linkarr[userindex][j]==1){
                for (int k = 0; k < nameList.length; k++) {
                    if(linkarr[j][k]==1){
                        int score = scoreMap.get(nameList[k]);
                        scoreMap.put(nameList[k],score+10 );
                    }
                }
            }
        }




        return answer;
    }

    public static void friendScore(List<List<String>> friends){



    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        solution(user, friends, visitors);
    }
}
