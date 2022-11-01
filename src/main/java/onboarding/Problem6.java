package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (List<String> e : forms) {
            System.out.println("*"+e.get(1)+"*");
            String targetName = e.get(1);
            ArrayList<String> cutNameList = cutNickname(e.get(1));
            for (String cutName : cutNameList) {
                System.out.println(cutName);
                Boolean matchResult = isThereMatch(forms, cutName, targetName);
                System.out.println(matchResult);
                System.out.println("ㅡㅡㅡㅡㅡ");
                if (matchResult) {
                    String email = e.get(0);
                    if(!answer.contains(email)){
                        answer.add(e.get(0));
                    }
                    break;
                }
            }
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        return answer;
    }

    private static Boolean isThereMatch(List<List<String>> forms, String cutName, String targetName) {
        String regex = "(.*)"+cutName+"(.*)";
        for (List<String> e : forms) {
            String nickname = e.get(1);
            if (!nickname.equals(targetName)) {
                System.out.println("in");
                System.out.println(nickname);
                Boolean result = nickname.matches(regex);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<String> cutNickname(String nickname) {
        ArrayList<String> cutNameList = new ArrayList<> ();
        for (int i = 0; i < nickname.length() - 1; i++) {
            cutNameList.add(nickname.substring(i, i + 2));
        }
        return cutNameList;
    }
}
