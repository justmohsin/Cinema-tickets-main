# Cinema Ticking System (Java Solution)

## Tasks list

It is a DWP Coding exercise where I need to implements ticket service considering ***objective, business rules, constraints & assumptions***.

### Business Rules
 Implementation of a ***TicketService***
  - Clean Code, well-Tested and reusable.
   - Three types of tickets
     - Infant price £0.0, Child price £10.0, Adult Price £20.0
   - Multiple tickets can be bought
   - Max 20 tickets can be bought
   - Infants do not pay for tickets
   - Infants sit on an adult lap
   - Infant and child tickets cannot be purchased
### Constraints
  - ***TicketService*** interface cannot be modified.
  - The code in the thirdparty.* packages Cannot be modified.
  - The ***TicketTypeRequest*** should be an immutable object.

### Assumptions:

  - Accounts with an ID greater than zero are valid.
  - ***TicketPaymentService*** implementation works fine
  - Payments go through fine
  - ***SeatReservationService*** implementation works with no defects
  - Seat always reseved

# 1. Implementaion of code

Considering all the objectives, business rules, constraints & assumptions I implemented business logic in ***TicketServiceImpl.java*** file. 

Following are the list of tasks I took in order to implement the java solution 

## Algorithm of the Above issue

public interface TicketService {

void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

}

public class TicketTypeRequest {

- int infantTicPrice = 0
- int chileTicPrice = 10
- int adultTicPrice = 20

- int noOfInfant
- int noOfChild
- int noOfAdult

}

public class TicketServiceImpl implements TicketService {

TicketPaymentService ticketPaymentservice
SeatReservationService seatReservetionService


void purchaseTickets(Long accountId, TicketTypeRequest ttr) throws InvalidPurchaseException;

**// Child and Infant tickets cannot be purchased without purchasing an Adult ticket.**

**if ttr.noOfInfant > 0 or ttr.noOfChile > 0 andttr.noOfAdult == 0**

**${\color{red}Reject}$ ${\color{red}request}$**

**// Only a maximum of 20 tickets that can be purchased at a time.**

**if ttr.noOfchild + ttr.noOfAdult > 20**

**${\color{red}Reject}$ ${\color{red}request}$**


- ***int noOfChildticket = ttr.noOfChild***
- ***int noOfAdultTicket = ttr.noOfAdult***
- ***int totalAmount = 0***
-  ***totalAmount = ttr.noOfChild * ttr.childTicPrice + ttr.noOfAdult * ttr.adultTicPrice***

ticketPaymentService.pay(totalAmount)
seatREservationService.reserve(noOfChildTicket, noOfAdultTicket)
}
}

The above algo is implmented in **${\color{red}TicketServiceImpl.java}$** class and ${\color{red}accountId}$ with ${\color{red}totalAmount}$ sent to ticketPaymentService interface via makePayment method.  

**ticketPaymentService.makePayment(accountId, totalAmount);**

Also, number of tickets and seats to resver sent to seat resver interface via reserve seat method.

**seatReservationService.reserveSeat(noOfChildTicket, noOfAdultTicket);**

***The Above alogrithme is implemented in  TicketServiceImpl.java and the test class created under test/java/uk.dwp.uc.pairtest/TicketServiceImpltest.java***



