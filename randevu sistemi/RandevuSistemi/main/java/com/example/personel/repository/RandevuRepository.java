package com.example.personel.repository;

import com.example.personel.entity.RandevularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.yaml.snakeyaml.events.Event;

public interface RandevuRepository extends JpaRepository<RandevularEntity,Long> {
    public abstract <T> java.util.Optional<T> findById(Event.ID id );

    @NoRepositoryBean
    public interface CrudRepository<T, ID>
            extends org.springframework.data.repository.Repository<T, ID> {
        public abstract void deleteById(     ID id );
    }


}



