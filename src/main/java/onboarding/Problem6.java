package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of(forms.get(1).get(0),forms.get(0).get(0),forms.get(3).get(0));
//        String[] nameList = new String[forms.size()];
//        List<String> subNameList = new ArrayList<>();
//
        HashMap map = new HashMap();
//
//        for (int i = 0; i < forms.size(); i++) {
//            for (int j = 1; j < forms.get(i).size(); j++) {
//                nameList[i] = forms.get(i).get(j);
//
//                System.out.println("forms.get(i).get(j) = " + forms.get(i).get(j) + forms.get(i).get(j).length());
//                map.put(forms.get(i).get(j),forms.get(i).get(j).length());
//            }
//        }
//        System.out.println("map.get(\"제이엠\") = " + map.get("제이엠"));
//
//        for (int i = 0; i < nameList.length; i++) {
//            System.out.println("subNameList = " + nameList[i]);
//        }
        /**
         * 처음에 한 생각은 이름값을 하나씩 다 쪼개서 비교해보자. 근데 이러면
         * jm@email.com을 찾을 수가 없어
         */
        for (int i = 0; i < forms.size(); i++) {
            System.out.println("forms.get(i) = " + forms.get(i));
        }

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).size(); j++) {
                map.put(forms.get(i).get(1),forms.get(i).get(0));
            }
        }

        return answer;
    }
}
