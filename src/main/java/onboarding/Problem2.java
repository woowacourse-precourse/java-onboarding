package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
    public static String solution(String cryptogram)
    {
        if(!checkCode(cryptogram))
            return cryptogram +  "is wrong.";

        char[] array = cryptogram.toCharArray();

        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i < cryptogram.length(); i++)
        {
            char c = cryptogram.charAt(i);
            list.add(c);
        }

        String answer = convertToString(checkDuplication(list));
        return answer;
    }

    private static boolean checkCode(String cryptogram)
    {
        String regex = "[a-z]{1,1000}";
        if(!cryptogram.matches(regex))
            return false;

        return true;
    }

    private static List<Character> checkDuplication(List<Character> list)
    {
        boolean isDupl = false;
        for(int i = 1; i < list.size(); i++)
        {
            if (isDupl)
                break;

            if (list.get(i - 1) == list.get(i))
            {
                list.remove(i);
                list.remove(i - 1);
                isDupl = true;
            } else
                isDupl = false;
        }

        if(isDupl)
            list = checkDuplication(list);

        return list;
    }

    private static String convertToString(List<Character> list)
    {
        String str = "";
        for(char a : list)
        {
            str += a;
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the code");
        String code = solution(scanner.next());
        System.out.println("answer is " + code);
    }
}

