package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (forms.size()<1 || forms.size()>10000)
            return null;

        answer = new ArrayList<String>();

        for(int i = 0; i<forms.size()-1;i++){
            String email = forms.get(i).get(0);
            //@이후 email.com인지 확인하는 Regex

            String nickname = forms.get(i).get(1);
            //nickname 길이 확인 필요
            if (nickname.length()<1 || nickname.length()>=20)
                return null;


        return answer;
    }
}
