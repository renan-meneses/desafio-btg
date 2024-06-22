package tech.builder.btgpactual.orderms.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponser paginationResponser){

}

