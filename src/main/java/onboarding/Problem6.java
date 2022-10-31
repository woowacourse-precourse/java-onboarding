package onboarding;

import java.util.*;

public class Problem6 {

    static List<String> in;
    static List<String> eq;

    // 2글자 이상의 조합 찾기 순서 대로
    public static List<String> combi(List<String> input, List<String> combi, int cnt){
        for(int i=0; i<input.size(); i++){
            String a = "";
            if(cnt-1 < input.size()){
                for(int j=0; j<cnt; j++){
                    if(i+j < input.size()){
                        a += input.get(i+j);
                    }
                }
                combi.add(a);
                combi(input, combi, cnt + 1);
            }
        }
        return combi;
    }

    public static List<String> removeDuplicationAndOne(List<String> combi){
        Set<String> set = new HashSet<String>(combi);
        List<String> newList = new ArrayList<>(set);
        for(int i=0; i<newList.size(); i++){
            if(newList.get(i).length() == 1) newList.remove(newList.get(i));
        }
        return newList;
    }

    public static List<String> solution(List<List<String>> forms) {
        // 닉네임 만 분리
        List<String> list = new ArrayList<>();
        for(int i=0; i< forms.size(); i++){
            list.add(forms.get(i).get(1));
        }
        System.out.println(list);

        // 각 닉네임 문자열 분리
        List<List<String>> arr11 = new ArrayList<>();
        for(String get : list){
            List<String> a = List.of(get.split(""));
            arr11.add(a);
        }

        // 조합 찾아서 비교
        int[] result = new int[list.size()];
        for(int i=0; i< arr11.size(); i++){
            in = new ArrayList<>();
            in = combi(arr11.get(i), in, 2);
            in = removeDuplicationAndOne(in);

            // 값 찾기
            if(i+1 < arr11.size()){
                for(int j=i+1; j< list.size(); j++){
                    eq = new ArrayList<>();
                    eq = combi(arr11.get(j), eq, 2);
                    eq = removeDuplicationAndOne(eq);
                    for(String a : in){
                        for(String b : eq){
                            if(a.equals(b)) {
                                result[i] +=1;
                                result[j] +=1;
                            }
                        }
                    }
                }
            }
        }

        // 최종 결과
        List<String> answer = new ArrayList<>();
        for(int i=0; i< result.length; i++){
            if(result[i] != 0){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);  // 문자열 정렬
        return answer;
    }
}
