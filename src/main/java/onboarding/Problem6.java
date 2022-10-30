package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer =duplicateNickName(forms);
        return answer;
    }

    /*
        중복된 이름 리스트에 담기
     */
    private static List<String> duplicateNickName(List<List<String>> forms){
        List<String> result=new ArrayList<>();
        int size= forms.size();
        for(int i=0;i<size;i++){
            String str1=forms.get(i).get(1);   //닉네임 가져오기
            String email=forms.get(i).get(0); //이메일 가져오기
            for(int k=0;k<size;k++){
                if(i!=k){
                    String str2=forms.get(k).get(1);
                    if(checkDuplicate(str1,str2)&&email.contains("email.com")){
                        result.add(email);
                        break;
                    }
                }
            }
        }
        result.sort(Comparator.naturalOrder());//오름차순 정렬
        return result;
    }

    /*
    중복된 이름 찾기
     */
    private static boolean checkDuplicate(String str1,String str2){
        for(int i=0;i<str1.length()-1;i++){
            String temp=str1.substring(i,i+2);
            if(str2.contains(temp)){
                return true;
            }
        }
        return false;
    }
}
