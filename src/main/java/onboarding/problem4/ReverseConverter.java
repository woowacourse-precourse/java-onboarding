package onboarding.problem4;

public class ReverseConverter {

    public static final int TYPE_NONE = 0;
    public static final int TYPE_UPPER_CASE = 1;
    public static final int TYPE_LOWER_CASE = 2;



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
