package com.airline.controller.controller_FE_SF;

import com.airline.dto.searchTiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchTicketDtoResponse;
import com.airline.service.SearchTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class SearchTicketController {
    @Autowired
    private SearchTicketService service;

    @PostMapping("/search")
    public ResponseEntity<Page<SearchTicketDtoResponse>> searchTicket(@Validated @RequestBody SearchTicketDtoRequest searchTicketDtoRequest,
                                                                      @RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size,
                                                                      @RequestParam(defaultValue = "ticketPrice,asc") String[] sort) {
        Pageable pageable = service.createPageable(page, size, sort);
        Page<SearchTicketDtoResponse> searchTicketDtoResponses = service.getSearchTicketDtoResponses(searchTicketDtoRequest, pageable);
        return new ResponseEntity<>(searchTicketDtoResponses, HttpStatus.OK);
    }
}
