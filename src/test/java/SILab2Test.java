import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void test_EveryStatement(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, ""));
        assertTrue(exception.getMessage().contains("allItems list can't be null!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("", 20, 150, 0.0)), ""));
        assertTrue(exception.getMessage().contains("Invalid item!"));

        assertEquals(6720.0, SILab2.checkCart(List.of(new Item("Computer", 15, 450, 0.0)), "0123456789763247"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Computer", 20, 450, 0.3)), "93285983985"));
        assertTrue(exception.getMessage().contains("Invalid card number!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Computer", 15, 450, 0.3)), "aleksandar@#4213"));
        assertTrue(exception.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    public void test_MultipleCondition(){

        assertEquals(6720.0, SILab2.checkCart(List.of(new Item("Computer", 15, 450, 0.0)), "0123456789763247"));

        assertEquals(1845.0, SILab2.checkCart(List.of(new Item("Computer", 15, 250, 0.5)), "0123456789763247"));

        assertEquals(3720.0, SILab2.checkCart(List.of(new Item("Computer", 15, 250, 0.0)), "0123456789763247"));

        assertEquals(1750.0, SILab2.checkCart(List.of(new Item("Computer", 7, 250, 0.0)), "0123456789763247"));
    }
}