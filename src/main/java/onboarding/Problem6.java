package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    /**
     * * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다. -> 이메일 정규식 검사
     * * 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다. ->도메인 정규식 검사
     * 위의 내용을 만족하지 못하면 제외
     * @param forms
     * @return
     */
    private static List<List<String>> check(List<List<String>> forms){
        List<List<String>> filter = new ArrayList<>();
        for (List<String> form : forms) {
            String email = form.get(0);
//            System.out.println("email = " +email + ' ' +checkLength(email) +' '+checkeMail(email));
            if(checkLength(email) && checkeMail(email)){
                filter.add(form);
            }
        }
        return filter;
    }

    /**
     * 이메일 길이 검사
     * @param email
     * @return
     */
    private static boolean checkLength(String email) {
        if(email.length() < 11 || email.length() >= 20){
            return false;
        }
        return true;
    }

    /**
     * 이메일 형식 정규식 검사
     * @param email
     * @return
     */
    private static boolean checkeMail(String email){
        Pattern pattern = Pattern.compile("^[a-z]+@email.com$");
        return pattern.matcher(email).matches();
    }

    /**
     * 체크하기 위한 문제 구하기
     * @param str
     * @param s
     * @param e
     * @return
     */
    private static String getWord(String str, int s, int e){
        return str.substring(s,e);
    }

    /**
     * 제이
     * 제이엠
     * 이엠
     * 제이
     * 제이슨
     * 이슨
     * 워니
     * 엠제
     * 엠제이
     * 제이
     * 2자리 이상의 단어 name1에서 추출하여 name2에 있는지 여부검사
     * @param name1
     * @param name2
     * @return
     */
    private static boolean comp(String name1, String name2) {
        int l = name1.length();

        for(int i = 0; i < l -1; i++){
            for(int j = i+2; j <= l; j++){
                String word = getWord(name1, i, j);
//                System.out.println("word = " + word);
                if(name2.contains(word)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다. -> 중복 조건
     * 크루는 1명 이상 10,000명 이하이다. -> List size
     * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다. -> 이메일 정규식 검사
     * 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다. ->도메인 정규식 검사
     * 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다. -> 닉네임 확인
     * result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다. -> Collections.sort, res에 있으면 넣지 않기
     */
    public static List<String> solution(List<List<String>> forms){
        forms = check(forms);
        /**
         * 비교할 대상이 없으면 throw error
         */
        if(forms.size() < 2){
            throw new IllegalArgumentException("Invaild format");
        }
        List<String> res = getEmail(forms);
        Collections.sort(res);
        return res;
    }
    /**
     * 비교하여 중복 되는 이메일 List반환
     * @param forms
     * @return
     */
    private static List<String> getEmail(List<List<String>> forms) {
        ArrayList res = new ArrayList<>();
        int l = forms.size();
        for(int i = 0; i < l; i++){
            List<String> first = forms.get(i);
            for(int j = 0; j< l; j++){
                List<String> seconds = forms.get(j);
                if(res.contains(seconds.get(0)) || i == j){
                    continue;
                }
                boolean comp = comp(first.get(1), seconds.get(1));
                if(comp){
                    res.add(seconds.get(0));
                }
            }
        }
        return res;
    }

}
