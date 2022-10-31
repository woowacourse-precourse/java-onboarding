package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    /**
     * [Solution 함수]
     * @param forms
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {
        return resultEmailSetToList(findEmail(formToMap(forms)));
    }


    /**
     * [입력받은 forms데이터를 Map데이터로 변환]
     * - 중복된단어:이메일 형태로 변환
     * @param forms
     * @return formMap
     */
    public static Map<String, List<String>> formToMap(List<List<String>> forms){
        Map<String,List<String>> formMap = new HashMap<>();
        for (List<String> f : forms) {
            for (int i=0; i<f.get(1).length()-1; i++){
                String word = f.get(1).substring(i,i+2);
                if (!formMap.containsKey(word)){
                    formMap.put(word, new ArrayList<>());
                }
                formMap.get(word).add(f.get(0));
            }
        }
        return formMap;
    }

    /**
     * [2글자 이상중복되는 이메일 찾기]
     *  - Map에 저장되어있는 이메일중 길이가 2이상인 이메일만 Set으로 담아 반환
     * @param formMap
     * @return
     */
    public static Set<String> findEmail(Map<String,List<String>> formMap) {
        Set<String> resultEmail = new HashSet<>();

        formMap.values().stream()
                .filter(item -> item.size()>1)
                .forEach(resultEmail::addAll);
        return resultEmail;
    }

    /**
     * [출력 조건에 맞게 변경]
     * - Set을 List로 변환하고 이메일을 사전순으로 정렬
     * @param resultEmail
     * @return
     */
    public static List<String> resultEmailSetToList(Set<String> resultEmail){
        List<String> resultEmailList = new ArrayList<>();
        resultEmailList = resultEmail.stream()
                .sorted()
                .collect(Collectors.toList());
        return resultEmailList;
    }



}
