package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(List<String> user : forms) {
            List<String> word_combi = createWordCombi(user.get(1));
            //word_combi를 활용해 나머지 닉네임 중에 해당하는 사람 있는지 확인
        }

        answer = new ArrayList<>(new HashSet<>(answer));
        Collections.sort(answer);
        return answer;
    }

    public static List<String> checkDuplicateNickname() {
        List<String> dup_member = new ArrayList<>();

        return dup_member;
    }

    public static List<String> createWordCombi(String nickname) {
        List<String> word_combi = new ArrayList<>();

        word_combi.add(nickname);
        for(int i = 0; i < nickname.length() - 1; i++) {
            word_combi.add(nickname.substring(i,i+2));
        }

        return word_combi;
    }
}
