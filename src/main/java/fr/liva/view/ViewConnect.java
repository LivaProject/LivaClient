package fr.liva.view;

import fr.liva.LivaClient;
import fr.liva.Main;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.input.LivaInputField;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

import java.net.UnknownHostException;

public class ViewConnect extends View {

    // Fields
    private LivaInputField pseudoField = new LivaInputField();
    private LivaInputField portField = new LivaInputField();

    // Buttons
    private LivaButton connectButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewConnect(LauncherPanel panel) {
        super(panel);
    }

    @Override
    public void init() {

        // Fields
        pseudoField.setBounds(760, 320, 230, 40);
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

                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        });

        // Add Components
        addComponent(pseudoField, portField, connectButton);

    }
}
