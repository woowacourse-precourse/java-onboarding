package onboarding.problem6;

public class User implements Comparable<User>
{
    private String email;
    private String name;

    public User(String email,String name)
    {
        this.email = email;
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return email.compareTo(o.email);
    }
}