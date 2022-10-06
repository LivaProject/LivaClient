package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.ViewType;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.others.LivaText;
import fr.liva.components.others.LivaTitleText;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

public class ViewMain extends View {

    // Texts
    private LivaTitleText mainText = new LivaTitleText();
    private LivaText playText = new LivaText();
    private LivaText optionsText = new LivaText();
    private LivaText quitText = new LivaText();

    // Buttons
    private LivaButton playButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
    private LivaButton optionsButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
    private LivaButton quitButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewMain(LauncherPanel panel) {
        super(panel, ViewType.MAIN);
    }

    @Override
    public void init() {

        // Texts
        mainText.setText("Liva");

        playText.setText("Jouer");
        playText.setBounds(100, 370, 550, 90);

        optionsText.setText("Options");
        optionsText.setBounds(100, 490, 550, 90);

        quitText.setText("Quitter");
        quitText.setBounds(100, 610, 550, 90);


        // Buttons
        playButton.setBounds(100, 370, 550, 90);
        playButton.setAction(LivaActionType.PRESS, () -> {
            getPanel().openWindow("Beta", "Fonctionnalité non terminée");
        });

        optionsButton.setBounds(100, 490, 550, 90);
        optionsButton.setAction(LivaActionType.PRESS, () -> {
            getPanel().setState(GuiState.OPTIONS);
        });

        quitButton.setBounds(100, 610, 550, 90);
        quitButton.setAction(LivaActionType.PRESS, () -> {
            System.exit(0);
        });


        // Add Elements
        addComponent(mainText, playText, optionsText, quitText, playButton, optionsButton, quitButton);
    }
}
