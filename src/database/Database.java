package database;

import java.util.List;

public interface Database<T,ID> {

    int create(T object);

    T get(ID id);

    List<T> getAll();

    boolean update(T object);

    boolean delete(ID id);
    boolean deleteAll();

    int size();
}
