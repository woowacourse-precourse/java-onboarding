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
        List<String> nickName = Collections.emptyList(); // 기준 리스트 저장를 저장할 공간

        while(formsIter.hasNext()){
            nickName = formsIter.next(); // 기준 닉네임

        } // end while
    } // enD formsIter

    // 비교할 리스트의 반복자를 만들고 닉네임을 순차적으로 비교
    private static void compIter(List<String> nickName, List<List<String>> forms){

        Iterator<List<String>> compFormsIter = forms.iterator(); // 비교할 리스트의 반복자
        List<String> compNickName = Collections.emptyList(); // 비교할 리스트를 저장할 공간

        while(compFormsIter.hasNext()){
            compNickName = compFormsIter.next(); // 비교할 닉네임
            if(!nickName.containsAll(compNickName)) { // 리스트의 요소가 같지 않다면
                StringBuffer sb = new StringBuffer(); // 문자열을 용이하게 다루기 위해 StringBuffer 생성

            }
        }

    }
}
