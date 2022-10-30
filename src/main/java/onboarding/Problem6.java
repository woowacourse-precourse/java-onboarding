package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    static List<List<String>> findContinualChar(List<List<String>> forms){
        List<List<String>> continualCharOfCrew = new ArrayList<>();
        for(int crewIdx = 0; crewIdx < forms.size(); crewIdx++) {
            String nickName = forms.get(crewIdx).get(1);
            List<String> continualChar = new ArrayList<>();
            String divededChar;

            for(int nickNameIdx = 1; nickNameIdx < nickName.length(); nickNameIdx++){
                divededChar = Character.toString(nickName.charAt(nickNameIdx-1)) + Character.toString(nickName.charAt(nickNameIdx));
                continualChar.add(divededChar);
            }
            continualCharOfCrew.add(continualChar);
        }
        return continualCharOfCrew;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        return answer;
    }
}
