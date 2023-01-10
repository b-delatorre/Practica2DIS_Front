package org.ufv.dis.Front;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.ufv.dis.Back.Covid19Mayor;
import org.ufv.dis.Back.Data;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MyUI extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MyUI(@Autowired CovidService service) {
        HorizontalLayout inputs = new HorizontalLayout();
        VerticalLayout results = new VerticalLayout();
        ComboBox<String> comboBox = new ComboBox<>("Selecciona uno...");
        comboBox.setAllowCustomValue(false); //este deja que el usuario escriba lo que quiera en la caja del comboBox. Si se pone a false no deja
        comboBox.setItems("Todos los pokemons", "Por Nombre", "Por tipo");
        comboBox.setHelperText("Selecciona el tipo de petición");
        Grid<Data> grid = new Grid<>(Data.class, true);
        grid.addColumn(Data::getCasos).setHeader("Casos");

        TextField datos = new TextField("Nombre/Tipo");
        datos.addThemeName("bordered");
        inputs.add(comboBox, datos);

        Button boton1 = new Button("Lee caracter",
                e -> {
                    String tipoPeticion = comboBox.getValue();
                    String dato = datos.getValue();
                    try {
                        results.removeAll();
                        if (tipoPeticion.equals("Por Nombre")){
                            results.add(service.leeDatoCovid(dato));
                        }
                    } catch (Exception ex) {
                    }
                });
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton1.addClickShortcut(Key.ENTER);
// Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
        add(inputs, boton1, results);
    }
}
