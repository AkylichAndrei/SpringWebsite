package com.example.demo.repos;

import com.example.demo.enums.Type;
import com.example.demo.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<ItemModel,Long> { //CrudRepository убрали

    List<ItemModel> findAllByType(Type type);
}
