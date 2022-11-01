package onboarding;

public class Problem4 {
    static int[] convert = {25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25};
    public static boolean IsUpper(char c)
    {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }
    public static boolean IsLower(char c)
    {
        if (c >= 'a' && c <= 'z')
            return true;
        return false;
    }
    public static boolean IsAlpha(char c)
    {
        if (IsUpper(c) || IsLower(c))
            return true;
        return false;
    }
    public static String solution(String word) {
        String answer;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (IsAlpha(chars[i]))
            {
                if (IsUpper(chars[i]))
                    chars[i] += convert[chars[i] - 'A'];
                else
                    chars[i] += convert[chars[i] - 'a'];
            }
        answer = String.valueOf(chars);
        return answer;
    }
}
