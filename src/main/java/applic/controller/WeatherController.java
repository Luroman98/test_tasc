package applic.controller;

import applic.model.WeatherInfo;
import applic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/{city}")
    public Mono<ResponseEntity<WeatherInfo>> getWeather(@PathVariable String city) {
        return weatherService.getWeather(city)
                .map(weatherInfo -> ResponseEntity.ok().body(weatherInfo))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}