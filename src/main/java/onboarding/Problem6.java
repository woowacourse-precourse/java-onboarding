package onboarding;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem6 {
    List<String> answer = Collections.emptyList();
    public static List<String> solution(List<List<String>> forms) {



        return answer;
    }

    // 기준이 되는 닉네임의 iter를 만들고 비교할 닉네임 리스트의 iter를 만들어 비교
    private static void formsIter(List<List<String>> forms){
        Iterator<List<String>> formsIter = forms.iterator(); // 기준이 되는 리스트 반복자
        List<String> nickName = Collections.emptyList(); // 기준 리스트 저장

        while(formsIter.hasNext()){
            nickName = formsIter.next(); // 기준 닉네임

        }

    }
}
