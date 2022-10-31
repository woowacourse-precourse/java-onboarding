package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer= new ArrayList<>();

        final int LENGTH=forms.size();
        String[] strArr= new String[LENGTH];
        //닉네임 문자열 배열
        for(int i=0;i<LENGTH;i++){
            strArr[i]=forms.get(i).get(1);
        }
        Set set1=new HashSet(); //닉네임 문자열 집합
        Set set2=new HashSet(); //중복 닉네임 문자열 집합

        for(int i=0;i<LENGTH;i++){
            int length=strArr[i].length();
            for(int j=0;j<length-1;j++){
                if(set1.contains(strArr[i].substring(j,j+2))){
                    set2.add(strArr[i].substring(j,j+2));
                }
                set1.add(strArr[i].substring(j,j+2));
            }
        }
        Set set3=new HashSet();

        for(int i=0;i<LENGTH;i++){
            for(int j=0;j<strArr[i].length()-1;j++) {
                if (set2.contains(strArr[i].substring(j, j + 2))){
                    set3.add(forms.get(i).get(0));
                }
            }
        }
        Object[] answerArr=set3.toArray();
        for(int i=0;i<answerArr.length;i++){
            answer.add((String)answerArr[i]);
        }
        Collections.sort(answer);
        return answer;
    }
}