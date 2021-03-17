// camel-k: language=java dependency=camel-quarkus-openapi-java 

import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;

public class LoggerK extends RouteBuilder {
  @Override
  public void configure() throws Exception {
  

    from("knative:channel/demo")
      .log("${body}");
  }
}