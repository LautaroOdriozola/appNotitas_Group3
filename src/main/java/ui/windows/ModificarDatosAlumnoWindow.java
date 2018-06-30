package main.java.ui.windows;

import org.uqbar.arena.bindings.ObservableProperty;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import main.java.ui.vm.*;

public class ModificarDatosAlumnoWindow extends Dialog<ModificarDatosAlumnoViewModel> {

	public ModificarDatosAlumnoWindow(WindowOwner owner) {
		super(owner, new ModificarDatosAlumnoViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre alumno:");
		new Field(form) //no se como es el field
        .setWidth(150)
		.bindValueToProperty("nombre"); 

		new Label(form).setText("Legajo:");
		new Field(form) //no se como es el field
                .setWidth(150)
				.bindValueToProperty("legajo");
		
		new Label(form).setText("Usuario github:");
		new Field(form) //no se como es el field
                .setWidth(150)
				.bindValueToProperty("usuarioGithub");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

	@Override
	protected void executeTask() {
		System.out.println("Me aceptaron, yuppiiii!!!");
		this.getModelObject().procesarCambios(); 
		super.executeTask();
	}

}


