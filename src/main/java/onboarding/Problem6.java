package onboarding;
//닉네임을 2글자씩 끊어서 반복문을통해 contains 이용한후 찾으면 set 함수에 넣기
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicates=duplicates(forms);
        return duplicates;
    }
    public static List<String>  duplicates(List<List<String>> forms){//중복 닉네임 구하는 배열
        Set<String> duplicatesSet = new HashSet<>();//중복제거하는 배열을위해 Set 생성
        for (int i = 0; i < forms.size();i++ ) {
            String Nick = forms.get(i).get(1);

            for(int j=0;j<Nick.length()-1;j++){
               String name=Makeword(Nick,j);
                for(int k=0;k<forms.size();k++){
                    if(k==i){
                        continue;//자기자신제외
                    }
                    String Nickname=forms.get(k).get(1);
                if(Nickname.contains(name)){
                    duplicatesSet.add(forms.get(k).get(0));
                }}
            }
        }
        List<String> duplicates=new ArrayList<>(duplicatesSet);
        Collections.sort(duplicates);
        return duplicates;
    }
    public static String Makeword(String Nick,int index){//검사하는 단어
        String name="";
        name += (char) Nick.charAt(index);
        name += (char) Nick.charAt(index+1);
        return name;
    }
}
