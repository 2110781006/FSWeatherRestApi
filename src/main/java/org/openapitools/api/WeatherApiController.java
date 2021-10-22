package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-22T09:18:47.043380800+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.fsuWeatherRest.base-path:/api/v1}")
public class WeatherApiController implements WeatherApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public WeatherApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
