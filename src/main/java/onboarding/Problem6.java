package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;

public class Problem6 {
    /*  */
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();
        for(List<String> form : forms){
            String nickname = form.get(1);
            /* 이미 중복된 아이디라면 비교하지 않는다. */
            if(!emails.contains(form.get(0))){
                for(int i = 0; i < nickname.length(); i++){
                    for(int j = i+1; j < nickname.length()+1; j++){
                        String word = nickname.substring(i, j);
                        if(word.length() >= 2){
                            /* 2개 이상의 연속된 문자열을 슬라이싱 후 다른 닉네임에 포함되는지 확인함으로써 중복 여부 파악. */
                            for(List<String> check_form : forms.subList(forms.indexOf(form)+1, forms.size())){
                                if(check_form.get(1).contains(word)){
                                    /* 중복된 두 닉네임 모두 Hashset에 넣는다. */
                                    emails.add(form.get(0));
                                    emails.add(check_form.get(0));
                                }
                            }
                        }

                    }
                }
            }
        }
        /* 아직 Java method에 대해 모르는 게 너무 많다. 자료구조 기준으로 공부를 하는게 좋을듯.. */
        List<String> result = Lists.newArrayList(emails);
        /* naturalOrder()는 오름차순, reverseOrder()는 내림차순 */
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
