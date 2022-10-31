package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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
        List<String> answer = List.of("answer");
        return answer;
    }
}
