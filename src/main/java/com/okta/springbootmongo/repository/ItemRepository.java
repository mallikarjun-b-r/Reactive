package com.okta.springbootmongo.repository;
import com.okta.springbootmongo.model.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item,Long> {
}
