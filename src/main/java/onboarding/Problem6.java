package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    private List<Boolean> isdup_list = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<List<String>> makeBigramsList(List<List<String>> forms) {
        List<List<String>> bigrams_list = new ArrayList<>();
        for (int i=0; i<forms.size(); i++) {
            String str = forms.get(i).get(1);

            List<String> list = new ArrayList<>();
            int j = 0;
            while (j < str.length() - 1) {
                String sub_str = str.substring(j, j+2);
                list.add(sub_str);
                j += 1;
            }
            bigrams_list.add(list);
        }
        return bigrams_list;
    }

    private void setIsdupList(List<List<String>> forms) {
        for (int i=0; i<forms.size(); i++) {
            isdup_list.add(false);
        }
    }
}
