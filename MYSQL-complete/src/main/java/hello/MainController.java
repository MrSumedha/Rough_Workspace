package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entities.Location;
import hello.entities.User;
import hello.repos.LocationRepository;
import hello.repos.UserRepository;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;

	@PostMapping(path = "/add/user")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@PostMapping(path = "/add/location")
	public @ResponseBody String addNewLocation(@RequestParam String cityName, @RequestParam String countryName) {
		Location location = new Location();
		location.setCityName(cityName);
		location.setCountryName(countryName);
		
		User user1 = new User();
		user1.setName("abc");
		user1.setEmail("emmn@nnnm");
		user1.setLocation(location);
		
		User user2 = new User();
		user2.setName("def");
		user2.setEmail("def@asd");
		user2.setLocation(location);
		
		location.setUsers(Arrays.asList(user1, user2));
		locationRepository.save(location);
		return "Saved";
	}

	@GetMapping(path = "/all/users")
	public @ResponseBody Iterable<User> getAllUsers() throws InterruptedException {
		User user = userRepository.findById(1).get();
		user.setEmail("newemail.po.com");
		userRepository.save(user);
		return userRepository.findAll();
	}

	@GetMapping(path = "/all/locations")
	public @ResponseBody Iterable<Location> getAllLocations() {
		return locationRepository.findAll();
	}
}
