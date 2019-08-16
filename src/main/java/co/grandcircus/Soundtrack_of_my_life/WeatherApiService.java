package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.Soundtrack_of_my_life.model.weather.weatherResponse;

public class WeatherApiService {
	private RestTemplate restTemplate = new RestTemplate();
	{
		// This configures the restTemplateWithUserAgent to include a User-Agent header
		// with every HTTP
		// request. Some of the APIs in this demo have a bug where User-Agent is
		// required.
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
			return execution.execute(request, body);
		};
		restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public weatherResponse showWeather() {
		String url = "api.openweathermap.org/data/2.5/weather?q=Detroit";
		
		weatherResponse response = restTemplate.getForObject(url, weatherResponse.class);
		
		return response;
	}
}
