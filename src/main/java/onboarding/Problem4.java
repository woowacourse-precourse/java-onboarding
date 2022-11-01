package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> treeFrogDic = new HashMap<>();

    public static String solution(String word) {

        char[] alpa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'x', 'y', 'z'};

        for(int i = 0; i < alpa.length; i++)
        {
            treeFrogDic.put(alpa[i], alpa[alpa.length-1-i]);
        }

        char[] wordCharArray = word.toCharArray();
        String answer = "";

        for(int i = 0; i < wordCharArray.length; i++)
        {
            boolean isUpper = false;
            if(Character.isUpperCase(wordCharArray[i]))
                isUpper = true;

            answer += convertTreeFrogDic(Character.toLowerCase(wordCharArray[i]), isUpper);
        }

        return answer;
    }

    private static char convertTreeFrogDic(char oneWord, boolean isUpper)
    {
        for(char key : treeFrogDic.keySet()) {
            if(oneWord == key)
            {
                char value = treeFrogDic.get(key);
                return isUpper ? Character.toUpperCase(value) : value;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(solution("I lOve yOu"));
    }
}
