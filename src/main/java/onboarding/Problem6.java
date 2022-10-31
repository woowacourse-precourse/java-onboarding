package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {

    public static ArrayList<Boolean> checkDuplication(List<String> nicknames){
        ArrayList<String> testedStringList = new ArrayList<>();
        ArrayList<Boolean> isDuplicated = new ArrayList<>(Collections.nCopies(nicknames.size(),Boolean.FALSE));

        for(int i=0; i<nicknames.size(); i++){
            String nickname = nicknames.get(i);
            for(int j=0; j<nickname.length()-1; j++){
                String testString = nickname.substring(j,j+2);
                if (testedStringList.contains(testString)){
                    continue;
                }

                for(int k=i+1; k< nicknames.size(); k++){
                    if(nicknames.get(k).contains(testString)){
                        isDuplicated.set(i,Boolean.TRUE);
                        isDuplicated.set(k,Boolean.TRUE);
                    }
                    testedStringList.add(testString);
                }
            }
        }
        return isDuplicated;
    }

    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> nicknames = new ArrayList<>();

        for(int i=0; i<forms.size(); i++){
            nicknames.add(forms.get(i).get(1));
        }

        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Boolean> isDuplicated = checkDuplication(nicknames);

        for(int i=0; i< isDuplicated.size(); i++){
            if(isDuplicated.get(i)){
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
