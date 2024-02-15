package github.com.rosivaldolucas.uolhostchallenge.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public ModelAndView home(){
    final ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("Index");

    return modelAndView;
  }

}
