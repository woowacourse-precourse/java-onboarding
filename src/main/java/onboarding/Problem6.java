package onboarding;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }



    public static Map<String, String> convertToMap(List<List<String>> forms){

        Map<String, String> formsMap = forms.stream()
                .collect(Collectors.toMap(k->k.get(0), v->v.get(1)));

        return formsMap;
    }


}
