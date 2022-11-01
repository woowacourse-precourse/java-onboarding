package onboarding;

public class Message_p4 {
    private String message;

    public Message_p4(String message) {
        this.message = message;
    }

    private char encryptChar(char c) {
        if (Character.isUpperCase(c)){
            return (char)(155 - (int) c);
        } else if (Character.isLowerCase(c)) {
            return (char)(219 - (int) c);
        } else{
            return ' ';
        }
    }

    public String encryptMessage() {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            result += encryptChar(message.charAt(i));
        }
        return result;
    }
}
