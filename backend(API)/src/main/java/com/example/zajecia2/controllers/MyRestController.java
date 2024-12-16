package com.example.zajecia2.controllers;

import com.example.zajecia2.model.Auto;
import com.example.zajecia2.services.AutoService;
import com.example.zajecia2.services.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;




import static javax.print.DocFlavor.URL.PDF;


@RestController

public class MyRestController {

    private AutoService autoService;
    @Autowired

    public MyRestController(AutoService autoService){
        this.autoService= autoService;
    }

    // wyswietlenie aut z repozytorium
    @GetMapping("/auta/zRepo")
    public List<Auto> WyswietlAuta(){
        return autoService.getAll();
    }




    // wyszukanie auta po ID z repozytorium
//    @GetMapping("/auto/id/{id}")
//    public Optional<Auto> GetById(@PathVariable Long id){
//        return autoService.getById(id);
//    }


    // wyszukanie auta po modelu z repozytorium
    @GetMapping("/auto/model/{model}")
    public List<Auto> GetByModel(@PathVariable String model){
        return autoService.getByModel(model);
    }


    // wyszukanie auta po roku produkcji z repozytorium
    @GetMapping("/auto/rokProdukcji/{rokProdukcji}")
    public List<Auto> GetByRokProdukcji(@PathVariable int rokProdukcji){
        return autoService.getByRokProdukcji(rokProdukcji);
    }


    // usniecie auta z repozytorium
    @DeleteMapping("/auto/usun/{model}")
    public void usunAuto(@PathVariable String model){
        autoService.delete(model);
    }


    // dodanie auta do repozytorium
//    @PostMapping("/auto/dodaj")
//    public void dodajAuto(@RequestBody Auto auto){
//        autoService.add(auto);
//    }

    // aktualizacja auto z repozytorium po ID
    @PatchMapping("/auto/update")
    public void aktualizujAuto(@RequestBody Auto auto){
        autoService.update(auto);
    }



    //zajecia5

    //zamiana na duze litery
    @PostMapping("/auto/dodajj")
    public void dodajAutoDuzeLitery(@RequestBody Auto auto){
        autoService.addupper(auto);
    }


    //zamiana na male litery
    @PostMapping("/auto/dodajjj")
    public void dodajAutoMaleLitery(@RequestBody Auto auto){
        autoService.addlower(auto);
    }

    //pierwsza duza reszta male
    @GetMapping("/auta/zRepoo")
    public List<Auto> WyswietlAutaa(){
        return autoService.getFirstLetterBiggerRestLower();
    }




    // zajecia6

    @GetMapping("auta/all")
    public ResponseEntity<List<Auto>> wyswietlAuta(){
        return new ResponseEntity<>(autoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/autoo/id/{id}")
    public ResponseEntity<Optional<Auto>> GetById(@PathVariable Long id){
        return new ResponseEntity<>(autoService.getById(id),HttpStatus.OK);
    }


    @PostMapping("/autoo/dodaj")
    public ResponseEntity<Auto> dodajAuto(@RequestBody Auto auto){
        autoService.add(auto);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    aktualizacja po id. Wszytsko inne sie zmienia
    @PutMapping("/autko/update")
    public ResponseEntity<Auto> AktualizujAuto(@RequestBody Auto auto){
        autoService.Update(auto);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/auto/usunn/{model}")
    public ResponseEntity<Auto> usunAutoo(@PathVariable String model){
        autoService.DeleteAuto(model);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/Auto/dodaj")
    public ResponseEntity<Auto> DDodajAuto(@RequestBody Auto auto){
        autoService.Add(auto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    zajecia7

    @GetMapping("/auto/wyszukaj/poID/{id}/pdf")

    public ResponseEntity<byte[]> getObjectPdf(@PathVariable Long id) {
        try {
            Auto auto = autoService.findById(id);
            byte[] pdfBytes = PDFGenerator.generatePdf(auto);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=auto_" + id + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

























}
