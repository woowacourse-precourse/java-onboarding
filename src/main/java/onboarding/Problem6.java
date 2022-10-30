package onboarding;

import java.util.List;
import java.util.Map;

public class Problem6 {

    public static Map<String, Integer> distinctNickList;

    public static List <String> solution(List <List <String>> forms) {
        for (List <String> crew : forms) {
            distinctNick(crew.get(1));
        }

        return null;
    }

    public static void distinctNick(String nickName) {
        for(int i = 0; i < nickName.length() - 2; i++){
            String partOfNick = nickName.substring(i, i+2);

            if(distinctNickList.containsKey(partOfNick)){
                distinctNickList.put(partOfNick, 1 + distinctNickList.get(partOfNick));
            } else
                distinctNickList.put(partOfNick, 1);
        }
    }

    /*class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }*/
}