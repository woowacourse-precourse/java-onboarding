package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    final static int EMAIL = 0;
    final static int NICK_NAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static List<Integer> checkOverlapUserCycle(int nicknameIndex, List<List<String>> forms){
        List<Integer> overlapUserIndexList = new ArrayList<Integer>();
        String nickname = forms.get(nicknameIndex).get(NICK_NAME);

        List<String> substringCombination = new ArrayList<String>();
        substringCombination.add(nickname);

        if(nickname.length() > 1) {
            substringCombination = makeSubstringCombination(nickname);
        }
        for (String substring: substringCombination) {
            List<Integer> tempIndex = findOverlabUserIndexList(substring, forms);
            tempIndex.remove(Integer.valueOf(nicknameIndex)); // 닉네임 본인 인덱스를 제거하는 코드
            overlapUserIndexList.addAll(tempIndex);
        }

        return overlapUserIndexList;
    }

    public static List<String> makeSubstringCombination(String nickname){
        List<String> substringCombination = new ArrayList<>();

        int length = nickname.length();
        for(int i = 0; i < length - 1; i++){
            String substring = nickname.substring(i, i + 2);
            substringCombination.add(substring);
        }
        return substringCombination;

    }

    public static List<Integer> findOverlabUserIndexList(String subStringNickname, List<List<String>> forms){
        int length = forms.size();
        List<Integer> overlabUserIndexList = new ArrayList<Integer>();
        for(int i = 0; i < length; i++){
            String comparisonNickname = forms.get(i).get(NICK_NAME);
            if(comparisonNickname.equals(subStringNickname)){ //한글자 닉네임의 중복확인을 위한 조건문
                overlabUserIndexList.add(i);
            }
            else if(comparisonNickname.contains(subStringNickname) && subStringNickname.length() > 1){ //두글자이상 닉네임의 중복확인을 위한 조건문
                overlabUserIndexList.add(i);
            }
        }
        return overlabUserIndexList;
    }
}
