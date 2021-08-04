package entity;

import java.util.Comparator;
import java.util.Map;

public class Entity implements Comparator<Entity> {
   private Long id;
   private String value;

    public Entity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "entity.Entity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }


    @Override
    public int compare(Entity o1, Entity o2) {
        if (o1.id.equals(o2.id)) {
            return 0;
        }
        if (o1.id > o2.id) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
