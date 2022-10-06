package fr.liva.view;

import fr.liva.LivaClient;
import fr.liva.Main;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.input.LivaInputField;
import fr.liva.components.input.LivaPasswordField;
import fr.liva.components.others.LivaText;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;
import lombok.Getter;

import java.net.InetAddress;

public class ViewConnect extends View {

    // Texts
    private LivaText connectText = new LivaText(36);

    // Fields
    private LivaInputField pseudoField = new LivaInputField();

    @Getter
    private LivaInputField addressField = new LivaInputField();

    @Getter
    private LivaInputField portField = new LivaInputField();

    // Buttons
    private LivaButton connectButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewConnect(LauncherPanel panel) {
        super(panel, ViewType.RIGHT_BOX);
    }

    @Override
    public void init() {

        // Texts
        connectText.setText("Connection");
        connectText.setBounds(760, 230, 230, 40);

        // Fields
        pseudoField.setBounds(760, 270, 230, 40);
        addressField.setBounds(760, 320, 230, 40);
        portField.setBounds(760, 370, 230, 40);

        // Buttons
        connectButton.setBounds(760, 420, 230, 40);
        connectButton.setAction(LivaActionType.PRESS, () -> {
            try {
                try {
                    if (Main.livaClient != null) {
                        Main.livaClient.disconnect();
                    }

                    Main.livaClient = new LivaClient(pseudoField.getText(), Integer.parseInt(portField.getText()), getPanel(), InetAddress.getByName(addressField.getText()));

                    getPanel().getViews(ViewType.RIGHT_BOX).forEach(View::hide);
                    ViewChat viewChat = (ViewChat) getPanel().getView(ViewChat.class);
                    viewChat.getChatBox().setText("");
                    viewChat.show();
                } catch (NumberFormatException e) {
                    getPanel().openWindow("Connection", "Erreur<br>Le port saisit est invalide.");
                }
            } catch (Exception e) {
                getPanel().openWindow("Connection", "Erreur<br>Impossible de contacter le serveur.");
            }
        });

        // Add Components
        addComponent(connectText, pseudoField, addressField, portField, connectButton);

    }
}
