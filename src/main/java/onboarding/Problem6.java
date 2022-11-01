package onboarding;

import java.util.*;
import java.util.stream.Collectors;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
public class Problem6 {

    /* 닉네임과 이메일 값이 담기는 2차원 배열 */
    List<List<String>> forms = new ArrayList<>();
    /* 각각의 닉네임들이 2글자씩 끊겨서 저장되는 Map 인스턴스 변수 */
    Map<String, String> map = new HashMap<String, String>();
    /* 결과값들이 담기는 Set 인스턴스 변수 */
    Set<String> result = new HashSet<>();
    /*
     * Problem 6의 메인 메소드
     * @param forms 닉네임과 이메일 값이 담기는 2차원 배열
     * @return 중복된 유저의 닉네임들이 담긴 배열
     */
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        p6.forms = forms;
        p6.iterate();
        return p6.sortingSet();
    }
    /*
     * forms를 순차적으로 탐색하는 메소드
     */
    private void iterate(){
        for(List<String> form : forms){
            searchNickName(form.get(0), form.get(1));
        }
    }
    /*
     * 각각의 닉네임을 2글자씩 끊어가며 탐색하늠 메소드
     * @param email 이메일
     * @param nickName 닉네임
     */
    private void searchNickName(String email, String nickName){
        for(int i = 0; i < nickName.length()-1; i++){
            String substring = nickName.substring(i, i + 2);
            whetherExisted(email, substring);
        }
    }
    /*
     * 2글자씩 끊긴 닉네임을 map에 저장하하는 메소드
     * @email 이메일
     * @subStr 2글자로 끊긴 subString
     */
    private void whetherExisted(String email, String subStr){
        if(!map.containsKey(subStr)) map.put(subStr, email);
        else{
            result.add(email);
            result.add(map.get(subStr));
        }
    }
    /*
     * 오름 차순으로 정렬하며 최종 결과값을 반환하는 메소드
     * @return 최종 결과값
     */
    private ArrayList<String> sortingSet(){
        return result.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
