package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int len = forms.size();
        for(int i=0;i<len-1;i++){
            for(int j = i+1;j<len;j++){
                if(check(forms.get(i).get(1),forms.get(j).get(1))){
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        return answer;
    }
    public static boolean check(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        for(int i=0;i<(len1-1);i++){
            for(int j=0;j<(len2-1);j++){
                if((str1.charAt(i)==str2.charAt(j))&(str1.charAt(i+1)==str2.charAt(j+1))){
                    return true;
                }
            }
        }
        return false;
    }
}
