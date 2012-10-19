package com.ingenuity.icg.search;

import com.ingenuity.icg.domain.SearchItem;
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
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

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
@Component("elasticSearchClient")
public class ElasticSearchClient {
    protected final Log log = LogFactory.getLog(getClass());

    @Value("${elastic_server_url}")
    private String elasticServerUrl;

    @Value("${elastic_server_index}")
    private String elasticServerIndex;

    @Value("${elastic_type}")
    private String elasticType;

    @Autowired
    DatasetParserHelper datasetParserHelper;

    private void configure() {

    }

    public JestResult update(SearchDocument entity) {
        JestResult jr = null;

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

            Index index = new Index.Builder(entity).index(elasticServerIndex).type(elasticType).build();
            jr = client.execute(index);
            log.info(jr.getJsonString());
        } catch (Exception ex) {
            log.warn(ex);
        }

        return jr;
    }

    public JestResult search(SearchItem searchItem) {
        JestResult jr = null;

        try {
            ClientConfig clientConfig = new ClientConfig();
            LinkedHashSet<String> servers = new LinkedHashSet<String>();
            servers.add(elasticServerUrl);
            clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST, servers);

            JestClientFactory factory = new JestClientFactory();
            factory.setClientConfig(clientConfig);
            JestClient client = factory.getObject();

            QueryBuilder queryBuilder = QueryBuilders.queryString(searchItem.getSearchTerm());

            Search search = new Search(queryBuilder);
            search.addIndex(elasticServerIndex);
            search.addType(elasticType);

            jr = client.execute(search);
        } catch (Exception ex) {
            log.warn(ex);
        }

        return jr;
    }
}
