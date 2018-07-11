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
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Estudiante:");
		Selector<Estudiante> selectorEstudiante = new Selector<Estudiante>(form).allowNull(true);
		selectorEstudiante.bindValueToProperty("estudianteSeleccionado");

		Binding<Estudiante, Selector<Estudiante>, ListBuilder<Estudiante>> binding =
				selectorEstudiante.bindItems(new ObservableProperty<>(this.getModelObject(), "estudiantes"));

		binding.setAdapter(new PropertyAdapter(Estudiante.class, "nombre"));
		
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask() {
		System.out.println("UN ESTUDIANTE QUIERE SABER SUS NOTAS!");
		this.getModelObject().procesarNotas(); 
		super.executeTask();
	}


}