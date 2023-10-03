package uk.gov.dwp.uc.pairtest;
import org.junit.jupiter.api.Test;



class TicketServiceImplTest {

    @Test
    void testPurchaseTickets() {
        TicketServiceImpl t = new TicketServiceImpl();
        t.ticketPaymentService.makePayment(405, 50);
        t.seatReservationService.reserveSeat(405, 3);

    }

}