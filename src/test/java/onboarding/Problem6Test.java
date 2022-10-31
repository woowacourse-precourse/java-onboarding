package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6Test {

    @Test
    void worstCaseTimeTest() {
        List<List<String>> forms =new ArrayList<>();
        forms.addAll(
                List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
                )
        );
        List <String>idParts = List.of("a","b","c","d","q");
        List<String>nickParts=List.of("가","나","다","라","마","바","ㅋ","ㅂ");

        for (int i = 0; i <10_000-5 ; i++) {
            String id=makeTestStr(idParts,10)+"@email.com";
            String nickName = makeTestStr(nickParts,20);

            forms.addAll(List.of(List.of(id,nickName)));
        }
        long startTime = System.currentTimeMillis();
        Problem6.solution(forms);
        long endTime =System.currentTimeMillis();
        long time = (endTime-startTime)/1000;
        assertThat(1L).isGreaterThan(time);


    }

    private static String makeTestStr(List<String> list,int size) {
        StringBuffer id= new StringBuffer();
        for (int j = 0; j < size; j++) {
            id.append(new Random().nextInt(list.size()));
        }
        return id.toString();
    }
}
