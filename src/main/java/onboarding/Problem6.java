package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> emailList = valueExtraction(forms,0);
        List<String> nameList = valueExtraction(forms,1);
        return getEmail(nameList,emailList);
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
                    max = max>arr[i][j] ? max : arr[i][j];
                }
            }
        }
        return false;
    }

    public static List<String> getEmail(List<String> nameList,List<String> emailList){
        List<String> answer = new ArrayList<>();
        for(int i=0;i<nameList.size();i++){
            String name = nameList.get(i);
            boolean check =false;
            for(int k=0;k<name.length()-1;k++){  // 최소 2개이상이므로 -1
                for(int z=k+2;z<=name.length();z++){
                    String nameSub=name.substring(k,z);
                    for(int j=i+1;j<nameList.size();j++){
                        if(nameList.get(j).contains(nameSub)){
                            if(!answer.contains(emailList.get(j))){
                                check= true;
                                answer.add(emailList.get(j));
                            }
                        }
                    }
                }
            }
            if(check==true){
                answer.add(emailList.get(i));
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static List<String> valueExtraction(List<List<String>> forms,int index){
        return  forms.stream().map(o-> o.get(index)).collect(Collectors.toList());
    }
}
