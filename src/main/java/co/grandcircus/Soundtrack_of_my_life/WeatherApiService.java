package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.Soundtrack_of_my_life.model.weather.weatherResponse;

@Component
public class WeatherApiService {
	
	private String API_KEY = "992458133bfe1abd9baa37448990f219";
	
	private RestTemplate restTemplate = new RestTemplate();
//	{
//		// This configures the restTemplateWithUserAgent to include a User-Agent header
//		// with every HTTP
//		// request. Some of the APIs in this demo have a bug where User-Agent is
//		// required.
//		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
//			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
//			return execution.execute(request, body);
//		};
//		restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
//	}
	
	public weatherResponse showWeather() {
		String url = "https://api.openweathermap.org/data/2.5/weather?q=Detroit,us&appid=" + API_KEY;
		
		weatherResponse response = restTemplate.getForObject(url, weatherResponse.class);
		return response;
	}
}
