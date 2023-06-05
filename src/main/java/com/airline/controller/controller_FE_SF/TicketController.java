package com.airline.controller.controller_FE_SF;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("api/ticket")
public class TicketController {

    public ResponseEntity<?> showingTicket(@Param(""))

}
