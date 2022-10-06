package fr.liva.view;

import fr.liva.GuiState;
import fr.liva.LivaClient;
import fr.liva.Main;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.input.LivaInputField;
import fr.liva.components.input.LivaPasswordField;
import fr.liva.components.others.LivaText;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

import java.awt.*;
import java.net.UnknownHostException;

public class ViewConnect extends View {

    // Texts
    private LivaText connectText = new LivaText(36);

    // Fields
    private LivaInputField pseudoField = new LivaInputField();
    private LivaPasswordField passwordField = new LivaPasswordField();
    private LivaInputField portField = new LivaInputField();

    // Buttons
    private LivaButton connectButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewConnect(LauncherPanel panel) {
        super(panel);
    }

    @Override
    public void init() {

        // Texts
        connectText.setText("Connection");
        connectText.setBounds(760, 230, 230, 40);

        // Fields
        pseudoField.setBounds(760, 270, 230, 40);
        passwordField.setBounds(760, 320, 230, 40);
        portField.setBounds(760, 370, 230, 40);

        // Buttons
        connectButton.setBounds(760, 420, 230, 40);
        connectButton.setAction(LivaActionType.PRESS, () -> {
            try {
                try {
                    if (Main.livaClient != null) {
                        Main.livaClient.disconnect();
                    }
                    Main.livaClient = new LivaClient(pseudoField.getText(), Integer.parseInt(portField.getText()), getPanel());
                } catch (NumberFormatException e) {
                    ViewWindow viewWindow = (ViewWindow) getPanel().getView(ViewWindow.class);

                    viewWindow.getTitleText().setText("Connection");
                    viewWindow.getMainText().setText("<html>Erreur:<br>Le port saisie doit être un entier.</html>");

                    getPanel().setState(GuiState.WINDOW);
                }
            } catch (Exception e) {
                ViewWindow viewWindow = (ViewWindow) getPanel().getView(ViewWindow.class);

                viewWindow.getTitleText().setText("Connection");
                viewWindow.getMainText().setText("<html>Erreur:<br>Impossible de contacter le sevreur.</html>");

                getPanel().setState(GuiState.WINDOW);
            }
        });

        // Add Components
        addComponent(connectText, pseudoField, passwordField, portField, connectButton);

    }
}
