package antra.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    public String url = "https://jsonmock.hackerrank.com/api/moviesdata/search/";

    @RequestMapping("/hello")
    public String hello() {
        return "Hello to the movie hosting website";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient() {
        String uri = "http://localhost:8080/hello";
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping(value = "/movies")
    private String getMovies() {
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Integer> getMoviebyPage(@RequestParam Integer page) {
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<String> getMoviebyTitle(@RequestParam String Title) {
        return new ResponseEntity<>(Title, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Integer> getMoviebyYear(@RequestParam Integer Year) {
        return new ResponseEntity<>(Year, HttpStatus.OK);
    }
}
