package com.fullStack;


import com.fullStack.DAO.BokDAO;
import com.fullStack.Entities.Bok;
import com.fullStack.Service.BokService;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class BokServiceTest {

  @InjectMocks
  private BokService service;

  @Mock
  private BokDAO dao;

  @BeforeEach // NB!! Mock-konteksten resettes mellom hver testmetode (@AfterEach kjøres og rydder opp), så bare @Before/@BeforeClass vil ikke funke
  public void setUp() {
    Bok neededForCreate = new Bok("Mummi",5566, 1989);

    Mockito.lenient().when(dao.tomBok()).thenReturn(neededForCreate); // merk bruk av lenient() her, ellers blir det exception
    lenient().doNothing().when(dao).createBok(neededForCreate);
  }

  @Test
  void create() {
    try {
      dao.createBok(new Bok("",0, 0));
    } catch (IllegalArgumentException iae) {
      System.out.println("We should never have reached this point.");
      System.out.println("Did we somehow call the real method in stead of the mocked one?");
      fail();
    }
  }

  @Test
  void lesson4Message() {
    ArrayList<Bok> boeker = service.getBoeker();

    assertThat(boeker.get(0).getNavn()).isEqualTo("Mummi");
    assertThat(boeker.get(0).getISBN()).isEqualTo(5566);
    assertThat(boeker.get(0).getUtgittAar()).isEqualTo(1989);

  }
}