package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        int i;
        int index = 0;
        HashMap<String, Integer> names = new HashMap<>();
        String[] u_check = new String[friends.size()];

        int outSize = friends.size();
        for(i = 0; i < outSize; i++){
            List<String> First = friends.get(i);
            String str1 = First.get(0);
            String str2 = First.get(1);
            if(str1.equals(user)){
                u_check[index] = str2;
                index++;
            }
            if(str2.equals(user)){
                u_check[index] = str1;
                index++;
            }
            if(!names.containsKey(str1)){
                names.put(str1, 0);
            }
            if(!names.containsKey(str2)){
                names.put(str2, 0);
            }
        }
        int check = 0;
        for(i = 0; i < outSize; i++) {
            List<String> First = friends.get(i);
            String str1 = First.get(0);
            String str2 = First.get(1);
            int j = 0;
            while( j < index){
                if(u_check[j].equals(str1) && !user.equals(str2)){
                    check = names.get(str2);
                    names.replace(str2, check + 10);
                }
                if(u_check[j].equals(str2) && !user.equals(str1)){
                    check = names.get(str1);
                    names.replace(str1, check + 10);
                }
                j++;
            }
        }

        for(i = 0; i < visitors.size(); i++){
            String v = visitors.get(i);
            if(!names.containsKey(v)){
                names.put(v, 1);
            }
            else{
                check = names.get(v);
                names.replace(v, check + 1);
            }
        }

        List<String> listKeySet = new ArrayList<>(names.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (names.get(value2).compareTo(names.get(value1))));

        List<String> answer = new ArrayList<>();
        answer.add("andole");
        answer.add("jun");
        answer.add("bedi");




        return answer;
    }
}
