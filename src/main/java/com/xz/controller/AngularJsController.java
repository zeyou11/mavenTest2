package com.xz.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ag")
public class AngularJsController {
    private static Logger logger = Logger.getLogger(AngularJsController.class);

    @RequestMapping("/testJson")
    @ResponseBody
    public Map<String, String> testJson() {
        // 记录日志
        logger.info("This is info message.");
        logger.error("This is error message.");
        String jsonStr = "[{\"name\":\"zhangsan\",\"age\":\"12\"},{\"name\":\"lisi\",\"age\":\"11\"}]";
        System.out.println(jsonStr);
        Map<String, String> map = new HashMap<String, String>();
        map.put("jsonStr", jsonStr);
        return map;
    }
}
