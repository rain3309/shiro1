package com.rain.shiro.dao;

import com.rain.shiro.orm.Limitable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BaseDao<T> extends Repository<T ,String> {

    public List<T> findAll(Specification<T> spec, Limitable limit);

    public Page<T> findAll(Specification<T> spec, Pageable page);

    public T findOne(String id);

    public T save(T bean);

    public void delete(T bean);

}
