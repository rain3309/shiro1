package com.rain.shiro.service;

import com.rain.shiro.orm.Limitable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface  BaseService<T>{

    public List<T> findList(Map<String,String[]> spec, Limitable limit);

    public Page<T> findList(Map<String,String[]> spec, Pageable pageable);

    public T get(String id);

    public T save(T bean);

    public T update(T bean);

    public T updateProperty(T fromBean, Set<String> properties);

    public T delete(T bean);

    public void deleteSome(List<String> ids);
}
