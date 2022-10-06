package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.others.LivaBackwardButton;
import fr.liva.components.others.LivaText;
import fr.liva.components.others.LivaTitleText;
import fr.liva.launcher.LauncherPanel;

public class ViewOptions extends View {

    // Texts
    private LivaTitleText mainText = new LivaTitleText();
    private LivaText backwardText = new LivaText();

    // Buttons
    private LivaButton backwardButton = new LivaBackwardButton();

    public ViewOptions(LauncherPanel panel) {
        super(panel);
    }

    @Override
    public void init() {

        // Texts
        backwardText.setText("Retour");
        backwardText.setBounds(100, 610, 550, 90);

        mainText.setText("Options");


        // Buttons
        backwardButton.setAction(LivaActionType.PRESS, () -> {
            getPanel().setState(GuiState.MAIN);
        });


        // Add Elements
        addComponent(mainText, backwardText, backwardButton);
    }
}
