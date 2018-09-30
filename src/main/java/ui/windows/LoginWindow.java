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
import model.*;

public class LoginWindow extends Dialog<LoginViewModel> {

	public LoginWindow(WindowOwner owner) {
		super(owner, new LoginViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Usuario:");
		new TextBox(form).setWidth(150).bindValueToProperty("nombre");

		new Label(form).setText("Contraseña:");
		new TextBox(form).setWidth(150).bindValueToProperty("contrasenia");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Ingresar").onClick(this::ingresar).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

	protected void ingresar() {
		this.getModelObject().ingresar();

		if (this.getModelObject().logueoCorrecto()) {
			Dialog<?> dialog = new PantallaPrincipalWindow(this, this.getModelObject().getToken());
			dialog.open();
		} else {
			// TODO: mostrar logueo incorrecto
		}

		super.executeTask();
	}

}
