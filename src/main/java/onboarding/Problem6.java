package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static boolean isSame(String nick1, String nick2){
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for(int i=0; i<nick1.length()-1; i++){
            int checkNum1 = (nick1.charAt(i)/2-16127)*(nick1.charAt(i+1)-16127);
            arr1.add(checkNum1);
        }
        for(int i=0; i<nick2.length()-1; i++){
            int checkNum2 = (nick2.charAt(i)/2-16127)*(nick2.charAt(i+1)-16127);
            arr2.add(checkNum2);
        }

        int check = 0;
        for (int i=0; i<arr1.size(); i++){
            for(int j=0; j<arr2.size(); j++){
                if(arr1.get(i).equals(arr2.get(j))){
                    check++;
                }
            }
        }

        if(check==0){
            return false;
        }

        return true;
    }

    public static List<String> sameNickEmails(List<List<String>> forms){
        List<String> emailsArr = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            for(int j=1; j<forms.size()-i; j++){
                if(isSame(forms.get(i).get(1),forms.get(i+j).get(1))){
                    emailsArr.add(forms.get(i).get(0));
                    emailsArr.add(forms.get(i+j).get(0));
                }
            }
        }
        //중복제거
        HashSet<String> hashSet = new HashSet<>();
        for(String item : emailsArr){
            hashSet.add(item);
        }
        ArrayList<String> finalEmailsArr = new ArrayList<>(hashSet);

        //오름차순 정렬
        Collections.sort(finalEmailsArr);

        return finalEmailsArr;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = sameNickEmails(forms);
        return answer;
    }
}
