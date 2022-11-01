package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static String solutionAnswer(){
        String answer="";
        List<String> list = new ArrayList<String>();

        list.add("제이엠");
        list.add("제이슨");
        list.add("워니");
        list.add("엠제이");
        list.add("이제엠");

        System.out.println(list);

        ArrayList<String> check = new ArrayList<>();
        ArrayList<Integer> countSize = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = "";
            int count = 0;
            check.add("" + i);
            for (int j = 0; j < list.get(i).length() - 1; j++) {
                s = list.get(i).substring(j, j + 2);
                check.add(s);
                count++;
            }

            countSize.add(count);
        }

        for(int i=0;i<check.size()-1;i++) {
            if(check.lastIndexOf(check.get(i)) != i) {
                check.remove(check.get(i));
            }


        }
        return answer;
    }
}
