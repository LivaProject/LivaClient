package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.chat.LivaChatArea;
import fr.liva.components.chat.LivaChatBox;
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
    private LivaButton play = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
    private LivaButton options = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
    private LivaButton quit = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewMain(LauncherPanel panel) {
        super(panel);
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
        play.setBounds(100, 370, 550, 90);

        options.setBounds(100, 490, 550, 90);
        options.setAction(LivaActionType.PRESS, () -> {
            getPanel().setState(GuiState.OPTIONS);
        });

        quit.setBounds(100, 610, 550, 90);
        quit.setAction(LivaActionType.PRESS, () -> {
            System.exit(0);
        });

        LivaChatBox chatBox = new LivaChatBox();

        LivaChatArea chatArea = new LivaChatArea();

        LivaButton livaButton = new LivaButton(getPanel(), LivaUtils.getResource("images/icon.png"));
        livaButton.setBounds(950, 670, 50, 50);
        livaButton.setAction(LivaActionType.HOVER, () -> {
            getPanel().setCursor(getPanel().getLauncher().hoverCursor());
        });


        // Add Elements
        addComponent(mainText, playText, optionsText, quitText, play, options, quit, chatBox, chatArea, livaButton);
    }
}
