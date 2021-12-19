package com.sawami.backendservice.mapper;

import com.sawami.backendservice.dto.ItemDto;
import com.sawami.backendservice.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemMapper {

	Item toItem(ItemDto itemDto);

	ItemDto fromItem(Item item);

	void updateItemFromDto(ItemDto itemDto, @MappingTarget Item item);

}
