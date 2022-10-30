package onboarding;

import java.util.List;

public class Problem6 {
    static String [] matchWord;
    public static List<String> solution(List<List<String>> forms) {

        for(int i=0; i<forms.size()-1; i++){

            String nickname = forms.get(i).get(1);
            if(nickname.length()==1)
                continue;

            divideWord(nickname);
        }

        List<String> answer = List.of("");
        return answer;
    }


    private static void divideWord(String nickname) {
        matchWord = new String[nickname.length()-1];
        for(int k = 0; k< nickname.length()-1; k++){
            matchWord[k]= nickname.substring(k,k+2);
        }
    }
}
