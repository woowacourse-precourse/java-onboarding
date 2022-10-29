package onboarding;
//닉네임을 2글자씩 끊어서 반복문을통해 contains 이용한후 찾으면 set 함수에 넣기
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicates=duplicates(forms);
       List<String> answer= CheckDuplicates(duplicates);
       
        return answer;
    }
    public static List<String>  duplicates(List<List<String>> forms){//중복 닉네임 모아둔 배열
        List<String> duplicates = new ArrayList<>();
        for (int i = 0; i < forms.size();i++ ) {
            String Nick = forms.get(i).get(1);
            String name="";
            for(int j=0;j<Nick.length()-1;j++){
                name += (char) Nick.charAt(j);
                name += (char) Nick.charAt(j+1);
                if(forms.contains(name)){
                    duplicates.add(forms.get(i).get(0));
                }
                name="";
            }
        }
        return duplicates;
    }
    public static List<String>  CheckDuplicates(List<String> duplicates){//중복 닉네임 모아둔 배열속 같은 주소록은 하나만 만들기
        Set<String> set = new HashSet<>(duplicates);]
        return duplicates=new ArrayList<>(set);
    }
}
