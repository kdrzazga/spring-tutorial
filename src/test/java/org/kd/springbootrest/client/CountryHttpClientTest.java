package org.kd.springbootrest.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kd.springbootrest.demo.client.CountryHttpClient;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryHttpClientTest {

    private static byte countryCounter;

    @Test
    public void testCountriesEndpoint() {

        var response = new CountryHttpClient().request("/countries");
        assertNotNull(response);

        assertEquals(200, response.statusCode());
        assertNotNull(response.headers());
        assertNotNull(response.body());
    }

    @Test
    public void testSingleCountryEndpoint() {
        var response = new CountryHttpClient().request("/country/0");
        assertNotNull(response);

        assertEquals(HttpStatus.OK.value(), response.statusCode());
        assertNotNull(response.headers());
        assertNotNull(response.body());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Poland", "Germany", "Chad"})
    public void testSingleCountryEndpointGetCountryName(String country) {
        var response = new CountryHttpClient().request("/country/" + countryCounter);

        assertNotNull(response);
        assertThat(response.body(), containsString(country));
        countryCounter++;
    }

    @Test
    public void testGetPoland(){
        var response = new CountryHttpClient().request("/country/0");

        assertNotNull(response);
        assertThat(response.body(), containsString("Poland"));

    }

    @ParameterizedTest
    @ValueSource(strings = {"Warszawa", "Berlin", "Njamena"})
    public void testSingleCountryEndpointGetCountryCapital(String capital) {
        var endpoint = "/country/" + countryCounter;
        var response = new CountryHttpClient().request(endpoint);

        assertNotNull(response);
        assertThat(response.body(), containsString(capital));
        countryCounter++;
    }

    @BeforeEach
    public void resetCountryCounter() {
        countryCounter = 0;
    }
}
