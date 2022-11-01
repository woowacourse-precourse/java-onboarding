package onboarding;

import java.util.List;

public class Problem6 {
    static String [] matchWord;
    public static List<String> solution(List<List<String>> forms) {
        String result = "";
        String nickname = "";
        String name = "";
        String email = "";
        boolean[] used = new boolean[forms.size()];

        for(int i=0; i<forms.size()-1; i++){

            nickname = forms.get(i).get(1);
            if(nickname.length()==1)
                continue;

            divideWord(nickname);

            for( int j=i+1; j<forms.size(); j++){
                name= forms.get(j).get(1);

                for(String word:matchWord){
                    if(name.contains(word) ){
                        if(!used[i]){
                            email = forms.get(i).get(0);
                            result += email + " ";
                            used[i]=true;
                        }
                        if(!used[j]){
                            email = forms.get(j).get(0);
                            result += email + " ";
                            used[j] = true;
                        }

                    }
                }

            }
        }
        String[] list = result.split(" ");
        array(list);
        List<String> answer = List.of(list);
        return answer;
    }
    private static void array(String[] list) {
        for(int i=0; i<list.length-1; i++){
            for(int j=i+1; j<list.length; j++){
                if(list[i].compareTo(list[j])>0){
                    String temp = list[j];
                    list[j]= list[i];
                    list[i] = temp;
                }
            }
        }

    }


    private static void divideWord(String nickname) {
        matchWord = new String[nickname.length()-1];
        for(int k = 0; k< nickname.length()-1; k++){
            matchWord[k]= nickname.substring(k,k+2);
        }
    }
}
