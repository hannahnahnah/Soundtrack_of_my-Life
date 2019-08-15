package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SoundtrackController {
	
	@Autowired
	UserRepository JpaRepositry;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}

}
