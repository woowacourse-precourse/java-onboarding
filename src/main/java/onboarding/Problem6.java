package onboarding;
//닉네임을 2글자씩 끊어서 반복문을통해 contains 이용한후 찾으면 set 함수에 넣기
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicates=duplicates(forms);

        return duplicates;
    }
    public static List<String>  duplicates(List<List<String>> forms){//중복 닉네임 구하는 배열
        Set<String> duplicatesSet = new HashSet<>();
        for (int i = 0; i < forms.size();i++ ) {
            String Nick = forms.get(i).get(1);
            String name="";
            for(int j=0;j<Nick.length()-1;j++){
                name += (char) Nick.charAt(j);
                name += (char) Nick.charAt(j+1);
                for(int k=0;k<forms.size();k++){
                    if(k==i){
                        continue;
                    }
                    String Nickname=forms.get(k).get(1);
                if(Nickname.contains(name)){
                    duplicatesSet.add(forms.get(k).get(0));
                }}
                name="";
            }
        }
        List<String> duplicates=new ArrayList<>(duplicatesSet);//
        return duplicates;
    }
}
