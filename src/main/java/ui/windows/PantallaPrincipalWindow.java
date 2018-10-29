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

public class PantallaPrincipalWindow extends Dialog<PantallaPrincipalViewModel> {

	public PantallaPrincipalWindow(WindowOwner owner, String token) throws Exception{
		super(owner, new PantallaPrincipalViewModel(token));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		this.setTitle("Bienvenido al sistema de gestion de notas");

		Table tablaAsignaciones = new Table<>(form, Asignacion.class);
		tablaAsignaciones.bindItemsToProperty("asignaciones");

		Column<Asignacion> columnaNombre = new Column<Asignacion>(tablaAsignaciones);
		columnaNombre.setTitle("Nombre de asignacion");
		columnaNombre.setFixedSize(250);
		columnaNombre.bindContentsToProperty("nombre");

		Column<Asignacion> columnaLegajo = new Column<Asignacion>(tablaAsignaciones);
		columnaLegajo.setTitle("Ultima nota");
		columnaLegajo.setFixedSize(150);
		columnaLegajo.bindContentsToProperty("ultimaNota");

		Column<Asignacion> columnaAprobo = new Column<Asignacion>(tablaAsignaciones);
		columnaAprobo.setTitle("Estado");
		columnaAprobo.setFixedSize(100);
		columnaAprobo.bindContentsToProperty("estado");

		
		
		form.setWidth(2000);
		tablaAsignaciones.setHeight(300);
		tablaAsignaciones.setWidth(600);
	}

	@Override
	protected void addActions(Panel panelActions) {

		new Button(panelActions).setCaption("Modificar datos personales").onClick(this::modificarDatos);
	}

	private void modificarDatos() {
		Dialog<?> dialog = new ModificarDatosAlumnoWindow(this, this.getModelObject().getToken());
		dialog.open();

	}

}
