package onboarding.problem4;

import java.util.HashMap;
public class Encoder
{
    private static final int SIZE=26;
    private static final char LOWER_CHAR_A= 'a';
    private static final char LOWER_CHAR_Z = 'z';
    private static final char UPPER_CHAR_A = 'A';
    private static final char UPPER_CHAR_Z = 'Z';
    private HashMap<Character, Character> map;
    private void initEncoder()
    {
        for(int i = 0 ; i < SIZE; i++)
        {
            addCharacter((char)(LOWER_CHAR_A + i),(char)(LOWER_CHAR_Z-i));
            addCharacter((char)(UPPER_CHAR_A + i),(char)(UPPER_CHAR_Z-i));
        }
    }
    private void addCharacter(Character key,Character value)
    {
        if(map.containsKey(key))
        {
            map.remove(key);
        }
        map.put(key,value);
    }
    public Encoder()
    {
        map = new HashMap<>();
        initEncoder();
    }
    public String encode(String word)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < word.length();i++)
        {
            char key = word.charAt(i);
            char value = map.containsKey(key) ? map.get(key) : key;
            sb.append(value);
        }
        return sb.toString();
    }
}