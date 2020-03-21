package me.zhangyu.mapper.base;


public interface BaseMapper<T> {

    public T findById(int id);
    public T findByUsername(String username);
   // public T findByAdminname(String adminname);

    public T findByUUId(String uuid);


    public void deleteById(Integer id);
    public void deleteByUUId(String uuid);

    public void update(T t);

    public void insert(T t);
}
