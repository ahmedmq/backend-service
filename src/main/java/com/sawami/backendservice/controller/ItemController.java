package com.sawami.backendservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sawami.backendservice.dto.ItemDto;
import com.sawami.backendservice.entity.Item;
import com.sawami.backendservice.mapper.ItemMapper;
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
	private final ItemMapper itemMapper;

	@GetMapping(value = "/api/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDto> getItems(){
		return itemRepository.findAll().stream().map(itemMapper::fromItem).collect(Collectors.toList());
	}

	@PostMapping(value = "/api/items" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ItemDto createItem(@RequestBody ItemDto itemDto){
		Item item = itemMapper.toItem(itemDto);
		Item savedItem = itemRepository.save(item);
		return itemMapper.fromItem(savedItem);
	}

	@GetMapping(value = "/api/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDto getItemById(@PathVariable Long itemId){
		Item item = itemRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Item with ["+itemId+"] not found"));
		return itemMapper.fromItem(item);
	}

	@PutMapping(value = "/api/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDto updateItemById(@PathVariable Long itemId, @RequestBody ItemDto itemDto){
		Item item = itemRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Item with ["+itemId+"] not found"));
		itemMapper.updateItemFromDto(itemDto,item);
		item = itemRepository.save(item);
		return itemMapper.fromItem(item);
	}

	@DeleteMapping(value = "/api/items/{itemId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteItemById(@PathVariable Long itemId){
		itemRepository.deleteById(itemId);
	}
}
