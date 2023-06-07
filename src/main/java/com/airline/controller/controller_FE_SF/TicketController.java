package com.airline.controller.controller_FE_SF;

import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.service.SearchTicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<SearchTicketDtoResponse>> searchTicket(@Validated @RequestBody SearchTicketDtoRequest searchTicketDtoRequest,
                                                                      @RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "ticketPrice,asc") String[] sort) {
        Sort.Direction direction = Sort.Direction.ASC; // Mặc định sắp xếp tăng dần
        String sortField = "ticketPrice"; // Mặc định sắp xếp theo trường ticketPrice

        if (sort.length >= 2) {
            sortField = sort[0]; // Lấy trường sắp xếp từ phần tử đầu tiên của mảng
            if ("desc".equalsIgnoreCase(sort[1])) {
                direction = Sort.Direction.DESC; // Nếu phần tử thứ hai là "desc", sắp xếp giảm dần
            }
        }
        Pageable pageable = PageRequest.of(page, size, direction, sortField);
        Page<SearchTicketDtoResponse> searchTicketDtoResponses = service.getSearchTicketDtoResponses(searchTicketDtoRequest, pageable);
        return new ResponseEntity<>(searchTicketDtoResponses, HttpStatus.OK);
    }
}
