package org.ufv.dis.Front;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.stream.Stream;


@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")

public class MainVIew extends VerticalLayout{

    public MainVIew(@Autowired CovidService service){
        HorizontalLayout inputs=new HorizontalLayout();
        VerticalLayout results=new VerticalLayout();
        ComboBox<String> comboBox=new ComboBox<>("Seleccione el tipo de info....");
        comboBox.setAllowCustomValue(false);
        comboBox.setItems("Tasa acumulada poblacion general", "Tasa acumulada poblacion mayores de 65");
        comboBox.setHelperText("Seleccione el tipo de dato");

        Grid<Data> grid= new Grid<>(Data.class,true);
        grid.addColumn(Data::getCasos).setHeader("Casos");
        grid.addColumn(Data::getCod).setHeader("Codigo");
        grid.addColumn(Data::getFecha).setHeader("Fecha");
        grid.addColumn(Data::getTasa14).setHeader("Tasa 14 dias");
        grid.addColumn(Data::getTasaTotal).setHeader("Tasa Total");
        grid.addColumn(Data::getZona).setHeader("Zona");
        inputs.add(comboBox);
        Button boton1=new Button("Lee caracter",
        e -> {
            String tipoPeticion=comboBox.getValue();

            try {
                results.removeAll();
                if(tipoPeticion.equals("Tasa acumulada poblacion general")){
                   grid.setItems(service.leeCovidMenor());
                   results.add(grid);
                } else if (tipoPeticion.equals("Tasa acumulada poblacion mayores de 65")) {
                    //grid.setItems(service.leeCovidMayor());
                    results.add(grid);

                }

            } catch (Exception ex) {
            }
        });
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton1.addClickShortcut(Key.ENTER);

        addClassName("centered-content");
        add(inputs,boton1,results);
    }
}
