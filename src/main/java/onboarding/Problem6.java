package onboarding;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.toArray().length; i++) {
            List data = forms.get(i);
            if(checkName((String) data.get(1), forms)){
                answer.add((String) data.get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }
    // 이름을 하나씩 checkTwoWord 메소드에 비교하며 같은게 있는지 확인하는 메소드
    static boolean checkName(String name1, List<List<String>> forms) {
        for (int i = 0; i < forms.toArray().length; i++) {
            String name2 = forms.get(i).get(1);
            if (!Objects.equals(name1, name2)) {
                if(checkTwoWord(name1, name2)){
                    return true;
                }
            }
        }
        return false;
    }

    // 두글자 이상 같은 이름이 있으면 true로 반환하는 메소드
    static boolean checkTwoWord(String name1, String name2) {
        int i = 0;
        // i,j 포인터를 이용하여 비교한다.
        while(i<name1.length()){
            int j = 0;
            int count = 0;
            while (i< name1.length() && j<name2.length()){
                if(name1.charAt(i) == name2.charAt(j)){
                    count++;
                    i++;
                }
                j++;
            }
            if (count > 1) {
                return true;
            }
            i++;
        }
        return false;
        }
    }





