package onboarding;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private boolean isRemovable()
    {
        boolean flag = false;
        char[] array = message.toCharArray();
        for ( int i = 0; i < array.length - 1; i++ ){
            if ( array[i] == array[i+1]) {
                flag = true;
                array[i] = ' ';
                array[i+1] = ' ';
            }
        }
        this.message = String.valueOf(array).replaceAll(" ", "");
        return flag;
    }

    public String removeDuplicates() {
        while ( isRemovable() == true ){

        }
        return message;
    }

}
