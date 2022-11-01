package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        String[][] data = new String[friends.size()][2];
        List<List<String>> result = new ArrayList<>();
        List<String> value = new ArrayList<>();
        List<String> userf = new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(1).equals(user)){
                userf.add(friends.get(i).get(0));
            }
        }

        int a=0;
        for(int i=0;i<userf.size();i++){
            for(int j=0;j<friends.size();j++) {
                if (friends.get(j).get(0).equals(userf.get(i)) && !friends.get(j).get(1).equals(user)) {
                    data[a][0] = friends.get(j).get(0);
                    data[a][1] = "10";
                    a++;
                }
            }
        }


        return answer;
    }
}
