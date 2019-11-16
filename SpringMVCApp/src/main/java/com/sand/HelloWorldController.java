package com.sand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{
  @RequestMapping("/showForm")
  public String showForm()
  {
    return "hello-world-form";
  }

  @RequestMapping("/processFormVersionTwo")
  public String processFormVersionTwo()
  {
    return "hello-world";
  }

  @RequestMapping("/processFormAdvance")
  public String shout(HttpServletRequest request, Model model)
  {
    String studentName = request.getParameter("studentName");
    String result = "V2: YO! " + studentName.toUpperCase();
    model.addAttribute("message", result);

    return "hello-world";
  }

  @RequestMapping("/processFormVersionThree")
  public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model)
  {
    String result = "V3: YO! " + studentName.toUpperCase();
    model.addAttribute("message", result);

    return "hello-world";
  }
}
