package onboarding;

import java.util.List;

public class Problem6 {
    static String [] matchWord;
    public static List<String> solution(List<List<String>> forms) {
        String result = "";
        for(int i=0; i<forms.size()-1; i++){

            String nickname = forms.get(i).get(1);
            if(nickname.length()==1)
                continue;

            divideWord(nickname);

            for( int j=i+1; j<forms.size(); j++){
                String name= forms.get(j).get(1);

                for(String word:matchWord){
                    if(name.contains(word) ){

                    }
                }

            }
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
