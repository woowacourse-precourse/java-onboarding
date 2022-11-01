package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static List<String> sortHashSetAsList(HashSet<String> hashSet){
        return hashSet.stream().sorted().collect(Collectors.toList());
    }
    private static List<String> getEmailsToRecommend(List<List<String>> forms){

        HashSet<String> emails = new HashSet<>();
        HashMap<String, String> dic = new HashMap<>();

        for(List<String> form:forms){
            String email = form.get(0);
            String nickname = form.get(1);
            for(int i = 0; i < nickname.length()-1; i++)
            {
                String twoOfNick = nickname.substring(i,i+2);
                if(dic.containsKey(twoOfNick) && !dic.get(twoOfNick).equals(email))
                {
                    emails.add(email);
                    emails.add(dic.get(twoOfNick));
                }
                dic.put(twoOfNick, email);
            }
        }

        return sortHashSetAsList(emails);

    }
    public static List<String> solution(List<List<String>> forms) {
        return getEmailsToRecommend(forms);
    }
}
