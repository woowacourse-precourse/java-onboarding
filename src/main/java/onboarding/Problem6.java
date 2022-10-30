package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, String> map2 = new HashMap<>();

        TreeSet<String> treeSet = new TreeSet<>();


        Iterator<List<String>> it= forms.iterator();
        while(it.hasNext()){
            List<String> list2=it.next();
            String email=list2.get(0);
            String name=list2.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                String name2=name.substring(i,i+2);
                if(map2.containsKey(name2)){
                    treeSet.add(email);
                    //본인의 이메일추가(본인도 중복이므로)
                    treeSet.add(map2.get(name2));
                    //중복된 상대방의 이메일 추가.
                }
                map2.put(name2,email);
            }

        }
        answer=new LinkedList<>(treeSet);
        return answer;



    }
}
