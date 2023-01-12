package org.ufv.dis.Front;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;


@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@PageTitle("Datos covid_19")
@Route
public class MainView extends VerticalLayout{

    public MainView(@Autowired CovidService service) throws URISyntaxException, IOException, InterruptedException {
        //HorizontalLayout inputs=new HorizontalLayout();
        VerticalLayout results_General=new VerticalLayout();
        VerticalLayout results_Mayores=new VerticalLayout();
        //Tab tab_General = new Tab("Tasa acumulada poblacion general");
        //Tab tab_Mayores = new Tab("Tasa acumulada poblacion mayores de 65");


        //FormCovid_General formulario_general=new FormCovid_General(this);
        //FormCovid_Mayores formulario_mayores=new FormCovid_Mayores(this);
        /*ComboBox<String> comboBox=new ComboBox<>("Seleccione el tipo de info....");
        comboBox.setAllowCustomValue(false);
        comboBox.setItems("Tasa acumulada poblacion general", "Tasa acumulada poblacion mayores de 65");
        comboBox.setHelperText("Seleccione el tipo de dato");
        inputs.add(comboBox);*/

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

        TabSheet Pestanas = new TabSheet();
        results_General.removeAll();
        grid_General.setItems(service.leeCovidMenor());
        results_General.add(grid_General);
        Pestanas.add("Tasa acumulada poblacion general",results_General);
        grid_Mayor.setItems(service.leeCovidMayor());
        results_Mayores.add(grid_Mayor);
        Pestanas.add("Tasa acumulada poblacion mayores de 65",results_Mayores);
        Pestanas.setSizeFull();

       /* Button boton1=new Button("Lee caracter",
        e -> {
            String tipoPeticion=comboBox.getValue();

            try {

                if(tipoPeticion.equals("Tasa acumulada poblacion general")){

                } else if (tipoPeticion.equals("Tasa acumulada poblacion mayores de 65")) {


                }

            } catch (Exception ex) {
            }
        });
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton1.addClickShortcut(Key.ENTER);*/
        //addClassName("centered-content");
        add(Pestanas);

    }
}
