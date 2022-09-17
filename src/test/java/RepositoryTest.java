import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    Repository repository = new Repository();
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

    @Test
    public void addNewAndRemoveTicket() {
        repository.add(mowAerNordWings);
        repository.add(mowAerPobeda);
        repository.add(mowAerS7);
        repository.add(mowLedUtair);
        repository.removeById(mowLedUtair.getId());

        Ticket[] expected = {mowAerNordWings, mowAerPobeda, mowAerS7};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}