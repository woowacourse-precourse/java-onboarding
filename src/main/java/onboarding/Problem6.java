package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> getSubString(String str, int len) {
        List<String> ret = new ArrayList<>();

        int limit = str.length() - len;
        for(int i=0;i<=limit;i++) {
            ret.add(str.substring(i, i+len));
        }
        return ret;
    }

    public static boolean isValidInput(String email, String nickname){
        String[] arr = email.split("@");
        if(!arr[1].equals("email.com")) return false;
        if(email.length() < 11 || email.length() >= 20) return false;
        if(nickname.length() < 1 || nickname.length() >= 20) return false;
        return true;
    }
    //기능 2
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Set<String> result = new TreeSet<>();

        for(int i=0;i<forms.size();i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(nickname.length() == 1) continue;
            if(!isValidInput(email, nickname)) continue;
            int count = 0;
            for(int j=2;j<=nickname.length();j++){
                List<String> target = getSubString(nickname, j);
                for(int k=i+1;k<forms.size();k++){
                    String mail = forms.get(k).get(0);
                    String nick = forms.get(k).get(1);
                    if(!isValidInput(mail, nick)) continue;
                    for(String sub : target) {
                        if(nick.contains(sub)) {
                            result.add(mail);
                            count += 1;
                        }
                    }
                }
            }
            if(count > 0) result.add(email);
        }
        for(String elem : result) answer.add(elem);
        return answer;
    }
}
