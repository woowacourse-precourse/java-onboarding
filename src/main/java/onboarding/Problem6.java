package onboarding;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

public class Problem6 {
    public static List<String> getEmail(String[] word, String[][] newforms){
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < newforms.length; i++) {
            for (int j = 0; j < word.length; j++) {
                if (notKorean(newforms[i][1]) == false) {
                    if (newforms[i][1].contains(word[j]) == true) {
                        if (newforms[i][0].contains("email.com") == true) {
                            result.add(newforms[i][0]);
                        }
                    }
                }
            }
        }
        return result;
    }
    public static String[] reWord(String[][] newforms, int size){
        StringBuffer word = new StringBuffer();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < newforms[i].length - 1; j++) {
                for (int k = i + 1; k < size; k++) {
                    if (newforms[k][1].indexOf(newforms[i][1].charAt(j)) != -1) {
                        int index = newforms[k][1].indexOf(newforms[i][1].charAt(j));
                        if (index + 1 > newforms[k][1].length() - 1)
                            break;
                        else if (newforms[i][1].charAt(j + 1) == newforms[k][1].charAt(index + 1)) {
                            word.append(newforms[i][1].charAt(j));
                            word.append(newforms[i][1].charAt(j + 1));
                            word.append(" ");
                        }
                    }
                }
            }
        }
        String reword = word.toString();
        String[] rewords = reword.split(" ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < rewords.length; i++){
            set.add(rewords[i]);
        }
        String[] result = new String[set.size()];
        Iterator iter = set.iterator();
        int index = 0;
        while (iter.hasNext()){
            result[index] = iter.next().toString();
            index++;
        }
        return result;
    }
    public static boolean notKorean(String word) {
        for (int i = 0; i < word.length(); i++){
            if (Character.getType(word.charAt(i)) != 5){
                return true;
            }
        }
        return false;
    }
    public static String[][] ChangeFroms(List<List<String>> forms)
    {
        String[][] result = new String[forms.size()][2];
        for (int i = 0; i < forms.size(); i++){
            for (int j = 0; j < 2; j++){
                result[i][j] = forms.get(i).get(j);
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        String[][] newforms;
        String[] word;

        newforms = ChangeFroms(forms);
        word = reWord(newforms, forms.size());
        answer = getEmail(word, newforms);
        HashSet<String> setting = new HashSet<String>();
        for (int i = 0; i < answer.size(); i++){
            setting.add(answer.get(i));
        }
        List<String> result = new ArrayList<String>();
        Iterator iter = setting.iterator();
        while (iter.hasNext()){
            result.add(iter.next().toString());
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이준재엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"),
                List.of("wnswo8628@email.com", "준재곽"),
                List.of("wnswo8888@email.com", "곽준재"),
                List.of("wnwnwn@email.com", "준재준재k")
        );
        List<String> result = solution(forms);
        //System.out.println(result);
    }
}
