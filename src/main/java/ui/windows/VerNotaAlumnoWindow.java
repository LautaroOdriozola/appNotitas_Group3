package ui.windows;

import org.uqbar.arena.bindings.ObservableProperty;


import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import ui.vm.*;
import model.*;

public class VerNotaAlumnoWindow extends Dialog<VerNotaAlumnoViewModel> {

	public VerNotaAlumnoWindow(WindowOwner owner) {
		super(owner, new VerNotaAlumnoViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		
		Table tablaAsignaciones = new Table<>(form, Asignacion.class);
		tablaAsignaciones.bindItemsToProperty("asignaciones");

		Column<Asignacion> columnaAsignacion = new Column<Asignacion>(tablaAsignaciones);
		columnaAsignacion.setTitle("Asignacion");
		columnaAsignacion.bindContentsToProperty("nombre"); 

		Column<Asignacion> columnaNota = new Column<Asignacion>(tablaAsignaciones);
		columnaNota.setTitle("Nota");
		columnaNota.bindContentsToProperty("ultimaNota"); 
		
		Column<Asignacion> columnaAprobo = new Column<Asignacion>(tablaAsignaciones);
		columnaAprobo.setTitle("Aprobo");
		columnaAprobo.bindContentsToProperty("estaAprobada"); 

	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::cancel);
	}


}