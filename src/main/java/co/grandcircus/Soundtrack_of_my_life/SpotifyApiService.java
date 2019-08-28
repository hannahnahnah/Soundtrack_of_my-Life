package co.grandcircus.Soundtrack_of_my_life;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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

import co.grandcircus.Soundtrack_of_my_life.model.spotify.AlbumtItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.ArtistItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.PlaylistItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.SpotifyResponse;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.TokenResponse;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.TrackItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.Type;

@Component
public class SpotifyApiService {
	
	
	private final String CLIENT_ID = "d6a515f31243414b8a32f69ef1bcbac4";
	@Value("${spotify.CLIENT_SECRET}")
	private String CLIENT_SECRET;
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
    	//System.out.println(encoded);
		headers.add("Authorization", "Basic " + encoded);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//System.out.println(headers);
		
    	
    	
		TokenResponse response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, headers), 
				TokenResponse.class).getBody();
    	
		
		String accessToken = response.getAccess_token(); 
		//System.out.println(accessToken);
		
		
		return accessToken;
    }
    
    
    
    public List<TrackItems> showTracks2(String q, Type type, String q2){
    	String accessToken = getAccessToken();
    	String limit = "5";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<TrackItems> myTrack = response.getTrack().getItems();
		
		String url2 = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q2)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
		SpotifyResponse response2 = restTemplate.exchange(url2, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		myTrack.addAll(response2.getTrack().getItems());
		return myTrack;
    	
    }
    public List<PlaylistItems> showPlaylists2(String q, Type type, String q2) {
    	String accessToken = getAccessToken();
    	String limit = "5";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
				.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	
    	System.out.println("playlists 2 service: " + url);
    	
    	String bearerString = "Bearer " + accessToken;
    	System.out.println(bearerString);
    	
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		//System.out.println(headers);
		
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
    													SpotifyResponse.class).getBody();
		List<PlaylistItems> myList = response.getPlaylist().getItems();
		
		String url2 = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q2)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
		SpotifyResponse response2 = restTemplate.exchange(url2, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		myList.addAll(response2.getPlaylist().getItems());
    	return myList;  	
    }
    public List<ArtistItems> showArtists2(String q, Type type, String q2){
    	String accessToken = getAccessToken();
    	String limit = "5";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<ArtistItems> myArtist = response.getArtist().getItems();
		
		String url2 = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q2)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
		SpotifyResponse response2 = restTemplate.exchange(url2, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		myArtist.addAll(response2.getArtist().getItems());
		return myArtist;
   }
    public List<AlbumtItems> showAlbums2(String q, Type type, String q2){
    	String accessToken = getAccessToken();
    	String limit = "5";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<AlbumtItems> myAlbum = response.getAlbum().getItems();
		
		String url2 = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q2)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
		SpotifyResponse response2 = restTemplate.exchange(url2, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		myAlbum.addAll(response2.getAlbum().getItems());
		return myAlbum;
     }
    
    public List<TrackItems> showTracks(String q, Type type){
    	String accessToken = getAccessToken();
    	String limit = "10";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<TrackItems> myTrack = response.getTrack().getItems();
		return myTrack;
    	
    }
    
    public List<PlaylistItems> showPlaylists(String q, Type type) {
    	System.out.println("in playlist api service");
    	String accessToken = getAccessToken();
    	String limit = "10";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
				.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	
    	System.out.println("@@query url: " + url);
    	
    	String bearerString = "Bearer " + accessToken;
    	System.out.println("Bearer " + accessToken);
    	
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		//System.out.println(headers);
		
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
    													SpotifyResponse.class).getBody();
		List<PlaylistItems> myList = response.getPlaylist().getItems();
		System.out.println("@@myList: " + myList.size());
		
    	return myList;  	
    }
    
    public List<ArtistItems> showArtists(String q, Type type){
    	String accessToken = getAccessToken();
    	String limit = "10";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<ArtistItems> myArtist = response.getArtist().getItems();
		return myArtist;
   }
    
    public List<AlbumtItems> showAlbums(String q, Type type){
    	String accessToken = getAccessToken();
    	String limit = "10";
    	String url = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/search")
    			.queryParam("q", q)
				.queryParam("type", type)
				.queryParam("limit", limit)
				.toUriString();
    	String bearerString = "Bearer " + accessToken;
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", bearerString);
		SpotifyResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), 
				SpotifyResponse.class).getBody();
		List<AlbumtItems> myAlbum = response.getAlbum().getItems();
		return myAlbum;
     }
    
  

}//apiService class

