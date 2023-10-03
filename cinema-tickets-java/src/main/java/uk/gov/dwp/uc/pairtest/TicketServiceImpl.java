package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentService;
import thirdparty.seatbooking.SeatReservationService;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */

    TicketPaymentService ticketPaymentService;
    SeatReservationService seatReservationService;


    @Override
    public void purchaseTickets(Long accountId, SeatReservationService seatReservationService,  uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {

    }

    public static class TicketTypeRequest {

        int infantTicPrice = 0;
        int childTicPrice = 10;
        int adultTicPrice = 20;

        int noOfInfant;
        int noOfChild;
        int noOfAdult;

    }

    public void purchaseTickets(Long accountId, TicketTypeRequest ttr) throws InvalidPurchaseException {

        // child and infant ticket cannot be purchased without purchasing an adult ticket
        if (ttr.noOfInfant > 0  || ttr.noOfChild > 0 && ttr.noOfAdult == 0){
            System.out.println("Infant and child tickets cannot be purchased without Adult ticket. Please buy Adult ticket first");
            throw new InvalidPurchaseException();
        }
        // maximum of 20 tickets can bee purchased at a time.
        if (ttr.noOfChild + ttr.noOfAdult > 20) {
            System.out.println("You cannot buy more than 20 tickets at a same time.");
            throw new InvalidPurchaseException();
        }
        // calculating total amount of adult and child tickets and sending to payment service

        int noOfChildTicket = ttr.noOfChild;
        int noOfAdultTicket = ttr.noOfAdult;
        int totalAmount = 0;
        totalAmount = (ttr.noOfChild * ttr.childTicPrice) + (ttr.noOfAdult * ttr.adultTicPrice);

        // sending account id and total amount to Ticket payment service for payment
        ticketPaymentService.makePayment(accountId, totalAmount);

        // sending number of children and adults to reserve seats.
        seatReservationService.reserveSeat(noOfChildTicket, noOfAdultTicket);
        }


    }

