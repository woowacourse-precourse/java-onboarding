package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@email[.]com");
        for (List<String> data : forms) {
            if(!emailPattern.matcher(data.get(0)).matches()) {
                return null;
            }
        }
        return forms.get(0);
    }
}
