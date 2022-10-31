package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Problem6 {
    public static boolean isItRightEmail(List<List<String>> forms) {
        for(int i =0; i < 5; i++) {
            String[] emailArr = forms.get(i).get(0).split("@");
            if(forms.get(i).get(0).length() < 11 || forms.get(i).get(0).length() >= 20) {
                return false;
            };
            if(!emailArr[1].equals("email.com")) {
                return false;
            }
        };
        return true;
    }
    public static List<String> findSolution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        for(int i =0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for(int j = 0; j < name.length() - 1; j++) {
                nameList.add(name.substring(j, j + 2));
            }
        };

        for(int k = 0; k < forms.size(); k++) {
            String newName = forms.get(k).get(1);
            for(int l = 0; l < newName.length() - 1; l++) {
                String anotherName = newName.substring(l, l + 2);
                int frequency = Collections.frequency(nameList, anotherName);
                if(frequency >= 2) {
                 answer.add(forms.get(k).get(0));
                 break;
                }
            }
        };
        return answer;
    };
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        if(isItRightEmail(forms)) {
            answer = findSolution(forms);
            Collections.sort(answer);
        }
        return answer;
    }
}
