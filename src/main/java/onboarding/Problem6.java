package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    // 연속되는 2자리 수를 저장한 리스트 만드는 함수
    public static List<String> make(List<List<String>> listD){
        List<String> list =  new ArrayList<String>();
        for(int i = 0; i < listD.size(); i++){
            String Name = listD.get(i).get(1);
            for (int j = 0; j < Name.length()-1; j++){
                list.add(Name.substring(j,j+2));
            }
        }
        return list;
    }
    // 중복값만 필터링하는 함수
    public static List<String> filter(List<String> l){
        Set<String> Set = l.stream().filter(i -> Collections.frequency(l, i) > 1)
                .collect(Collectors.toSet());
        List<String> list = new ArrayList<String>(Set);
        return list;
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
        List<String> NameList = filter(make(forms));
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
