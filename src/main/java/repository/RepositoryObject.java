package repository;

import lombok.Data;

@Data
public class RepositoryObject {


    private final Integer id;
    private final String date;
    private final String time;
    private final String code;

    public RepositoryObject(Integer id, String date, String time, String code) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Record ID= " + id +
                ", date= " + date +
                ", time= " + time +
                ", code= " + code;

    }
}
