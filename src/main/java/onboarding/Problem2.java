package onboarding;

public class Problem2 {
    public static boolean istwo(String str)
    {
        int flag = 0;
        for (int i = 0; i < str.length() - 1; i++)
        {
            if (str.charAt(i) == str.charAt(i + 1))
                flag = 1;
        }
        if (flag == 1)
            return true;
        else
            return false;
    }
    public static String removeStr(String str)
    {
        StringBuilder MyString = new StringBuilder(str);
        for (int i = 0; i < MyString.length() - 1; i++)
        {
            if (MyString.charAt(i) == MyString.charAt(i + 1))
            {
                MyString = MyString.deleteCharAt(i);
                MyString = MyString.deleteCharAt(i);
            }
        }
        str = MyString.toString();
        return str;
    }
    public static String solution(String cryptogram) {
        String answer;

        int i = 0;
        answer = cryptogram;
        while (true)
        {
            answer = removeStr(answer);
            if (istwo(answer) == false)
                break;
            i++;
        }
        return answer;
    }
}
