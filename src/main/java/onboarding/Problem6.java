package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> getName(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(0);
            String twoCharName = name.substring(i, i+2);
            if (name == twoCharName) {
                nameList.add(name);
            }
        }
        return nameList;
    }

    private static List<String> getMail(List<List<String>> forms) {
        List<String> mailList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if (isValidEmail(email)) {
                mailList.add(email);
            }
        }
        return mailList;
    }

    public static boolean isValidEmail(String email) {
        boolean err = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()) {
            err = true;
        }
        return err;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(true){
            List<String> mailList = getMail(forms);
            List<String> nameList = getName(forms);
        }
        return answer;
    }
}
