package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();


        for(List<String> form : forms){
            int index = 0;
            while(index < form.get(1).length()-1){
                if(hashSet.contains(form.get(1).substring(index,index+2))) {
                    hashSet2.add(form.get(1).substring(index,index+2));
                }
                hashSet.add(form.get(1).substring(index,index+2));
                index++;
            }
        }

        for(List<String> form : forms){
            int index = 0;
            while(index < form.get(1).length()-1) {
                if (hashSet2.contains(form.get(1).substring(index, index + 2))) {
                    hashSet3.add(form.get(0));
                }
                index++;
            }

        }
        List<String> answer = new ArrayList<>(hashSet3);

        return answer;
    }
}
