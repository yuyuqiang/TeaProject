package me.zhangyu.service.base;

public interface IBaseService<T> {
    public T findById(int id);
    public T findByUsername(String username);
    public T findByUUId(String uuid);


    public void deleteById(Integer id);
    public void deleteByUUId(String uuid);

    public void update(T t);

    public void insert(T t);
}
