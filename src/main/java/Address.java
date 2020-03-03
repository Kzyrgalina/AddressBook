public class Address {
    private String street;
    private int house;
    private int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }


    public String getStreet() {
        return street;
    }

    public int getHome() {
        return house;
    }

    public int getRoom() {
        return flat;
    }

    /*public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int house) {
        this.house = house;
    }

    public void setRoom(int flat) {
        this.flat = flat;
    }*/


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Address){
            Address otherAddress = (Address) obj;
            return otherAddress.getStreet().equals(getStreet()) && otherAddress.getRoom() == getRoom()
                    && otherAddress.getHome() == getHome();
        }
        return false;
    }
}
