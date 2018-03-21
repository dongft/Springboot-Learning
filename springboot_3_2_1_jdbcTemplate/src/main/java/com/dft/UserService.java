package com.dft;

public interface UserService {

    /**
     * 获取用户总量
     */
    Integer getAll();

    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据名字删除用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 删除所有用户
     */
    void deleteAll();
}
