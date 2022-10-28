package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] word_char = word.toCharArray();

        for(int i=0; i<word_char.length;i++)
        {
            word_char[i] = chager(word_char[i]);

        }
        answer = new String(word_char);

        return  answer;

    }
    public static char chager(char word)
    {
        int number =0;
        if(96<word&&word<110) //a~m 까지 변환
        {
            word=a_m_count((int)word,97);
        }
        else if(109<word&&word<123)//n~z까지 변환
        {
            word = n_z_count((int)word,122);
        }
        else if(65<=word&&word<=77)//A~M 까지 변환
        {
            word=a_m_count((int)word,65);
        }
        else if(78<=word&&word<=90)//N~Z까지 변환
        {
            word = n_z_count((int)word,90);
        }
        return word;
    }
    public static char a_m_count(int word,int score)// a~m 변환 계산 과정
    {
        int number=0;

        number = word-score;
        number = 25-(2*number);
        word+=number;

        return (char)word;
    }
    public static char n_z_count(int word,int score)// n~z 변환 계산 과정
    {
        int number=0;

        number = score-word;
        number = 25-(2*number);
        word-=number;

        return (char)word;
    }
}
