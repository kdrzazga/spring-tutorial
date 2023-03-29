package org.kd.springbootrest.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.kd.springbootrest.demo.client.CountryHttpClient;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryHttpClientTest {

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
    @CsvSource({"0, Poland", "1, Germany", "2, Chad"})
    public void testSingleCountryEndpointGetCountryName(Integer i, String country) {
        var response = new CountryHttpClient().request("/country/" + i);

        assertNotNull(response);
        assertThat(response.body(), containsString(country));
    }

    @Test
    public void testGetPoland() {
        var response = new CountryHttpClient().request("/country/0");

        assertNotNull(response);
        assertThat(response.body(), containsString("Poland"));

    }

    @ParameterizedTest
    @CsvSource({"Warszawa, 0", "Berlin, 1", "Njamena, 2"})
    public void testSingleCountryEndpointGetCountryCapital(String capital, Integer index) {
        var endpoint = "/country/" + index;
        var response = new CountryHttpClient().request(endpoint);

        assertNotNull(response);
        assertThat(response.body(), containsString(capital));
    }

}
