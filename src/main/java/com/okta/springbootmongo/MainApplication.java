package com.okta.springbootmongo;

import com.okta.springbootmongo.model.Item;
import com.okta.springbootmongo.repository.ItemRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class MainApplication {
  @Bean
  ApplicationRunner init(ItemRepository repository) {

    Object[][] data = {
            {"sea", "Andrew", 300.12 },
            {"creek", "Andrew", 100.75 },
            {"loaner", "Andrew", 75}
    };

    return args -> {
      repository
              .deleteAll()
              .thenMany(
                      Flux
                              .just(data)
                              .map(array -> {
                                return new Item((String)array[0],(String)array[1],(Number) array[2]);
                              })
                              .flatMap(repository::save)
              )
              .thenMany(repository.findAll())
              .subscribe(kayak -> System.out.println("saving " + kayak.toString()));
    };
  }
  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }
}

