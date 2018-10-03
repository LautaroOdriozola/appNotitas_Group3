package gestion;
import org.uqbar.arena.Application;

import org.uqbar.arena.windows.Window;

import model.Fixture;
import ui.windows.*;

public class GestionNotasApplication extends Application{

	public static void main(String[] args) {
		Fixture.initialize();
		new GestionNotasApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}
}