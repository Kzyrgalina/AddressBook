import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook addressBook;
    

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        addressBook.add("Иванов", new Address("Виноградная", 12, 1));
        addressBook.add("Петров", new Address("Садовая", 3, 17));
        addressBook.add("Козлова", new Address("Виноградная", 9, 11));
        addressBook.add("Найденова", new Address("Космонавтов", 102, 2));
        addressBook.add("Костин", new Address("Виноградная", 12, 71));
        addressBook.add("Андреева", new Address("Ленина", 52, 90));
        /*люди на одной улице: Иванов, Козлова, Костин - Виноградная
          люди в одном доме: Иванов, Костин - Виноградная, 12*/

    }

    @Test
    void add() { //Добавление пары человек-адрес

        assertNull(addressBook.getAddress("Сидоров"));
        Address address = new Address("1-я Линия", 98, 22);
        addressBook.add("Сидоров", address);
        assertNotNull(addressBook.getAddress("Сидоров"));
    }

    @Test
    void delete() { //Удаление человека

        assertNotNull(addressBook.getAddress("Найденова"));
        addressBook.delete("Найденова");
        assertNull(addressBook.getAddress("Найденова"));
    }

    @Test
    void editAddress() {  //Изменение адреа человека

        Address addressBefore = new Address("Садовая", 3, 17);
        assertEquals(addressBook.getAddress("Петров"), addressBefore);
        Address addressAfter = new Address("Кантемировская", 8, 13);
        addressBook.editAddress("Петров", addressAfter);
        assertEquals(addressAfter, addressBook.getAddress("Петров"));
    }

    @Test
    void getAddress() { //Получение адреса человека
        Address addressTrue = new Address("Ленина", 52, 90);
        assertEquals(addressTrue, addressBook.getAddress("Андреева"));
        Address addressFalse = new Address("Российская", 32, 73);
        addressBook.editAddress("Андреева", addressFalse);
        assertNotEquals(addressTrue, addressBook.getAddress("Андреева"));
    }

    @Test
    void getSurnamesByStreet() {  //Получение списка людей, живущих на заданной улице.

        ArrayList<String> addressStreet = new ArrayList<String>();
        addressStreet.add("Иванов");
        addressStreet.add("Козлова");
        addressStreet.add("Костин");
        assertEquals(addressStreet, addressBook.getSurnamesByStreet("Виноградная"));
    }

    @Test
    void getSurnamesByHouse() {//Получение списка людей, живущих в заданном доме

        ArrayList<String> addressHouse = new ArrayList<String>();
        addressHouse.add("Иванов");
        addressHouse.add("Костин");
        assertEquals(addressHouse, addressBook.getSurnamesByHouse("Виноградная", 12));

    }
}