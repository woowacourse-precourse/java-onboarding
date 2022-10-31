package onboarding;

public class User {
    private String name;

    public User(String name){
        validName(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    private void validName(String name){
        if (!name.matches("^[a-z]*$"))
            throw new IllegalArgumentException("아이디는 영어 소문자로만 이루어져야 합니다.");

        if(name.length() < 1 || name.length() >30)
            throw new IllegalArgumentException("아이디 길이는 1이상 30이하로 이루어져야 합니다.");
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
    @Override
    public boolean equals(Object o){
        return this.hashCode() == o.hashCode();
    }
}
