package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 두글자로 된 SubString 종류 조사.
        HashMap<String, List<Integer>> subStrHashMap = new HashMap<>();
        for(int i=0;i<forms.size();i++){
            List<String> form=forms.get(i);
            String email=form.get(0);
            String nick=form.get(1);
            if(!checkEmailLen(email)||!checkEmailFormat(email)){
                continue;
            }
            if(!checkNickLen(nick)||!checkOnlyHangul(nick)){
                continue;
            }
            updateSubStrHashMap(subStrHashMap,nick,i);
        }
        // 겹치는 Substring 을 가진 user 의 idx 조사
        Set<Integer> duplicatedStrIdxSet=getDuplicatedStrIdx(subStrHashMap);
        Set<String> emailSet = new HashSet<>();
        for(int idx:duplicatedStrIdxSet){
            emailSet.add(forms.get(idx).get(0));
        }
        // 해당 user 의 email list 조사
        List<String> emailList=new ArrayList<>(emailSet);
        emailList.sort(String::compareTo);
        return emailList;
    }

    private static boolean checkOnlyHangul(String nick){
        String pattern="^[가-힣]*$";
        return Pattern.matches(pattern,nick);
    }

    private static boolean checkNickLen(String nick){
        int len=nick.length();
        return len>=1 && len<20;
    }

    private static boolean checkEmailFormat(String email){
        String pattern="^.*@email.com$";
        return Pattern.matches(pattern,email);
    }

    private static boolean checkEmailLen(String email){
        int len=email.length();
        return len>=11 && len<20;
    }

    private static void updateSubStrHashMap(HashMap<String,List<Integer>> map, String str, int strIdx){
        for(int i=0;i<str.length()-1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i+1));
            String subStr=sb.toString();
            if(!map.containsKey(subStr)){
                map.put(subStr,new ArrayList<>());
            }
            map.get(subStr).add(strIdx);
        }
    }

    private static Set<Integer> getDuplicatedStrIdx(HashMap<String,List<Integer>> set){
        Set<Integer> result = new HashSet<>();
        for(List<Integer> idxList:set.values()){
            if (idxList.size()!=1){
                result.addAll(idxList);
            }
        }
        return result;
    }
}
