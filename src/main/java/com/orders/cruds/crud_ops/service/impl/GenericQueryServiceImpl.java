package com.orders.cruds.crud_ops.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.service.GenericQueryService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenericQueryServiceImpl implements GenericQueryService {
    private static final Logger logger = LoggerFactory.getLogger(GenericQueryServiceImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Map<String, String>> executeHqlQuery(String hql, Map<String, Object> parameters) {
        logger.debug("executeHqlQuery START");

        List<Map<String, String>> resultListMap = new ArrayList<>();

        Query query = entityManager.createQuery(hql);

        // Set query parameters if available
        if (parameters != null) {
            parameters.forEach(query::setParameter);
            logger.debug("Parameters set: {}", parameters);
        }

        logger.debug("Executing HQL: {}", hql);

        // Execute the query and fetch results
        List<Object[]> results = query.getResultList();

        // Process the results and populate the map
        for (Object[] row : results) {
            if (row != null && row.length >= 2) {
                String valueKey = (String) row[0];  // Assuming the first column is valueKey
                String valueDisplay = (String) row[1];  // Assuming the second column is valueDisplay

                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("title", valueKey);
                resultMap.put("label", valueDisplay);

                resultListMap.add(resultMap);

                logger.debug("Row: valueKey = {}, valueDisplay = {}", valueKey, valueDisplay);
            }
        }

        logger.debug("executeHqlQuery END");
        return resultListMap;
    }
}