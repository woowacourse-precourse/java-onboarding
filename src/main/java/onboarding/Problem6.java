package onboarding;

import net.bytebuddy.TypeCache;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (CheckInput(forms)) {
            Map<String, Integer> nickHash = new HashMap<>();
            return RunGame(forms,nickHash);
        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(List<List<String>> forms){
        if(isInRange(forms)&&isEmail(forms)&&isNick(forms))return true;
        return false;
    }
    private static boolean isInRange(List<List<String>> forms){
        if(forms.size()>0 && forms.size()<10001) return true;
        return false;
    }
    private static boolean isEmail(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            String tmp = forms.get(i).get(0);
            if(tmp.indexOf("@email.com")==-1)return false;
        }
        return true;
    }
    private static boolean isNickInRange(String nickname){
        if(nickname.length() >0 && nickname.length() <21)return true;
        return false;
    }
    private static boolean isNickKorean(String nickname){
            for(int j=0; j<nickname.length(); j++){
                if(Character.getType(nickname.charAt(j))!=5) return false;
            } return true;
    }
    private static boolean isNick(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            String nickname = forms.get(i).get(1);
            if (isNickKorean(nickname) && isNickInRange(nickname))return true;
        }return false;
    }

    /* 기능2 : 닉네임 중복 확인할 Hash 생성 */
    private static void MakeNickHash(List<List<String>> forms, Map<String, Integer> nickHash) {
        for(int i=0;i<forms.size();i++){
            String nickname = forms.get(i).get(1);
            DivideTwo(nickHash, nickname);
        }
    }

    /* 기능2-1: 두개씩 나누어 저장 */
    private static void DivideTwo(Map<String,Integer> nickHash, String nickname) {
        for(int i=0;i<nickname.length()-1;i++){
            String tmp = nickname.substring(i,i+2);
            nickHash.put(tmp,nickHash.getOrDefault(tmp,0)+1);
        }
    }

    /* 기능 3 : 닉네임 중복 확인 */
    private static boolean CheckDuplicates(List<String> forms, Map<String, Integer> nickHash) {
        String nickname = forms.get(1);
        for(int i=0;i<nickname.length()-1;i++){
            String tmp = nickname.substring(i,i+2);
            if(nickHash.get(tmp)>1)return true;
        }return false;
    }

    /* 기능 4 : 중복된 사용자의 이메일 출력 */
    private static List<String> RunGame(List<List<String>> forms, Map<String, Integer> nickHash){
        MakeNickHash(forms, nickHash);
        HashSet<String> hashset = new HashSet<String>();
        for(int i =0; i<forms.size(); i++){
            if(CheckDuplicates(forms.get(i),nickHash)==true) hashset.add(forms.get(i).get(0));
        }
        List<String> answer = new ArrayList<String>(hashset);
        return SortEmail(answer);
    }

    /* 기능 5 : 중복된 사용자의 이메일 오름차순 정렬 */
    private static List<String> SortEmail(List<String> answer){
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
