package co.grandcircus.Soundtrack_of_my_life;


import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Soundtrack_of_my_life.model.spotify.AlbumtItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.ArtistItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.PlaylistItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.TrackItems;
import co.grandcircus.Soundtrack_of_my_life.model.spotify.Type;
import co.grandcircus.Soundtrack_of_my_life.model.weather.weatherResponse;


@Controller
public class SoundtrackController {
	
	@Autowired
	UserRepository JpaRepository;
	
	@Autowired
	WeatherApiService weatherApi;

	@Autowired 
	private SpotifyApiService spotifyApiService;
	

	
	@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		List<PlaylistItems> playlistList = spotifyApiService.showPlaylists("sunny", Type.playlist);
		List<TrackItems> trackList = spotifyApiService.showTracks("sunny", Type.track);
		List<ArtistItems> artistList = spotifyApiService.showArtists("sunny", Type.artist);
		List<AlbumtItems> albumList = spotifyApiService.showAlbums("sunny", Type.album);
		mv.addObject("playlist", playlistList);
		mv.addObject("track", trackList);
		mv.addObject("artist", artistList);
		mv.addObject("album", albumList);
		return mv;
		//return new ModelAndView("home", "playlist", spotifyApiService.showPlaylists("sunny", Type.playlist));
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
