package ui.windows;

import org.uqbar.arena.bindings.ObservableProperty;


import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import ui.vm.*;

public class VerNotaAlumnoWindow extends Dialog<VerNotaAlumnoViewModel> {

	public VerNotaAlumnoWindow(WindowOwner owner) {
		super(owner, new VerNotaAlumnoViewModell());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		
		Table tablaAsignaciones = new Table<>(formPanel, Asignacion.class);
		tablaAsignaciones.bindItemsToProperty("asignaciones");

		Column<Asignacion> columnaAsignacion = new Column<Asignacion>(tablaAsignaciones);
		columnaAsignacion.setTitle("Asignacion");
		columnaAsignacion.bindContentsToProperty("nombre"); 

		Column<Venta> columnaNota = new Column<Asignacion>(tablaAsignaciones);
		columnaNota.setTitle("Nota");
		columnaNota.bindContentsToProperty("ultimaNota"); //habria q ver de poner 'ultimaNota' a la asignacion
		
		Column<Venta> columnaAprobo = new Column<Asignacion>(tablaAsignaciones);
		columnaAprobo.setTitle("Aprobo");
		columnaAprobo.bindContentsToProperty("aprobo"); //habria q ver de ponerle 'aprobo' a la asign

	}

	@Override
	protected void addActions(Panel actions) {
		// new Button(actions).setCaption("Ver nota").onClick(this::accept).setAsDefault();
		//new Button(actions).setCaption("Volver").onClick(this::cancel);
	}

	@Override
	protected void executeTask() { //supongo que este es el metodo accept
		System.out.println("Me aceptaron, yuppiiii!!!");
		//this.getModelObject().setearAsignaciones();
		//this.getModelObject().mostrarNotas(); 
		super.executeTask();
	}

}