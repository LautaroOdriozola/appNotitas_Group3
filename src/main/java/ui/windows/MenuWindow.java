package ui.windows;

import org.uqbar.arena.bindings.ObservableProperty;


import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
//import org.uqbar.arena.widgets.tables.Column;
//import org.uqbar.arena.widgets.tables.LabelProviderBuilder;
//import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import ui.vm.*;
import repositories.RepoEstudiantes;
import model.Estudiante;

public class MenuWindow extends SimpleWindow<MenuViewModel> {

	public MenuWindow(WindowOwner parent) {
		super(parent, new MenuViewModel());
	}

	@Override
	protected void addActions(Panel panelActions) {
	/*	new Button(panelActions)
		.setCaption("Ver ultima nota")
		.onClick(this::verNota);*/
		
		new Button(panelActions)
		.setCaption("Agregar estudiante o modificar datos")
		.onClick(this::modificarDatos);
	}

	protected void createFormPanel(Panel formPanel) {
		this.setTitle("Bienvenido al sistema de gestion de notas");
		
		Table tablaEstudiantes = new Table<>(formPanel, Estudiante.class);
		tablaEstudiantes.bindItemsToProperty("estudiantes");
		
		Column<Estudiante> columnaNombre = new Column<Estudiante>(tablaEstudiantes);
		columnaNombre.setTitle("Nombre");
		columnaNombre.bindContentsToProperty("nombre");

		Column<Estudiante> columnaLegajo = new Column<Estudiante>(tablaEstudiantes);
		columnaLegajo.setTitle("Legajo");
		columnaLegajo.bindContentsToProperty("legajo");
		
		Column<Estudiante> columnaUsuario = new Column<Estudiante>(tablaEstudiantes);
		columnaUsuario.setTitle("Usuario Github");
		columnaUsuario.bindContentsToProperty("usuarioGithub");
		
		new Label(formPanel).setText("Estudiante:");
		Selector<Estudiante> selectorEstudiante = new Selector<Estudiante>(formPanel).allowNull(true);
		selectorEstudiante.bindValueToProperty("alumnoSeleccionado");

		Binding<Estudiante, Selector<Estudiante>, ListBuilder<Estudiante>> binding =
				selectorEstudiante.bindItems(new ObservableProperty<>(this.getModelObject(), "estudiantes"));

		binding.setAdapter(new PropertyAdapter(Estudiante.class, "nombre"));
		
		formPanel.setWidth(1200);
		tablaEstudiantes.setHeight(300);
		tablaEstudiantes.setWidth(600);
	}

	private void modificarDatos() {
		Dialog<?> dialog = new ModificarDatosAlumnoWindow(this);
		dialog.onAccept(() ->
        this.getModelObject().setEstudiantes(
           RepoEstudiantes.getInstance().all()
        )
		);
		dialog.open();

	}
	
	/*private void VerNota() {
		Dialog<?> dialog = new VerNotaAlumnoWindow(this);
		dialog.open();

	}*/

	
}