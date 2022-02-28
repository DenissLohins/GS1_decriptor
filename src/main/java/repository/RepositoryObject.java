package repository;

import java.util.Objects;

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
        return  "Record ID=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", code='" + code + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryObject that = (RepositoryObject) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, code);
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCode() {
        return code;
    }
}
