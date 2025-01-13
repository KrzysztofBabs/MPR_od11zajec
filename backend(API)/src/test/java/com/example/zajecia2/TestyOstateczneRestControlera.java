package com.example.zajecia2;

import com.example.zajecia2.controllers.MyRestController;
import com.example.zajecia2.model.Auto;
import com.example.zajecia2.services.AutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@WebMvcTest(MyRestController.class)
public class TestyOstateczneRestControlera {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AutoService mockAutoService;

    @Test
    public void testWyswietlAuta1() {

        AutoService mockAutoService = mock(AutoService.class);

        Auto auto1 = new Auto( "Toyota", 1999);
        Auto auto2 = new Auto( "Honda", 2000);
        List<Auto> mockAuta = Arrays.asList(auto1, auto2);
        when(mockAutoService.getAll()).thenReturn(mockAuta);

        MyRestController myRestController = new MyRestController(mockAutoService);
        List<Auto> wynik = myRestController.wyswietlAuta1();

        assertEquals(2, wynik.size());
        assertEquals("Toyota", wynik.get(0).getModel());
        assertEquals("Honda", wynik.get(1).getModel());
    }

    @Test
    public void testGetByModel(){

        AutoService mockAutoService=mock(AutoService.class);
        Auto auto1 = new Auto("Toyota", 1999);
        Auto auto2 = new Auto("Cupra", 2024);
//        List<Auto> mockAuta = Arrays.asList(auto1,auto2);
        when(mockAutoService.getByModel("Toyota")).thenReturn(Arrays.asList(auto1));
        when(mockAutoService.getByModel("Cupra")).thenReturn(Arrays.asList(auto2));

//        utworzenie controlera ze zmockowanym serwisem
        MyRestController myRestController = new MyRestController(mockAutoService);


        List<Auto> wynik0 = myRestController.getByModel("Toyota");
        List<Auto> wynik1 = myRestController.getByModel("Cupra");

        assertEquals(1,wynik0.size());
        assertEquals("Toyota", wynik0.get(0).getModel());
        assertEquals("Cupra", wynik1.get(0).getModel());

    }

    @Test
    public void testGetByRokProdukcji(){
        AutoService mockAutoService=mock(AutoService.class);
        Auto auto1 = new Auto("Toyota", 1999);
        Auto auto2 = new Auto("Cupra", 2024);

        when(mockAutoService.getByRokProdukcji(1999)).thenReturn(Arrays.asList(auto1));
        when(mockAutoService.getByRokProdukcji(2024)).thenReturn(Arrays.asList(auto2));

        MyRestController myRestController = new MyRestController(mockAutoService);

        List<Auto> wynik0 = myRestController.getByRokProdukcji(1999);
        List<Auto> wynik1 = myRestController.getByRokProdukcji(2024);

        assertEquals(1,wynik0.size());
        assertEquals(1999, wynik0.get(0).getRokProdukcji());
        assertEquals(2024, wynik1.get(0).getRokProdukcji());

    }

    @Test
    public void testUsunAuto(){
        AutoService mockAutoService = mock(AutoService.class);
        MyRestController myRestController = new MyRestController(mockAutoService);
        String modelDoUsuniecia = "Toyota";
        myRestController.usunAuto(modelDoUsuniecia);
        verify(mockAutoService,times(1)).delete(modelDoUsuniecia);

    }
    @Test
    public void testAktualizujAuto(){
        AutoService mockAutoService=mock(AutoService.class);
        MyRestController myRestController= new MyRestController(mockAutoService);
        Auto autoDoAktualizacji = new Auto("Toyota",2000);
        myRestController.aktualizujAuto(autoDoAktualizacji);
        verify(mockAutoService).update1(autoDoAktualizacji);

    }

//    @Test
//    public void testAktualizujAuto() throws Exception {
//        Auto autoDoAktualizacji = new Auto("Toyota", 2000);
//
//        mockMvc.perform(patch("/auto/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"model\": \"Toyota\", \"rokProdukcji\": 2000}"))
//                .andExpect(status().isOk());
//
//        verify(mockAutoService, times(1)).update1(autoDoAktualizacji);
//    }

    @Test
    public void testDodajAuto(){
        AutoService mockAutoService=mock(AutoService.class);
        MyRestController myRestController= new MyRestController(mockAutoService);
        Auto autoDoDodania = new Auto("Toyota",2000);
        myRestController.dodajAuto(autoDoDodania);
        verify(mockAutoService).add(autoDoDodania);

    }



}
