package onboarding;

import java.util.*;

//-----기능-----
//1. 닉네임 배열 생성
//2. 연속적인 닉네임 조합 생성
//3. 조합이 닉네임 중 존재하는지 확인
//4. 오름차순 정렬

public class Problem6 {

    static List<String> nick = new ArrayList<>();
    private static List<String> stringCombination = new ArrayList<>();
    private static HashSet<Integer> idx = new HashSet<>();

    private static void comb(char[] str, int r, int i) {
        String result = "";

        while (r-- > 0)
            result += str[i++];
        stringCombination.add(result);
    }

    private static void callComb(char[] str, int r) {
        for(int i = 0; i <= str.length - r; i++){
            comb(str, r, i);
        }
    }

    private static void getnickComb(int i) {
        String str = nick.get(i);
        for (int j = 2; j <= str.length(); j++)
            callComb(str.toCharArray(),  j);
    }

    private static void getDupEmail(int i) {
        getnickComb(i); //조합 얻음
        for(int k = i + 1; k < nick.size(); k++)
            dupCheck(i); // 중복 검사
        stringCombination.clear();//  Comb 비우기
    }

    private static void dupCheck(int i) {
        for(int k = 0; k < stringCombination.size(); k++)
            isContain(stringCombination.get(k), i);
    }

    private static void isContain(String str, int i) {
        for (int k = i + 1; k < nick.size(); k++)
        {
            if (nick.get(k).contains(str))
            {
                idx.add(i);
                idx.add(k);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        for (int i = 0; i <forms.size(); i++)
            nick.add(forms.get(i).get(1));

        for (int i = 0; i <forms.size(); i++)
            getDupEmail(i);

        Iterator iter = idx.iterator();
        while(iter.hasNext()) {
           answer.add(forms.get((Integer) iter.next()).get(0));
        }

        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
