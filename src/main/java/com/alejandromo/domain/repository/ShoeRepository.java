package com.alejandromo.domain.repository;

import java.util.List;
import java.util.Optional;
import com.alejandromo.domain.Shoe;

public interface ShoeRepository {
    List<Shoe> getAll();
    Optional<List<Shoe>> getByCategory(int idCategory);
    Optional<Shoe> getShoe(int idShoe);
    Shoe save(Shoe shoe);
    void delete(int idShoe);
}