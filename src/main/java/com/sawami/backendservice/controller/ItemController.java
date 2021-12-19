package com.sawami.backendservice.controller;

import java.util.List;

import com.sawami.backendservice.entity.Item;
import com.sawami.backendservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

	private final ItemRepository itemRepository;

	@GetMapping(value = "/api/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getProducts(){
		return itemRepository.findAll();
	}

	@PostMapping(value = "/api/items" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item createProduct(Item item){
		return itemRepository.save(item);
	}

	@GetMapping(value = "/api/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Item getProductById(@PathVariable Long itemId){
		return itemRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Product with ["+itemId+"] not found"));
	}

	@PutMapping(value = "/api/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Item updateProductById(@PathVariable Long itemId, @RequestBody Item item){
		return itemRepository.save(item);
	}

	@DeleteMapping(value = "/api/items/{itemId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable Long itemId){
		itemRepository.deleteById(itemId);
	}
}
