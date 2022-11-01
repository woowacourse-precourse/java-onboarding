package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static List<String> cutTwoLettersEach(String nickname){
        List<String> cuttedletters = new ArrayList<>();

        for(int i=0; i<nickname.length()-1; i++){
            cuttedletters.add(nickname.substring(i,i+2));
        }
        return cuttedletters;
    }


}
