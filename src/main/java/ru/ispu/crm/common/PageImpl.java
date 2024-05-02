package ru.ispu.crm.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageImpl<T> {
    private List<T> elements;

    private Integer totalPages;
}
