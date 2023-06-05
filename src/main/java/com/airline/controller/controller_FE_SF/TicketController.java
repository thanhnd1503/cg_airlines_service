package com.airline.controller.controller_FE_SF;

import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.service.SearchTicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class TicketController {
    @Autowired
    private SearchTicketService service;
    @PostMapping("/search")
    public ResponseEntity<?> searchTicket(@Validated @RequestBody SearchTicketDtoRequest searchTicketDtoRequest) {
        List<SearchTicketDtoResponse> searchTicketDtoResponses = service.getSearchTicketDtoResponses(searchTicketDtoRequest);
        return new ResponseEntity<>(searchTicketDtoResponses, HttpStatus.OK);
    }
}
