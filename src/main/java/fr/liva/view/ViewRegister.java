package fr.liva.view;

import fr.liva.ViewType;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.input.LivaInputField;
import fr.liva.components.input.LivaPasswordField;
import fr.liva.components.others.LivaText;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

public class ViewRegister extends View {

    // Texts
    private LivaText registerText = new LivaText(36);

    // Fields
    private LivaInputField pseudoField = new LivaInputField();
    private LivaPasswordField passwordField = new LivaPasswordField();

    // Buttons
    private LivaButton registerButton = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    public ViewRegister(LauncherPanel panel) {
        super(panel, ViewType.RIGHT_BOX);
    }

    @Override
    public void init() {

        // Texts
        registerText.setText("Inscription");
        registerText.setBounds(760, 230, 230, 40);

        // Fields
        pseudoField.setBounds(760, 270, 230, 40);
        passwordField.setBounds(760, 320, 230, 40);

        // Buttons
        registerButton.setBounds(760, 420, 230, 40);
        registerButton.setAction(LivaActionType.PRESS, () -> {

        });

        // Add Components
        addComponent(registerText, pseudoField, passwordField, registerButton);

    }
}
