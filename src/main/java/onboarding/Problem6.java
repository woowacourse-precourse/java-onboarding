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
