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

    //두 닉네임이 유사한지 판단하는 함수
    public static boolean getDuplicate(List<List<String>> forms, int index, String currentNick) {
        String nextNick = getNickname(forms, index);
        int firstIndex=-1;
        for (int i = 0; i < currentNick.length()-1; i++) {
            char currentChar = currentNick.charAt(i);
            firstIndex = getFirstIndexOfDuplicate(currentChar,nextNick);
            if(firstIndex==-1) continue;

            //이후 인덱스에서도 같은지 확인
            boolean isDuplicated = checkDuplicate(currentNick.charAt(i+1),nextNick.charAt(firstIndex+1));
            if(isDuplicated) return true;
        }
        return false;
    }

}
