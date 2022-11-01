package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            if (isNotEmail(forms.get(i).get(0))) {
                forms.remove(i);
                i--;
            }
        }
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (isOverlapped(forms.get(i).get(1), forms.get(j).get(1))) {
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }
        List<String> emailList = new ArrayList<>(emailSet);
        emailList.sort(Comparator.naturalOrder());
        return emailList;
    }
    public static boolean isNotEmail(String emailAddress) {
        return !emailAddress.endsWith("@email.com");
    }
    public static boolean isOverlapped(String str1, String str2) {
        return strEqualsOthersSubstr(str1, str2) || strEqualsOthersSubstr(str2, str1);
    }
    public static boolean strEqualsOthersSubstr(String str1, String str2) {
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str2.contains(str1.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }
}
