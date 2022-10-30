package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

    }

    //List에서 닉네임을 받아오는 함수
    public static String getNickname(List<List<String>> forms, int index) {
        List<String> data = forms.get(index);
        String nickname = data.get(1);
        return nickname;
    }

}
