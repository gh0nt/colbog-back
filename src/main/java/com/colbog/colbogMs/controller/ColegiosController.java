package com.colbog.colbogMs.controller;

import com.colbog.colbogMs.dto.MessageDto;
import com.colbog.colbogMs.models.ColegiosEntity;
import com.colbog.colbogMs.service.ColegiosService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/colegios")
public class ColegiosController {

    @Autowired
    private ColegiosService colegiosService;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll() {
        var colegios= colegiosService.findAll();
        if(colegios == null){
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(colegios, HttpStatus.OK);
    }

    @GetMapping("/findall-page/{page}/{size}")
    public ResponseEntity<?> findPage(@PathVariable  int page, @PathVariable int size) {
        var colegios= colegiosService.findPage(page,size);
        if(colegios == null){
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(colegios, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MessageDto> save(@RequestBody ColegiosEntity colegio) {
        boolean response=colegiosService.save(colegio);
        if(response){
            return ResponseEntity.ok(new MessageDto(HttpStatus.OK,"Guardado con exito"));
        }
        return ResponseEntity.internalServerError().body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Guardando"));
    }

    @PostMapping("/update")
    public ResponseEntity<MessageDto> update(@RequestBody ColegiosEntity colegio) {
        boolean response=colegiosService.update(colegio);
        if(response){
            return ResponseEntity.ok(new MessageDto(HttpStatus.OK,"Actualizado con exito"));
        }
        return ResponseEntity.internalServerError().body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Actualizando"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) {
        boolean response = colegiosService.delete(id);
        if (response) {
            return ResponseEntity.ok(new MessageDto(HttpStatus.OK, "Eliminado con exito"));
        }
        return ResponseEntity.internalServerError().body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Eliminando"));
    }
    @GetMapping("/findFilter/{niveles}/{jornadas}/{especialidad}/{modelos_educativos}/{idiomas}/{calendario}/{discapacidades}/{prestador_de_servicio}")
    public ResponseEntity<?> findFilter(@PathVariable String niveles, @PathVariable String jornadas, @PathVariable String especialidad, @PathVariable String modelos_educativos, @PathVariable String idiomas, @PathVariable String calendario, @PathVariable String discapacidades, @PathVariable String prestador_de_servicio) {
        
        var colegios= colegiosService.findFilter(niveles, jornadas, especialidad, modelos_educativos, idiomas, calendario, discapacidades, prestador_de_servicio);
        if(colegios == null){
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(colegios, HttpStatus.OK);
    }

    @GetMapping("/find-niveles")
    public ResponseEntity<List<String>> findNiveles() {
       
        List<String> niveles = colegiosService.findNiveles();
        
        if(niveles == null){
            return new ResponseEntity<>(niveles, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(niveles, HttpStatus.OK);
        
    }

    @GetMapping("/find-jornadas")
    public ResponseEntity<List<String>> findJornadas() {
       
        List<String> jornadas = colegiosService.findJornadas();
        
        if(jornadas == null){
            return new ResponseEntity<>(jornadas, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jornadas, HttpStatus.OK);
        
    }

    @GetMapping("/find-especialidad")
    public ResponseEntity<List<String>> findEspecialidad() {
       
        List<String> especialidad = colegiosService.findEspecialidad();
        
        if(especialidad == null){
            return new ResponseEntity<>(especialidad, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(especialidad, HttpStatus.OK);
        
    }

    @GetMapping("/find-modeloseducativos")
    public ResponseEntity<List<String>> findModelosEducativos() {
       
        List<String> modeloseducativos = colegiosService.findModelosEducativos();
        
        if(modeloseducativos == null){
            return new ResponseEntity<>(modeloseducativos, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(modeloseducativos, HttpStatus.OK);
        
    }

    @GetMapping("/find-idiomas")
    public ResponseEntity<List<String>> findIdiomas() {
       
        List<String> idiomas = colegiosService.findIdiomas();
        
        if(idiomas == null){
            return new ResponseEntity<>(idiomas, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(idiomas, HttpStatus.OK);
        
    }

    @GetMapping("/find-calendario")
    public ResponseEntity<List<String>> findCalendario() {
       
        List<String> calendario = colegiosService.findCalendario();
        
        if(calendario == null){
            return new ResponseEntity<>(calendario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(calendario, HttpStatus.OK);
        
    }

    @GetMapping("/find-discapacidades")
    public ResponseEntity<List<String>> findDiscapacidades() {
       
        List<String> discapacidades = colegiosService.findDiscapacidades();
        
        if(discapacidades == null){
            return new ResponseEntity<>(discapacidades, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(discapacidades, HttpStatus.OK);
        
    }

    @GetMapping("/find-prestador")
    public ResponseEntity<List<String>> findPrestador() {
       
        List<String> prestador = colegiosService.findPrestador();
        
        if(prestador == null){
            return new ResponseEntity<>(prestador, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(prestador, HttpStatus.OK);
        
    }

}