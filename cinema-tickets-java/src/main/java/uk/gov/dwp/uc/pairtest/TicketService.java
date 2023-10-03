package uk.gov.dwp.uc.pairtest;

import thirdparty.seatbooking.SeatReservationService;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

import java.util.Scanner;

public interface TicketService {



    void purchaseTickets(Long accountId, SeatReservationService seatReservationService, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

}

