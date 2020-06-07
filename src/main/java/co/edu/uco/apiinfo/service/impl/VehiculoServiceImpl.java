package co.edu.uco.apiinfo.service.impl;


import co.edu.uco.apiinfo.entity.Vehiculo;
import co.edu.uco.apiinfo.exception.NoExisteException;
import co.edu.uco.apiinfo.repository.VehiculoRepository;
import co.edu.uco.apiinfo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    private static final String VEHICULO_NO_EXISTE = "El vehículo no exite";

    @Override
    public Vehiculo findById(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findById(placa).orElse(null);
        vehiculoExiste(vehiculo);
        return vehiculo;
    }

    private void vehiculoExiste(Vehiculo vehiculo) {
        if(vehiculo == null){
            throw new NoExisteException(VEHICULO_NO_EXISTE);
        }
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void update(Vehiculo vehiculo, String placa) {
        Vehiculo vehiculoConsultado = findById(placa);
        vehiculoConsultado.setColor(vehiculo.getColor());
        vehiculoConsultado.setMarca(vehiculo.getMarca());
        vehiculoConsultado.setModelo(vehiculo.getMarca());
        vehiculoRepository.save(vehiculoConsultado);
    }

    @Override
    public void delete(String placa) {
        Vehiculo vehiculo = findById(placa);
        vehiculoRepository.delete(vehiculo);
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }
}
