package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(int i = 0; i < forms.size() - 1; i++){
            for(int j = i + 1; j < forms.size(); j++){
                List<String> crew1 = forms.get(i);
                List<String> crew2 = forms.get(j);

                String crew1_mail = crew1.get(0);
                String crew1_name = crew1.get(1);

                String crew2_mail = crew2.get(0);
                String crew2_name = crew2.get(1);
            }
        }

        return answer;
    }

    public static boolean checkSameWord(String name1, String name2) {
        boolean result = false;

        for (int i = 0; i < name1.length() - 1; i++) {
            String name1_i = name1.substring(i, i + 2);

            for (int j = 0; j < name2.length() - 1; j++) {
                String name2_j = name2.substring(j, j + 2);

                if (name1_i.equals(name2_j)) {
                    result = true;
                }
            }
        }

        return result;
    }
}
