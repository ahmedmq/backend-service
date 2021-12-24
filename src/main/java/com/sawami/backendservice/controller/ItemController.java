package com.sawami.backendservice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import com.sawami.backendservice.dto.ItemDto;
import com.sawami.backendservice.entity.Item;
import com.sawami.backendservice.mapper.ItemMapper;
import com.sawami.backendservice.report.ItemReportService;
import com.sawami.backendservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	private final ItemReportService itemReportService;

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

	@GetMapping(value = "/api/items/{itemNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDto getItemById(@PathVariable String itemNo){
		Item item = itemRepository.findById(itemNo).orElseThrow(()-> new RuntimeException("Item with ["+ itemNo +"] not found"));
		return itemMapper.fromItem(item);
	}

	@PutMapping(value = "/api/items/{itemNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDto updateItemById(@PathVariable String itemNo, @RequestBody ItemDto itemDto){
		Item item = itemRepository.findById(itemNo).orElseThrow(()-> new RuntimeException("Item with ["+ itemNo +"] not found"));
		itemMapper.updateItemFromDto(itemDto,item);
		item = itemRepository.save(item);
		return itemMapper.fromItem(item);
	}

	@DeleteMapping(value = "/api/items/{itemNo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteItemById(@PathVariable String itemNo){
		itemRepository.deleteById(itemNo);
	}

	@GetMapping(value = "/api/items/report/itemSummary")
	public ResponseEntity<Void> downloadItemSummaryReport(HttpServletResponse httpServletResponse) throws JRException, SQLException, IOException {
		itemReportService.downloadItemSummaryReport(httpServletResponse);
		return ResponseEntity.ok().build();
	}
}
