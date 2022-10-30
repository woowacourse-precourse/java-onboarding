package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 1. 전체 nickname을 담은 set 생성
        HashSet<String> totalNicks = new HashSet<>();
        for(List<String> info: forms){
            String nickname = info.get(1);
            totalNicks.add(nickname);
        }
        System.out.println(totalNicks);


        // 2. 나의 닉네임을 제외한 nickname set 생성
        for (List<String> info: forms) {
            String email = info.get(0);
            String nickname = info.get(1);


            HashSet<String> compareNicks = new HashSet<>();
            compareNicks.addAll(totalNicks);
            compareNicks.remove(nickname);

            // 3. compareNicks 내의 닉네임을 모두 2글자 단위로 절단
            HashSet<String> compareNicksSplit = new HashSet<>();
            for(String compareNick: compareNicks) {
                for (int k = 0; k < compareNick.length()-1; k++) {
                    compareNicksSplit.add(compareNick.substring(k, k + 2));
                }
            }
            System.out.println(compareNicksSplit);

            // 4. 내 닉네임을 2글자 단위로 절단
            HashSet<String> myNickSplit = new HashSet<>();
            for (int k = 0; k < nickname.length()-1; k++) {
                myNickSplit.add(nickname.substring(k, k + 2));
            }

            // 5. 전체와 교집합이 있으면 메일을 list에 추가
            compareNicksSplit.retainAll(myNickSplit);
            if(compareNicksSplit.size()>0){
                // email form validation
                String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(email);
                Boolean check1 = m.matches();
                Boolean check2 = email.length() >= 11;
                Boolean check3 = email.length() < 20;
                if(check1 && check2 && check3){
                    answer.add(email);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
