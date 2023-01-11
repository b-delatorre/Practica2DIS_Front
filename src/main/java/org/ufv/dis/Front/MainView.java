package org.ufv.dis.Front;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Route
public class MainView extends VerticalLayout{

    public MainView(@Autowired CovidService service){
        HorizontalLayout inputs=new HorizontalLayout();
        VerticalLayout results=new VerticalLayout();
        //FormCovid_General formulario_general=new FormCovid_General(this);
        //FormCovid_Mayores formulario_mayores=new FormCovid_Mayores(this);
        ComboBox<String> comboBox=new ComboBox<>("Seleccione el tipo de info....");
        comboBox.setAllowCustomValue(false);
        comboBox.setItems("Tasa acumulada poblacion general", "Tasa acumulada poblacion mayores de 65");
        comboBox.setHelperText("Seleccione el tipo de dato");
        inputs.add(comboBox);

        Grid<Data> grid_General= new Grid<>(Data.class,true);
        grid_General.addColumn(Data::getCasos).setHeader("Casos");
        grid_General.addColumn(Data::getCod).setHeader("Codigo");
        grid_General.addColumn(Data::getFecha).setHeader("Fecha");
        grid_General.addColumn(Data::getTasa14).setHeader("Tasa 14 dias");
        grid_General.addColumn(Data::getTasaTotal).setHeader("Tasa Total");
        grid_General.addColumn(Data::getZona).setHeader("Zona");
        Grid<DataMayor> grid_Mayor= new Grid<>(DataMayor.class,true);
        grid_Mayor.addColumn(DataMayor::getCasos).setHeader("Casos");
        grid_Mayor.addColumn(DataMayor::getCod).setHeader("Codigo");
        grid_Mayor.addColumn(DataMayor::getFecha).setHeader("Fecha");
        grid_Mayor.addColumn(DataMayor::getTasa14).setHeader("Tasa 14 dias");
        grid_Mayor.addColumn(DataMayor::getZona).setHeader("Zona");

        Button boton1=new Button("Lee caracter",
        e -> {
            String tipoPeticion=comboBox.getValue();

            try {
                results.removeAll();
                if(tipoPeticion.equals("Tasa acumulada poblacion general")){
                    grid_General.setItems(service.leeCovidMenor());
                    results.add(grid_General);
                } else if (tipoPeticion.equals("Tasa acumulada poblacion mayores de 65")) {
                    grid_Mayor.setItems(service.leeCovidMayor());
                    results.add(grid_Mayor);

                }

            } catch (Exception ex) {
            }
        });
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton1.addClickShortcut(Key.ENTER);
        //addClassName("centered-content");
        add(inputs,boton1,results);

    }
}
