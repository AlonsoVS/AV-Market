package com.av.avmarket.persistence.Mapper;

import com.av.avmarket.domain.CategoryDomain;
import com.av.avmarket.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
          @Mapping(source = "categoryId", target = "categoryId"),
          @Mapping(source = "description", target = "category"),
          @Mapping(source = "status", target = "active"),
  })
  CategoryDomain toCategoryDomain(Category category);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Category toCategory(CategoryDomain categoryDomain);
}
