package co.grandcircus.Soundtrack_of_my_life;

import java.text.DecimalFormat;

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
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	@RequestMapping("/welcome")
	public ModelAndView showWelcome() {
		weatherResponse response = weatherApi.showWeather();
		ModelAndView mv = new ModelAndView("welcome");
		double temp = response.getMain().getTemp();
		temp = ((temp - 273.15) * 9/5 + 32);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
		return mv;
		
	}

}
