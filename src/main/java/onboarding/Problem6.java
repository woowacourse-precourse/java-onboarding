package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    /**
     * [Solution 함수]
     * @param forms
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {
        return searchAll(forms);
    }



    /**
     * [2글자이상 연속되는 닉네임을 가진 이메일을 찾는 메서드]
     * - 입력받은 데이터에서 searchWord를 통해 검색해야하는 단어들을 가져온다.
     * - 가져온 단어들이 중복되는지 search를 통해 확인한다.
     * - 중복 확인한 결과를 HashSet에 저장한다.
     * - HashSet을 ArrayList로 바꾼 뒤, 오름차순으로 정렬한다.
     * @param forms - 이메일, 닉네임 정보
     * @return - 중복되는 이메일 정보
     */
    public static ArrayList<String> searchAll(List<List<String>> forms) {
        return new ArrayList<>();
    }

    /**
     *[form의 idx의 닉네임으로 2글자 단어 만들기]
     * - 입력으로 들어온 index의 닉네임으로 만들 수 있는 2글자의 모든 단어를 리턴한다.
     * @param idx
     * @param forms
     * @return
     */
    public static ArrayList<String> searchWord(int idx, List<List<String>> forms) {
        return new ArrayList<>();
    }

    /**
     * [시작 idx부터 forms의 모든 데이터에서 word가 중복되는지 체크]
     *  - 입력으로 들어온 인덱스부터 forms의 모든 데이터가 word랑 중복되는지 체크한다.
     *  - word랑 중복되는 데이터가 있다면 Email을 HashSet형태로 반환한다.
     * @param startIdx
     * @param forms
     * @param word
     * @return
     */
    public static HashSet<String> search(int startIdx,List<List<String>> forms, String word) {

        return new HashSet<>();
    }






}
