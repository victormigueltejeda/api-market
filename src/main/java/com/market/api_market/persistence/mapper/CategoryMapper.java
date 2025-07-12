package com.market.api_market.persistence.mapper;

import com.market.api_market.domain.Category;
import com.market.api_market.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mappings(value = {
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")

    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos",ignore = true)
    Categoria toCategoria(Category category);
}
