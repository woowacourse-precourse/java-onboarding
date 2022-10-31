package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer
{
    private static final int SEQUENCE = 2;
    public static List<String> getTokens(String input)
    {
        List<String> resultList = new ArrayList<>();

        for(int i = 0 ; i <= input.length() - SEQUENCE;i++)
        {
            resultList.add(input.substring(i,i+SEQUENCE));
        }

        return resultList;
    }
}