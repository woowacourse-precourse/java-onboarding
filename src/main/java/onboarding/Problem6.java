package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    // 검증리스트 만드는 함수
    public static List<String> makeList(List<List<String>> listD){
        //  모든닉네임의 연속되는 2자리 문자들을 모아놓은 리스트 생성
        List<String> list =  new ArrayList<String>();

        for(int i = 0; i < listD.size(); i++){
            String Name = listD.get(i).get(1);
            // 이름별 2자리 문자들 (중복 없이)
            List<String> sub_list = new ArrayList<String>();
            for (int j = 0; j < Name.length()-1; j++){
                sub_list.add(Name.substring(j,j+2));
            }
            sub_list = uniqueSort(sub_list);

            for (int k = 0; k < sub_list.size(); k++){
                list.add(sub_list.get(k));
            }

        }
        // 2. 중복되는 2자리 문자만 필터링
        Set<String> Set = list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
        List<String> result = new ArrayList<String>(Set);


        return result;
    }
    // 중복제거 + 정렬 함수
    public static List<String> uniqueSort(List<String> l){
        HashSet<String> Set = new HashSet<String>(l);
        List<String> list = new ArrayList<String>(Set);
        Collections.sort(list);
        return list;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        // 검증 이름 리스트 생성
        List<String> NameList = makeList(forms);
        // 검증
        for(int i = 0; i< forms.size(); i++){
            for(int j = 0; j< NameList.size(); j++)
                if(forms.get(i).get(1).contains(NameList.get(j))){
                    answer.add(forms.get(i).get(0));
                }
        }
        // 중복제거 및 정렬
        answer = uniqueSort(answer);
        return answer;
    }
}
