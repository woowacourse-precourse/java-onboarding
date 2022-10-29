package onboarding;

import java.util.ArrayList;
import java.util.List;
/*
* 중복의 최소 단위인 2글자만 탐색하면 됨
1. 금지 단어목록인 빈 리스트 생성, appeared 리스트 생성
2. 모든 닉네임에 대해서 순차적으로 탐색
3. 각 닉네임마다 2글자씩 탐색하면서 appeared에 없으면 추가
4. 만약 appeared에 이미 존재하는 2글자이면 금지목록에 추가
5. 다시 forms[][1] 닉네임 부분을 탐색하면서 금지목록의 단어가 포함되어있으면 result리스트에 이메일 추가
6. result 오름차순 정렬
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> prohibition = makeProhibition();
        return answer;
    }
    public static List<String> makeProhibition() {
        List<String> appeared = new ArrayList<String>();
        List<String> prohibition = makeProhibition();

    }
}
