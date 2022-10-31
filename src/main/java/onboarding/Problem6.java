package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<Integer, String> member = new HashMap<>();
        for(int i = 0; i < forms.size()-1; i++) {
            for(int j = i+1; j < forms.size(); j++) {
                boolean existsSameToken = compareToToken(token(forms.get(i).get(1)), token(forms.get(j).get(1)));
                if(!existsSameToken) {
                    member.put(i, forms.get(i).get(0));
                    member.put(j, forms.get(j).get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(member.values());
        Collections.sort(answer);
        return answer;
    }
    public static List<String> token(String nickName) {
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < nickName.length()-1; i++) {
            tokens.add(nickName.substring(i, i+2));
        }
        return tokens;
    }
    public static Boolean compareToToken(List<String> tokenList, List<String> tokenList2) {
        boolean flag = true;
        for(int i = 0; i < tokenList.size(); i++) {
            if (tokenList2.contains(tokenList.get(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static Boolean verifyEmail(String email) {
        boolean flag = false;
        int atIndex = 0;
        for(int j = 0; j < email.length(); j++) {
            if(email.charAt(j) == '@') {
                atIndex = j;
                break;
            }
        }
        String domain = email.substring(atIndex+1);
        if(domain.equals("email.com")) {
            flag = true;
        }
        return flag;
    }
}
