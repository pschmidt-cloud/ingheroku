package com.ingenuity.icg.web;

import com.ingenuity.icg.domain.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: pschmidt
 * Date: 10/11/12
 * Time: 11:49 PM
 * <p/>
 * Copyright (C) 2010 Ingenuity Systems, Inc. All rights reserved.
 * <p/>
 * This software is the confidential & proprietary information of Ingenuity Systems, Inc.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of any agreement or agreements you entered into with
 * Ingenuity Systems.
 */
@RequestMapping("/ws/rest/v1")
@Controller
public class CategoryContoller {
     private  final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/category/{catId}", method = RequestMethod.GET)
       @ResponseBody
       public Category read(@PathVariable(value = "catId") String catId) {
           log.info("Reading coupon with id {}" +  catId);
           Category category = new Category();
           category.setName("Fake1");

           //Validate.isTrue(category != null, "Unable to find category with id: " + catId);
           return category;
       }

}
