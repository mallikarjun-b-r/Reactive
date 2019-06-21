package com.okta.springbootmongo.controller;
import com.okta.springbootmongo.model.Item;
import com.okta.springbootmongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
@RequestMapping(path ="/items")
@CrossOrigin
public class ItemController {

    @Autowired

    private ItemRepository itemRepository;

    @PostMapping()
    public Mono<Item> addItem(@RequestBody Item item){

        return itemRepository.save(item);
    }

    @GetMapping() @ResponseBody
    public Flux<Item> getAllItems(){
        Item i = new Item("sad","asd",2);
        return itemRepository.findAll();
    }



}
