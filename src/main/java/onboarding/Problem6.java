package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*기능 요구 사항*/
/* 1. 닉네임 중 같은 글자가 연속적으로 포함될 경우 제한
 * 2. 같은 글자가 연속적으로 포함되는 지원자의 이메일 목록을 return
 <solution>
 *  - 모두의 이름을 배열 name 안에 넣은 후,
 *  - 연속되는 두글자가 자신이 아닌 name에 포함되는지 확인
 *  - 포함되면, answer에 이메일을 추가
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer =  new ArrayList<String>();
        List<String> name = new ArrayList<String>();

        for(int i=0; i<forms.size(); i++){
            name.add(forms.get(i).get(1));
        }

        for(int i=0; i<forms.size(); i++) { // 10000 * 20 * 10000
            boolean usable = true;
            for (int j = 0; j <= forms.get(i).get(1).length() - 2; j++) {
                for(int k=0; k<name.size(); k++){
                    if(i==k) continue;
                    if (name.get(k).contains(forms.get(i).get(1).substring(j, j + 2))) { // 이름이 중복되면
                        usable = false;
                        answer.add(forms.get(i).get(0));
                        break;
                    }
                }
                if(!usable) break;
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
