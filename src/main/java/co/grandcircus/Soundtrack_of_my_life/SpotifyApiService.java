package co.grandcircus.Soundtrack_of_my_life;

import java.util.Base64;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.grandcircus.Soundtrack_of_my_life.model.spotify.Playlist;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.Playlists;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.SpotifyResponse;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.TokenResponse;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.Type;

@Component
public class SpotifyApiService {
	
	private final String API_KEY = "d6a515f31243414b8a32f69ef1bcbac4";
	private final String CLIENT_ID = "d6a515f31243414b8a32f69ef1bcbac4";
	private final String CLIENT_SECRET = "bd9a2b1361d3406b885221c61764ff66";
	
	private RestTemplate restTemplate;
    
    {
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
            return execution.execute(request, body);
        };
        restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
    }
    
    
    public String getAccessToken() {
//String url = "https://api.spotify.com/v1/search?q=" + q + "&type=" + type;
    	
    	String url = "https://accounts.spotify.com/api/token";
    	//System.out.println(url);
    	
    	// request body
    	MultiValueMap<String, String> body= new LinkedMultiValueMap<String, String>();
    	body.add("grant_type", "client_credentials");
    	
    	// headers
    	HttpHeaders headers = new HttpHeaders();
    	String unencoded = CLIENT_ID + ":" + CLIENT_SECRET; 
    	String encoded = Base64.getEncoder().encodeToString(unencoded.getBytes());
    	System.out.println(encoded);
		headers.add("Authorization", "Basic " + encoded);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		System.out.println(headers);
		
    	
    	
		TokenResponse response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, headers), 
				TokenResponse.class).getBody();
    	
		
		String accessToken = response.getAccess_token(); 
		System.out.println(accessToken);
		
		
		return accessToken;
    }
    
    public List<Playlist> showPlaylists(String q, Type type) {
    	String accessToken = getAccessToken();
    	
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
				.queryParam("q", q)
				.queryParam("type", type)
				.toUriString();
    	
    	System.out.println(url);
    	
    	String bearerString = "Bearer " + accessToken;
    	
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		System.out.println(headers);
		
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
    													SpotifyResponse.class).getBody();
		List<Playlist> myList = response.getPlaylists().getPlaylistItems();
    	return myList;  	
    }

    
//    public List<Playlists> showPlaylists__old(String q, Type type) {
//    	//String url = "https://api.spotify.com/v1/search?q=" + q + "&type=" + type;
//    	
//    	String url = UriComponentsBuilder.fromHttpUrl("https://accounts.spotify.com/authorize")
//				//.queryParam("q", q)
//				.queryParam("client_id", API_KEY)
//				.queryParam("response_type", "code")
//				.queryParam("redirect_uri", "localhost:8080/")
//				.toUriString();
//    	
//    	System.out.println(url);
//    	
//    	HttpHeaders headers = new HttpHeaders();
//		headers.add("X-Api-Key", API_KEY);
//		
//		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
//    													SpotifyResponse.class).getBody();
//    	List<Playlists> myList = response.getPlaylistList();
//    	return myList;
//    }
}
