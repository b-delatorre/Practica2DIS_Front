package org.ufv.dis.Front;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.awt.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class FormCovid_General extends FormLayout {
    private TextField code=new TextField("codigo_geometria");
    private TextField zona=new TextField("zona_basica_salud");
    private TextField catorcedias=new TextField("Incidencia_14_dias");
    private TextField incidenciaTotal=new TextField("Incidencia_Total");
    private TextField TotalCasos=new TextField("Total_Casos");
    private TextField CasosCatorce=new TextField("Casos_14_dias");
    private Button Aceptar=new Button("Aceptar");
    private Button Cancelar=new Button("Delete");
    private MainView myUI;

    public FormCovid_General(MainView myUI){
        this.myUI=myUI;
        setSizeUndefined();

        Aceptar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Aceptar.addClickShortcut(Key.ENTER);
        Cancelar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Cancelar.addClickShortcut(Key.ENTER);
        //add(CasosCatorce);
        //add(code,zona,catorcedias,incidenciaTotal,TotalCasos,CasosCatorce);
    }
}
