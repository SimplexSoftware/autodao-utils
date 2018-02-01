package ru.simplex_software.entity;

import net.sf.autodao.PersistentEntity;
import org.hibernate.Hibernate;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Class with id of type String.
 */
@MappedSuperclass
public class StringIdPersistentEntity implements PersistentEntity<String> {

    @Id
    private String id;

    public String getPrimaryKey() {
        return id;
    }

    @Override
    public int hashCode() {
        if(id==null){
            return 0;
        }else{
            return id.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof StringIdPersistentEntity){
            StringIdPersistentEntity pe = (StringIdPersistentEntity) obj;

            if(id==null) {
                return false;
            }

            if (!Hibernate.getClass(this).equals(Hibernate.getClass(pe))) {
                return false;
            }

            return id.equals(pe.getId());

        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return getClass().getName()+"{id = "+id+"}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
