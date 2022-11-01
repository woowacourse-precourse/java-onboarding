package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> overlapped = new ArrayList<String>();

        String str = new String("");

        for(int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                str = forms.get(i).get(1).substring(j,j+2) + Integer.toString(i);
                overlapped.add(str);
            }
        }
        overlapped.sort(Comparator.naturalOrder());

        for(int i = 0; i < overlapped.size() - 1; i++) {
            str = overlapped.get(i).substring(0,2);
            char index1 = overlapped.get(i).charAt(2);
            char index2 = overlapped.get(i+1).charAt(2);

            if( (str.equals(overlapped.get(i+1).substring(0,2))) && index1 != index2) {
                answer.add(forms.get(index1 - '0').get(0));
                answer.add(forms.get(index2 - '0').get(0));
            }
        }
        answer = answer.stream().distinct().collect(Collectors.toList());
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
