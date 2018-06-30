package ui.windows;

import org.uqbar.arena.bindings.ObservableProperty;


import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.LabelProviderBuilder;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import ui.vm.*;

public class MenuWindow extends SimpleWindow<MenuViewModel> {

	public MenuWindow(WindowOwner parent) {
		super(parent, new MenuViewModel());
	}

	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelActions)
		.setCaption("Ver ultima nota")
		.onClick(this::verNota);
		
		new Button(panelActions)
		.setCaption("Modificar datos")
		.onClick(this::modificarDatos);
	}

	protected void createFormPanel(Panel formPanel) {
		this.setTitle("Bienvenido al sistema de gestion de notas");

		new Label(form).setText("Estudiante:");
		Selector<Estudiante> selectorEstudiante = new Selector<Estudiante>(form).allowNull(true);
		selectorEstudiante.bindValueToProperty("estudianteElegido");

		Binding<Estudiante, Selector<Estudiante>, ListBuilder<Estudiante>> binding =
				selectorEstudiante.bindItems(new ObservableProperty<>(this.getModelObject(), "estudiantes"));

		binding.setAdapter(new PropertyAdapter(Estudiante.class, "nombre"));
		
		formPanel.setWidth(1200);
	}

	private void modificarDatos() {
		Dialog<?> dialog = new ModificarDatosAlumnoWindow(this);
		dialog.onAccept(() -> {}); //setearle el estudiante elegido
		dialog.open();

	}
	
	private void VerNota() {
		Dialog<?> dialog = new VerNotaAlumnoWindow(this);
		dialog.onAccept(() -> {}); //setearle el estudiante elegido
		dialog.open();

	}

	
}