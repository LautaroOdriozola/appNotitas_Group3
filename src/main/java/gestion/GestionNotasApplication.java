import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import main.java.model.*;
import main.java.ui.windows.*;

public class GestionNotasApplication extends Application{

	public static void main(String[] args) {
		Fixture.initialize();
		new GestionNotasApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new MenuWindow(this);
	}
}