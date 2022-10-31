package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> member : forms){
            if (checkValidate(member, forms)){
                answer.add(member.get(0));
            }
        }
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return answer;
    }

    private static boolean checkValidate(List<String> member, List<List<String>> forms) {
        String memberEmail = member.get(0);
        String memberNickName = member.get(1);

        for (int i = 2; i < memberNickName.length()+1; i++) {
           String targetSubNickName = memberNickName.substring(i-2, i);
           if (isMatchWithOther(memberEmail, targetSubNickName, forms)){
               return true;
           }
        }
        return false;
    }

    private static boolean isMatchWithOther(String myEmail, String targetSubNickName, List<List<String>> forms) {
        for (List<String> member : forms) {
            if (member.get(0).equals(myEmail)) {
                continue;
            }
            if (checkDuplicate(targetSubNickName, member.get(1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDuplicate(String targetSubNickName, String otherNickName) {
        String regex = ".*" + targetSubNickName + ".*";
        return Pattern.matches(regex, otherNickName);
    }
}
