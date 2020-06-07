package co.edu.uco.apiinfo.service;

import co.edu.uco.apiinfo.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {


    Vehiculo findById(String placa);

    void insert(Vehiculo vehiculo);

    void update(Vehiculo vehiculo, String placa);

    void delete(String placa);

    List<Vehiculo> findAll();
}
