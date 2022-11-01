package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashSet;

public class Problem6 {
    /* str1, str2 의 닉네임 중 두글자 이상이 연속적으로 순서에 맞추어 포함되어 있는지의 여부를 반환한다.
       1<=str1, str2 < 20 으로 짧으므로 단순히 비교한다. */
    private boolean isContiDup(String str1, String str2){
        boolean prevMatched = false;
        for(int begin = -str2.length() + 1; begin < str1.length(); ++begin){
            prevMatched = false;
            for(int i = 0; i < str2.length() && begin + i < str1.length(); ++i){
                if(begin + i < 0) {
                    continue;
                }
                if(str1.charAt(begin + i) == str2.charAt(i)){
                    if(prevMatched){
                        return true;
                    } else{
                        prevMatched = true;
                    }
                } else{
                    prevMatched = false;
                }
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>();
        Problem6 p6 = new Problem6();
        for(int i = 0; i < forms.size(); ++i){
            for(int j = i + 1; j < forms.size(); ++j){
                if(p6.isContiDup(forms.get(i).get(1), forms.get(j).get(1))){
                    hs.add(forms.get(i).get(0));
                    hs.add(forms.get(j).get(0));
                }
            }
        }
        answer.addAll(hs);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
