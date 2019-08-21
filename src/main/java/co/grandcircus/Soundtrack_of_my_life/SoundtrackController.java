package co.grandcircus.Soundtrack_of_my_life;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Soundtrack_of_my_life.dao.UserDao;
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
	
	@Autowired
	private UserDao dao;

	@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");

		return mv;
	}

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	@RequestMapping("/welcome")
	public ModelAndView showWelcome(@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude) {
		weatherResponse response = weatherApi.showWeather(latitude, longitude);
		ModelAndView mv = new ModelAndView("welcome");
		double temp = response.getMain().getTemp();
		temp = ((temp - 273.15) * 9 / 5 + 32);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
		mv.addObject(longitude);
		mv.addObject(latitude);
		List<PlaylistItems> playlistList = spotifyApiService.showPlaylists(response.getWeather().get(0).getMain(),
				Type.playlist);
		List<TrackItems> trackList = spotifyApiService.showTracks(response.getWeather().get(0).getMain(), Type.track);
		List<ArtistItems> artistList = spotifyApiService.showArtists(response.getWeather().get(0).getMain(),
				Type.artist);
		List<AlbumtItems> albumList = spotifyApiService.showAlbums(response.getWeather().get(0).getMain(), Type.album);
		mv.addObject("playlist", playlistList);
		mv.addObject("track", trackList);
		mv.addObject("artist", artistList);
		mv.addObject("album", albumList);

		return mv;
	}

	@PostMapping("/welcome")
	public ModelAndView moodWelcome(@RequestParam("mood") String mood,
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude) {
		ModelAndView mv = new ModelAndView("welcome");
		weatherResponse response = weatherApi.showWeather(latitude, longitude);
		double temp = response.getMain().getTemp();
		temp = ((temp - 273.15) * 9 / 5 + 32);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
		mv.addObject("mood", mood);
		String newMood = mood.replaceAll("\\s+", "+");
		List<PlaylistItems> playlistList = spotifyApiService.showPlaylists(newMood,Type.playlist);
		List<TrackItems> trackList = spotifyApiService.showTracks(newMood, Type.track);
		List<ArtistItems> artistList = spotifyApiService.showArtists(newMood,Type.artist);
		List<AlbumtItems> albumList = spotifyApiService.showAlbums(newMood, Type.album);
		mv.addObject("playlist", playlistList);
		mv.addObject("track", trackList);
		mv.addObject("artist", artistList);
		mv.addObject("album", albumList);
		
		return mv;
	}

	@RequestMapping("/testwelcome")
	public ModelAndView testWelcome() {

		return new ModelAndView("testwelcome");
	}
	
	@RequestMapping("/preferences")
	public ModelAndView displayPreferences(@RequestParam(value="genres", required=false) String[] genres) {

		String imploded=StringUtils.join(genres);
		System.out.println(imploded);
		dao.update((long) 1, imploded);
		System.out.println(dao.getGenrePreferences((long) 1));
		//User test = JpaRepository.findByUsernameAndPassword("tester", "test");
		//test.setGenrePreferences(genres);
		ModelAndView mav = new ModelAndView("preferences");
		mav.addObject( "imploded", imploded);
		return mav;
	}

}
