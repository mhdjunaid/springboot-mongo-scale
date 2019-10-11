package com.jaysdk.adscale.repo;

import org.springframework.data.repository.CrudRepository;

import com.jaysdk.adscale.model.Click;

public interface ClickRepo extends CrudRepository<Click, String> {
    @Override
    void delete(Click deleted);
}