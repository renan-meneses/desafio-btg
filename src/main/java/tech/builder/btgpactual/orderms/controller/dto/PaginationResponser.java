package tech.builder.btgpactual.orderms.controller.dto;

import org.springframework.data.domain.Page;

public record PaginationResponser(Integer page, Integer pageSize , Long totalElements, Integer totalPages) {
    public static PaginationResponser fromPage(Page<?> page){
        return new PaginationResponser(
        page.getNumber(),
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages()
        );
    }
}
