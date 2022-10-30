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
        List<String> answer = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
}
