package onboarding;

import java.lang.reflect.Field;
import java.util.*;

public class UserRepository implements SnsRepository {
    private static final SnsRepository repo=new UserRepository(new HashMap<>());
    protected Map<Integer, Domain> dataBase;

    public UserRepository(Map<Integer, Domain> dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Domain save(Domain domain) {
        setId(domain);
        dataBase.put(domain.getId(),domain);
        return domain;
    }

    @Override
    public Optional<Domain> findById(int id) {
        try {
            return Optional.of(dataBase.get(id));
        }catch (NullPointerException e){
            return Optional.empty();
        }
    }

    @Override
    public Domain update(Domain domain) {
        Domain dataUser = dataBase.put(domain.getId(),domain);
        return dataUser;
    }

    @Override
    public List<Domain> findAll() {
        return new ArrayList<>(dataBase.values());
    }

    @Override
    public int lastIdNumber() {
        return dataBase.size();
    }

    @Override
    public void removeAll() {
        dataBase.clear();
    }

    private void setId(Domain domain)  {
        try {
            Class<? extends Domain> userClass = domain.getClass();
            Class<?> superclass = userClass.getSuperclass();
            Field id = superclass.getDeclaredField("id");
            id.setAccessible(true);
            id.set(domain,dataBase.size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static SnsRepository of(){
        return repo;
    }
}
