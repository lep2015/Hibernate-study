package org.lep.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lvep on 2016/3/20.
 */
@Entity
public class User {
    @EmbeddedId // 联合主键
//    @AttributeOverride(name="firstName", column=@Column(name="fld_firstname")) // 覆盖定义中的属性名称和列名称
    UserId id;
    Integer age;

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

@Embeddable
class UserId implements Serializable {
    String firstName;
    String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserId userId = (UserId) o;

        if (firstName != null ? !firstName.equals(userId.firstName) : userId.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(userId.lastName) : userId.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}