package study.dddstart.domain;

public class Receiver {

    private String name;
    private String phone;

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
