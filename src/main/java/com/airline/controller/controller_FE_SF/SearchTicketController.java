package com.airline.controller.controller_FE_SF;

import com.airline.dto.searchTiketDto.request.SearchFlightDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import com.airline.service.SearchFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class SearchTicketController {
    @Autowired
    private SearchFlightService service;
    @PostMapping("/search")
    public ResponseEntity<Page<SearchFlightDtoResponse>> searchTicket(@Validated @RequestBody SearchFlightDtoRequest searchFlightDtoRequest,Pageable pageable) {

        Page<SearchFlightDtoResponse> searchFlightDtoResponses = service.getSearchFlightDtoResponses(searchFlightDtoRequest,pageable);
        return new ResponseEntity<>(searchFlightDtoResponses, HttpStatus.OK);
    }
}
