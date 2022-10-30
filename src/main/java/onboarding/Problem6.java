package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static int countChar(String str, String s){
        return (str.length() - str.replace(s,"").length())/s.length();
    }

    // check nickname and whether there's duplicate.
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size();i++){
            int len=1;
            String nickname = forms.get(i).get(1);

            // should not be larger than the size of nickname
            while (len < nickname.length()+1){
                int j=0;
                len++;
                if (j+len < nickname.length()+1){
                    // make duplicate check unit
                    String s = nickname.substring(j, j+len);

                    for (int k = i+1; k< forms.size();k++){
                        String checkNick = forms.get(k).get(1);

                        if(countChar(checkNick, s) >0){
                            // insert dup email to answer
                            answer.add(forms.get(i).get(0));
                            answer.add(forms.get(k).get(0));
                        };
                    }
                }
                j++;
            }
            len=0;
        }
        Collections.sort(answer);
        TreeSet<String> arr = new TreeSet<>(answer);
        ArrayList<String> after_answer = new ArrayList<>(arr);
        return after_answer;
    }
}
