package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        int size = forms.size();
        int[] check =  new int[size];

        for(int i=0;i<forms.size();i++){
            String name = forms.get(i).get(1);
            for(int j=0;j<name.length()-1;i++){
                String duplication = name.substring(j,j+2);


            }
        }

        return answer;
    }
}
