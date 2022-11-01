package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> crew = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        List<Integer> plus;

        try {
            if (forms.size() < 1 || forms.size() > 10000) {
                throw new Exception("크루 숫자가 이상합니다");
            }
            for (int i = 0; i < forms.size(); i++) {
                if(Valid(forms.get(i))) {
                    crew.add(forms.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

        for (int i = 0; i < crew.size(); i++) {
            for (int j = 0; j < crew.get(i).get(1).length() - 1; j++){
                plus = repeat(crew, crew.get(i), j);
                if(!plus.isEmpty()) {
                    for (int k = 0; k < plus.size(); k++) {
                        if (!answer.contains(crew.get(plus.get(k)).get(0))) {
                            answer.add(crew.get(plus.get(k)).get(0));
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    static List<Integer> repeat(List<List<String>> forms, List<String> crew, int num) {
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).equals(crew.get(1))) {
                continue;
            }
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                if (crew.get(1).substring(num, num + 2).equals(forms.get(i).get(1).substring(j, j+2))) {
                    plus.add(i);
                    break;
                }
            }
        }
        return plus;
    }

    static boolean Valid(List<String> list) {
        boolean err = ((list.get(0).split("@")[1].equals("email.com"))
                && (20 > list.get(0).length() && list.get(0).length()> 10)
                && Pattern.matches("^[가-힣]*$", list.get(1))
                && list.get(1).length() < 20 && list.get(1).length() > 0);
        return err;
    }
}