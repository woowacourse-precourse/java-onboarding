package onboarding;
/*
* 1. 닉네임으로 만들 수 있는 2글자의 문자를 모두 리스트에 저장
* 2. 중복되는 문자열은 따로 리스트에 저장
* 3. 중복되는 문자열과 닉네임을 비교하여 중복되는 닉네임 추출
*/
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();// 모든 2글자 저장
        List<String> duplicate = new ArrayList<>();// 중복된 문자열 저장

        for(int i = 0; i<forms.size(); i++){
            String str = forms.get(i).get(1);
            Set<String> tmpSet= new HashSet<>();

            for(int j = 0; j<str.length()-1; j++){
                String tmp = str.substring(j, j+2);

                if(list.indexOf(tmp) == -1){
                    tmpSet.add(tmp);
                }
                else if(duplicate.indexOf(tmp) == -1){
                    duplicate.add(tmp);
                }
            }
            for(String tmp : tmpSet){
                list.add(tmp);
            }
        }

        for(int i = 0; i<forms.size(); i++){
            String str = forms.get(i).get(1);

            for(int j = 0; j<duplicate.size(); j++){
                if(str.contains(duplicate.get(j))){
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}