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

    public static List<String > findEmailBySimilarNicname(int nowformsindex , List<List<String>> forms , List<String> letters , List<String> answer){
        List<String> result = answer;
        int samecount =0;

        for(int j=nowformsindex+1; j<forms.size(); j++){
            String othernickname = forms.get(j).get(1);
            for(int k=0; k<letters.size(); k++){
                if ( othernickname.contains(letters.get(k))) {
                    if(samecount==0){
                        result.add(forms.get(nowformsindex).get(0));
                        samecount++;
                    }
                    result.add(forms.get(j).get(0));
                }
            }
        }
        return result;
    }

}
