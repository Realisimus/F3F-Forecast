package weather.dbinterfaces;

public interface DataObject<T> {
    public void save(T entity);
    public T get();
}
