// camel-k: language=java dependency=camel-quarkus-openapi-java 

import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;

public class ReceiverK extends RouteBuilder {
  @Override
  public void configure() throws Exception {
 
    from("direct:root")
      .setBody(simple("{\"status\":\"UP\"}"));

    from("direct:receiver")
    .setBody(simple("${header.message}"))
    .to("knative:channel/demo")
    .setBody(simple("{\"message\": \"sent\"}"));  
  }
}