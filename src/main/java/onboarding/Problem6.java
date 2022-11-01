package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Integer> map = new HashMap<String, Integer>();
    static Set<String> result = new HashSet<String>();
    public static void makeResultSet(String email, String nickname, int index, List<List<String>> forms){
        for(int j=0; j<nickname.length()-1; j++) {
            String substr = nickname.substring(j, j+2);
            //현재 map에 해당 문자열이 존재하지 않는 경우
            if(map.get(substr)==null) {
                map.put(substr, index);
            }
            //현재 map에 해당 문자열이 존재하는 경우
            else {
                //해당 문자열을 map에 넣었을 때의 크루와 현재 크루가 동일한 사람이 아나면 중복되므로 result에 insert
                if(map.get(substr)!=index) {
                    int ind = map.get(substr);
                    result.add(forms.get(ind).get(0));
                    result.add(email);
                }
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        for(int i=0; i<forms.size(); i++) {
            List<String> form = forms.get(i);
            String email = form.get(0);
            String nickname = form.get(1);
            //닉네임이 1글자이면 중복될 수 없다.
            if(nickname.length()==1) continue;
            makeResultSet(email, nickname, i, forms);
        }
        List <String> answer = makeAnsList();
        return answer;
    }
}

