package optional.jdbc;

public interface AbstractFactory<T> {
    void create(T entity);
}
