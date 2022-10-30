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

    //겹친부분 첫번째 인덱스 찾기
    public static int getFirstIndexOfDuplicate(char currentNickChar, String nextNick) {
        int firstIndex = -1;
        for (int i = 0; i < nextNick.length() - 1; i++) {
            if (currentNickChar == nextNick.charAt(i)){
                firstIndex= i;
                return firstIndex;
            }
        }

        return firstIndex;
    }

    //서로 같은 문자인지 확인하는 함수
    public static boolean checkDuplicate(char currentChar, char nextChar) {
        if (currentChar == nextChar) return true;
        return false;
    }


}
