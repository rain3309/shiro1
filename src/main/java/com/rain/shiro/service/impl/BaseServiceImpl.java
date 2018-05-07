package com.rain.shiro.service.impl;

import com.rain.shiro.dao.BaseDao;
import com.rain.shiro.orm.Limitable;
import com.rain.shiro.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getRepository();

    public List<T> findList(Map<String,String[]> spec, Limitable limitable) {

        return null;
    }

    public Page<T> findList(Map<String,String[]>spec, Pageable pageable){
        return null;
    }

    @Override
    public T get(String id) {
        return null;
    }

    @Override
    public T save(T bean) {
        return null;
    }

    @Override
    public T update(T bean) {
        return null;
    }

    @Override
    public T updateProperty(T fromBean, Set<String> properties) {
        return null;
    }

    @Override
    public T delete(T bean) {
        return null;
    }

    @Override
    public void deleteSome(List<String> ids) {

    }
}
