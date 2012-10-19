package com.ingenuity.icg.web;

import com.ingenuity.icg.domain.Dataset;
import com.ingenuity.icg.domain.SearchItem;
import com.ingenuity.icg.domain.UploadItem;
import com.ingenuity.icg.util.DatasetParserHelper;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.ClientConstants;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashSet;
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

    @Value("${elastic_server_url}")
    private String elasticServerUrl;

    @Value("${elastic_server_index}")
    private String elasticServerIndex;

    @Value("${elastic_type}")
    private String elasticType;

    @Autowired
    DatasetParserHelper datasetParserHelper;

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
            // Configuration
            ClientConfig clientConfig = new ClientConfig();
            LinkedHashSet<String> servers = new LinkedHashSet<String>();
            servers.add(elasticServerUrl);
            clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST, servers);

            // Construct a new Jest client according to configuration via factory
            JestClientFactory factory = new JestClientFactory();
            factory.setClientConfig(clientConfig);
            JestClient client = factory.getObject();

            QueryBuilder queryBuilder = QueryBuilders.queryString(searchItem.getSearchTerm());

            //Search search = new Search(searchItem.getSearchTerm());
            Search search = new Search(queryBuilder);
            search.addIndex(elasticServerIndex);
            search.addType(elasticType);

            JestResult jr = client.execute(search);
            log.info(jr.getJsonString());

            dataMap.put("results", jr.getJsonString());
            dataMap.put("status",  "SUCCESS");

        } catch (Exception ex) {
            log.warn(ex);
        }

        return dataMap;
    }
}
