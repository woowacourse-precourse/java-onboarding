package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> name = new ArrayList<>();
        List<Integer> emailnumber = new ArrayList<>();
        List<String> email = new ArrayList<>();
        String tmp = "";

        for (int i = 0; i < forms.size(); i++) {
            name.add(forms.get(i).get(1));
        } // 네임 리스트 생성


        for (int i = name.size() - 1; i > 0; i--) {
            for (int j = 0; j < name.get(i).length() - 1; j++) {
                tmp = name.get(i).substring(j, j + 2);//pattern
                for (int z = 0; z < i; z++) {
                    if (name.get(z).contains(tmp)) {
                        emailnumber.add(i);
                        emailnumber.add(z);
                    }
                }

            }
        }
        return email;
    }
}