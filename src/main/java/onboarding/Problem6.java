package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = get_answerList(forms);

        return answer;
    }

    public static List<String> get_answerList(List<List<String>> forms){
        List<String> answer = new ArrayList<String>();

        answer = divine(forms);


        return answer;
    }

    public static List<String> divine(List<List<String>> forms){
        List<String> temp = new ArrayList<String>();
        List<List<String>> divform = new ArrayList<List<String>>();
        String temp_string = new String();
        for(int i =0;i<forms.size();i++){
            temp = forms.get(i);
            temp_string = temp.get(1);
            if(temp_string.length() <=2 ){
                divform.add(temp);
            }
            else
            {
                List<String> divtempList = new ArrayList<String>();
                divtempList.add(temp.get(0));

                for(int j = 1; j < temp_string.length(); j++)
                {
                    StringBuilder tempSB = new StringBuilder();
                    tempSB.append(temp_string.charAt(j-1));
                    tempSB.append(temp_string.charAt(j));
                    divtempList.add(tempSB.toString());
                }
                divform.add(divtempList);
            }
        }

        return compare(divform);
    }

    public static List<String> compare(List<List<String>> compareList) {
        List<String> answerlist = new ArrayList<>();
        //compareList = [[[asdf@nnn], [nn], [nn]], ...]
        for(int i =compareList.size()-1;i>0;i--)
        {
            for(int j = i-1; j>=0;j--){
                if(answerlist.contains(compareList.get(j).get(0)))
                    break;
                if(hasSimilarName(compareList.get(i), compareList.get(j))){
                    putInList(answerlist, compareList.get(i).get(0), compareList.get(j).get(0));
                    break;
                }
            }
        }

        Collections.sort(answerlist, String.CASE_INSENSITIVE_ORDER);
        return answerlist;
    }

    public static boolean hasSimilarName(List<String> x, List<String> y) {
        for(int i = x.size()-1;i>0;i--)
        {
            for(int j = y.size()-1;j>0;j--)
            {
                if(x.get(i).equals(y.get(j)))
                    return true;
            }
        }
        return false;
    }

    public static void putInList(List<String> answerlist, String x, String y) {
        if(!answerlist.contains(x)){
            answerlist.add(x);
        }
        if(!answerlist.contains(y)){
            answerlist.add(y);
        }
    }

}
