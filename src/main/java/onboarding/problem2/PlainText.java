package onboarding.problem2;

public class PlainText {
    public static String decodeCipherText(String ciphertext) {
        String pattern = "a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|j{2,}|k{2,}|l{2,}|n{2,}|m{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}";
        String answer ="";
        boolean flag = true;
        do {
            answer = ciphertext.replaceAll(pattern, "");
            if(answer.length() == ciphertext.length()){
                flag = false;
            }
            ciphertext = answer;
        }while(flag);
        return answer;
    }
}
