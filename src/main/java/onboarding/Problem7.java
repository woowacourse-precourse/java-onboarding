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
        value.add(data[0][0]);
        value.add(data[0][1]);
        for(int i=1;i<data.length;i++) {
            if (!value.contains(data[i][0])){
                value.add(data[i][0]);
                value.add(data[i][1]);
            }else{
                for(int j=0;j<value.size()-1;j++){
                    if(value.get(j).equals(data[i][0])){
                        int va = Integer.parseInt(value.get(j+1)) +10;
                        value.set(j+1,String.valueOf(va));
                    }
                }
            }
        }
        for(int i=0;i<value.size()-1;i++){
            for(int j=0;j<visitors.size();j++) {
                if(!value.contains(visitors.get(j))){
                    value.add(visitors.get(j));
                    value.add("1");
                }
                else if (!userf.contains(visitors.get(j)) && value.get(i).equals(visitors.get(j))){
                    int va = Integer.parseInt(value.get(j+1)) + 1;
                    value.set(j+1,String.valueOf(va));
                }
            }
        }
        result.add(value);

        return answer;
    }
}
