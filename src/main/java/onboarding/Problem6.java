package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> twoChars = new HashSet<>();
        Set<String> duplicated = new HashSet<>();

        for(List<String> info:forms) {
            String nickName = info.get(1);

            for(String twoChar :twoChars) {
                if(nickName.contains(twoChar)) {
                    duplicated.add(twoChar);
                }
            }

            for(int i=0; i<nickName.length()-1; i++) {
                twoChars.add( nickName.substring(i,i+2) );
            }
        }

        for(List<String> info:forms) {
            String nickName = info.get(1);
            for(String dupString: duplicated) {
                if (nickName.contains(dupString)) {
                    String email = info.get(0);
                    answer.add(email);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
