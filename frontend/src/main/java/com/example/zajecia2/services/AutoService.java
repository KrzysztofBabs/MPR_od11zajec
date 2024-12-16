package com.example.zajecia2.services;

import com.example.zajecia2.exceptions.*;
import com.example.zajecia2.model.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



//@Component
@Service
public class AutoService{
    private RestClient restClient;
    private StringUtilsService stringUtilsService;


//    @Autowired
    public AutoService() {
        this.restClient = RestClient.create("http://localhost:8081/");



    }

//    public Optional<Auto> getById(Long id){
//        return this.repository.findById(id);
//    }

    public List<Auto> getAll(){
        List<Auto> autoList = restClient.get()
                .uri("auta/all")
                .retrieve().body(new ParameterizedTypeReference<List<Auto>>() {});
        return autoList;
    }

    public void create(Auto auto){
        ResponseEntity<Void> response = this.restClient.post()
                .uri("/autoo/dodaj")
                .body(auto)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toBodilessEntity();
    }


    public List<Auto> getByModel(String model){
        List<Auto> autoList = restClient.get()
                .uri("/auto/model/{model}")
                .retrieve().body(new ParameterizedTypeReference<List<Auto>>() {});
        return autoList;
    }

    public List<Auto> getByRokProdukcji(int rokProdukcji){
        List<Auto> autoList = restClient.get()
                .uri("/auto/rokProdukcji/{rokProdukcji}")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Auto>>() {});
        return autoList;
    }




    public void delete(String model){
        ResponseEntity<Void> response = this.restClient.post()
                .uri("/auto/usun/{model}")
                .body(model)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toBodilessEntity();


    }

//    public void add(Auto auto){
//        auto.setIdentyfikator();//potrzebne do testu ID
//        this.repository.save(new Auto(auto.getModel(), auto.getRokProdukcji()));
//
//    }

    //zajecia5
//    public void addupper(Auto auto){
//        this.repository.save(new Auto(stringUtilsService.upper(auto.getModel()), auto.getRokProdukcji()));
//    }
//    public void addlower(Auto auto){
//        this.repository.save(new Auto(stringUtilsService.lower(auto.getModel()), auto.getRokProdukcji()));
//    }
//
//    public List<Auto> getFirstLetterBiggerRestLower(){
//
//        List<Auto> all = this.repository.findAll();
//        for(Auto auto : all){
//            auto.setModel(stringUtilsService.firstBigger(auto.getModel()));
//        }
//        return all;
//    }
//    // zajecia 5 koniec
//
//    public void update(Auto auto){
//        Long id = auto.getId();
//        String model = auto.getModel();
//        int rokProdukcji = auto.getRokProdukcji();
//        Optional<Auto> car = this.repository.findById(id);
//        if(car.isPresent()){
//            Auto noweAuto = car.get();
//            noweAuto.setModel(model);
//            noweAuto.setRokProdukcji(rokProdukcji);
//            noweAuto.setIdentyfikator();
//            this.repository.save(noweAuto);
//        }
//        else{
//            System.out.println("nie podano dobrego id!");
//        }
//
//    }
//
//    //zajecia6
//
//    public Optional<Auto> getById(Long id){
//        Optional<Auto> auto = this.repository.findById(id);
//        if(auto.isEmpty()){
//            throw new NotFoundException();
//        }
//        else{
//            return Optional.of(auto.get());
//        }
//
//    }
//
//    public void add(Auto auto){
//        auto.setIdentyfikator();//potrzebne do testu ID
//        List<Auto> autoZIdentyfikatorem = this.repository.findByIdentyfikator(auto.getIdentyfikator());
//        if(autoZIdentyfikatorem.isEmpty()){
//            this.repository.save(auto);
//        } else {
//            throw new CarAlreadyExistsException();
//        }
//
//    }
//
//    public void DeleteAuto(String model){
////        List<Auto> a = this.repository.findByModel(model); to usuwalo tylko jedna toyote
//
//        //to usuwa np wszytskie toyoty z repozytorium
//        List<Auto> auto=  this.repository.findAll().stream().filter(a->a.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
//        if(auto.isEmpty()){
//            throw new CantDeleteAuto_NotFoundException();
//        }
//        this.repository.deleteAll(auto);
////        this.repository.deleteById();
//    }
//
//    public void Update(Auto auto){
//        Long id = auto.getId();
//        String model = auto.getModel();
//        int rokProdukcji = auto.getRokProdukcji();
//        Optional<Auto> car = this.repository.findById(id);
//        if(car.isPresent()){
//            Auto noweAuto = car.get();
//            noweAuto.setModel(model);
//            noweAuto.setRokProdukcji(rokProdukcji);
//            noweAuto.setIdentyfikator();
//            this.repository.save(noweAuto);
//        }
//        else{
//            throw new CantUpdateAuto_NotFoundException();
//        }
//
//    }
//
//    public void Add(Auto auto){
//        if(auto.getModel()==null || auto.getModel().isEmpty()){
//            throw new CantAddAuto_IncorrectData("nie ma podanego modelu");
//        }
//
//        else if(auto.getRokProdukcji()==0){
//            throw new CantAddAuto_IncorrectData("nie ma roku produkcji!");
//        }
//
//            else{
//                auto.setIdentyfikator();
//                this.repository.save(auto);
//
//            }
//        }
//
////    zajecia7
//
//    public Auto findById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Object with ID " + id + " not found"));
//    }
//
////    public Auto findById(Long id) {
////        Optional<Auto> optionalAuto = repository.findById(id);
////        if (optionalAuto.isPresent()) {
////            return optionalAuto.get();
////        } else {
////            throw new IllegalArgumentException("Auto with ID " + id + " not found");
////        }
////    }
//
//    // zajecia9
//
//    // usuneicie po id w formularzu
//    public void deleteAutoById(Long id){
//        Optional<Auto> auto = this.repository.findById(id);
//        this.repository.delete(auto.get());
//    }
//
//
//
    }










