/*
 * Name: Peyton Johnston
 * Course: CS 320
 * Assignment: Module Three Milestone - Contact Service
 * File: ContactTest.java
 * Description: Tests the Contact class requirements, including field limits and null checks.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void buildsContactWithValidData() {
        Contact contact = new Contact("PJ1001", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertEquals("PJ1001", contact.getContactId());
        assertEquals("Peyton", contact.getFirstName());
        assertEquals("Johnston", contact.getLastName());
        assertEquals("5735559090", contact.getPhone());
        assertEquals("22 Lake Road", contact.getAddress());
    }

    @Test
    public void rejectsNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Peyton", "Johnston", "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void rejectsContactIdLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CONTACT12345", "Peyton", "Johnston", "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void acceptsContactIdThatIsTenCharacters() {
        Contact contact = new Contact("1234567890", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    public void rejectsNullFirstNameInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1002", null, "Johnston", "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void rejectsFirstNameLongerThanTenCharactersInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1003", "PeytonJames", "Johnston", "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void rejectsNullFirstNameInSetter() {
        Contact contact = new Contact("PJ1004", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void rejectsFirstNameLongerThanTenCharactersInSetter() {
        Contact contact = new Contact("PJ1005", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("PeytonJames");
        });
    }

    @Test
    public void rejectsNullLastNameInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1006", "Peyton", null, "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void rejectsLastNameLongerThanTenCharactersInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1007", "Peyton", "JohnstonLong", "5735559090", "22 Lake Road");
        });
    }

    @Test
    public void rejectsNullLastNameInSetter() {
        Contact contact = new Contact("PJ1008", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void rejectsLastNameLongerThanTenCharactersInSetter() {
        Contact contact = new Contact("PJ1009", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("JohnstonLong");
        });
    }

    @Test
    public void rejectsNullPhoneInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1010", "Peyton", "Johnston", null, "22 Lake Road");
        });
    }

    @Test
    public void rejectsPhoneShorterThanTenDigitsInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1011", "Peyton", "Johnston", "57355", "22 Lake Road");
        });
    }

    @Test
    public void rejectsPhoneLongerThanTenDigitsInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1012", "Peyton", "Johnston", "57355590901", "22 Lake Road");
        });
    }

    @Test
    public void rejectsPhoneWithLettersInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1013", "Peyton", "Johnston", "573555ABCD", "22 Lake Road");
        });
    }

    @Test
    public void rejectsNullPhoneInSetter() {
        Contact contact = new Contact("PJ1014", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    public void rejectsPhoneThatIsNotTenDigitsInSetter() {
        Contact contact = new Contact("PJ1015", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("57355");
        });
    }

    @Test
    public void rejectsPhoneWithLettersInSetter() {
        Contact contact = new Contact("PJ1016", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("573555ABCD");
        });
    }

    @Test
    public void rejectsNullAddressInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1017", "Peyton", "Johnston", "5735559090", null);
        });
    }

    @Test
    public void rejectsAddressLongerThanThirtyCharactersInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("PJ1018", "Peyton", "Johnston", "5735559090",
                    "This address is longer than thirty characters");
        });
    }

    @Test
    public void rejectsNullAddressInSetter() {
        Contact contact = new Contact("PJ1019", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void rejectsAddressLongerThanThirtyCharactersInSetter() {
        Contact contact = new Contact("PJ1020", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is longer than thirty characters");
        });
    }

    @Test
    public void updatesValidContactFields() {
        Contact contact = new Contact("PJ1021", "Peyton", "Johnston", "5735559090", "22 Lake Road");

        contact.setFirstName("PJ");
        contact.setLastName("Beats");
        contact.setPhone("4175551212");
        contact.setAddress("99 Main St");

        assertEquals("PJ", contact.getFirstName());
        assertEquals("Beats", contact.getLastName());
        assertEquals("4175551212", contact.getPhone());
        assertEquals("99 Main St", contact.getAddress());
    }
}