package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return make_by_tree_frog_dictionary(word);
    }
    static String make_by_tree_frog_dictionary(String word)
    {
        String frog_word = "";

        for(int i = 0; i < word.length(); i ++)
        {
            if(is_alpha(word.charAt(i)))
            {
                char tmpch = make_ch_by_frog(word.charAt(i));
                frog_word = frog_word + tmpch;
            }
            else
            {
                frog_word = frog_word + word.charAt(i);
            }
        }
        return frog_word;
    }
    static boolean is_alpha(char ch)
    {
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            return true;
        return false;
    }
    static char make_ch_by_frog(char ch)
    {
        if(ch >= 'A' && ch <= 'Z')
            return (char)('A' + 25 - (ch - 'A'));
        if(ch >= 'a' && ch <= 'z')
            return (char)('a' + 25 - (ch - 'a'));
        return '?';
    }
}
