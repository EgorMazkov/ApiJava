package org.example.customerdemo.repository;

import org.example.customerdemo.model.CustomerProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<CustomerProject, Long> {


    @Query(value = "select distinct cp from CustomerProject cp" +// todo ключевые слова лучше делать капсом
            " left join fetch cp.customerAttributes " +
            "left join fetch cp.customerGeometries " +// todo джойн нескольких коллекций влияет на производительность, лучше сдлеать поиск одной из коллекций другим запросом
            "where cp.id = :id")
    CustomerProject findAbobaById(@Param("id") Long id);// todo Aboba??? findById

}
