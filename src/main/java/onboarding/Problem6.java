package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(checkLimit(forms)) answer=duplicateNickName(forms);
        return answer;
    }

    /*
    문제 조건 사항 체크
     */
    private static boolean checkLimit(List<List<String>> forms){
        boolean check=true;
        //크루 1명부터 10000까지
        if(!(forms.size()>=1&&forms.size()<=10000)) check=false;
        for(List<String> s: forms){
            String email=s.get(0);
            //이메일 길이 11부터 20까지
            if(!(email.length()>=11&&email.length()<=20)) check= false;

            //도메인은 email.com
            int idx=email.indexOf("@");
            String domain=email.substring(idx+1);
            if(!(domain.contains("email.com"))) check= false;

            //닉네임은 한글 그리고 길이 1부터 20미만
            String nickName=s.get(1);
            if(!(nickName.matches("^[가-힣]*$")&&nickName.length()>=1&&nickName.length()<20)) check= false;
        }
        return check;
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
