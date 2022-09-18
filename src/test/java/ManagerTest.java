import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ManagerTest {

    Ticket mowLedPobeda = new Ticket(1, 1260, "MOW", "LED", 90);
    Ticket mowLedS7 = new Ticket(2, 2100, "MOW", "LED", 95);
    Ticket mowLedUtair = new Ticket(3, 1495, "MOW", "LED", 80);
    Ticket mowLedUral = new Ticket(4, 1950, "MOW", "LED", 80);
    Ticket mowLedNordWings = new Ticket(5, 1999, "MOW", "LED", 95);

    Ticket ledMowPobeda = new Ticket(6, 1260, "LED", "MOW", 95);
    Ticket ledMowS7 = new Ticket(7, 3500, "LED", "MOW", 95);
    Ticket ledMowUtair = new Ticket(8, 1895, "LED", "MOW", 95);
    Ticket ledMowUral = new Ticket(9, 2440, "LED", "MOW", 90);
    Ticket ledMowNordWings = new Ticket(10, 1779, "LED", "MOW", 85);

    Ticket mowAerPobeda = new Ticket(11, 2574, "MOW", "AER", 220);
    Ticket mowAerS7 = new Ticket(12, 4200, "MOW", "AER", 225);
    Ticket mowAerNordWings = new Ticket(13, 4004, "MOW", "AER", 230);

    Ticket aerMowPobeda = new Ticket(14, 10174, "AER", "MOW", 220);
    Ticket aerMowS7 = new Ticket(15, 17725, "AER", "MOW", 225);
    Ticket aerMowNordWings = new Ticket(15, 11354, "AER", "MOW", 235);

    Ticket ledAerPobeda = new Ticket(16, 3336, "LED", "AER", 265);
    Ticket ledAerUral = new Ticket(17, 3535, "LED", "AER", 305);
    Ticket ledAerNordWings = new Ticket(18, 3535, "LED", "AER", 285);

    Ticket aerLedPobeda = new Ticket(19, 19285, "AER", "LED", 265);
    Ticket aerLedUral = new Ticket(20, 16285, "AER", "LED", 305);
    Ticket aerLedNordWings = new Ticket(21, 18315, "AER", "LED", 285);

    Repository repository = new Repository();
    Manager manager = new Manager(repository);


    @Test //тест проверки работы поиска, найдено 5 билетов, включена сортировка по возрастанию стоимости билета
    public void shouldFindTicketsLedMow() {
        manager.add(mowAerNordWings);
        manager.add(mowAerS7);
        manager.add(mowAerPobeda);
        manager.add(mowLedPobeda);
        manager.add(mowLedNordWings);
        manager.add(mowLedS7);
        manager.add(mowLedUral);
        manager.add(mowLedUtair);
        manager.add(ledAerNordWings);
        manager.add(ledAerPobeda);
        manager.add(ledAerUral);
        manager.add(ledMowPobeda);
        manager.add(ledMowNordWings);
        manager.add(ledMowS7);
        manager.add(ledMowUtair);
        manager.add(ledMowUral);
        manager.add(aerLedNordWings);
        manager.add(aerLedPobeda);
        manager.add(aerLedUral);
        manager.add(aerMowNordWings);
        manager.add(aerMowPobeda);
        manager.add(aerMowS7);


        Ticket[] expected = manager.searchBy("LED", "MOW");
        Ticket[] actual = {ledMowPobeda, ledMowNordWings, ledMowUtair, ledMowUral, ledMowS7};
//        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

        @Test //тест проверки поиска билетов, когда не найдено по нужному направлению
    public void shouldFindTicketsMowBqs() {
        manager.add(mowAerNordWings);
        manager.add(mowAerS7);
        manager.add(mowAerPobeda);
        manager.add(mowLedPobeda);
        manager.add(mowLedNordWings);
        manager.add(mowLedS7);
        manager.add(mowLedUral);
        manager.add(mowLedUtair);
        manager.add(ledAerNordWings);
        manager.add(ledAerPobeda);
        manager.add(ledAerUral);
        manager.add(ledMowPobeda);
        manager.add(ledMowNordWings);
        manager.add(ledMowS7);
        manager.add(ledMowUtair);
        manager.add(ledMowUral);
        manager.add(aerLedNordWings);
        manager.add(aerLedPobeda);
        manager.add(aerLedUral);
        manager.add(aerMowNordWings);
        manager.add(aerMowPobeda);
        manager.add(aerMowS7);

        Ticket[] expected = manager.searchBy("MOW", "BQS");
        Ticket[] actual = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест проверки поиска билетов, когда найден только один билет
    public void shouldFindTicketsAerMow() {
        manager.add(mowAerNordWings);
        manager.add(mowAerS7);
        manager.add(mowAerPobeda);
        manager.add(mowLedPobeda);
        manager.add(mowLedNordWings);
        manager.add(mowLedS7);
        manager.add(mowLedUral);
        manager.add(mowLedUtair);
        manager.add(ledAerNordWings);
        manager.add(ledAerPobeda);
        manager.add(ledAerUral);
        manager.add(ledMowPobeda);
        manager.add(ledMowNordWings);
        manager.add(ledMowS7);
        manager.add(ledMowUtair);
        manager.add(ledMowUral);
        manager.add(aerLedNordWings);
        manager.add(aerLedPobeda);
        manager.add(aerLedUral);
        manager.add(aerMowS7);

        Ticket[] expected = manager.searchBy("AER", "MOW");
        Ticket[] actual = {aerMowS7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //тест проверки правильности поиска билета. запрос проходит
    public void shouldFindTicketsLedMowMatchesMethod() {
        manager.add(mowAerNordWings);
        manager.add(mowAerS7);
        manager.add(mowAerPobeda);
        manager.add(mowLedPobeda);
        manager.add(mowLedNordWings);
        manager.add(mowLedS7);
        manager.add(mowLedUral);
        manager.add(mowLedUtair);
        manager.add(ledAerNordWings);
        manager.add(ledAerPobeda);
        manager.add(ledAerUral);
        manager.add(ledMowPobeda);
        manager.add(ledMowNordWings);
        manager.add(ledMowS7);
        manager.add(ledMowUtair);
        manager.add(ledMowUral);
        manager.add(aerLedNordWings);
        manager.add(aerLedPobeda);
        manager.add(aerLedUral);
        manager.add(aerMowNordWings);
        manager.add(aerMowPobeda);
        manager.add(aerMowS7);

        boolean actual = manager.matches(ledMowUral, "LED", "MOW");
        boolean expected = (true);

        Assertions.assertEquals(expected, actual);
    }

    @Test //тест проверки правильности поиска билета. запрос не проходит
    public void shouldFindTicketsLedBqsMatchesMethod() {
        manager.add(mowAerNordWings);
        manager.add(mowAerS7);
        manager.add(mowAerPobeda);
        manager.add(mowLedPobeda);
        manager.add(mowLedNordWings);
        manager.add(mowLedS7);
        manager.add(mowLedUral);
        manager.add(mowLedUtair);
        manager.add(ledAerNordWings);
        manager.add(ledAerPobeda);
        manager.add(ledAerUral);
        manager.add(ledMowPobeda);
        manager.add(ledMowNordWings);
        manager.add(ledMowS7);
        manager.add(ledMowUtair);
        manager.add(ledMowUral);
        manager.add(aerLedNordWings);
        manager.add(aerLedPobeda);
        manager.add(aerLedUral);
        manager.add(aerMowNordWings);
        manager.add(aerMowPobeda);
        manager.add(aerMowS7);

        boolean actual = manager.matches(ledMowUral, "LED", "BQS");
        boolean expected = (false);

        Assertions.assertEquals(expected, actual);
    }


}