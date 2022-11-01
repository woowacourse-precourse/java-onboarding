package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    //Hash를 list로 하여금 정렬하는 함수
    private static List<String> sortHashSetAsList(HashSet<String> hashSet){
        return hashSet.stream().sorted().collect(Collectors.toList());
    }
    //추천할 이메일을 반환하는 함수, dictionary를 활용하여 연속으로 중복되는 문자열을 O(1)로 찾음
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
