package onboarding;

import java.util.*;

public class Problem6 {

    public static Map<String,Integer> subNicknameCount = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            List<String> subNicknameList = getSubNicknameList(nickname);
            addSubNicknameCount(subNicknameList);
        }

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            if(hasDuplicateSubNickname(nickname)){
                answer.add(email);
            }
        }

        answer.sort((Comparator.naturalOrder()));
        return answer;
    }

    public static List<String> getSubNicknameList(String nickname){
        List<String> subNicknameList = new ArrayList<>();
        int length = nickname.length();
        for(int left=0;left<length-1;left++){
            for(int right=left+1;right<length;right++){
                String subNickname = nickname.substring(left,right+1);
                subNicknameList.add(subNickname);
            }
        }
        return subNicknameList;
    }

    public static void addSubNicknameCount(List<String> subNicknameList){
        for (String subNickname : subNicknameList) {
            if(subNicknameCount.containsKey(subNickname)){
                int tempCount = subNicknameCount.get(subNickname);
                subNicknameCount.put(subNickname, tempCount+1);
            }else{
                subNicknameCount.put(subNickname,0);
            }
        }
    }

    public static boolean hasDuplicateSubNickname(String nickname){
        List<String> subNicknameList = getSubNicknameList(nickname);
        for (String subNickname : subNicknameList) {
            if(subNicknameCount.get(subNickname)>1){
                return true;
            }
        }
        return false;
    }
}
