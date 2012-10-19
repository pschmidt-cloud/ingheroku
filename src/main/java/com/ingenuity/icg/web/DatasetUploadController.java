package com.ingenuity.icg.web;

import com.ingenuity.icg.domain.DatasetDocument;
import com.ingenuity.icg.domain.UploadItem;
import com.ingenuity.icg.search.ElasticSearchClient;
import com.ingenuity.icg.util.DatasetParserHelper;
import io.searchbox.client.JestResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
@Controller("datasetUploadController")
@RequestMapping(value = "/dataset_upload")
public class DatasetUploadController {
    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    DatasetParserHelper datasetParserHelper;

    @Autowired
    ElasticSearchClient elasticSearchClient;

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm(Model model) {
        model.addAttribute(new UploadItem());
        return "dataset_upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(UploadItem uploadItem, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error: " + error.getCode() + " - " + error.getDefaultMessage());
            }
            return new ModelAndView("upload", "status", "errors in upload");
        }

        try {
            String str = new String(uploadItem.getFileData().getBytes());
            Map<String, String> keywordMap = datasetParserHelper.convertStringToMap(str);

            DatasetDocument dataset = new DatasetDocument();
            dataset.setFileName(uploadItem.getFileData().getOriginalFilename());
            dataset.setDescription(uploadItem.getDesc());
            dataset.setKeywords(keywordMap);

            JestResult jr = elasticSearchClient.update(dataset);
            log.info(jr.getJsonString());
        } catch (Exception ex) {
            log.warn(ex);
        }

        return new ModelAndView("dataset_upload", "status", "STATUS: successful upload of " + uploadItem.getFileData().getOriginalFilename());
    }
}
