package entity;

public class ResultEntity {
    private Long id;
    private String value1;
    private String value2;

    public ResultEntity(Long id, String value1, String value2) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "entity.ResultEntity{" +
                "id=" + id +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
