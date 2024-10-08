package dao.entity;

public class PassengerEntity {
    private int id;
    private String fullName;

    public PassengerEntity(int id,String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "PassengerEntity{id=%d, fullName='%s'}".formatted(id, fullName);
    }
}
