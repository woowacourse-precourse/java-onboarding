package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> set = new TreeSet<String>();
        for (int i = 0; i < forms.size() - 1; i++) {
            String checkString = forms.get(i).get(1);
            for (int j = i + 1; j < forms.size(); j++) {
                String compareString = forms.get(j).get(1);
                for (int l = 0; l < checkString.length() - 1; l++) {
                    String checkSentence = String.valueOf(checkString.charAt(l)) + String.valueOf(checkString.charAt(l + 1));
                    for (int k = 0; k < compareString.length() - 1; k++) {
                        String compareSentence = String.valueOf(compareString.charAt(k)) + String.valueOf(compareString.charAt(k + 1));
                        if (compareSentence.equals(checkSentence)) {
                            set.add(forms.get(i).get(0));
                            set.add(forms.get(j).get(0));
                        }
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(set);
        answer.sort(Comparator.naturalOrder());


        return answer;
    }
}
