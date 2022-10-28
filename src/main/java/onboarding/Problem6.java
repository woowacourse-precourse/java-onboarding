package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return checkDuplicate(forms, answer);
    }

    // 닉네임을 2문자 단위로 쪼개는 기능
    public static List<String> twoUnits (String nickname) {
        List<String> twoUnitList = new ArrayList<>();

        for(int i = 0; i<nickname.length()-1; i++){
            if (nickname.length() == 2) twoUnitList.add(nickname);
            else twoUnitList.add(nickname.substring(i,i+2));
        }
        return twoUnitList;
    }

    // 자기 자신 빼고의 닉네임들을 문자열로 만드는 기능
    public static String nicknamesToString (List<String> names, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < names.size(); j++) {
            if (j != i)
                sb.append(names.get(j)).append(".");
        }
        return sb.toString();
    }
}
