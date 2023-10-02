package com.example.springdemo.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
class DemoControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    private static final String  EXPECTED_EMPLOYEES_JSON = "[{\"id\":1,\"name\":\"Tomasz\"},{\"id\":2,\"name\":\"Tom\"},{\"id\":3,\"name\":\"Tomus\"}]";
    private static final String  EXPECTED_EMPLOYEE_BY_ID_JSON = "{\"id\":1,\"name\":\"Tomasz\"}";

    @Test
    @Sql("/employees-dml.sql")
    @Sql(scripts = "/clean-up.sql", executionPhase = AFTER_TEST_METHOD)
    void shouldGetAllEmployeesFromDatabase() throws JSONException {

        // when
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/employees", String.class);

        // then
        JSONAssert.assertEquals(EXPECTED_EMPLOYEES_JSON, response.getBody(), JSONCompareMode.LENIENT);
    }
    @Test
    @Sql("/employees-dml.sql")
    @Sql(scripts = "/clean-up.sql", executionPhase = AFTER_TEST_METHOD)
    void shouldGetEmployeeFromDatabaseByID() throws JSONException {
        // when
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/employees/1",
                String.class);
        //then
        JSONAssert.assertEquals(EXPECTED_EMPLOYEE_BY_ID_JSON, response.getBody(), JSONCompareMode.LENIENT);

    }
}