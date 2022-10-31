package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        HashMap<Integer, List> checkword = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {

            String check = forms.get(i).get(1);
            map.put(forms.get(i).get(0), forms.get(i).get(1)); //맵에 넣기

            String a =" ";
            list.clear();
            for (int j = 0; j < check.length()-1; j++) {
                a =" ";
                char [] word = check.toCharArray();
                a += word[j];
                a += word[j+1]; //두 글자씩 자름
                list.add(a);
                System.out.println("리스트" + list);

            } checkword.put(i, list);
            System.out.println(checkword);
        }
        return answer;
    }
}
