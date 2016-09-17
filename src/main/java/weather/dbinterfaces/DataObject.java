package weather.dbinterfaces;

public interface DataObject<T> {
    void save(T entity);
    T get();
}
