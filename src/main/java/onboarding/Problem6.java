package onboarding;

import java.util.*;

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
        //크루 1명부터 10000까지
        if(!(forms.size()>=1&&forms.size()<=10000)) return false;
        for(List<String> s: forms){
            String email=s.get(0);
            //이메일 길이 11부터 20까지
            if(!(email.length()>=11&&email.length()<=20)) return false;

            //도메인은 email.com
            int idx=email.indexOf("@");
            String domain=email.substring(idx+1);
            if(!(domain.contains("email.com"))) return false;

            //닉네임은 한글 그리고 길이 1부터 20미만
            String nickName=s.get(1);
            if(!(nickName.matches("^[가-힣]*$")&&nickName.length()>=1&&nickName.length()<20)) return false;
        }
        return true;
    }

    /*
        중복된 이름 리스트에 담기
     */
    private static List<String> duplicateNickName(List<List<String>> forms){
        List<String> result=new ArrayList<>();
        Map<String,List<String>> subMap=checkDuplicate(forms);
        for(int i=0;i< forms.size();i++){
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            if(nickName.length()>1) {
                for (int k = 0; k < nickName.length() - 1; k++) {
                    String subNick = nickName.substring(k, k + 2);
                    if(subMap.get(subNick).size()>1){
                        result.add(email);
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
    private static Map<String,List<String>> checkDuplicate(List<List<String>> forms){
        Map<String ,List<String> > subMap=new HashMap<>();
        for(int i=0;i<forms.size();i++) {
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);

            if (nickName.length() > 1) {
                for (int k = 0; k < nickName.length() - 1; k++) {
                    String subNick = nickName.substring(k, k + 2);
                    List<String> list = subMap.getOrDefault(subNick, new ArrayList<>());
                    list.add(email);
                    subMap.put(subNick, list);
                }
            }
        }
        return subMap;
    }
}
