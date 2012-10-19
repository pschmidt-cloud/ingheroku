package com.ingenuity.ingheroku.app.ui.controller;

import com.ingenuity.ingheroku.app.ui.model.SearchItem;
import com.ingenuity.ingheroku.app.ui.util.DatasetParserHelper;
import com.ingenuity.ingheroku.search.component.ElasticSearchClient;
import io.searchbox.client.JestResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pschmidt
 * Date: 10/14/12
 * Time: 6:11 PM
 * <p/>
 * Copyright (C) 2010 Ingenuity Systems, Inc. All rights reserved.
 * <p/>
 * This software is the confidential & proprietary information of Ingenuity Systems, Inc.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of any agreement or agreements you entered into with
 * Ingenuity Systems.
 */
@Controller("datasatSearchController")
@RequestMapping(value = "/dataset_search")
public class DatasetSearchController {
    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    DatasetParserHelper datasetParserHelper;

    @Autowired
    ElasticSearchClient elasticSearchClient;

    @RequestMapping(method = RequestMethod.GET)
    public String getSearchForm(Model model) {
        model.addAttribute(new SearchItem());
        return "dataset_search";
    }

    @RequestMapping(value="/doSearch", method = RequestMethod.POST)
    public @ResponseBody Map search(@ModelAttribute(value="searchItem") SearchItem searchItem, BindingResult result) {
        Map dataMap = new HashMap();

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error: " + error.getCode() + " - " + error.getDefaultMessage());
            }
        }

        try {
            JestResult jr = elasticSearchClient.search(searchItem) ;
            log.info(jr.getJsonString());

            dataMap.put("results", jr.getJsonString());
            dataMap.put("status",  "SUCCESS");

        } catch (Exception ex) {
            log.warn(ex);
        }

        return dataMap;
    }
}
