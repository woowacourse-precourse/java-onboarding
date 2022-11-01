package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int numberOfCrews = forms.size();

        HashSet<String> twoLetters = new HashSet<String>();
        HashSet<String> overlappedWord = new HashSet<String>();
        for (int i=0; i<numberOfCrews; i++){
            String crewName = forms.get(i).get(1);
            for(int j=0; j<crewName.length()-1; j++){
                String cuttingName = crewName.substring(j,j+2);
                if(twoLetters.contains(cuttingName)){
                    overlappedWord.add(cuttingName);
                }else {
                    twoLetters.add(cuttingName);
                }
            }
        }
//        System.out.println(twoLetters);
//        System.out.println(overlappedWord);

        for (int i=0; i<numberOfCrews; i++){
            String crewName = forms.get(i).get(1);
            for(int j=0; j<crewName.length()-1; j++){
                if(overlappedWord.contains(crewName.substring(j,j+2))){
                    answer.add(forms.get(i).get(0));
                    // 중복 제거
                    break;
                }
            }
        }
//        System.out.println(answer);
        java.util.Collections.sort(answer);
//        System.out.println(answer);
        return answer;
    }
}
