package co.grandcircus.Soundtrack_of_my_life;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.grandcircus.Soundtrack_of_my_life.model.geocode.GeocodeResponse;
import co.grandcircus.Soundtrack_of_my_life.model.geocode.Location;
import co.grandcircus.Soundtrack_of_my_life.model.geocode.ReverseGeocodeResponse;

@Component
public class GeocodeApiService {
	
	
	@Value("${geocode.API_KEY}")
	private String API_KEY;
	private RestTemplate restTemplate;
    
    {
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
            return execution.execute(request, body);
        };
        restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
    }
    

    public Location getLocation(String city, String state, String country) {
		Location response;	
		String cityParam = city.replaceAll("\\s+", "");
			String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/geocode/json?")
					.queryParam("address", cityParam + "," + state + "," + country)
					.queryParam("key", API_KEY)
					.toUriString();
			
			if (!(restTemplate.getForObject(url, GeocodeResponse.class).getStatus().equalsIgnoreCase("OK"))) {
				response = null;
			} else {
				response = restTemplate.getForObject(url, GeocodeResponse.class)
					.getResults()[0]
					.getGeometry()
					.getLocation();
			}
			return response;
		
		
	}
    	

    public String getCity(Double latitude, Double longitude) {
    	
    	String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/geocode/json?")
    			.queryParam("latlng", latitude + "," + longitude)
				.queryParam("key", API_KEY)
				.toUriString();
    	
    	String response = restTemplate.getForObject(url, ReverseGeocodeResponse.class)
    			.getResults()[0]
    			.getFormattedAddress();

    	
    	return response;
    	
    }

}
