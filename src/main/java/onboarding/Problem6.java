package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
class TokenGroup{
    List<String> divideToken(String nickName){
        final int WINDOW_SIZE=2;
        int nickNameLength=nickName.length()-1;

        HashSet<String> token=new HashSet<>();
        for(int position=0;position<nickNameLength;position++){
            token.add(nickName.substring(position,position+WINDOW_SIZE));
        }
        return new ArrayList<>(token);
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
