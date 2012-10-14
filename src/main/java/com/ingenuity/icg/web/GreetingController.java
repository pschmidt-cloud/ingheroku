package com.ingenuity.icg.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequestMapping("/home")
public class GreetingController {

	protected static Logger logger = Logger.getLogger("GreetingController");

	//define the same url with GET so users can skip to the greetings page
        //note there is no actual greetings.html file!!
	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String showAllGreetings(@RequestParam(value="greetingText", required=true) String greetingText,
			Map<String, Object> model) {

		logger.info("entering showAllGreetings");

		model.put("greetingText", greetingText);

	        // This will resolve to /WEB-INF/jsp/greetings.jsp
	        return "greetings";
	}

	@RequestMapping(value = "/addgreeting.html", method = RequestMethod.GET)
        public String showAddGreetingPage() {

		logger.info("entering showAddGreetingPage");

    	        // This will resolve to /WEB-INF/jsp/addgreeting.jsp
    	        return "addgreeting";
	}

}