package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        // 1. 전체 nickname을 담은 set 생성
        HashSet<String> nickSet = new HashSet<>();
        for(List<String> info: forms){
            String nickname = info.get(1);
            nickSet.add(nickname);
        }


        // 2. 나의 닉네임을 제외한 nickname set 생성
        for (List<String> info: forms) { //  ["jm@email.com", "제이엠"]
            String email = info.get(0); // jm@email.com
            String nickname = info.get(1); // 제이엠


            HashSet<String> compareNicks = new HashSet<>();
            compareNicks.addAll(nickSet);
            compareNicks.remove(nickname);

            // 3. compareNicks 내의 닉네임을 모두 2글자 단위로 절단
            HashSet<String> compareNicksSplit = new HashSet<>();
            for(String compareNick: compareNicks) {
                HashSet<String> compareNickSplit = getBreakLetters(compareNick);
                compareNicksSplit.addAll(compareNickSplit);
            }

            // 4. 내 닉네임을 2글자 단위로 절단
            HashSet<String> myNickSplit = getBreakLetters(nickname);

            // 5. 전체와 교집합이 있으면 메일을 list에 추가
            compareNicksSplit.retainAll(myNickSplit);
            if(compareNicksSplit.size() > 0){
                // email form validation
                getValidEmails(answer, email);
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static HashSet<String> getBreakLetters(String str) {
        HashSet<String> res = new HashSet<>();
        for (int k = 0; k < str.length()-1; k++) {
            res.add(str.substring(k, k + 2));
        }
        return res;
    }

    private static void getValidEmails(List<String> emailList, String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        Boolean check1 = m.matches();
        Boolean check2 = email.length() >= 11;
        Boolean check3 = email.length() < 20;
        if(check1 && check2 && check3){
            emailList.add(email);
        }
    }
}
