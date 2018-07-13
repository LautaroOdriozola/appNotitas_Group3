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
import repositories.RepoEstudiantes;

public class mostrarNotaWindow extends Dialog<mostrarNotaViewModel> {
	
	public mostrarNotaWindow(WindowOwner owner, mostrarNotaViewModel model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		this.setTitle("Mostrando notas de alumno seleccionado");
		
		Table tablaEstudiantes = new Table<>(form, Asignacion.class);
		tablaEstudiantes.bindItemsToProperty("estudianteSeleccionado");
		
		Column<Asignacion> columnaNombre = new Column<Asignacion>(tablaEstudiantes);
		columnaNombre.setTitle("Nombre de asignacion");
		columnaNombre.bindContentsToProperty("nombre");

		Column<Asignacion> columnaLegajo = new Column<Asignacion>(tablaEstudiantes);
		columnaLegajo.setTitle("Ultima nota");
		columnaLegajo.bindContentsToProperty("nota");

		form.setWidth(1200);
		tablaEstudiantes.setHeight(300);
		tablaEstudiantes.setWidth(600);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

	@Override
	protected void executeTask() {
		System.out.println("Un estudiante quiere saber su ultima nota de una materia!");
		this.getModelObject().procesarCambios(); 
		super.executeTask();
	}

}
