package com.ingenuity.icg.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: pschmidt
 * Date: 10/13/12
 * Time: 7:02 PM
 * <p/>
 * Copyright (C) 2010 Ingenuity Systems, Inc. All rights reserved.
 * <p/>
 * This software is the confidential & proprietary information of Ingenuity Systems, Inc.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of any agreement or agreements you entered into with
 * Ingenuity Systems.
 */
@RequestMapping("/home")
@Controller
public class HomeController {
	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHomePage() {

		log.info("entering home page");

        return new ModelAndView("home", "message", "hello there");
	}

}