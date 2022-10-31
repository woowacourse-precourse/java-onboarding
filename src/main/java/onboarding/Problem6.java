package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static String[] sort(int count, String[] strArray){
        int i, j; int index = 0;
        boolean contains;
        String current;
        String[] strArr = new String[count];

        for(String str : strArray){
            contains = false;
            if(str == null || str.length() == 0){
                break;
            }
            for(i=0; i<strArr.length; i++){
                if(str.equals(strArr[i])){
                    contains = true;
                    break;
                }
            }
            if(!contains){
                strArr[index] = str;
                index++;
            }
        }

        // sorting
        for(i=1; i<index; i++){
            current = strArr[i];
            j = i-1;
            while(j >= 0 && current.compareTo(strArr[j]) < 0){
                strArr[j+1] = strArr[j];
                j -= 1;
            }
            strArr[j+1] = current;
        }
        return strArr;
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> result = new ArrayList<>();
        String[] answer = new String[10000];

        int i = 0; int j = 0; int k = 0; int count = 0;
        String word = ""; String word2 = ""; String letter = "";
        String email = ""; String email2 = "";

        for(i=0; i<(forms.size()-1); i++){
            boolean wordContains = false;
            word = forms.get(i).get(1);
            email = forms.get(i).get(0);
            for(j=(i+1); j<forms.size(); j++){
                word2 = forms.get(j).get(1);
                email2 = forms.get(j).get(0);
                for(k=0; k<word.length()-1; k++){
                    letter = word.substring(k, k+2);
                    if(word2.contains(letter)){
                        wordContains = true;
                        answer[count] = email2;
                        count++;
                        break;
                    }
                }
            }
            if(wordContains){
                answer[count] = email;
                count++;
            }
        }
        String[] strArr = sort(count, answer);

        for(i=0; i<strArr.length; i++){
            String wo = strArr[i];
            if(wo == null || wo.length() == 0){
                break;
            }else if(!result.contains(wo)){
                result.add(wo);
            }
        }
        return result;
    }
}
