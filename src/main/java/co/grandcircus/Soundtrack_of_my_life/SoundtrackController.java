package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Soundtrack_of_my_life.model.weather.weatherResponse;

@Controller
public class SoundtrackController {
	
	@Autowired
	UserRepository JpaRepositry;
	
	@Autowired
	WeatherApiService weatherApi;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/welcome")
	public ModelAndView showWelcome() {
		weatherResponse response = weatherApi.showWeather();
		ModelAndView mv = new ModelAndView("welcome");
		
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", response.getMain().getTemp());
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
		return mv;
		
	}

}
