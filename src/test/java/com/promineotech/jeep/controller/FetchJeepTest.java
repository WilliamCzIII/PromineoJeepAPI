package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

/*@ActiveProfiles("test")




@Sql(scripts = {
    
    "classpath:flyway/migrations/V1.__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
     
    config = @SqlConfig(encoding = "utf-8"))
    */

class FetchJeepTest extends FetchJeepTestSupport{
  
  /*@Test
  void test() {
    System.out.println(getBaseUri());
  }
  */
  
 /* @Autowired

  private TestRestTemplate restTemplate;

  @LocalServerPort

  private int serverPort;
*/
  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
      //Given: a valid model, trim and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    
   // System.out.println(uri);
    
      //When: a connection is made to the URI
   ResponseEntity<Jeep> response = getRestTemplate().getForEntity(uri, Jeep.class);
    
    
      //Then: a success (OK -200) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
  }

}
