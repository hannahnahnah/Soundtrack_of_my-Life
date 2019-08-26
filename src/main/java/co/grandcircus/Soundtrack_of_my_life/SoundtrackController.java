package co.grandcircus.Soundtrack_of_my_life;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Soundtrack_of_my_life.dao.UserDao;
import co.grandcircus.Soundtrack_of_my_life.entity.Coordinates;
import co.grandcircus.Soundtrack_of_my_life.entity.User;
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

	@PostMapping("/")
	public ModelAndView showPostHome(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam(value="mood", required=false) String mood,
			@SessionAttribute(name="coords") Coordinates coords) {
		User user = dao.findById((long) 1); 
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setMoodPreferences(mood);
		
		dao.updateUser(user);
		ModelAndView mv = new ModelAndView("redirect:/welcome");
		return mv;
	}
	
	
	
	@RequestMapping("/session/set")
		public ModelAndView setSession(@RequestParam("latitude") String lat,
				@RequestParam("longitude") String lon,
				Coordinates coords, HttpSession session) {
		coords.setLatitude(lat);
		coords.setLongitude(lon);
		session.setAttribute("coords", coords);
		return new ModelAndView("redirect:/welcome");
	}
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	@RequestMapping("/welcome")
	public ModelAndView showWelcome(@SessionAttribute(name="coords") Coordinates coords) {
		ModelAndView mv = new ModelAndView("welcome");
		
		User user = dao.findById((long) 1);
		mv.addObject("user", user);
		mv.addObject("defaultMood", user.getMoodPreferences());
		
		weatherResponse response = weatherApi.showWeather(coords.getLatitude(), coords.getLongitude());
		double temp = response.getMain().getTemp();
		//converting Kelvin to Fahrenheit
		temp = ((temp - 273.15) * 9 / 5 + 32);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
//		mv.addObject("lon", longitude);
//		mv.addObject("lat", latitude);
		
		
		int hour = LocalDateTime.now().getHour();
		if (hour >= 5 && hour < 12) {
			String morning = "Good Morning";
			mv.addObject("hour", morning);
		} else if (hour >= 12 && hour < 17) {
			String afternoon = "Good Afternoon";
			mv.addObject("hour", afternoon);	
		} else if (hour >= 17 && hour < 21) {
			String evening = "Good Evening";
			mv.addObject("hour", evening);
		} else {
			String night = "Good Night";
			mv.addObject("hour", night);	
		}
		
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

	@PostMapping("/favorite")
	public ModelAndView addFavorites(@RequestParam("favorite") String id) {
		ModelAndView mv = new ModelAndView("redirect:/welcome");
				
		return mv;
	}
	
	@PostMapping("/welcome")
	public ModelAndView moodWelcome(@RequestParam("mood") String mood,
			@SessionAttribute(name="coords") Coordinates coords) {
		
		ModelAndView mv = new ModelAndView("welcome");
		User user = dao.findById((long) 1);
		mv.addObject("user", user);
		
		weatherResponse response = weatherApi.showWeather(coords.getLatitude(), coords.getLongitude());
		double temp = response.getMain().getTemp();
		temp = ((temp - 273.15) * 9 / 5 + 32);
//		mv.addObject("lon", longitude);
//		mv.addObject("lat", latitude);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());
		mv.addObject("mood", mood); //passed in as request parameter from the post mapped form
		
		int hour = LocalDateTime.now().getHour();
		if (hour >= 5 && hour < 12) {
			String morning = "Good Morning";
			mv.addObject("hour", morning);
		} else if (hour >= 12 && hour < 17) {
			String afternoon = "Good Afternoon";
			mv.addObject("hour", afternoon);	
		} else if (hour >= 17 && hour < 21) {
			String evening = "Good Evening";
			mv.addObject("hour", evening);
		} else {
			String night = "Good Night";
			mv.addObject("hour", night);	
		}
		

		if(mood.length() > 0) {
			mv.addObject("defaultMood", mood);
		} else {
			mv.addObject("defaultMood", user.getMoodPreferences());
		}
		
		if(mood.length() > 0) {
			mood = mood.replaceAll("\\s+", "+");
		} else {
			mood = user.getMoodPreferences();
			mood = mood.replaceAll("\\s+", "+");
		}
		
		List<PlaylistItems> playlistList = spotifyApiService.showPlaylists(mood, Type.playlist);
		List<TrackItems> trackList = spotifyApiService.showTracks(mood, Type.track);
		List<ArtistItems> artistList = spotifyApiService.showArtists(mood,Type.artist);
		List<AlbumtItems> albumList = spotifyApiService.showAlbums(mood, Type.album);
		mv.addObject("playlist", playlistList);
		mv.addObject("track", trackList);
		mv.addObject("artist", artistList);
		mv.addObject("album", albumList);
		return mv;
	}

	
	@RequestMapping("/preferences")
	public ModelAndView displayPreferences() {
		User user = dao.findById((long) 1);
		ModelAndView mv = new ModelAndView("preferences");
		mv.addObject("user", user);
		mv.addObject("mood", user.getMoodPreferences());
		
		int hour = LocalDateTime.now().getHour();
		if (hour >= 5 && hour < 12) {
			String morning = "Good Morning";
			mv.addObject("hour", morning);
		} else if (hour >= 12 && hour < 17) {
			String afternoon = "Good Afternoon";
			mv.addObject("hour", afternoon);	
		} else if (hour >= 17 && hour < 21) {
			String evening = "Good Evening";
			mv.addObject("hour", evening);
		} else {
			String night = "Good Night";
			mv.addObject("hour", night);	
		}
		
		return mv;
	}

}
