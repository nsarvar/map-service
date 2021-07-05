package location

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client

@Header(name = "privateKey", value = '${uberall.apiKey}')
@Client("https://sandbox.uberall.com/api")
interface LocationHttpClient {
    @Get("/locations?max={max}")
    LocationResult list(Integer max);
}
