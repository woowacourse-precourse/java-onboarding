package onboarding.problem4;

public class ReverseConverter {

    public static final int TYPE_NONE = 0;
    public static final int TYPE_UPPER_CASE = 1;
    public static final int TYPE_LOWER_CASE = 2;

    private static final char ASCII_A_Z_SUM = 155;
    private static final char ASCII_a_z_SUM = 219;


    public static String convert(String word){
        StringBuilder stringBuilder = new StringBuilder();
        char convertedChar;
        for(int i=0; i<word.length(); i++){
            convertedChar = convert(word.charAt(i));
            stringBuilder.append(convertedChar);
        }
        return stringBuilder.toString();
    }

    public static char convert(char ch){
        if(checkCharType(ch) == TYPE_UPPER_CASE){
            return (char) (ASCII_A_Z_SUM - ch);
        }
        if(checkCharType(ch) == TYPE_LOWER_CASE){
            return (char) (ASCII_a_z_SUM - ch);
        }
        return ch;
    }

    private static int checkCharType(char ch){
        if(Character.isUpperCase(ch)){
            return TYPE_UPPER_CASE;
        }
        if(Character.isLowerCase(ch)){
            return TYPE_LOWER_CASE;
        }
        return TYPE_NONE;
    }

}
