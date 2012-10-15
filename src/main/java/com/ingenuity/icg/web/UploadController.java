package com.ingenuity.icg.web;

import com.ingenuity.icg.domain.Article;
import com.ingenuity.icg.domain.UploadItem;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.ClientConstants;
import io.searchbox.core.Index;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm(Model model) {
        model.addAttribute(new UploadItem());
        return "upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(UploadItem uploadItem, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error: " + error.getCode() + " - " + error.getDefaultMessage());
            }
            return "upload";
        }

        try {
            // Configuration
            ClientConfig clientConfig = new ClientConfig();
            LinkedHashSet<String> servers = new LinkedHashSet<String>();
            servers.add("http://api.searchbox.io/api-key/1a8c433f2e2f0af26151571ef530284e");
            clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST, servers);

            // Construct a new Jest client according to configuration via factory
            JestClientFactory factory = new JestClientFactory();
            factory.setClientConfig(clientConfig);
            JestClient client = factory.getObject();

            Article source = new Article();
            source.setAuthor("Alexander Dumas");
            source.setContent("The Three Muskateers part 2");

            Index index = new Index.Builder(source).index("index1").type("article").build();
            client.execute(index);
        } catch (Exception ex) {
            log.warn(ex);
        }

        return "redirect:/home";
    }
}
