package onboarding;

import java.util.*;

public class Problem6 {
    public HashMap<String,Integer> makeCheckMap(List<List<String>> forms){
        HashMap<String,Integer> map = new HashMap<>();
        return map;
    }

    public ArrayList<String> duplicatedEmails(HashMap<String,Integer> map, List<List<String>> forms){
        ArrayList<String> emails = new ArrayList<>();
        return emails;
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 T = new Problem6();

        HashMap<String,Integer> map = T.makeCheckMap(forms);
        List<String> answer = T.duplicatedEmails(map, forms);

        return answer;
    }
}
