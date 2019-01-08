package com.mtrhz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Solrsky
 * @date 2019/1/8
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
}
