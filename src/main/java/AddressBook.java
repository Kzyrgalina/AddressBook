import java.util.ArrayList;
import java.util.HashMap;

/** Хранит список адресов различных людей.
 * Адрес состоит из улицы, номера дома и номера квартиры.
 * Человек задается фамилией, для каждого человека хранится лишь один адрес.
 * Методы:
 * 1) Добавление пары человек-адрес
 * 2) Удаление человека.
 * 3) Изменение адреа человека.
 * 4) Получение адреса человека.
 * 5) Получение списка людей, живущих на заданной улице.
 * 6) Получение списка людей, живущих в заданном доме
 * */
public class AddressBook {
    private HashMap<String, Address> book;

    public AddressBook() {
        book = new HashMap<String, Address>();
    }

    //Добавление пары человек-адрес
    public void add (String surname, Address address) {
        book.put(surname, address);
    }

    //Удаление человека
    public void delete (String surname){
        book.remove(surname);
    }

    //Изменение адреа человека
    public void editAddress(String surname, Address newAddress) {
        book.put(surname, newAddress);
    }

    //Получение адреса человека
    public Address getAddress (String surname){
        return book.get(surname);
    }


    //Получение списка людей, живущих на заданной улице.
    public ArrayList<String> getSurnamesByStreet(String street){
        ArrayList<String> out = new ArrayList<String>();

        for (String surname : book.keySet()) {
            if (book.get(surname).getStreet().equalsIgnoreCase(street)) {
                out.add(surname);
            }
        }
        return out;
    }


    //Получение списка людей, живущих в заданном доме
    public ArrayList<String> getSurnamesByHouse(String street, int house){
        ArrayList<String> out = new ArrayList<String>();

        ArrayList<String> allOnTheStreet = getSurnamesByStreet(street);
        for (String surname : allOnTheStreet) {
            if (book.get(surname).getHome() == house) {
                out.add(surname);
            }
        }
        return out;
    }

}
