package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer = removeNicknameDeduplication(forms);

        return answer;
    }
    public static List<String> removeNicknameDeduplication(List<List<String>> forms) {
        int flag;
        int flag2;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                flag = 0;
                flag2 = 0;
                for (int k = 0; k < forms.get(i).get(1).length(); k++) {
                    for (int z = 0; z < forms.get(j).get(1).length(); z++) {
                        if (forms.get(i).get(1).charAt(k) == forms.get(j).get(1).charAt(z) && forms.get(i).get(0 ).contains("email.com")) {
                            if (k == flag + 1 && z == flag2 + 1) {
                                if (!result.contains(forms.get(i).get(0))) {
                                    result.add(forms.get(i).get(0));
                                }
                                if (!result.contains(forms.get(j).get(0))) {
                                    result.add(forms.get(j).get(0));
                                }
                            } else {
                                flag = k;
                                flag2 = z;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    //public static List<String> sortByEmail() {};
}
