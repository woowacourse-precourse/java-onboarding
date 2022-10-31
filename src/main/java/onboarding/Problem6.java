package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    
    static List<String> in;
    static List<String> eq;
    public static List<String> combi(List<String> input, List<String> combi){
        // 2글자 조합
        for(int i=0; i<input.size(); i++){  // 제, 이, 슨
            if(i+1 < input.size()){
                String a = input.get(i) + input.get(i+1);
                combi.add(a);
            }
        }
        // 3글자 조합
        for(int i=0; i<input.size(); i++){  // 제, 이, 슨
            if(i+2 < input.size()){
                String a = input.get(i) + input.get(i+1) + input.get(i+2);
                combi.add(a);
            }
        }
        return combi;
//        // 2글자 이상의 조합 찾기 순서대로
//        for(int i=0; i<input.size(); i++){
//        }
    }

    public static List<String> solution(List<List<String>> forms) {
        // 닉네임 만 분리
        List<String> list = new ArrayList<>();
        for(int i=0; i< forms.size(); i++){
            list.add(forms.get(i).get(1));
        }
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
            in = combi(arr11.get(i), in);
            System.out.println(in);

            // 값 찾기
            if(i+1 < arr11.size()){
                for(int j=i+1; j< list.size(); j++){
                    eq = new ArrayList<>();
                    eq = combi(arr11.get(j), eq);
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
