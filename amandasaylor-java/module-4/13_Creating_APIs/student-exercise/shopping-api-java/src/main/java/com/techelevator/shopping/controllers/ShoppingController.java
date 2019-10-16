package com.techelevator.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.shopping.dao.ItemDao;
import com.techelevator.shopping.exception.ItemNotFoundException;
import com.techelevator.shopping.model.Item;

@RestController
@CrossOrigin
@RequestMapping("/api/groceries")
public class ShoppingController {
private ItemDao itemDao;


@Autowired
public ShoppingController(ItemDao itemDao) {
    this.itemDao = itemDao;
}

@GetMapping
public List<Item> list(){
    return itemDao.list();
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Item create(@RequestBody Item item) {
    return itemDao.create(item);
    
}

@PutMapping("/{id}")
public Item read(@PathVariable int id, String message) {
    Item item = itemDao.read(id);
    if(item != null) {
        return item;
    }else {
        throw new ItemNotFoundException(id, message);
    }   
}

public Item update(@PathVariable int id, @RequestBody Item item, String message) {
    Item requestedItem = itemDao.read(id);
    if(requestedItem != null) {
        item.setId(id);
        return itemDao.update(item);
    }else {
        throw new ItemNotFoundException(id,message);
    }
    
}

@DeleteMapping("/{id}")
public void delete(@PathVariable int id, String message) {
    Item itemToDelete = itemDao.read(id);
    if(itemToDelete != null) {
        itemDao.delete(id);
    }else {
        throw new ItemNotFoundException(id,message);
    }

}
}