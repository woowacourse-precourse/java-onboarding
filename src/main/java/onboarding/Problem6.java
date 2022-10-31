package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> for_final = new ArrayList<>();
        String name= "";
        String name2= "";
        String email = "";
        String email2 = "";

        if(checkCrewAmount(forms)) {
            for (int i = 0; i < forms.size(); i++) {
                email = forms.get(i).get(0);
                name = forms.get(i).get(1);
                if (checkEmailAvailable(email) && checkNameAvailable(name)) {
                    for (int j = i + 1; j < forms.size(); j++) {
                        name2 = forms.get(j).get(1);
                        email2 = forms.get(j).get(0);
                        for(int k =0; k<name2.length()-1; k++) {
                            String substring_name = name2.substring(k, k+2);
                            if (name.contains(substring_name)) {
                                for_final.add(email);
                                for_final.add(email2);
                            }
                        }
                    }
                } else return answer;
            }
            for_final.sort(Comparator.naturalOrder());
            answer = for_final.stream().distinct().collect(Collectors.toList());
        } else return answer;
        return answer;
    }

    public static boolean checkNameAvailable(String name){
        return Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
    }
    public static boolean checkEmailAvailable(String email) {
        return Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@email.com", email) && email.length() > 10 && email.length() < 20;
    }

    public static boolean checkCrewAmount(List<List<String>> forms){
        return forms.size() > 1 && forms.size() < 10000;
    }
}
