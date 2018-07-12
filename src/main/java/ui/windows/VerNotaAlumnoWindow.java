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

public class VerNotaAlumnoWindow extends Dialog<VerNotaAlumnoViewModel> {

	public VerNotaAlumnoWindow(WindowOwner owner) {
		super(owner, new VerNotaAlumnoViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre alumno:");
		new TextBox(form) 
        .setWidth(150)
		.bindValueToProperty("nombre"); 
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this::mostrarNotas);
		new Button(actions).setCaption("Volver").onClick(this::cancel);
	}
	
	private void mostrarNotas() {
		Dialog<?> dialog = new mostrarNotaWindow(this);
		dialog.onAccept(() -> 
		this.getModelObject().setEstudiantes(
				RepoEstudiantes.getInstance().all()
		)
		);
		dialog.open();
	}

}