package com.techmaster.testSpringRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<UserDTO> data;
}
