public class Student {
    private int id;
    private String name, ac_nonAc;
    private int number_of_bed, room_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBed() {
        return number_of_bed;
    }

    public void setBed(int number_of_bed) {
        this.number_of_bed = number_of_bed;
    }

    public int getRoom() {
        return room_number;
    }

    public void setRoom(int room_number) {
        this.room_number = room_number;
    }

    public String getAc() {
        return ac_nonAc;
    }

    public void setAc(String ac_nonAc) {
        this.ac_nonAc = ac_nonAc;
    }
}
