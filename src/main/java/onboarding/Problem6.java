package onboarding;

import java.util.*;


/*
* 약어
* sn : Substring Name(이름의 부분 문자열)
* */
public class Problem6 {
    private static List<List<String>> snList = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> snAndCountMap = new HashMap<>();
        snList = new ArrayList<>();

        makeSnList(forms);
        makeCount(snAndCountMap);
        makeAnswer(forms, snAndCountMap, answer);

        Collections.sort(answer);

        return answer;
    }

    /*
     * 이름에서 두 자리 이상의 부분 문자열을 구해 리스트로 반환한다.
     * */
    private static List<String> subName(String name) {
        List<String> sub = new ArrayList<>();
        int n = name.length();
        for (int i = 2; i <= n; i++) { // 크기
            for (int j = 0; i + j <= n; j++) { // 위치
                if (n - j >= 2) {
                    sub.add(name.substring(j, i + j));
                }
            }
        }
        return sub;
    }

    /*
     * 각 이름에서 부분 문자열을 구한다.
     * */
    private static void makeSnList(List<List<String>> forms){
        for (List<String> form : forms) {
            String name = form.get(1);
            snList.add(subName(name));
        }
    }

    /*
     * 구해진 부분 문자열로 개수를 센다.
     * */
    private static void makeCount(Map<String, Integer> snAndCountMap){
        for (List<String> strings : snList) {
            for (String par : strings) {
                snAndCountMap.put(par, snAndCountMap.getOrDefault(par, 0) + 1);
            }
        }
    }

    /*
     * 부분 문자열의 길이가 2 이상일 경우 정답에 추가한다.
     * */
    private static void makeAnswer(List<List<String>> forms,
                                   Map<String, Integer> snAndCountMap,
                                   List<String> answer){

        Person : for (int i = 0; i < snList.size(); i++) {
            for (int j = 0; j < snList.get(i).size(); j++) {
                int val = snAndCountMap.get(snList.get(i).get(j));
                if (val >= 2) {
                    String email = forms.get(i).get(0);
                    answer.add(email);
                    continue Person;
                }
            }
        }
    }
}
