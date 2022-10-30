package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 풀이 : 딕셔너리를 리스트로 만들어 2개 이상일 때 찾는다
        // 주의점 1) 오름차순으로 정렬하기
        // 궁금점 1) 닉네임은 한글만 된다고 했지만 한글에 대해서 어떻게 처리하는지 나와있지 않음
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> Duplicatemap=new HashMap<>();

        // 1) 입력 받은 forms 만큼 진행합니다
        for (List<String> form: forms) {
            String Email = form.get(0); //0은 이메일
            String Name = form.get(1); //1은 이름
            // 2) 두글자의 닉네임을 해시 맵에 저장하는 부분을 진행합니다/
            for (int j=0; j<Name.length()-1;j++) {
                String TmpString = Name.substring(j,j+2); // 2글자만 가져오기
                // 3-1) 이미 있다면 List에 Add 하기
                if (Duplicatemap.containsKey(TmpString)) {
                    List<String> Tmp = Duplicatemap.get(TmpString);
                    Tmp.add(Email);
                    Duplicatemap.put(TmpString,Tmp);
                } // 3-2) 없다면 List를 만들고 Add하기
                else {
                    List<String> Tmp = new ArrayList<>();
                    Tmp.add(Email);
                    Duplicatemap.put(TmpString,Tmp);
                }
            }
        }
        // 4) 해시맵에 저장된 키 값들을 순서대로 진행하기
        for (String str : Duplicatemap.keySet()) {
            List<String> Tmp =  Duplicatemap.get(str);
            if (Tmp.size()>=2) { // 2개 이상일 때는 중복
                for (String j : Tmp) {
                    // 5) 값이 없다면 추가한다
                    if (!answer.contains(j)) answer.add(j);
                }
            }
        }
        // 5) 오름차순 정렬 하기
        Collections.sort(answer);
        return answer;
    }
}
