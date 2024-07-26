package com.orders.cruds.crud_ops.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.service.GenericQueryService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Map;

@Service
public class GenericQueryServiceImpl implements GenericQueryService{
	private static final Logger logger = LoggerFactory.getLogger(GenericQueryService.class);

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<?> executeHqlQuery(String hql, Map<String, Object> parameters) {
    	logger.debug("executeHqlQuery START :: ");
        Query query = entityManager.createQuery(hql);
        if(null!=parameters) {
        parameters.forEach(query::setParameter);
        }
        logger.debug("FINAL GENERIC HQL IS :: "+hql +" :=: PARAMETERS=> ");
        return query.getResultList();
    }
}