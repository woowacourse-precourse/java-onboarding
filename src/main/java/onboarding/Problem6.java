package onboarding;

import java.util.*;

/**
 * 기능 요구사항
 * 1. 닉네임에서 중복을 탐지할 데이터 set 구축
 * 2. 중복 확인
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem6 = new Problem6();
        return problem6.getDuplicateUser(forms);
    }

    /**
     * 중복 이름 확인을 위한 Key, Set형식의 데이터를 구축하낟.
     * @param forms
     * @return {key: set} 형식의 데이터
     */

    private Map<String, HashSet<String>> getNickNameSet(List<List<String>> forms){
        // 중복 문자열을 담을 데이터 형식 지정
        Map<String, HashSet<String>> data = new HashMap<>();

        for(List<String> form : forms){
            String nickName = form.get(1);
            if(nickName.length() <= 1) continue;

            HashSet<String> nickNameSet = new HashSet<>();
            for(int i=0; i<nickName.length()-1; i++){
                nickNameSet.add(nickName.substring(i, i+2));
            }
            data.put(form.get(0), nickNameSet);
        }
        return data;
    }

    /**
     * 중복이름이 있는 회원을 정렬있게 반환한다.
     * @param forms
     * @return
     */
    public List<String> getDuplicateUser(List<List<String>> forms){
        HashSet<String> ret = new HashSet<>();
        Map<String, HashSet<String>> nickNameSet = getNickNameSet(forms);

        for(List<String> form : forms){
            for(String key : nickNameSet.keySet()){
                if(form.get(0) == key)continue;
                HashSet<String> nickNames = nickNameSet.get(key);
                for(String nickName : nickNames){
                    if(form.get(1).contains(nickName)){
                        ret.add(form.get(0));
                    }
                }
            }
        }
        List<String> parsing = new ArrayList<>(ret);
        Collections.sort(parsing);
        return parsing;
    }


}
