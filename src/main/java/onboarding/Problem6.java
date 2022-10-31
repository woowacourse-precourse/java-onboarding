package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem6 {
    static List<String> answer = Collections.emptyList();
    public static List<String> solution(List<List<String>> forms) {

        formsIter(forms);

        return answer;
    }

    // 기준이 되는 닉네임의 iter를 만들고 비교할 닉네임 리스트의 iter를 만들어 비교
    private static void formsIter(List<List<String>> forms){
        Iterator<List<String>> formsIter = forms.iterator(); // 기준이 되는 리스트 반복자
        List<String> nickName = Collections.emptyList(); // 기준 리스트 저장를 저장할 공간

        while(formsIter.hasNext()){
            nickName = formsIter.next(); // 기준 리스트
            compIter(nickName, forms); // 기준 리스트와 비교될 forms리스트 전달

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
                findDupNick(nickName, compNickName, sb);
            } // end if
        } // end while

    } // end compIter

    // 중복된 단어 찾기
    private static void findDupNick(List<String> nickName, List<String> compNickName, StringBuffer sb) {
        // 단어를 자르며 검사하기 위해 닉네임을 charArr 형태로 변환
        char[] nickNameCharArr = nickName.get(1).toCharArray();
        int conditinoExpression = nickNameCharArr.length - 1; // 조건식
        String word = ""; // 검사할 단어를 저장할 공간
        boolean nickDupFlag = false; // 중복된 단어가 있는지 판별하는 플래그 변수

        for(int i=0; i<conditinoExpression; i++){
            sb.setLength(0); // 초기화
            sb.append(nickNameCharArr[i]);
            sb.append(nickNameCharArr[i + 1]);
            nickDupFlag = compNickName.get(1).matches("(.*)"+sb+"(.*)");// 단어가 포함되어 있는지 검사

            // 중복체크가 True이며 result가 비어있을 시
            if(nickDupFlag && answer.isempty){
                answer = new ArrayList<>();
                answer.add(nickName.get(0));
                answer.add(compNickName.get(0));
                break;
            } else if (nickDupFlag) { // 중복체크만 True
                answer.add(nickName.get(0));
                answer.add(compNickName.get(0));
                break;
            }
        } // end for
    } // end findDupNick
}
