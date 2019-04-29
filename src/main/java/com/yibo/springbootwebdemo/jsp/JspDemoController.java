package com.yibo.springbootwebdemo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 20:49
 * @Description:
 */

@Controller
public class JspDemoController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message","world");
        return "index";
    }
}
