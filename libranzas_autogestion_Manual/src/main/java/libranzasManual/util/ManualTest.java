package libranzasManual.util;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static org.junit.Assert.assertEquals;

public class ManualTest {

	public static void validate(String step, String nameScenario) {
		int YES = 1;
        String reason = "";
        String[] options = {"No", "Yes"};
        int optionSelected = JOptionPane.showOptionDialog(new JFrame(), "¿El paso \"" + step + "\" fue ejecutado correctamente?",
                nameScenario, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if(optionSelected == 0) {
            reason = JOptionPane.showInputDialog("Ingresa la razón por la cual la prueba no funciona correctamente.");
        }
        assertEquals(reason, YES, optionSelected);
    }
}
