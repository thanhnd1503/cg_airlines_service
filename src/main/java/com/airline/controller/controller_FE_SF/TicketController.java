package com.airline.controller.controller_FE_SF;

import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getService(@PathVariable("id") Long id) {
       TicketDtoRes res = ticketService.getTicketDtoResById(id);
        if (res==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(res);
    }
}
