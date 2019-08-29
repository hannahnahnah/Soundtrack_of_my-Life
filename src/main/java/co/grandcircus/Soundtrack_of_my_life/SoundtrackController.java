package co.grandcircus.Soundtrack_of_my_life;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Soundtrack_of_my_life.dao.FavoritesDao;
import co.grandcircus.Soundtrack_of_my_life.dao.UserDao;
import co.grandcircus.Soundtrack_of_my_life.entity.AlbumFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.ArtistFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.Coordinates;
import co.grandcircus.Soundtrack_of_my_life.entity.PlaylistFavorites;
import co.grandcircus.Soundtrack_of_my_life.entity.Search;
import co.grandcircus.Soundtrack_of_my_life.entity.TrackFavorites;
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
	private GeocodeApiService geocodeApiService;
	@Autowired
	private UserDao dao;
	@Autowired
	private FavoritesDao favDao;

	@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@PostMapping("/")
	public ModelAndView showPostHome(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam(value = "mood", required = false) String mood,
			@RequestParam(value = "feelingThunderstorm", required = false) String thunderstorm,
			@RequestParam(value = "feelingDrizzle", required = false) String drizzle,
			@RequestParam(value = "feelingRain", required = false) String rain,
			@RequestParam(value = "feelingSnow", required = false) String snow,
			@RequestParam(value = "feelingMist", required = false) String mist,
			@RequestParam(value = "feelingSmoke", required = false) String smoke,
			@RequestParam(value = "feelingHaze", required = false) String haze,
			@RequestParam(value = "feelingFog", required = false) String fog,
			@RequestParam(value = "feelingSand", required = false) String sand,
			@RequestParam(value = "feelingDust", required = false) String dust,
			@RequestParam(value = "feelingAsh", required = false) String ash,
			@RequestParam(value = "feelingSquall", required = false) String squall,
			@RequestParam(value = "feelingTornado", required = false) String tornado,
			@RequestParam(value = "feelingClear", required = false) String clear,
			@RequestParam(value = "feelingClouds", required = false) String clouds,
			@SessionAttribute(name = "coords") Coordinates coords) {

		User user = dao.findById((long) 1);

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setMoodPreferences(mood);

		user.setThunderstorm(thunderstorm);
		user.setDrizzle(drizzle);
		user.setRain(rain);
		user.setSnow(snow);
		user.setMist(mist);
		user.setSmoke(smoke);
		user.setHaze(haze);
		user.setFog(fog);
		user.setSand(sand);
		user.setDust(dust);
		user.setAsh(ash);
		user.setSquall(squall);
		user.setTornado(tornado);
		user.setClear(clear);
		user.setClouds(clouds);

		dao.updateUser(user);
		ModelAndView mv = new ModelAndView("redirect:/welcome");
		return mv;
	}

	@RequestMapping("/session/set")
	public ModelAndView setSession(@RequestParam("latitude") String lat, @RequestParam("longitude") String lon,
			Coordinates coords, HttpSession session) {
		coords.setLatitude(lat);
		coords.setLongitude(lon);
		session.setAttribute("coords", coords);
		return new ModelAndView("redirect:/welcome");
	}

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	private String getWeatherFeeling(weatherResponse weatherResponse) {
		User user = dao.findById((long) 1);
		
		String weatherString = weatherResponse.getWeather().get(0).getMain();
		String weatherFeeling = "";
		if (weatherString.equalsIgnoreCase("thunderstorm")) {
			weatherFeeling = user.getThunderstorm();
		} else if (weatherString.equalsIgnoreCase("drizzle")) {
			weatherFeeling = user.getDrizzle();
		} else if (weatherString.equalsIgnoreCase("rain")) {
			weatherFeeling = user.getRain();
		} else if (weatherString.equalsIgnoreCase("snow")) {
			weatherFeeling = user.getSnow();
		} else if (weatherString.equalsIgnoreCase("mist")) {
			weatherFeeling = user.getMist();
		} else if (weatherString.equalsIgnoreCase("smoke")) {
			weatherFeeling = user.getSmoke();
		} else if (weatherString.equalsIgnoreCase("haze")) {
			weatherFeeling = user.getHaze();
		} else if (weatherString.equalsIgnoreCase("fog")) {
			weatherFeeling = user.getFog();
		} else if (weatherString.equalsIgnoreCase("sand")) {
			weatherFeeling = user.getSmoke();
		} else if (weatherString.equalsIgnoreCase("dust")) {
			weatherFeeling = user.getDust();
		} else if (weatherString.equalsIgnoreCase("ash")) {
			weatherFeeling = user.getAsh();
		} else if (weatherString.equalsIgnoreCase("squall")) {
			weatherFeeling = user.getSquall();
		} else if (weatherString.equalsIgnoreCase("tornado")) {
			weatherFeeling = user.getTornado();
		} else if (weatherString.equalsIgnoreCase("clear")) {
			weatherFeeling = user.getClear();
		} else {
			weatherFeeling = user.getClouds();
		}
		return weatherFeeling;
	}
	
	private String displayGreeting() {
		String timeIsh = null;
		int hour = LocalDateTime.now().getHour();
		if (hour >= 5 && hour < 12) {
			timeIsh = "Good Morning";
		} else if (hour >= 12 && hour < 17) {
			timeIsh = "Good Afternoon";
		} else if (hour >= 17 && hour < 21) {
			timeIsh = "Good Evening";
		} else {
			timeIsh = "Good Night";
		}
		return timeIsh;
	}
	
	private String buildDateQ(String startDate) {
		String startYear = startDate.substring(0, 4);
		String yearQ = "+year:" + startYear;
		return yearQ; 
	}
	
	private String buildDateQ(String startDate, String endDate) {
		String startYear = startDate.substring(0, 4);
		String endYear = endDate.substring(0, 4);
		String yearQ = "+year:" + startYear + "-" + endYear;
		return yearQ; 
	}
	
	@RequestMapping("/currentlocation")
	public ModelAndView removeSearchSession(HttpSession session) {
		session.removeAttribute("search");
		return new ModelAndView("redirect:/");
	}
	

	@RequestMapping("/welcome")
	public ModelAndView showWelcome(@SessionAttribute(name = "coords") Coordinates coords,
			@SessionAttribute(name="search", required=false) Search search) {
		ModelAndView mv = new ModelAndView("welcome");
		
		if(search == null) {
		User user = dao.findById((long) 1);
		mv.addObject("user", user);
		mv.addObject("defaultMood", user.getMoodPreferences());

		weatherResponse response = weatherApi.showWeather(coords.getLatitude(), coords.getLongitude());
		double temp = response.getMain().getTemp();
		// converting Kelvin to Fahrenheit
		temp = ((temp - 273.15) * 9 / 5 + 32);
		mv.addObject("name", response.getcityName());
		mv.addObject("temp", df2.format(temp));
		mv.addObject("mainCondition", response.getWeather().get(0).getMain());
		mv.addObject("description", response.getWeather().get(0).getDescription());

		mv.addObject("hour", displayGreeting());

		String weatherFeeling = getWeatherFeeling(response);
		String localWeather = response.getWeather().get(0).getMain();

		List<PlaylistItems> playlistWeather = spotifyApiService.showPlaylists(localWeather, Type.playlist);
		List<TrackItems> trackWeather = spotifyApiService.showTracks(localWeather, Type.track);
		List<ArtistItems> artistWeather = spotifyApiService.showArtists(localWeather, Type.artist);
		List<AlbumtItems> albumWeather = spotifyApiService.showAlbums(localWeather, Type.album);
		
		List<PlaylistItems> playlistFeeling = spotifyApiService.showPlaylists(weatherFeeling, Type.playlist);
		List<TrackItems> trackFeeling = spotifyApiService.showTracks(weatherFeeling, Type.track);
		List<ArtistItems> artistFeeling = spotifyApiService.showArtists(weatherFeeling, Type.artist);
		List<AlbumtItems> albumFeeling = spotifyApiService.showAlbums(weatherFeeling, Type.album);
		
		List<PlaylistItems> playlistList = mergeLists(playlistWeather, playlistFeeling);
		List<TrackItems> trackList = mergeLists(trackWeather, trackFeeling);
		List<ArtistItems> artistList = mergeLists(artistWeather, artistFeeling);
		List<AlbumtItems> albumList = mergeLists(albumWeather, albumFeeling);
		
		mv.addObject("playlist", playlistList);
		mv.addObject("track", trackList);
		mv.addObject("artist", artistList);
		mv.addObject("album", albumList);
		return mv;
		
		} else {
//			System.out.println("is mood - " + search.isByMood());
//			System.out.println("is releasedate - " + search.isSearchReleaseDate());
//			System.out.println("is current location - " + search.isUseCurrentLocation());
			String query = "";
			User user = dao.findById((long) 1);
			mv.addObject("user", user);
			mv.addObject("hour", displayGreeting());
			
			String yearQ = "";
			if (search.isSearchReleaseDate()) {
				if (search.getSelectEndDate() != "") {
					yearQ = buildDateQ(search.getSelectStartDate(), search.getSelectEndDate());
				} else {
					yearQ = buildDateQ(search.getSelectStartDate());
				}
			}
			
			

			List<PlaylistItems> playlistLocalWeather = new ArrayList<>();
			List<PlaylistItems> playlistAltLocal = new ArrayList<>();
			List<PlaylistItems> playlistWeatherFeeling = new ArrayList<>();
			List<PlaylistItems> playlistMood = new ArrayList<>();
			List<PlaylistItems> playlistMasterList = new ArrayList<>();
			
			List<TrackItems> trackLocalWeather = new ArrayList<>();
			List<TrackItems> trackAltLocal = new ArrayList<>();
			List<TrackItems> trackWeatherFeeling = new ArrayList<>();
			List<TrackItems> trackMood = new ArrayList<>();
			List<TrackItems> trackMasterList = new ArrayList<>();

			
			List<ArtistItems> artistLocalWeather = new ArrayList<>();
			List<ArtistItems> artistAltLocal = new ArrayList<>();
			List<ArtistItems> artistWeatherFeeling = new ArrayList<>();
			List<ArtistItems> artistMood = new ArrayList<>();
			List<ArtistItems> artistMasterList = new ArrayList<>();
			
			List<AlbumtItems> albumLocalWeather = new ArrayList<>();
			List<AlbumtItems> albumAltLocal = new ArrayList<>();
			List<AlbumtItems> albumWeatherFeeling = new ArrayList<>();
			List<AlbumtItems> albumMood = new ArrayList<>();
			List<AlbumtItems> albumMasterList = new ArrayList<>();


		//current location weather on current date
			weatherResponse currentResponse = weatherApi.showWeather(coords.getLatitude(), coords.getLongitude());
			double temp = currentResponse.getMain().getTemp();
			temp = ((temp - 273.15) * 9 / 5 + 32);
			mv.addObject("name", currentResponse.getcityName());
			mv.addObject("temp", df2.format(temp));
			mv.addObject("mainCondition", currentResponse.getWeather().get(0).getMain());
			mv.addObject("description", currentResponse.getWeather().get(0).getDescription());

		//add alternate date to current location weather
			if (search.isSearchReleaseDate()) {

				String weatherQ = currentResponse.getWeather().get(0).getMain();
				query = weatherQ + yearQ;
				
				playlistLocalWeather = spotifyApiService.showPlaylists(query, Type.playlist);
				trackLocalWeather = spotifyApiService.showTracks(query, Type.track);
				artistLocalWeather = spotifyApiService.showArtists(query, Type.artist);
				albumLocalWeather = spotifyApiService.showAlbums(query, Type.album);
			}
		
		//current weather at selected location (with date option)
			if (!search.isUseCurrentLocation() && search.getCity() != "") {
				Double Lat = geocodeApiService.getLatitude(search.getCity(), search.getState(), search.getCountry());
				String selectedLat = Double.toString(Lat);
				Double Long = geocodeApiService.getLongitude(search.getCity(), search.getState(), search.getCountry());
				String selectedLong = Double.toString(Long);

				weatherResponse selectedResponse = weatherApi.showWeather(selectedLat, selectedLong);
				double selectedtemp = selectedResponse.getMain().getTemp();
				selectedtemp = ((selectedtemp - 273.15) * 9 / 5 + 32);
				mv.addObject("name", selectedResponse.getcityName());
				mv.addObject("temp", df2.format(selectedtemp));
				mv.addObject("mainCondition", selectedResponse.getWeather().get(0).getMain());
				mv.addObject("description", selectedResponse.getWeather().get(0).getDescription());

				String weatherQ = selectedResponse.getWeather().get(0).getMain();
				
				if (search.isSearchReleaseDate()) {
					query = weatherQ + yearQ;
				} else {
					query = weatherQ;
				}
				//System.out.println("alt local query: " + query);

				playlistAltLocal = spotifyApiService.showPlaylists(query, Type.playlist);
				trackAltLocal = spotifyApiService.showTracks(query, Type.track);
				artistAltLocal = spotifyApiService.showArtists(query, Type.artist);
				albumAltLocal = spotifyApiService.showAlbums(query, Type.album);
				
			}
			
		//weather feeling for local and alternate place (with date option)
			if (search.isUseCurrentLocation()) {
				String localWeatherFeeling = getWeatherFeeling(currentResponse);
				
				if (search.isSearchReleaseDate()) {
					query = localWeatherFeeling + yearQ;
				} else {
					query = localWeatherFeeling;
				}
				
				playlistWeatherFeeling = spotifyApiService.showPlaylists(query, Type.playlist);
				trackWeatherFeeling = spotifyApiService.showTracks(query, Type.track);
				artistWeatherFeeling = spotifyApiService.showArtists(query, Type.artist);
				albumWeatherFeeling = spotifyApiService.showAlbums(query, Type.album);
				
			} else if (!search.isUseCurrentLocation() && search.getCity() != "") {
				Double Lat = geocodeApiService.getLatitude(search.getCity(), search.getState(), search.getCountry());
				String selectedLat = Double.toString(Lat);
				Double Long = geocodeApiService.getLongitude(search.getCity(), search.getState(), search.getCountry());
				String selectedLong = Double.toString(Long);

				weatherResponse selectedResponse = weatherApi.showWeather(selectedLat, selectedLong);
				double selectedtemp = selectedResponse.getMain().getTemp();
				selectedtemp = ((selectedtemp - 273.15) * 9 / 5 + 32);
				mv.addObject("name", selectedResponse.getcityName());
				mv.addObject("temp", df2.format(selectedtemp));
				mv.addObject("mainCondition", selectedResponse.getWeather().get(0).getMain());
				mv.addObject("description", selectedResponse.getWeather().get(0).getDescription());
				
				String altWeatherFeeling = getWeatherFeeling(selectedResponse);
				
				if (search.isSearchReleaseDate()) {
					query = altWeatherFeeling + yearQ;
				} else {
					query = altWeatherFeeling;
				}
				
				playlistWeatherFeeling = spotifyApiService.showPlaylists(query, Type.playlist);
				trackWeatherFeeling = spotifyApiService.showTracks(query, Type.track);
				artistWeatherFeeling = spotifyApiService.showArtists(query, Type.artist);
				albumWeatherFeeling = spotifyApiService.showAlbums(query, Type.album);
			}
			
			if (search.isByMood()) {
				playlistMood = spotifyApiService.showPlaylists(search.getMood(), Type.playlist);
				trackMood = spotifyApiService.showTracks(search.getMood(), Type.track);
				artistMood = spotifyApiService.showArtists(search.getMood(), Type.artist);
				albumMood = spotifyApiService.showAlbums(search.getMood(), Type.album);
				mv.addObject("mood", search.getMood());
			}
			
		//merge playlists
			playlistMasterList = mergeLists(playlistLocalWeather, playlistAltLocal, playlistWeatherFeeling, playlistMood);
		
		//merge track lists
			trackMasterList = mergeLists(trackLocalWeather, trackAltLocal, trackWeatherFeeling, trackMood);
			
		//merge artist lists
			artistMasterList = mergeLists(artistLocalWeather, artistAltLocal, artistWeatherFeeling, artistMood);
			
		//merge album lists
			albumMasterList = mergeLists(albumLocalWeather, albumAltLocal, albumWeatherFeeling, albumMood);

			
			mv.addObject("playlist", playlistMasterList);
			mv.addObject("track", trackMasterList);
			mv.addObject("album", albumMasterList);
			mv.addObject("artist", artistMasterList);
			return mv;
		}
	}

	@PostMapping("/favorite/playlist")
	public ModelAndView addFavoritePlaylist(@RequestParam("favorite") String id,
			@SessionAttribute(name = "sessionMood", required = false) String sessionMood) {
		PlaylistFavorites fav = new PlaylistFavorites();
		User user = dao.findById((long) 1);
		fav.setUserId(user.getId());
		fav.setPlaylistId(id);
		favDao.createPlaylist(fav);
		System.out.println("Session mood = " + sessionMood);
		
		return new ModelAndView("redirect:/welcome");
	}
	@PostMapping("/favorite/artist")
	public ModelAndView addFavoriteArtist(@RequestParam("favorite") String id,
			@SessionAttribute(name = "sessionMood", required = false) String sessionMood) {
		ArtistFavorites fav = new ArtistFavorites();
		User user = dao.findById((long) 1);
		fav.setUserId(user.getId());
		fav.setArtistId(id);
		favDao.createArtist(fav);
		System.out.println(sessionMood);
		if (sessionMood == null) {
			return new ModelAndView("redirect:/welcome");
		} else {
			return new ModelAndView("redirect:/welcome/mood");
		}
	}
	@PostMapping("/favorite/track")
	public ModelAndView addFavoritesTrack(@RequestParam("favorite") String id,
			@SessionAttribute(name = "sessionMood", required = false) String sessionMood) {
		TrackFavorites fav = new TrackFavorites();
		User user = dao.findById((long) 1);
		fav.setUserId(user.getId());
		fav.setTrackId(id);
		favDao.createTrack(fav);
		System.out.println(sessionMood);
		if (sessionMood == null) {
			return new ModelAndView("redirect:/welcome");
		} else {
			return new ModelAndView("redirect:/welcome/mood");
		}
	}
	@PostMapping("/favorite/album")
	public ModelAndView addFavoriteAlbum(@RequestParam("favorite") String id,
			@SessionAttribute(name = "sessionMood", required = false) String sessionMood) {
		AlbumFavorites fav = new AlbumFavorites();
		User user = dao.findById((long) 1);
		fav.setUserId(user.getId());
		fav.setAlbumId(id);
		favDao.createAlbum(fav);
		System.out.println(sessionMood);
		if (sessionMood == null) {
			return new ModelAndView("redirect:/welcome");
		} else {
			return new ModelAndView("redirect:/welcome/mood");
		}
	}

	@PostMapping("/welcome")
	public ModelAndView dateWelcome(Search search,
			@SessionAttribute(name = "coords") Coordinates coords,
			@SessionAttribute(name="search", required=false) Search sessionSearch,
			HttpSession session) {
		search.normalize();
		session.setAttribute("search", search);
		return new ModelAndView("redirect:/welcome");
		
//		ModelAndView mv = new ModelAndView("welcome");
//		User user = dao.findById((long) 1);
//		mv.addObject("user", user);
//		mv.addObject("hour", displayGreeting());
//		
//		String yearQ = "";
//		if (search.getSelectStartDate() != "") {
//			if (search.getSelectEndDate() != "") {
//				yearQ = buildDateQ(search.getSelectStartDate(), search.getSelectEndDate());
//			} else {
//				yearQ = buildDateQ(search.getSelectStartDate());
//			}
//		}
//
//		List<PlaylistItems> playlistLocalWeather = new ArrayList<>();
//		List<PlaylistItems> playlistAltLocal = new ArrayList<>();
//		List<PlaylistItems> playlistWeatherFeeling = new ArrayList<>();
//		List<PlaylistItems> playlistMood = new ArrayList<>();
//		List<PlaylistItems> playlistMasterList = new ArrayList<>();
//		
//		List<TrackItems> trackLocalWeather = new ArrayList<>();
//		List<TrackItems> trackAltLocal = new ArrayList<>();
//		List<TrackItems> trackWeatherFeeling = new ArrayList<>();
//		List<TrackItems> trackMood = new ArrayList<>();
//		List<TrackItems> trackMasterList = new ArrayList<>();
//
//		
//		List<ArtistItems> artistLocalWeather = new ArrayList<>();
//		List<ArtistItems> artistAltLocal = new ArrayList<>();
//		List<ArtistItems> artistWeatherFeeling = new ArrayList<>();
//		List<ArtistItems> artistMood = new ArrayList<>();
//		List<ArtistItems> artistMasterList = new ArrayList<>();
//		
//		List<AlbumtItems> albumLocalWeather = new ArrayList<>();
//		List<AlbumtItems> albumAltLocal = new ArrayList<>();
//		List<AlbumtItems> albumWeatherFeeling = new ArrayList<>();
//		List<AlbumtItems> albumMood = new ArrayList<>();
//		List<AlbumtItems> albumMasterList = new ArrayList<>();
//
//
//	//current location weather on current date
//		weatherResponse currentResponse = weatherApi.showWeather(coords.getLatitude(), coords.getLongitude());
//		double temp = currentResponse.getMain().getTemp();
//		temp = ((temp - 273.15) * 9 / 5 + 32);
//		mv.addObject("name", currentResponse.getcityName());
//		mv.addObject("temp", df2.format(temp));
//		mv.addObject("mainCondition", currentResponse.getWeather().get(0).getMain());
//		mv.addObject("description", currentResponse.getWeather().get(0).getDescription());
//
//	//add alternate date to current location weather
//
//		if (search.getSelectStartDate() != "") {
//
//			String weatherQ = currentResponse.getWeather().get(0).getMain();
//			String query = weatherQ + yearQ;
//			
//			System.out.println("local weather query: " + query);
//			
//			playlistLocalWeather = spotifyApiService.showPlaylists(query, Type.playlist);
//			trackLocalWeather = spotifyApiService.showTracks(query, Type.track);
//			artistLocalWeather = spotifyApiService.showArtists(query, Type.artist);
//			albumLocalWeather = spotifyApiService.showAlbums(query, Type.album);
//		}
//	
//	//current weather at selected location (with date option)
//		if (search.getCity() != "") {
//			Double Lat = geocodeApiService.getLatitude(search.getCity(), search.getState(), search.getCountry());
//			String selectedLat = Double.toString(Lat);
//			Double Long = geocodeApiService.getLongitude(search.getCity(), search.getState(), search.getCountry());
//			String selectedLong = Double.toString(Long);
//
//			weatherResponse selectedResponse = weatherApi.showWeather(selectedLat, selectedLong);
//			double selectedtemp = selectedResponse.getMain().getTemp();
//			selectedtemp = ((selectedtemp - 273.15) * 9 / 5 + 32);
//			mv.addObject("name", selectedResponse.getcityName());
//			mv.addObject("temp", df2.format(selectedtemp));
//			mv.addObject("mainCondition", selectedResponse.getWeather().get(0).getMain());
//			mv.addObject("description", selectedResponse.getWeather().get(0).getDescription());
//
//			String weatherQ = selectedResponse.getWeather().get(0).getMain();
//			
//
//			String query = weatherQ + yearQ;
//			
//			System.out.println("alt local query: " + query);
//
//			playlistAltLocal = spotifyApiService.showPlaylists(query, Type.playlist);
//			trackAltLocal = spotifyApiService.showTracks(query, Type.track);
//			artistAltLocal = spotifyApiService.showArtists(query, Type.artist);
//			albumAltLocal = spotifyApiService.showAlbums(query, Type.album);
//			
//		}
//		
//	//weather feeling for local and alternate place (with date option)
//		if (search.getCity().equals("")) {
//			String localWeatherFeeling = getWeatherFeeling(currentResponse);
//			
//			String query = localWeatherFeeling + yearQ;
//			System.out.println("local weather feeling query: " + query);
//			
//			playlistWeatherFeeling = spotifyApiService.showPlaylists(query, Type.playlist);
//			trackWeatherFeeling = spotifyApiService.showTracks(query, Type.track);
//			artistWeatherFeeling = spotifyApiService.showArtists(query, Type.artist);
//			albumWeatherFeeling = spotifyApiService.showAlbums(query, Type.album);
//			
//		} else {
//			Double Lat = geocodeApiService.getLatitude(search.getCity(), search.getState(), search.getCountry());
//			String selectedLat = Double.toString(Lat);
//			Double Long = geocodeApiService.getLongitude(search.getCity(), search.getState(), search.getCountry());
//			String selectedLong = Double.toString(Long);
//
//			weatherResponse selectedResponse = weatherApi.showWeather(selectedLat, selectedLong);
//			double selectedtemp = selectedResponse.getMain().getTemp();
//			selectedtemp = ((selectedtemp - 273.15) * 9 / 5 + 32);
//			mv.addObject("name", selectedResponse.getcityName());
//			mv.addObject("temp", df2.format(selectedtemp));
//			mv.addObject("mainCondition", selectedResponse.getWeather().get(0).getMain());
//			mv.addObject("description", selectedResponse.getWeather().get(0).getDescription());
//			
//			String altWeatherFeeling = getWeatherFeeling(selectedResponse);
//			
//
//			String query = altWeatherFeeling + yearQ;
//			System.out.println("alt local weather feeling query: " + query);
//			
//			playlistWeatherFeeling = spotifyApiService.showPlaylists(query, Type.playlist);
//			trackWeatherFeeling = spotifyApiService.showTracks(query, Type.track);
//			artistWeatherFeeling = spotifyApiService.showArtists(query, Type.artist);
//			albumWeatherFeeling = spotifyApiService.showAlbums(query, Type.album);
//		}
//		
//		if (!search.getMood().equals("")) {
//			playlistMood = spotifyApiService.showPlaylists(search.getMood(), Type.playlist);
//			trackMood = spotifyApiService.showTracks(search.getMood(), Type.track);
//			artistMood = spotifyApiService.showArtists(search.getMood(), Type.artist);
//			albumMood = spotifyApiService.showAlbums(search.getMood(), Type.album);
//			mv.addObject("mood", search.getMood());
//		}
//		
//	//merge playlists
//		playlistMasterList = mergeLists(playlistLocalWeather, playlistAltLocal, playlistWeatherFeeling, playlistMood);
//	
//	//merge track lists
//		trackMasterList = mergeLists(trackLocalWeather, trackAltLocal, trackWeatherFeeling, trackMood);
//		
//	//merge artist lists
//		artistMasterList = mergeLists(artistLocalWeather, artistAltLocal, artistWeatherFeeling, artistMood);
//		
//	//merge album lists
//		albumMasterList = mergeLists(albumLocalWeather, albumAltLocal, albumWeatherFeeling, albumMood);
//
//		
//		mv.addObject("playlist", playlistMasterList);
//		mv.addObject("track", trackMasterList);
//		mv.addObject("album", albumMasterList);
//		mv.addObject("artist", artistMasterList);
//		return mv;
	}
	
	@SafeVarargs
	private final <T> List<T> mergeLists(List<T>... lists) {
		List<T> masterList = new ArrayList<>();
		
		int maxTlLen = 0;
		for (List<T> list : lists) {
			if (list.size() > maxTlLen) {
				maxTlLen = list.size();
			}
		}
		for (int i = 0; i < maxTlLen; i++) {
			for (List<T> list : lists) {
				if (i < list.size()) {
					masterList.add(list.get(i));
				}
			}
		}
		
		if (masterList.size() > 10) {
			masterList = masterList.subList(0, 10);
		}
		return masterList;
	}

	@RequestMapping("/preferences")
	public ModelAndView displayPreferences() {
		User user = dao.findById((long) 1);
		ModelAndView mv = new ModelAndView("preferences");
		mv.addObject("user", user);
		mv.addObject("mood", user.getMoodPreferences());

		mv.addObject("feelingThunderstorm", user.getThunderstorm());
		mv.addObject("feelingDrizzle", user.getDrizzle());
		mv.addObject("feelingRain", user.getRain());
		mv.addObject("feelingSnow", user.getSnow());
		mv.addObject("feelingMist", user.getMist());
		mv.addObject("feelingSmoke", user.getSmoke());
		mv.addObject("feelingHaze", user.getHaze());
		mv.addObject("feelingFog", user.getFog());
		mv.addObject("feelingSand", user.getSand());
		mv.addObject("feelingDust", user.getDust());
		mv.addObject("feelingAsh", user.getAsh());
		mv.addObject("feelingSquall", user.getSquall());
		mv.addObject("feelingTornado", user.getTornado());
		mv.addObject("feelingClear", user.getClear());
		mv.addObject("feelingClouds", user.getClouds());

		mv.addObject("hour", displayGreeting());

		return mv;
	}
	
	@RequestMapping("/favorites")
	public ModelAndView displayFavorites() {
		ModelAndView mv = new ModelAndView();
		User user = dao.findById((long) 1);
		mv.addObject("user", user);
		
		List<AlbumFavorites> albumFavs = favDao.findAllAlbums();
		List<ArtistFavorites> artistFavs = favDao.findAllArtists();
		List<PlaylistFavorites> playlistFavs = favDao.findAllPlaylists();
		List<TrackFavorites> trackFavs = favDao.findAllTracks();
		mv.addObject("albumFavs", albumFavs);
		mv.addObject("artistFavs", artistFavs);
		mv.addObject("playlistFavs", playlistFavs);
		mv.addObject("trackFavs", trackFavs);
		mv.addObject("hour", displayGreeting());
		return mv;
	}
	
	@PostMapping("/favorite/playlist/delete")
	public ModelAndView deleteFavoritePlaylist(@RequestParam("favorite") Long id) {
		favDao.deletePlaylist(id);
		return new ModelAndView("redirect:/favorites");
	}
	@PostMapping("/favorite/track/delete")
	public ModelAndView deleteFavoriteTrack(@RequestParam("favorite") Long id) {
		favDao.deleteTrack(id);
		return new ModelAndView("redirect:/favorites");
	}
	@PostMapping("/favorite/artist/delete")
	public ModelAndView deleteFavoriteArtist(@RequestParam("favorite") Long id) {
		favDao.deleteArtist(id);
		return new ModelAndView("redirect:/favorites");
	}
	@PostMapping("/favorite/album/delete")
	public ModelAndView deleteFavoriteAlbum(@RequestParam("favorite") Long id) {
		favDao.deleteAlbum(id);
		return new ModelAndView("redirect:/favorites");
	}
	
}// controller class
