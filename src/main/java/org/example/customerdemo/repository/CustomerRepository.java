package org.example.customerdemo.repository;

import org.example.customerdemo.model.CustomerProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<CustomerProject, Long> {
    // todo ключевые слова лучше делать капсом DONE
    // todo джойн нескольких коллекций влияет на производительность, лучше сдлеать поиск одной из коллекций другим запросом DONE
    // todo Aboba??? findById DONE
    // TODO почему то при выполнение findByIdCustomerAttribute возвращается и customerGeometry ?

    @Query(value = "SELECT DISTINCT customerProject from CustomerProject customerProject " +
            "LEFT JOIN FETCH customerProject.customerAttributes " +
            "WHERE customerProject.id = :id")
    CustomerProject findByIdCustomerAttribute(@Param("id") Long id);

}
