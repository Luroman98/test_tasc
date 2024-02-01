package applic.service;

import applic.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {
    private final WebClient webClient;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherService() {
        this.webClient = WebClient.create();
    }

    public Mono<WeatherInfo> getWeather(String city) {
        return webClient.get()
                .uri(apiUrl + "?q={city}&APPID={apiKey}", city, apiKey)
                .retrieve()
                .bodyToMono(WeatherInfo.class);
    }
}