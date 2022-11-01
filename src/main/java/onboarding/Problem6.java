package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
========================================Problem6 기능 목록========================================
- 2차원 List를 2차원 array로 변환하는 기능
- 한 닉네임으로부터 모든 경우의 연속되는 2글자를 배열로 만드는 기능
- 해당 닉네임이 중복 키워드를 포함하는지 확인하는 기능
- 중복 닉네임에 해당하는 이메일을 set으로 포함하는 기능
- set을 List로 변환하는 기능
 */

public class Problem6 {
    public static String[][] listToArray(List<List<String>> list){
        String[][] array = list.stream()
                                .map(item->item.stream().toArray())
                                .toArray(String[][]::new);
        return array;
    }
    public static List<String> makeKeyword(String nickName){
        List<String> keyword = new ArrayList<>();
        String[] tempNickName = nickName.split("");
        int len = nickName.length();

        for(int i = 0;i < len - 1;i++)
            keyword.add(tempNickName[i] + tempNickName[i+1]);
        return keyword;
    }
    public static boolean checkKeywordInNickname(String nickName, String[] keyword){
        int len = keyword.length;

        for(int i = 0;i < len;i++){
            if(nickName.contains(keyword[i]))
                return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
