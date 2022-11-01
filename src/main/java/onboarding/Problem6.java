package onboarding;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> mailbox = new HashSet<String>();

        Map<String, String> comboMap = new HashMap<String, String>();
        String[] basket = new String[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            int j = 1;
            basket[i] = forms.get(i).get(j);

        }
        int max = 0;


        for (int i = 0; i < forms.size(); i++) {
            String pattern = forms.get(i).get(1);

            if (pattern.length() < 2) {
                break;
            }

            for (int j = 0; j < pattern.length() - 1; j++) {
                String key = pattern.substring(j, j + 2);

                if (comboMap.containsKey(key)) {
                    String mail = comboMap.get(key);
                    if (!mail.equals(forms.get(i).get(0))) {
                        mailbox.add(mail);
                        mailbox.add(forms.get(i).get(0));
                    }
                }
                comboMap.put(key, forms.get(i).get(0));
            }
        }


        List<String> answer = mailbox.stream().sorted().collect(Collectors.toList());

        return answer;

    }
}

