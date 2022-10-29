package onboarding;

import java.util.ArrayList;
import java.util.List;

//-----기능-----
//1. 닉네임 배열 생성
//2. 연속적인 닉네임 조합 생성
//2. 조합이 닉네임 중 존재하는지 확인

public class Problem6 {

    static List<String> nick = new ArrayList<>();
    private static List<String> stringCombination = new ArrayList<>();

    private static void nCr(char[] str, int r, int i){
        String result = "";

        while (r-- > 0)
            result += str[i++];
        stringCombination.add(result);
    }

    private static void callComb(char[] str, int r)
    {
        for(int i = 0; i <= str.length - r; i++){
            nCr(str, r, i);
        }
    }

    private static void nickComb(int i){
        String str = nick.get(i);
        for (int j = 2; j <= str.length(); j++)
            callComb(str.toCharArray(),  j);
        System.out.println("StringComb : " + stringCombination);
    }

    private static void getDupNick(int i) {
        nickComb(i);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (int i = 0; i <forms.size(); i++)
            nick.add(forms.get(i).get(1));

        for (int i = 0; i <forms.size(); i++)
        {
            getDupNick(i);
        }

        return answer;
    }
}
