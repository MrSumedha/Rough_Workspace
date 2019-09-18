package hello;

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
		locationRepository.save(location);
		return "Saved";
	}

	@GetMapping(path = "/all/users")
	public @ResponseBody Iterable<User> getAllUsers() throws InterruptedException {
		User user = userRepository.findById(1).get();
		user.setEmail("newemail.com");
		new Thread(() -> {
			System.out.println(userRepository.findById(1).get().getEmail());
		}).start(); 
		Thread.sleep(5000);
		userRepository.save(user);
		return userRepository.findAll();
	}

	@GetMapping(path = "/all/locations")
	public @ResponseBody Iterable<Location> getAllLocations() {
		return locationRepository.findAll();
	}
}
