package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int i,j,k;
        List<String> answer = new ArrayList<>();
        String nickname[] = new String[forms.size()];
        int check[] = new int[forms.size()];
        int num=0;
        for(i=0;i<forms.size();i++)
            nickname[i]=forms.get(i).get(1);

        for(i=0;i<forms.size()-1;i++){ //브루스 포스
            for(j=0;j<nickname[i].length()-1;j++){
                for(k=i; k<forms.size()-1; k++) {
                    if (nickname[k + 1].indexOf(nickname[i].charAt(j)) != -1 && nickname[k + 1].indexOf(nickname[i].charAt(j)) != nickname[k + 1].length() - 1) {
                        if (nickname[i].charAt(j + 1) == nickname[k+1].charAt(nickname[k + 1].indexOf(nickname[i].charAt(j)) + 1)) {
                            check[i]++;
                            check[k + 1]++;
                            break;
                        }
                    }
                }
            }
        }
        for(i=0;i<forms.size();i++){
            if(check[i]!=0){
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer,String.CASE_INSENSITIVE_ORDER); //이름 순 정렬

        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = new ArrayList<>();
        result = solution(forms);
        for (String value : result)
            System.out.println(value);
    }
}