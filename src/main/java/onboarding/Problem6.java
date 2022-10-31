package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        answer = checkString(forms);
        answer.addAll(reverse_checkString(forms));


        return answer;
    }
    //정순으로 2글자씩 비교
    public static List<String> checkString(List<List<String>> forms){
        List<String> strlist = new ArrayList<>();
        String strtemp = "";
        String check2word = "";

        for(int i=0; i<forms.size(); i++){
            strtemp = forms.get(i).get(1);
            for(int j = 0; j<strtemp.length()-1; j++){
                check2word = "";
                check2word += strtemp.charAt(j);
                check2word += strtemp.charAt(j+1);
                for(int k = 0; k<forms.size(); k++){
                    if(forms.get(k).get(1).contains(check2word)){
                        strlist.add(forms.get(k).get(0));
                    }
                }
            }
        }

        return strlist;
    }
    //역순으로 2글자씩 비교
    public static List<String> reverse_checkString(List<List<String>> forms){
        List<String> strlist = new ArrayList<>();
        String strtemp = "";
        String check2word = "";

        for(int i=0; i<forms.size(); i++){
            strtemp = forms.get(i).get(1);
            for(int j = 0; j<strtemp.length()-1; j++){
                check2word = "";
                check2word += strtemp.charAt(j+1);
                check2word += strtemp.charAt(j);
                for(int k = 0; k<forms.size(); k++){
                    if(forms.get(k).get(1).contains(check2word)){
                        strlist.add(forms.get(k).get(0));
                    }
                }
            }
        }

        return strlist;
    }

}
