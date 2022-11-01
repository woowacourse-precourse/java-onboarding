package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean[] isOverlap;
    public static List<String>[] userForms;
    public static List<String> answer;

    public static List<String> solution(List<List<String>> forms) {

        answer = new ArrayList<>();
        isOverlap = new boolean[forms.size()];
        StringBuilder stringBuilder = new StringBuilder();
        userForms = new List[forms.size()];
        setUserForms(forms);
        search(stringBuilder);
        removeDuplication();

        return answer;
    }

    public static void removeDuplication(){
        Set<String> set =  new HashSet<>(answer);
        answer = new ArrayList<>(set);
    }

    public static void searchOverlappedUser(){
        for(int i=0;i<isOverlap.length;i++) {
            if (isOverlap[i])
                answer.add(userForms[i].get(0));
        }
    }

    public static void search(StringBuilder stringBuilder){
        for(int i=0;i<userForms.length-1;i++){
            List<String> form = userForms[i];
            String nickName = form.get(1);
            String email = form.get(0);

            if(!isEmailDomainValid(email)){
                continue;
            }
            searchOtherUserNickName(nickName,i,stringBuilder);
        }
        searchOverlappedUser();
    }
    public static void searchOtherUserNickName(String nickName, int i, StringBuilder builder){
        for(int nickidx = 0; nickidx <nickName.length()-1;nickidx++){
            builder.append(nickName, nickidx, nickidx+2);

            for(int targetIdx=i+1;targetIdx<userForms.length;targetIdx++){

                if(isOverlap[i] && isOverlap[targetIdx])
                    continue;

                String target = userForms[targetIdx].get(1);
                if(bmMatch(target, builder.toString()) != -1){
                    isOverlap[i] = true;
                    isOverlap[targetIdx] = true;
                    break;
                }
            }
            builder.setLength(0);
        }
    }

    public static void setUserForms(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            userForms[i] = forms.get(i);
        }
    }

    public static boolean isEmailDomainValid(String email){

        String domain = "email.com";

        return email.split("@")[1].equals(domain);
    }

    static int bmMatch(String txt, String pat) {
        int pt;                     // txt 커서
        int pp;                     // pat 커서
        int txtLen = txt.length();  // txt의 문자 개수
        int n = pat.length();       // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1]; //  skip table (건너뛰기 표)

        // 건너뛰기 테이블(skip table) 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) skip[pt] = n;
        for (pt = 0; pt < n - 1; pt++) skip[pat.charAt(pt)] = n - pt - 1;

        //검색
        while (pt < txtLen) {
            pp = n - 1;

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) return pt; // 검색 성공
                pp--;
                pt--;
            }
            pt += Math.max(skip[txt.charAt(pt)], n - pp);
        }
        return -1; // while 문이 종료되면 검색 실패
    }

}
