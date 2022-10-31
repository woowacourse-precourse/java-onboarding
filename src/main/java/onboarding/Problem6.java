package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> emailList = valueExtraction(forms,0);
        List<String> nameList = valueExtraction(forms,1);
        List<String> answerList= checkList(nameList,emailList);

        return limitList(answerList);
    }
    public static List<String> limitList(List<String> answerList){
        return answerList.stream().limit(5).collect(Collectors.toList());
    }
    public static List<String> checkList(List<String> nameList,List<String> emailList){
        List<String> answer = new ArrayList<>();
        for(int i=0;i<nameList.size();i++){
            boolean check =false;
            for(int j=i+1;j<nameList.size();j++){
                if(lcs(nameList.get(i), nameList.get(j))){
                    if(!answer.contains(emailList.get(j))){
                        answer.add(emailList.get(j));
                        check=true; //이미 포함되어있다면 true가안됨
                    }
                }
            }
            if(check && !answer.contains(emailList.get(i))){
                answer.add(emailList.get(i));
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static boolean lcs(String str1, String str2){
        int[][] arr = new int[str1.length()+1][str2.length()+1];
        int max=0;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(max>1 && i>=2){
                    return true;
                }

                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    arr[i][j]=arr[i-1][j-1]+1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        return false;
    }


    public static List<String> valueExtraction(List<List<String>> forms,int index){
        return  forms.stream().map(o-> o.get(index)).collect(Collectors.toList());
    }
}
