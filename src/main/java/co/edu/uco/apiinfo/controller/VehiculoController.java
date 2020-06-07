package co.edu.uco.apiinfo.controller;

import co.edu.uco.apiinfo.entity.Vehiculo;
import co.edu.uco.apiinfo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("control-vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/{placa}/vehivulo")
    public Vehiculo findById(@PathVariable String placa){
        return vehiculoService.findById(placa);
    }

    @PostMapping("/vehiculo")
    public void insert(@RequestBody Vehiculo vehiculo){
        vehiculoService.insert(vehiculo);
    }

    @PutMapping("/{placa}/vehiculo")
    public void update(@RequestBody Vehiculo vehiculo, @PathVariable String placa){
        vehiculoService.update(vehiculo, placa);
    }

    @DeleteMapping("/{placa}/vehiculo")
    public void delete(@PathVariable String placa){
        vehiculoService.delete(placa);
    }

    @GetMapping("/vehivulos")
    public List<Vehiculo> list(){
        return vehiculoService.findAll();
    }
}
